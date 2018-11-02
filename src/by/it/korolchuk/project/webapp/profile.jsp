<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>
<h3>Профиль</h3>
</br>
    <h4>Мои объявления</h4>
    <table class="table">
            <thead>
                <tr>
                    <th scope="col">Описание</th>
                    <th scope="col">Особенности</th>
                    <th scope="col">Вид животного</th>
                    <th scope="col">Порода</th>
                    <th scope="col">Пол</th>
                    <th scope="col">Возраст</th>
                    <th scope="col">Рост</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach var="ad" items="${ads}">
                    <tr>
                        <td>${ad.description}</td>
                        <td>${ad.qualities}</td>
                        <td>${ad.kindOfAnimal}</td>
                        <td>${ad.greed}</td>
                        <td>${ad.sex}</td>
                        <td>${ad.age}</td>
                        <td>${ad.height}</td>

                    </tr>
                </c:forEach>
             </tbody>
    </table>


    <form class="form-horizontal" action="do?command=Profile" method="post">
    <fieldset>

    <!-- Form Name -->

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="logout"></label>
      <div class="col-md-4">
        <button id="logout" name="logout" class="btn btn-danger">Выход</button>
      </div>
    </div>

    </fieldset>
    </form>

    </div>
</body>
</html>
