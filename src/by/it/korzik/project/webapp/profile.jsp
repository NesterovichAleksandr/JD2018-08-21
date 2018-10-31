<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=Profile" method="post">
<fieldset>

<p>User ${user}</p>
<p>Orders: ${orders}</p>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logoutbutton"></label>
  <div class="col-md-4">
    <button id="logoutbutton" name="logoutbutton" class="btn btn-danger">LogOut</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>
