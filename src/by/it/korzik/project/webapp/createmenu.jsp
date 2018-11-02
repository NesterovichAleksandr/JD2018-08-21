<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=CreateMenu" method="post">
<fieldset>

<!-- Form Name -->
<legend>CreateMenu</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Name</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="ingridients">Ingredients</label>
  <div class="col-md-4">
  <input id="ingridients" name="ingridients" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="weight">Weight</label>
  <div class="col-md-4">
  <input id="weight" name="weight" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Price</label>
  <div class="col-md-4">
  <input id="price" name="price" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="CreateMenuButtom"></label>
  <div class="col-md-4">
    <button id="CreateMenuButtom" name="CreateMenuButtom" class="btn btn-success">Create</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>
