<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=Profile" method="post">
<fieldset>


    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>

            <!-- Form Name -->
            <legend>Profile</legend>


            <div class="form-group">
                <label class="col-md-4 control-label" for="login">UserName</label>
                <div class="col-md-4">
                    <input id="username" name="username" type="text" placeholder="" class="form-control input-md"
                           value="${user.userName}">
                </div>
            </div>


            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md"
                           value="${user.login}">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required=""
                           value="${user.email}">
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required=""
                           value="${user.password}">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="update"></label>
                <div class="col-md-4">
                    <button id="update" name="update" class="btn btn-success">Update</button>
                </div>
            </div>

        </fieldset>
    </form>
    <c:if test="${user.roles_id==3}">
<div>
 <table class="table">
            <thead>
            <tr>
                <th scope="col">Order_id</th>
                <th scope="col">Name</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>
                <c:forEach var="menu" items="${menu}">
                <c:if test="${menu.id==order.menu_id}">
                    <td>${order.id}</td>
                    <td>${menu.name}</td>
                    </c:if>
                    </c:forEach>
                    </tr>
            </c:forEach>


            </tbody>
        </table>

</div>
</c:if>
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logoutbutton"></label>
  <div class="col-md-4">
    <button id="logoutbutton" name="logoutbutton" class="btn btn-danger">LogOut</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>
