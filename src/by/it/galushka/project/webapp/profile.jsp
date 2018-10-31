<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>

    <h2>Your profile:</h2>

    <form class="form-horizontal" method="post" action="do?command=Profile">
            <fieldset>

                <!-- Form Name -->

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
                    <div class="row">
                        <div class="col-1">
                            <!-- Button -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="update"></label>
                                <div class="col-md-4">
                                    <button id="update" name="update" class="btn btn-dark">Update</button>
                                </div>
                            </div>
                        </div>
                        <div class="col-1">
                            <!-- Button -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="logout"></label>
                                <div class="col-md-4">
                                    <button id="logout" name="logout" value="1" class="btn btn-danger">Logout</button>
                                </div>
                            </div>
                        </div>
                    </div>

                        <c:if test="${user.roles_Id==1}">

                         <!-- Button -->
                         <div class="form-group">
                         <div class="col-md-4">
                             <button id="edit" name="edit" class="btn btn-warning btn-block">Edit other users</button>
                         </div>
                         </div>

                         <!-- Button -->
                         <div class="form-group">
                         <div class="col-md-4">
                             <button id="editCarList" name="editCarList" class="btn btn-warning btn-block">Edit car list</button>
                         </div>
                         </div>

                         </c:if>

            </fieldset>

        </form>

        <c:if test="${user.roles_Id!=1}">
        <h2>Your orders</h2>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Passport ID</th>
                <th scope="col">Start date</th>
                <th scope="col">Return date</th>
                <th scope="col">Surname</th>
                <th scope="col">Name</th>
                <th scope="col">Middle name</th>
                <th scope="col">Address</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>${order.passportId}</td>
                    <td>${order.orderDate}</td>
                    <td>${order.returnDate}</td>
                    <td>${order.surname}</td>
                    <td>${order.name}</td>
                    <td>${order.middleName}</td>
                    <td>${order.address}</td>
                </tr>
            </c:forEach>


            </tbody>
        </table>
        </c:if>

        <form class="form-horizontal" method="post" action="do?command=EditOrders">
        <fieldset>
        <div class="row">
            <div class="col">
            </div>
            <div class="col-2">
                <c:if test="${user.roles_Id!=1}">
                    <fieldset>

                    <!-- Button -->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="editOrders"></label>
                      <div class="col-md-4">
                        <button id="editOrders" name="editOrders" class="btn btn-warning">Edit your orders</button>
                      </div>
                    </div>

                    </fieldset>
                </c:if>
            </div>
        </div>
        </fieldset>
        </form>
    </div>
</body>
</html>
