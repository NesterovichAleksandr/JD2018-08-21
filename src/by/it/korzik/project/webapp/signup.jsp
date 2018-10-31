<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>

<form class="form-horizontal" action="do?command=SignUp" method="post">
<fieldset>

<!-- Form Name -->
<legend>SignUp</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="userName">UserName</label>
  <div class="col-md-4">
  <input id="username" name="username" value="user" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">help</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" value="TestLogin" type="text" placeholder="placeholder" class="form-control input-md" required="">
  </div>
</div>

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


<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="role_id">role</label>
  <div class="col-md-4">
    <select id="role_id" name="role_id" class="form-control">
      <option value="1">administrator</option>
      <option value="2">cook</option>
      <option value="3">customer</option>
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="SignUpButton"></label>
  <div class="col-md-4">
    <button id="SignUpButton" name="SignUpButton" class="btn btn-success">SignUp</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>




