<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>


<form class="form-horizontal" action="do?command=Login" method="post">
<fieldset>

<p>${user}<br></p>

<!-- Form Name -->
<legend>Form Login</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" value="user1" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" value="users1password" type="password" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="signupsubmit"></label>
  <div class="col-md-4">
    <button id="signupsubmit" name="signupsubmit" class="btn btn-success">LogIn</button>
  </div>
</div>

</fieldset>
</form>
</body>
</html>

