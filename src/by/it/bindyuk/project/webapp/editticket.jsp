<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <div class="container">
        <div class="row">
            <div class=col-md-2>Транспорт</div>
            <div class=col-md-2>Откуда</div>
            <div class=col-md-2>Куда</div>
            <div class=col-md-2>Дата</div>
            <div class=col-md-2>Пользователь</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${tickets}" var="ticket">
            <form class="update-ticket-${ticket.id}" action="do?command=EditTicket" method="post">
                <div class="row">
                    <input name="id" type="hidden" value="${ticket.id}"/>
                    <div class=col-md-2>
                        <input id="transport" class="form-control input-md" name="transport"
                               value="${ticket.transport}"/>
                    </div>

                    <div class=col-md-2>
                        <input id="routesIdFrom" class="form-control input-md" name="routesIdFrom"
                               value="${ticket.routesIdFrom}"/>
                    </div>

                    <div class=col-md-2>
                        <input id="routesIdTo" class="form-control input-md" name="routesIdTo"
                               value="${ticket.routesIdTo}"/>
                    </div>

                    <div class=col-md-2>
                        <input id="data" class="form-control input-md" name="data"
                               value="${ticket.data}"/>
                    </div>

                    <div class=col-md-2>
                        <select id="users_id" name="users_id" class="form-control">
                               <c:forEach items="${users}" var="user">
                                        <option value="${user.id}" user=${user.id} ${user.id==ticket.usersId?"selected":""}>
                                                   ${user.login}
                                        </option>
                               </c:forEach>
                        </select>
                    </div>

                    <button id="Update" value="Update" name="Update" class="btn btn-success col-md-1">
                        Обновить
                    </button>

                    <button id="Delete" value="Delete" name="Delete" class="btn btn-danger col-md-1">
                        Удалить
                    </button>
                </div>
            </form>
            <p></p>
        </c:forEach>
    </div>

</div>
</body>

