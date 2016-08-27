<%--
  Created by IntelliJ IDEA.
  User: Эдуард
  Date: 02.08.15
  Time: 20:31
  To change this template use File | Settings | File Templates.
  Как вытянуть ид с джавы
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body bgcolor=  #20b2aa>
<%--<%--%>
<%--if(request.getParameter("name").equals(null)){%>--%>
<%--Не заполнен Параметр Имя--%>
<%--<%}--%>
<%--else{%>--%>
<h1><strong>Вы удачно зарегестрировались под ID</strong></h1><br>
<form>
  <h1><%= request.getAttribute("person")%></h1><br>
  <a href="lorem.html"><img src="images/welcome.jpg"  width="500" height="350" alt="welcome"></a><br>

</form>
<%--<%}--%>
<%--%>--%>


</body>
</html>
