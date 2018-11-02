<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <div class="container">
        <div class="row">
            <div class=col-md-4>Город</div>

        </div>
    </div>

    <div class="container">
        <c:forEach items="${routes}" var="route">
            <form class="update-route-${route.id}" action="do?command=EditRoutes" method=POST>
                <div class="row">
                    <input name="id" type="hidden" value="${route.id}"/>
                    <div class=col-md-4>
                        <input id="city" class="form-control input-md" name="city"
                               value="${route.city}"/>
                    </div>

                    <button id="Update" value="Update" name="Update" class="btn btn-success col-md-2">
                        Обновить
                    </button>

                    <button id="Delete" value="Delete" name="Delete" class="btn btn-danger col-md-2">
                        Удалить
                    </button>
                </div>
            </form>
            <p></p>
        </c:forEach>
    </div>

</div>
</body>

