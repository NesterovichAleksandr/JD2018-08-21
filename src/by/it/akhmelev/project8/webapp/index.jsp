<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>
        <h2>Мои объявления</h2>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Фото</th>
                <th scope="col">Описание</th>
                <th scope="col">Этаж</th>
                <th scope="col">Этажность</th>
                <th scope="col">Число комнат</th>
                <th scope="col">Цена</th>
                <th scope="col">Площадь</th>
                <th scope="col">Адрес</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="ad" items="${ads}">
                <tr>
                    <td><img src="image/ad${ad.id}" height="50px"> </td>
                    <td>${ad.description}</td>
                    <td>${ad.floor}</td>
                    <td>${ad.floors}</td>
                    <td>${ad.rooms}</td>
                    <td>${ad.price}</td>
                    <td>${ad.area}</td>
                    <td>${ad.address}</td>
                </tr>
            </c:forEach>


            </tbody>
        </table>

        <mytag:paginator count="${adcount}" step="10" urlprefix="?start="/>


    </div>
</body>
</html>
