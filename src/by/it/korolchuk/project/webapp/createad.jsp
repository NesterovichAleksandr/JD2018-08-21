<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>

<form class="form-horizontal" action="do?command=CreateAd" method="post">
<fieldset>

<!-- Form Name -->
<legend>Новое объявление</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="description">Описание</label>
  <div class="col-md-5">
  <input id="description" value="Описание" name="description" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="kindOfAnimal">Вид животного</label>
  <div class="col-md-4">
  <input id="kindOfAnimal" value="Вид животного" name="kindOfAnimal" type="text" placeholder="" class="form-control input-md">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="greed">Порода</label>
  <div class="col-md-4">
  <input id="greed" value="порода" name="greed" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="sex">Пол</label>
  <div class="col-md-4">
    <select id="sex" name="sex" class="form-control">
      <option value="1">самец</option>
      <option value="2">самка</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="age">Возраст</label>
  <div class="col-md-4">
  <input id="age" value="5" name="age" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">кол-во полных лет</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="height">Рост</label>
  <div class="col-md-4">
  <input id="height" value="30" name="height" type="text" placeholder="30" class="form-control input-md">
  <span class="help-block">см</span>
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="qualities">Особенности</label>
  <div class="col-md-4">
    <textarea class="form-control" id="qualities" value="Особенности" name="qualities"> </textarea>
  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Отправить</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>

