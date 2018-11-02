<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <legend>List film</legend>
    <c:if test="${user.roles_id==1}">
    <div><a href="do?command=CreateFilm">Create film</a></div>
    </c:if>


            <table>
                <div class="row">
                    <%--<div class=col-md-1><b>ID</b></div>--%>
                    <div class=col-md-2><b>Name</b></div>
                    <div class=col-md-1><b>Country</b></div>
                    <div class=col-md-3><b>Genre</b></div>
                    <div class=col-md-1><b>Year of issue</b></div>
                    <div class=col-md-1><b>Duration</b></div>
                    <div class=col-md-2><b>Cinema</b></div>
                </div>
                <c:forEach items="${films}" var="film">
                <form class="form-horizontal" action="do?command=ListFilm" method="post">
                    <fieldset>
                    <tr>
                        <div class="row">
                            <input type="hidden" name="filmId" value="${film.id}"/>
                            <div class=col-md-2>${film.name}</div>
                            <div class=col-md-1>${film.country}</div>
                            <div class=col-md-3>${film.genre}</div>
                            <div class=col-md-1>${film.yearOfIssue}</div>
                            <div class=col-md-1>${film.duration}</div>
                            <div class=col-md-2>
                                <select id="cinemaTest" name="cinemaTest" class="form-control">
                                    <c:forEach items="${listCinemaForFilm}" var="cinemaT">
                                        <option>
                                            <c:forEach items="${cinemas}" var="cinema">
                                                <c:if test="${cinema.id==cinemaT.cinemas_id}">
                                                    <input type="hidden" name="cinemaId" value="${cinema.id}"/>
                                                    ${cinema.name}
                                                </c:if>
                                            </c:forEach>
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <button id="reservButton" value="reservButton" name="reservButton" class="btn btn-primary">Reserv</button>

                        </div>
                    </tr>
                    </fieldset>
                </form>
                </c:forEach>


            </table>

</body>
</html>
