<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
        <%@ include file="include/menu.htm" %>
                <h2>Cars list:</h2>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Mark</th>
                        <th scope="col">Model</th>
                        <th scope="col">Color</th>
                        <th scope="col">Engine capacity</th>
                        <th scope="col">Release date</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="car" items="${cars}">
                        <tr>
                            <td>${car.mark}</td>
                            <td>${car.model}</td>
                            <td>${car.color}</td>
                            <td>${car.engineCapacity}</td>
                            <td>${car.releaseDate}</td>
                        </tr>
                    </c:forEach>


                    </tbody>
                </table>
    </div>
</body>
</html>