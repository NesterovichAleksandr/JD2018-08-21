<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
        <%@ include file="include/menu.htm" %>

        <h2>Car list:</h2>

        <c:forEach var="car" items="${cars}">

<div class="row">
      <div class="col-1">
      </div>


      <div class="col">
        <div class="media shadow p-3 mb-5 bg-white rounded">
        <img class="align-self-center mr-3" src="img/car.png" alt="Generic placeholder image">
        <div class="media-body">
          <h5 class="mt-0">Car info</h5>
          <p><span class="font-weight-bold">Mark:</span> ${car.mark}<br>
          <span class="font-weight-bold">Model:</span> ${car.model}<br>
          <span class="font-weight-bold">Color:</span> ${car.color}<br>
          <span class="font-weight-bold">Engine capacity:</span> ${car.engineCapacity}<br>
          <span class="font-weight-bold">Release date:</span> ${car.releaseDate}</p>
        </div>
        <div class="media-body">
          <h1 class="mt-0">Status: <span class="text-danger">reserved</span></h1>
          <p>You can order this car right now!</p>
        </div>
        </div>
      </div>


      <div class="col-1">
      </div>
    </div>

    </c:forEach>

    </div>
</body>
</html>