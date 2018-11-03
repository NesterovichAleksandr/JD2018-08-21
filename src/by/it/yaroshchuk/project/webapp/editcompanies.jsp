<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
    <%@ include file="include/head.htm" %>
    <body>
        <div class="container">
            <%@ include file="include/menu.htm" %>
			<div class="container">
        <div class="row">
			<div class=col-md-2>Name</div>
            <div class=col-md-2>Start year</div>
            <div class=col-md-2>About</div>
            <div class=col-md-2>Login</div>
            <div class=col-md-2>Password</div>
            <div class=col-md-2>Email</div>

        </div>
    </div>

    <div class="container">
	<c:forEach items="${companies}" var="company">
        
            <form class="update-company-${company.id}" action="do?command=EditCompanies" method=POST>
                <div class="row">
                    <input style="width: 10px" name="companyId" type="hidden" value="${company.id}"/>
					<div class=col-md-2>
                        <input id="name" class="form-control input-md" name="name"
                               value="${company.name}"/>
                    </div>
					<div class=col-md-2>
                        <input style="width: 70px" id="startYear" class="form-control input-md" name="startYear"
                               value="${company.startYear}"/>
                    </div>
					<div class=col-md-2>
                        <input id="about" class="form-control input-md" name="about"
                               value="${company.about}"/>
                    </div>
					<c:forEach items="${users}" var="user">
						<c:if test="${company.usersId==user.id}">
							<input name="id" type="hidden" value="${user.id}"/>
							<div class=col-md-2>
								<input id="login" class="form-control input-md" name="login"
									   value="${user.login}"/>
							</div>
							<div class=col-md-2>
								<input style="width: 70px" id="password" class="form-control input-md" name="password"
									   value="${user.password}"/>
							</div>
							<div class=col-md-2>
								<input id="email" class="form-control input-md" name="email"
									   value="${user.email}"/>
							</div>
							 <input style="width: 10px" name="rolesId" type="hidden" value="${user.rolesId}"/>
						</c:if>
					 </c:forEach>

                    

                    <button id="Update" value="Update" name="Update" class="btn btn-success col-md-1">
                        Update
                    </button>

                    <button id="Delete" value="Delete" name="Delete" class="btn btn-danger col-md-1">
                        Delete
                    </button>
                </div>
            </form>
            <p></p>
       
		</c:forEach>
    </div>
    </body>
</html>
