<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
    <%@ include file="include/head.htm" %>
    <body>
        <div class="container">
            <%@ include file="include/menu.htm" %>
            <div class="container">
                <c:forEach items="${companies}" var="company">
				    <div class="row marketing">
					    <div class="col-lg-6" style="text-align: left; margin-right: 10%; margin-right: 10%">
						    <h4>${company.name}</h4>
						    <h6>from ${company.startYear}</h6>
						    <p>${company.about}</p>
					    </div>
				    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
