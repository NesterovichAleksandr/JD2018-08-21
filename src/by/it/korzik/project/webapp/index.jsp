<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/menu.htm" %>
 <table class="table">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">name</th>
                <th scope="col">ingredients</th>
                <th scope="col">weight</th>
                <th scope="col">price</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="menu" items="${menu}">
                <tr>
                    <td>${menu.id}</td>
                    <td>${menu.name}</td>
                    <td>${menu.ingridients}</td>
                    <td>${menu.weight}</td>
                    <td>${menu.price}</td>
                    </tr>
            </c:forEach>


            </tbody>
        </table>

</div>
</body>
</html>
