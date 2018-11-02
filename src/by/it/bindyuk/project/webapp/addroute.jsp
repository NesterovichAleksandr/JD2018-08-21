<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=AddRoute" method="post">
        <fieldset>

        <!-- Form Name -->
        <legend>Добавление города</legend>

        <!-- Text input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="city">Город</label>
          <div class="col-md-4">
          <input id="city" name="city" type="text" placeholder="" class="form-control input-md" required="">

          </div>
        </div>

        <!-- Button -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="enter"></label>
          <div class="col-md-4">
            <button id="enter" name="enter" class="btn btn-primary">Enter</button>
          </div>
        </div>

        </fieldset>
        </form>
</body>
</html>


