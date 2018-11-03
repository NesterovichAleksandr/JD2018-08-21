<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container" align="center">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=Login" method="post">
    <fieldset>

    <!-- Form Name -->
    <h3>Вход</h3>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="login">Логин</label>
      <div class="col-md-4">
      <input id="login" name="login" value="admin" type="text" placeholder="" pattern="[a-zA-Zа-яА-ЯёЁ0-9]{3,}" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Password input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="password">Пароль</label>
      <div class="col-md-4">
        <input id="password" name="password" value="admin" type="password" placeholder="" pattern="[a-zA-Z0-9а-яА-ЯёЁ]{3,}" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="enter"></label>
      <div class="col-md-4">
        <button id="enter" name="enter" class="btn btn-primary">Войти</button>
      </div>
    </div>

    </fieldset>
    </form>

</body>
</html>






