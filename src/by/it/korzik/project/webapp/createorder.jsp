<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/menu.htm" %>

<form class="form-horizontal" action="do?command=CreateOrder" method="post">
<fieldset>

<!-- Form Name -->
<legend>CreateOrder</legend>

<h1>${complete}</h1>




<div class=col-md-2>
<select id="menu_id" name="menu_id" class="form-control">
   <c:forEach items="${menu}" var="menu">
      <option value="${menu.id}"}>
                 ${menu.name}
        </option>
      </c:forEach>
     </select>
     </div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="CreateButton"></label>
  <div class="col-md-4">
    <button id="CreateButton" name="CreateButton" class="btn btn-success">Create</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>
