<%@ page import="model.Tariff.TariffStandart" %>
<%--
  Created by IntelliJ IDEA.
  User: Эдуард
  Date: 02.08.15
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Тарифы</title>
</head>
<body bgcolor="#f0f8ff">

<form><span style="color: green; font-size: 2em">

 <% double gas=TariffStandart.T1.getDiscountsCoefficient();
   double hating =TariffStandart.T2.getDiscountsCoefficient();
   double electricpower =TariffStandart.T3.getDiscountsCoefficient();
   double hotwater =TariffStandart.T4.getDiscountsCoefficient();
   double coldwater =TariffStandart.T5.getDiscountsCoefficient();
   double sewerage =TariffStandart.T6.getDiscountsCoefficient();
   double rent =TariffStandart.T7.getDiscountsCoefficient();
   double garbageremoval =TariffStandart.T8.getDiscountsCoefficient();

 %>
  Газ: <%= gas%> грн\м3<br>
Отопление:<%= hating%><br>
Электричество:<%= electricpower%><br>
Горячая вода:<%= hotwater%><br>
Холодная вода:<%= coldwater%><br>
Канализация:<%= sewerage%><br>
Квартплата:<%= rent%><br>
Вывоз мусора:<%= garbageremoval%><br>
</span>
</form>


</body>
</html>
