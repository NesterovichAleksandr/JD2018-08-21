<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal" action="do?command=Edit" method="post">
    <fieldset>

    <!-- Form Name -->
    <legend>Edit Ticket</legend>
    <p>Your Ticket: ${ticket}</p>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="edit"></label>
      <div class="col-md-4">
        <button id="edit" name="edit" class="btn btn-primary">edit</button>
      </div>
    </div>

    </fieldset>
    </form>

    <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
    </div>
</body>
</html>


