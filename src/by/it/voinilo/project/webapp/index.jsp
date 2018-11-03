<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class=" container-fluid" align="center">
<%@ include file="include/menu.htm" %>




<div class="container-fluid" display="inline-block ">

<c:forEach var="ad" items="${ads}">

<table class="tg table table-bordered " style="undefined;table-layout: inherit; width: auto">
<colgroup>
<col style="width: 150px">
<col style="width: 40px">
<col style="width: 77px">
<col style="width: 76px">
</colgroup>
  <tr >
    <td class="tg-ordi" colspan="2" rowspan="4"><a href="#"><img src="images/ads${ad.id}"></a></td>
    <td class="tg-hwi9" colspan="2">${ad.name}</td>
  </tr>
  <tr>
    <td class="tg-hwi9" colspan="2">${ad.number}</td>
  </tr>
  <tr>
    <td class="tg-hwi9" colspan="2">${ad.address}</td>
  </tr>
  <tr>
    <td class="tg-hwi9" colspan="2">${ad.price}</td>
  </tr>
  <tr>
    <td class="tg-hwi9" colspan="4">${ad.condition}</td>
  </tr>
  <tr>
    <td class="tg-hwi9" colspan="4">${ad.description}</td>
  </tr>
  </table>

  </c:forEach>

</div>
<mytag:paginator count="${adcount}" step="8" urlprefix="?start="/>
</div>
</body>
</html>
