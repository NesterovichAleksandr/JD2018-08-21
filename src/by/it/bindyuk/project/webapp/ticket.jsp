<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
     <div class="container">
     <%@ include file="include/menu.htm" %>
     <form class="form-horizontal" action="do?command=Ticket" method="post">


<fieldset>

<!-- Form Name -->
<legend>Заполните поля</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="transport">Транспорт</label>
  <div class="col-md-4">
  <input id="transport" name="transport" type="text" placeholder="" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="from">Откуда</label>
  <div class="col-md-4">
  <input id="from" name="from" type="text" placeholder="" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="to">Куда</label>
  <div class="col-md-4">
  <input id="to" name="to" type="text" placeholder="" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="when">Когда</label>
  <div class="col-md-4">
  <input id="when" name="when" type="text" placeholder="" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Купить</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>
