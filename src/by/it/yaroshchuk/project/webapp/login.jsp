<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<%@ include file="include/menu.htm" %>
	<body>
	<div class="container">


			<form class="form-horizontal"action="do?command=Login" method="post">
				<fieldset>
					<p>${user}<br></p>

					<!-- Form Name -->
					<legend>Form Login</legend>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="login">Login</label>
						<div class="col-md-4">
							<input id="login" name="login" value="" type="text" placeholder="" class="form-control input-md" required="">
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
					<div class="form-group" >
						<label class="col-md-4 control-label" for="signupsubmit"></label>
						<div class="col-md-4">
							<button id="signupsubmit" name="signupsubmit" class="btn btn-success">LogIn</button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</body>
</html>

