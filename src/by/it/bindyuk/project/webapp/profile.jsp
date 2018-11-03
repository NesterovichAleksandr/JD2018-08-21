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
    <div class="container">
        <div class="row">
            <div class=col-md-3>Транспорт</div>
            <div class=col-md-3>Откуда</div>
            <div class=col-md-3>Куда</div>
            <div class=col-md-3>Дата</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${tickets}" var="ticket">
            <form class="update-ticket-${ticket.id}" action="do?command=Profile" method="post">
                <div class="row">
                    <input name="id" type="hidden" value="${ticket.id}"/>
                    <div class=col-md-3>
                        <input id="transport" class="form-control input-md" name="transport"
                               value="${ticket.transport}"/>
                    </div>

                    <div class=col-md-3>
                        <select id="routes_idFrom" name="routes_idFrom" class="form-control">
                               <c:forEach items="${routes}" var="route">
                                        <option value="${route.id}" route=${route.id} ${route.id==ticket.routesIdFrom?"selected":""}>
                                                   ${route.city}
                                        </option>
                               </c:forEach>
                        </select>
                    </div>

                    <div class=col-md-3>
                        <select id="routes_idTo" name="routes_idTo" class="form-control">
                               <c:forEach items="${routes}" var="route">
                                        <option value="${route.id}" route=${route.id} ${route.id==ticket.routesIdTo?"selected":""}>
                                                   ${route.city}
                                        </option>
                               </c:forEach>
                        </select>
                    </div>

                    <div class=col-md-3>
                        <input id="data" class="form-control input-md" name="data"
                               value="${ticket.data}"/>
                    </div>

                </div>
            </form>

            <p></p>
        </c:forEach>

        <form class="form-horizontal" method="post" action="do?command=Profile">
                 <fieldset>
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