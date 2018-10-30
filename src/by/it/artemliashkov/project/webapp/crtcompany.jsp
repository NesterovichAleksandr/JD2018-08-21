<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p>Cmd CrtCompany: ${message}</p>

    <form class="form-horizontal" action="do?command=CrtCompany" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Create company</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Name</label>
                <div class="col-md-4">
                    <input id="name" name="name" value="TestName" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="type">Type</label>
                <div class="col-md-4">
                    <input id="country" name="type" value="TestType" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="amount_agents">AmountAgents</label>
                <div class="col-md-4">

                    <input id="amount_agents" name="amount_agents" value="662" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="address">Address</label>
                <div class="col-md-4">
                    <input id="address" name="address" value="ostroshitskaia" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>


            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createcompanysubmit"></label>
                <div class="col-md-4">
                    <button id="createcompanysubmit" name="createcompanysubmit" class="btn btn-success">Create company</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>
