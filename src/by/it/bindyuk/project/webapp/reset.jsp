<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
    <div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" method="post" action="do?command=Reset">
            <fieldset>

            <!-- Form Name -->
            <legend>Сбросить базу данных</legend>

            <form class="form-horizontal" method="post" action="do?command=Reset">
                             <fieldset>
                                       <div class="form-group">
                                              <label class="col-md-4 control-label" for="reset"></label>
                                              <div class="col-md-4">
                                                      <button id="reset" name="reset" value="1" class="btn btn-success">Сбросить</button>
                                              </div>
                                       </div>
                             </fieldset>
                    </form>

            </fieldset>
            </form>
    </div>
</body>
</html>


