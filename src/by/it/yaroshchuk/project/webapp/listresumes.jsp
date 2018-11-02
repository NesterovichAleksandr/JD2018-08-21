<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
	<%@ include file="include/head.htm" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.htm" %>
			<div class="container">
			    <c:forEach items="${resumes}" var="resume">
			        <p> <c:out value="${resume.fullName}"/>
			        <c:out value="${resume.dob}"/>
			        <c:out value="${resume.country}"/>
			        <c:out value="${resume.city}"/>
			    </c:forEach>



		<div>
					<form class="form-horizontal" action="do?command=CreateResume" method="post">
					<legend>Request Form</legend>
			<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="message">Message</label>
						<textarea class="form-control" id="message" rows="3"></textarea>
					</div>


					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="signupsubmit"></label>
						<div class="col-md-4">
							<button id="signupsubmit" name="signupsubmit" class="btn btn-success">Create request</button>
						</div>
					</div>
					</form>
		    </div>
		</div>
		</div>
	</body>
</html>