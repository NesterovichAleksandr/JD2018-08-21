<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
        <%@ include file="include/menu.htm" %>
        <form class="form-horizontal" action="do?command=Login" method="post">
    			<fieldset>

       			<!-- Form Name -->
       			<legend>Login</legend>

       			<!-- Text input-->
       			<div class="form-group">
       			  <label class="col-md-4 control-label" for="Login">Login</label>
       			  <div class="col-md-4">
       			  <input id="Login" name="Login" type="text" placeholder="" class="form-control input-md" required="">

       			  </div>
       			</div>

       			<!-- Password input-->
       			<div class="form-group">
       			  <label class="col-md-4 control-label" for="Password">Password</label>
       			  <div class="col-md-4">
       			    <input id="Password" name="Password" type="password" placeholder="" class="form-control input-md" required="">

       			  </div>
       			</div>

       			<!-- Button -->
       			<div class="form-group">
       			  <label class="col-md-4 control-label" for="signIn"></label>
       			  <div class="col-md-4">
       			    <button id="signIn" name="signIn" class="btn btn-dark">Login</button>
       			  </div>
       			</div>

       			</fieldset>
        	</form>
    </div>
</body>
</html>

