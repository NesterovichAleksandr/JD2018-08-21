<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <h2>Данные профиля</h2>
    <form class="form-horizontal" method="post" action="do?command=UserCabinet">
        <fieldset>

            <!-- Form Name -->
            <legend>Sign Up Form</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="name" name="name" type="text" placeholder="" class="form-control input-md"
                           value="${agent.name}">
                    <span class="help-block">${help_name}</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email</label>
                <div class="col-md-4">
                    <input id="address" name="address" type="text" placeholder="" class="form-control input-md" required=""
                           value="${agent.address}">
                    <span class="help-block">${help_address}</span>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="update"></label>
                <div class="col-md-4">
                    <button id="update" name="update" class="btn btn-success">Обновить</button>
                </div>
            </div>

        </fieldset>
    </form>


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
        <c:forEach var="company" items="${Companies}">
            <tr>
                <td>${company.description}</td>
                <td>${company.type}</td>
                <td>${company.amount_agents}</td>
                <td>${company.address}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>

            <!-- Form Name -->
            <legend>Выход</legend>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" value="1" class="btn btn-success">Выйти</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>