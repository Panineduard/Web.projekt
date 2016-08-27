<%--
  Created by IntelliJ IDEA.
  User: Эдуард
  Date: 03.08.15
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Поиск по адрессу</title>
</head>
<body bgcolor=  #20b2aa>
<h1>Введите все поля для поиска</h1>
<Form action="searchdata" method="post">
  <a href="lorem.html"><img src="images/yur_adres.jpg"  width="300" height="350" alt="Address"></a><br>
<h2>Указаный вами город:  <%=request.getAttribute("my1")%></h2><br>

  <h3>Укажите пожалуйста остальные параметры</h3>
  <%--Город : <input type="text" name="city" size="30"><br>--%>
Улица: <input type="text" name="strit" size="30"><br>
Номер дома: <input type="text" name="nohouse" size="30"><br>
Номер квартиры: <input type="text" name="namberflat" size="30"><br>
<INPUT value="Поиск" type="submit"  style="color: darkviolet"  name="searchdata" >
</form>
</body>
</html>
