<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
        <%@ include file="include/menu.htm" %>

        <h2>Your orders:</h2>

        <c:forEach items="${orders}" var="order">

        <form action="do?command=EditOrders" method="post" >
            <div class="form-row">
                <div class="col">
                    <input id="PassportID" value="${order.passportId}" name="PassportID" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="col">
                    <input id="StartDate" value="${order.orderDate}" name="StartDate" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="col">
                    <input id="ReturneDate" value="${order.returnDate}" name="ReturneDate" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="col">
                    <input id="Surname" value="${order.surname}" name="Surname" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="col">
                    <input id="Name" value="${order.name}" name="Name" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="col">
                    <input id="MiddleName" value="${order.middleName}" name="MiddleName" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="col">
                    <input id="Address" value="${order.address}" name="Address" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="col">

                        <button id="editOrder" name="editOrder" class="btn btn-warning">Edit</button>

                        <button id="deleteOrder" name="deleteOrder" class="btn btn-danger">Delete</button>

                </div>
            </div>

        </form>

        </c:forEach>

    </div>
</body>
</html>

