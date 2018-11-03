<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
    <%@ include file="include/head.htm" %>
    <body>
            <div class="container">
                <%@ include file="include/menu.htm" %>
    			<div class="container">
            <div class="row">
                <div class=col-md-2>User id</div>
                <div class=col-md-2>User login</div>
                <div class=col-md-2>User email</div>
                <div class=col-md-2>Resume id</div>
                <div class=col-md-2>Resume name</div>
                <div class=col-md-2>Company id</div>
                <div class=col-md-2>Company name</div>
                <div class=col-md-2>Company user id</div>
            </div>
        </div>

        <div class="container">
            <c:forEach items="${requests}" var="request">
                <form class="show-requests-${request.userId}" action="do?command=Requests" method=POST>
                    <div class="row">

                        <div class=col-md-2 >
                            <input style="width: 70px" id="userId" class="form-control input-md" name="userId"
                                   value="${request.userId}"/>
                        </div>
                        <div class=col-md-2 >
                            <input id="userLogin" class="form-control input-md" name="userLogin"
                                   value="${request.userLogin}"/>
                        </div>
                        <div class=col-md-2 >
                            <input id="userEmail" class="form-control input-md" name="email"
                                   value="${request.userEmail}"/>
                        </div>
                        <div class=col-md-2 >
                            <input style="width: 70px" id="resumeId" class="form-control input-md" name="resumeId"
                                   value="${request.resumeId}"/>
                        </div>
                        <div class=col-md-2 >
                            <input id="resumeName" class="form-control input-md" name="resumeName"
                                   value="${request.resumeName}"/>
                        </div>
                        <div class=col-md-2>
                            <input style="width: 70px" id="companyId" class="form-control input-md" name="companyId"
                                   value="${request.companyId}"/>
                        </div>
                         <div class=col-md-2>
                            <input  id="companyName" class="form-control input-md" name="companyName"
                                   value="${request.companyName}"/>
                        </div>
                        <div class=col-md-2>
                            <input style="width: 70px" id="companyUserId" class="form-control input-md" name="companyUserId"
                                   value="${request.companyUserId}"/>
                        </div>

                    </div>
                </form>
                <p></p>
            </c:forEach>
        </div>
            </div>
        </body>
</html>
