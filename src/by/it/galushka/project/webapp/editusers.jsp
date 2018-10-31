<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
        <%@ include file="include/menu.htm" %>

        <h2>All users:</h2>

        <c:forEach items="${users}" var="user">
            <form action="do?command=EditUsers" method="post" >
              <div class="form-row">
              <div class="col-1">
                    <input id="id" name="id" type="text" class="form-control" value="${user.ID}">
                </div>
                <div class="col">
                  <input id="login" name="login" type="text" class="form-control" value="${user.login}">
                </div>
                <div class="col">
                  <input id="password" name="password" type="text" class="form-control" value="${user.password}">
                </div>
                <div class="col">
                  <input id="email" name="email" type="text" class="form-control" value="${user.email}">
                </div>
                <div class="col-1">
                  <input id="rolesId" name="rolesId" type="text" class="form-control" value="${user.roles_Id}">
                </div>
                <div class="col-md-1">
                    <!-- Button -->

                        <button id="Update" name="Update" class="btn btn-warning">Edit</button>

                </div>
                <div class="col-md-1">
                    <!-- Button -->

                        <button id="Delete" name="Delete" class="btn btn-danger">Delete</button>

                </div>
              </div>
            </form>
        </c:forEach>
    </div>
</body>
</html>
