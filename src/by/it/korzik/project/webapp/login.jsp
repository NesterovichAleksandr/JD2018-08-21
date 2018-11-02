<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=LogIn" method="post">
<fieldset>

<!-- Form Name -->
<legend>LogIn</legend>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email</label>
  <div class="col-md-4">
  <input id="email" name="email" value="email@gmail.com" type="text" placeholder="placeholder" class="form-control input-md" required="">
  </div>
</div>


<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" value="password" type="password" placeholder="placeholder" class="form-control input-md" required="">
  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="LogInButton"></label>
  <div class="col-md-4">
    <button id="LogInButton" name="LogInButton" class="btn btn-success">LogIn</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>

