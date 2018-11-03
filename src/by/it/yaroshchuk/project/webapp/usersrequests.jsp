<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
	<%@ include file="include/head.htm" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.htm" %>

        <c:forEach items="${resumes}" var="resume">
		  <c:forEach items="${requests}" var="request">
			<c:if test="${resume.id==request.resumesId}">
			<form class="send-request-${resume.id}" action="do?command=UsersRequests" method="post">
				<fieldset>
				    <p><h5>Request on resume</h5>
					 <c:out   value="${resume.resumeName}"/>
					<textarea class="form-control" id="message" name="message" rows="3">"${request.message}"</textarea>

					<c:forEach items="${companies}" var="company">
                        <c:if test="${request.companiesId==company.id}">
                            <c:out value="${company.name}"/>
                            <c:out value="${company.startYear}"/>
                            <c:out value="${company.about}"/>
					    </c:if>
					</c:forEach>
        </fieldset>
    </form>
		</c:if>
</c:forEach>
</c:forEach>

		</div>
	</body>
</html>