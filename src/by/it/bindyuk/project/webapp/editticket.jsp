<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal" action="do?command=editticket" method="post">
    <fieldset>

    <!-- Form Name -->
    <legend>Edit Ticket</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="transport">Transport</label>
      <div class="col-md-4">
      <input id="transport" name="transport" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">на чем поедем?</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="from">From</label>
      <div class="col-md-4">
      <input id="from" name="from" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">Откуда</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="tot">To</label>
      <div class="col-md-4">
      <input id="tot" name="tot" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">куда</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="date">Date</label>
      <div class="col-md-4">
      <input id="date" name="date" type="text" placeholder="" class="form-control input-md">
      <span class="help-block">дата и время поездки</span>
      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="confirm"></label>
      <div class="col-md-4">
        <button id="confirm" name="confirm" class="btn btn-primary">confirm</button>
      </div>
    </div>

    </fieldset>
    </form>

    <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
    </div>
</body>
</html>




