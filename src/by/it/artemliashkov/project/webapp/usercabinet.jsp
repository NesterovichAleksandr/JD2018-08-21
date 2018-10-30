<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p>PROFILE: ${agent.name}</p>
    <form class="form-horizontal" action="do?command=UserCabinet" method="post">
        <fieldset>

            <legend>User cabinet</legend>
            <p>${agent}<br></p>
            <div><a href="do?command=UserCabinet">User Cabinet</a></div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" class="btn btn-danger">Logout</button>
                </div>
            </div>

        </fieldset>
    </form>

</body>
</html>