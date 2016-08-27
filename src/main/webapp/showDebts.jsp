<%--
  Created by IntelliJ IDEA.
  User: Эдуард
  Date: 05.08.15
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor=  #20b2aa >
<div style="font-size: 18px; color: beige !important; clear: both;">
  <FORM action="searchdata" method="post">
    <h1>Ваша задолженость состовляет</h1>


    Газ: <%= request.getAttribute("gas")%> грн<br>
    Отопление:<%= request.getAttribute("hating")%> грн<br>
    Электричество:<%= request.getAttribute("electricpower")%> грн<br>
    Горячая вода:<%= request.getAttribute("hotwater")%> грн<br>
    Холодная вода:<%= request.getAttribute("coldwater")%> грн<br>
    Канализация:<%= request.getAttribute("sewerage")%> грн<br>
    Квартплата:<%= request.getAttribute("rent")%> грн<br>
    Вывоз мусора:<%= request.getAttribute("garbageremoval")%> грн<br>
    Общий долг по квартире составил :<%= request.getAttribute("all")%> грн<br>
    <h3>Отрицательное значение говорит о переплате по квартире</h3>

  </Form>
  <form action="index.jsp" > <INPUT value="Перейти на стартовую страницу" type="submit"  style="color: darkviolet"  name="index" ></form>
</div>
</body>
</html>
