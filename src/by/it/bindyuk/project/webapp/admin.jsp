<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>

   <form class="form-horizontal"  action="do?command=Admin">
   <fieldset>

   <!-- Form Name -->
   <legend>Панель администратора</legend>


  <div class="jumbotron">
          <p><a class="btn btn-lg btn-success" href="do?command=EditUsers" role="button">Редактировать пользователей</a></p>
        </div>
  <div class="jumbotron">
            <p><a class="btn btn-lg btn-success" href="do?command=EditRoutes" role="button">Редактировать города</a></p>
          </div>
  <div class="jumbotron">
            <p><a class="btn btn-lg btn-success" href="do?command=EditTicket" role="button">Редактировать билеты</a></p>
          </div>
  <div class="jumbotron">
            <p><a class="btn btn-lg btn-success" href="do?command=AddRoute" role="button">Добавлять города</a></p>
          </div>
  <div class="jumbotron">
              <p><a class="btn btn-lg btn-success" href="do?command=Reset" role="button">Сброс базы</a></p>
            </div>

   </fieldset>
   </form>

    </div>
</body>
</html>


