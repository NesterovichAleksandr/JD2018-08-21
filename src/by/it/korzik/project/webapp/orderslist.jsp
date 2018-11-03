<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/menu.htm" %>
<div>
 <table class="table">
            <thead>
            <tr>
                <th scope="col">Order_id</th>
                <th scope="col">User</th>
                <th scope="col">Name</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>
                <td>${order.id}</td>
                <c:forEach var="user" items="${users}">
                <c:if test="${user.id==order.users_id}">
                    <td>${user.userName}</td>
                    </c:if>
                    </c:forEach>
                <c:forEach var="menu" items="${menu}">
                <c:if test="${menu.id==order.menu_id}">
                    <td>${menu.name}</td>
                    </c:if>
                    </c:forEach>
                    </tr>
            </c:forEach>


            </tbody>
        </table>

</div>
</div>
</body>
</html>
