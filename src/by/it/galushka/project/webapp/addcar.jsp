<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
        <%@ include file="include/menu.htm" %>

        <form class="form-horizontal" action="do?command=AddCar" method="post">
        		<fieldset>

        		<!-- Form Name -->
        		<legend>Add car</legend>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="Mark">Mark</label>
        		  <div class="col-md-4">
        		  <input id="Mark" value="TestMark" name="Mark" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="Model">Model</label>
        		  <div class="col-md-4">
        		  <input id="Model" value="TestModel" name="Model" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="Color">Color</label>
        		  <div class="col-md-4">
        		  <input id="Color" value="TestColor" name="Color" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="EngineCapacity">Engine capacity</label>
        		  <div class="col-md-4">
        		  <input id="EngineCapacity" value="2.0" name="EngineCapacity" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="ReleaseDate">Release date</label>
        		  <div class="col-md-4">
        		  <input id="ReleaseDate" value="2000/08/12" name="ReleaseDate" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Button -->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="Send"></label>
        		  <div class="col-md-4">
        		    <button id="Send" name="Send" class="btn btn-dark">Add car</button>
        		  </div>
        		</div>

        		</fieldset>
        		</form>

    </div>
</body>
</html>

