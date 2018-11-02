<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>
    <h1>Ваши данные</h2>

<p>Логин: ${login}</p>
<p>Email: ${email}</p>

    <h2>Купленные билеты</h2>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Транспорт</th>
                <th scope="col">Откуда</th>
                <th scope="col">Куда</th>
                <th scope="col">Дата</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="ticket" items="${tickets}">
                <tr>
                    <td>${ticket.transport}</td>
                    <td>${ticket.routesIdFrom}</td>
                    <td>${ticket.routesIdTo}</td>
                    <td>${ticket.data}</td>
                </tr>
            </c:forEach>


            </tbody>
        </table>

    <form class="form-horizontal" action="do?command=Profile" method="post">
    <fieldset>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="logout"></label>
      <div class="col-md-4">
        <button id="logout" name="logout" class="btn btn-warning">Выйти</button>
      </div>
    </div>

    </fieldset>
    </form>

    </div>
</body>
</html>


