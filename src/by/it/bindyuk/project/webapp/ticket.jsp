<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
     <div class="container" align="center">
     <%@ include file="include/menu.htm" %>
     <form class="form-horizontal" action="do?command=Ticket" method="post">


<fieldset>

<!-- Form Name -->
<h3>Оформление заказа</h3>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="transport">Транспорт</label>
  <div class="col-md-4">
  <input id="transport" name="transport" type="text" placeholder="" pattern="[a-zA-Zа-яА-ЯёЁ]{3,15}" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="from">Откуда</label>
  <div class="col-md-4">
  <input id="from" name="from" type="text" placeholder="" pattern="[a-zA-Zа-яА-ЯёЁ0-9]{1,20}" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="to">Куда</label>
  <div class="col-md-4">
  <input id="to" name="to" type="text" placeholder="" pattern="[a-zA-Zа-яА-ЯёЁ0-9]{1,20}" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="when">Когда</label>
  <div class="col-md-4">
  <input id="when" name="when" type="text" placeholder="ex. 2018-11-20 03:00:00.0" class="form-control input-md" required="">
    
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
