<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
        <%@ include file="include/menu.htm" %>

        <form class="form-horizontal">
        		<fieldset>

        		<!-- Form Name -->
        		<legend>Your order</legend>

        		<!-- Password input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="PassportID">Passport ID</label>
        		  <div class="col-md-4">
        		  <input id="PassportID" name="PassportID" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="StartDate">Start date</label>
        		  <div class="col-md-4">
        		  <input id="StartDate" name="StartDate" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="ReturneDate">Returne date</label>
        		  <div class="col-md-4">
        		  <input id="ReturneDate" name="ReturneDate" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="Surname">Surname</label>
        		  <div class="col-md-4">
        		  <input id="Surname" name="Surname" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="Name">Name</label>
        		  <div class="col-md-4">
        		  <input id="Name" name="Name" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="MiddleName">Middle name </label>
        		  <div class="col-md-4">
        		  <input id="MiddleName" name="MiddleName" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="Address">Address</label>
        		  <div class="col-md-4">
        		  <input id="Address" name="Address" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Button -->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="Send"></label>
        		  <div class="col-md-4">
        		    <button id="Send" name="Send" class="btn btn-primary">Send</button>
        		  </div>
        		</div>

        		</fieldset>
        		</form>

    </div>
</body>
</html>
