<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <div class="container">
        <div class="row">
            <div class=col-md-2>Описание</div>
            <div class=col-md-2>Вид животного</div>
            <div class=col-md-3>Порода</div>
            <div class=col-md-2>пол</div>
            <div class=col-md-2>Возраст</div>
            <div class=col-md-2>Рост</div>
            <div class=col-md-2>Особенности</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${ads}" var="ad">
            <form class="update-ad-${ad.id}" action="do?command=EditAds" method=POST>
                <div class="row">
                    <input name="id" type="hidden" value="${ad.id}"/>
                    <div class=col-md-2>
                        <input id="description" class="form-control input-md" name="description"
                               value="${ad.description}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="kindOfAnimal" class="form-control input-md" name="kindOfAnimal"
                               value="${ad.kindOfAnimal}"/>
                    </div>
                    <div class=col-md-3>
                        <input id="greed" class="form-control input-md" name="greed"
                               value="${ad.greed}"/>
                    </div>
                    <div class=col-md-3>
                        <input id="sex" class="form-control input-md" name="sex"
                         value="${ad.sex}"/>
                    </div>
                    <div class=col-md-3>
                        <input id="age" class="form-control input-md" name="age"
                           value="${ad.age}"/>
                    </div>
                    <div class=col-md-3>
                        <input id="height" class="form-control input-md" name="height"
                           value="${ad.height}"/>
                    </div>
                    <div class=col-md-3>
                        <input id="qualities" class="form-control input-md" name="qualities"
                           value="${ad.qualities}"/>
                    </div>
                    <input name="users_id" type="hidden" value="${ad.usersId}"/>

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

