<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
        <%@ include file="include/menu.htm" %>

        <h2>Car list:</h2>



        <form>

            <div class="form-row">
                <div class="form-group col-md-1">
                    <input id="ID" value="ID" readonly name="ID" type="text" placeholder="" class="form-control input-sm" required="">
                </div>
                <div class="form-group col-md-2">
                    <input id="Mark" value="Mark" readonly name="Mark" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="form-group col-md-2">
                    <input id="Model"value="Model" readonly value="${car.model}" name="Model" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="form-group col-md-1">
                    <input id="Color" value="Color" readonly name="Color" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="form-group col-md-1">
                    <input id="EngineCapacity" value="Engine" readonly name="EngineCapacity" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="form-group col-md-2">
                    <input id="ReleaseDate" value="Release date" readonly name="ReleaseDate" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="form-group col-md-1">
                    <input id="Reserved" value="Reserved" readonly name="Reserved" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="form-group col-md-2">

                </div>

            </div>
        </form>

        <c:forEach items="${cars}" var="car">
        <form action="do?command=EditCarList" method="post" >


            <div class="form-row">
                <div class="form-group col-md-1">
                    <input id="ID" value="${car.ID}" name="ID" type="text" placeholder="" class="form-control input-sm" required="">
                </div>
                <div class="form-group col-md-2">
                    <input id="Mark" value="${car.mark}" name="Mark" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="form-group col-md-2">
                    <input id="Model" value="${car.model}" name="Model" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="form-group col-md-1">
                    <input id="Color" value="${car.color}" name="Color" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="form-group col-md-1">
                    <input id="EngineCapacity" value="${car.engineCapacity}" name="EngineCapacity" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="form-group col-md-2">
                    <input id="ReleaseDate" value="${car.releaseDate}" name="ReleaseDate" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="form-group col-md-1">
                    <input id="Reserved" value="${car.reserved}" name="Reserved" type="text" placeholder="" class="form-control input-md" required="">
                </div>
                <div class="form-group col-md-2">

                    <button id="editCar" name="editCar" class="btn btn-warning">Edit</button>

                    <button id="deleteCar" name="deleteCar" class="btn btn-danger">Delete</button>

                </div>

            </div>



        </form>
        </c:forEach>



    </div>
</body>
</html>

