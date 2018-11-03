<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <div class="container">
        <div class="row">
            <div class=col-md-2>Имя</div>
            <div class=col-md-2>Адрес</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${agents}" var="agent">
            <form class="update-agent-${agent.id}" action="do?command=EditAgents" method=POST>
                <div class="row">
                    <input name="id" type="hidden" value="${agent.id}"/>
                    <div class=col-md-2>
                        <input id="name" class="form-control input-md" name="name"
                               value="${agent.name}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="address" class="form-control input-md" name="address"
                               value="${agent.address}"/>
                    </div>

                    <button id="Update" value="Update" name="Update" class="btn btn-success col-md-1">
                        Обновить
                    </button>
                </div>
            </form>
            <p></p>
        </c:forEach>
    </div>

</div>
</body>

