<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>

<form class="form-horizontal" action="do?command=Login" method="post">
<fieldset>

<p>${agent}<br></p>

<!-- Form Name -->
<legend>Form Login</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Name</label>
  <div class="col-md-4">
  <input id="name" name="name" value="TestName" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="address">Address</label>
  <div class="col-md-4">
    <input id="address" name="address" value="TestAddress" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="signupsubmit"></label>
  <div class="col-md-4">
    <button id="signupsubmit" name="signupsubmit" class="btn btn-success">SignUp</button>
  </div>
</div>

</fieldset>
</form>


</body>
</html>
