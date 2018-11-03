<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>
        <h2>Список кампаний</h2>
        <table class="table">
            <thead>
            <tr>
               <th scope="col">Имя</th>
               <th scope="col">Тип</th>
               <th scope="col">Количество агентов</th>
               <th scope="col">Адрес</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="Company" items="${companies}">
            <tr>
                <td>${Company.description}</td>
                <td>${Company.type}</td>
                <td>${Company.amount_agents}</td>
                <td>${Company.address}</td>
            </tr>
            </c:forEach>


            </tbody>
        </table>


    </div>
</body>
</html>

