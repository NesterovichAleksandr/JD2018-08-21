<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
        <%@ include file="include/menu.htm" %>

        <form class="form-horizontal" action="do?command=AddOrder" method="post">
        		<fieldset>

        		<!-- Form Name -->
        		<legend>Your order</legend>

                    <div class="col-md-4 control-label">

                        <c:if test="${carExist==true}">
                        <select id="carList" name="carList" class="form-control">
                            <c:forEach items="${freeCars}" var="freeCar">
                                <option value="${freeCar.ID}" car=${freeCar.ID} ${freeCar.ID==freeCar.ID?"selected":""}>
                                        ${freeCar.mark} ${freeCar.model} ${freeCar.color}
                                </option>
                            </c:forEach>
                        </select>
                        </c:if>

                        <c:if test="${carExist==false}">
                            <input id="noCar" value="All car reserved, sorry..." readonly name="noCar" type="text" placeholder="" class="form-control input-md" required="">
                        </c:if>
                    </div>

        		<!-- Password input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="PassportID">Passport ID</label>
        		  <div class="col-md-4">
        		  <input id="PassportID" value="12345678912345" name="PassportID" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="StartDate">Start date</label>
        		  <div class="col-md-4">
        		  <input id="StartDate" value="2018/01/01" name="StartDate" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="ReturneDate">Returne date</label>
        		  <div class="col-md-4">
        		  <input id="ReturneDate" value="2018/12/31" name="ReturneDate" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="Surname">Surname</label>
        		  <div class="col-md-4">
        		  <input id="Surname" value="TestName" name="Surname" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="Name">Name</label>
        		  <div class="col-md-4">
        		  <input id="Name" value="Name" name="Name" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="MiddleName">Middle name </label>
        		  <div class="col-md-4">
        		  <input id="MiddleName" value="Middle name" name="MiddleName" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

        		<!-- Text input-->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="Address">Address</label>
        		  <div class="col-md-4">
        		  <input id="Address" value="Prospekt Mira, 99" name="Address" type="text" placeholder="" class="form-control input-md" required="">

        		  </div>
        		</div>

                <c:if test="${carExist==true}">
        		<!-- Button -->
        		<div class="form-group">
        		  <label class="col-md-4 control-label" for="Send"></label>
        		  <div class="col-md-4">
        		    <button id="Send" name="Send" class="btn btn-dark">Create order</button>
        		  </div>
        		</div>
                </c:if>
                <c:if test="${carExist==false}">
                    <p class="font-weight-bold text-danger">Unable to add a new order because all cars are reserved!</p>
                    <p class="font-weight-bold text-danger">Admin must add a new car from his account!</p>
                </c:if>

        		</fieldset>
        		</form>

    </div>
</body>
</html>
