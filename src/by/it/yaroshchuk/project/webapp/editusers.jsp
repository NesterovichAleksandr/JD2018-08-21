<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
    <%@ include file="include/head.htm" %>
    <body>
        <div class="container">
            <%@ include file="include/menu.htm" %>
			<div class="container">
        <div class="row">
            <div class=col-md-2>Login</div>
            <div class=col-md-2>Password</div>
            <div class=col-md-3>Email</div>
            <div class=col-md-2>Role</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${users}" var="user">
            <form class="update-user-${user.id}" action="do?command=EditUsers" method=POST>
                <div class="row">
                    <input name="id" type="hidden" value="${user.id}"/>
                    <div class=col-md-2>
                        <input id="login" class="form-control input-md" name="login"
                               value="${user.login}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="password" class="form-control input-md" name="password"
                               value="${user.password}"/>
                    </div>
                    <div class=col-md-3>
                        <input id="email" class="form-control input-md" name="email"
                               value="${user.email}"/>
                    </div>
                    <input name="rolesId" type="hidden" value="${user.rolesId}"/>
                    <c:forEach items="${roles}" var="role">
                        <c:if test="${user.rolesId==role.id}">
                            <div class=col-md-2>
                                <input id="role" class="form-control input-md" name="role"
                                  value="${role.role}"/>
                             </div>
                        </c:if>
                   </c:forEach>

                    <button id="Update" value="Update" name="Update" class="btn btn-success col-md-1">
                        Update
                    </button>

                    <button id="Delete" value="Delete" name="Delete" class="btn btn-danger col-md-1">
                        Delete
                    </button>
                </div>
            </form>
            <p></p>
        </c:forEach>
    </div>
        </div>
    </body>
</html>
