<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <legend>Reserved ticket</legend>

    <form class="form-horizontal" action="do?command=ReservedTicket" method="get">
        <fieldset>
            <table>
                <div class="row">
                    <div class=col-md-1><b>Users id</b></div>
                    <div class=col-md-1><b>Code</b></div>
                    <div class=col-md-1><b>Cost</b></div>
                    <div class=col-md-2><b>Film</b></div>
                    <div class=col-md-1><b>Cinema</b></div>
                </div>
                <c:forEach items="${reservedTickets}" var="reservedTicket">
                        <div class="row">
                            <div class=col-md-1>${reservedTicket.users_id}</div>
                            <div class=col-md-1>${reservedTicket.code}</div>
                            <div class=col-md-1>${reservedTicket.cost}</div>
                            <div class=col-md-2>
                                <c:forEach items="${films}" var="film">
                                    <c:if test="${film.id==reservedTicket.films_id}">
                                        <c:out value="${film.name}" escapeXml="false"/>
                                    </c:if>
                                </c:forEach>
                            </div>
                            <div class=col-md-1>
                                <c:forEach items="${cinemas}" var="cinema">
                                    <c:if test="${cinema.id==reservedTicket.cinemas_id}">
                                        <c:out value="${cinema.name}" escapeXml="false"/>
                                    </c:if>
                                </c:forEach>
                            </div>

                        </div>
                </c:forEach>
            </table>
        </fieldset>
    </form>

</body>
</html>
