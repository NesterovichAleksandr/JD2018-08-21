<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <h2>Profile Data</h2>
    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>

            <!-- Form Name -->
            <legend>Sign Up Form</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md"
                           value="${user.login}">
                    <span class="help-block">${help_login}</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required=""
                           value="${user.email}">
                    <span class="help-block">${help_email}</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required=""
                           value="${user.password}">
                    <span class="help-block">${help_password}</span>
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


    <h2>My ads</h2>
    <table class="table">
        <thread>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Address</th>
            <th scope="col">Description</th>
            <th scope="col">Condition</th>
            <th scope="col">Cellnumber</th>
            <th scope="col">Price</th>

        </tr>
        </thread>
        <tbody>
        <c:forEach var="ad" items="${ads}">
            <tr>
                <td>${ad.name}</td>
                <td>${ad.address}</td>
                <td>${ad.description}</td>
                <td>${ad.condition}</td>
                <td>${ad.number}</td>
                <td>${ad.price}</td>
                <td><img src="images/ads${ad.id}" height="50px"> </td>
     </tr>
        </c:forEach>


        </tbody>
    </table>
    <div align="center">
<mytag:paginator count="${adcount}" step="8" urlprefix="?start="/>
</div>

    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>


            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" value="1" class="btn btn-danger" >Logout</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>