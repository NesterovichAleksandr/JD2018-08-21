<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>
        <h2>My Forms</h2>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Surname</th>
                <th scope="col">Address</th>
                <th scope="col">Description</th>
                <th scope="col">Age</th>
                <th scope="col">Information</th>
                <th scope="col">Aim</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="form" items="${forms}">
                <tr>
                    <td>${form.name}</td>
                    <td>${form.surname}</td>
                    <td>${form.address}</td>
                    <td>${form.description}</td>
                    <td>${form.age}</td>
                    <td>${form.information}</td>
                    <td>${form.aim}</td>
                </tr>
            </c:forEach>


            </tbody>
        </table>


    </div>
</body>
</html>
