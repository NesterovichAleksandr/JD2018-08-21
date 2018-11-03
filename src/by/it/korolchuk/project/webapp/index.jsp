<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>

    <h2>Все объявления </h2>
    <table class="table">
            <thead>
            <tr>
                <th scope="col">Описание</th>
                <th scope="col">Особенности</th>
                <th scope="col">Вид животного</th>
                <th scope="col">Порода</th>
                <th scope="col">Пол</th>
                <th scope="col">Возраст</th>
                <th scope="col">Рост</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach var="ad" items="${ads}">
                <tr>
                    <td>${ad.description}</td>
                    <td>${ad.qualities}</td>
                    <td>${ad.kindOfAnimal}</td>
                    <td>${ad.greed}</td>
                    <td>${ad.sex}</td>
                    <td>${ad.age}</td>
                    <td>${ad.height}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>
</body>
</html>
