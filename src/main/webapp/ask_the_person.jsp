<%--
  Created by IntelliJ IDEA.
  User: Эдуард
  Date: 07.08.15
  Time: 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor=  #20b2aa>
<a href="lorem.html"><img src="images/askPerson.jpg"  width="300" height="350" alt="Address"></a><br>
<h1>Таких фамилий в поиске несколько. Пожалуйста введите ИНН.</h1>
<Form action="searchdata1" method="get">

  <h2>Указанная вами фамилия:  <%=request.getAttribute("lastname")%></h2><br>
  ИНН: <input name="data" size="50" type="text" class="in"> &nbsp; &nbsp;
  <input value="Найти" onclick="compute(this.form)" type="submit">


</form>
</body>
</html>
