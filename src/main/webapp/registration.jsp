<%--
  Created by IntelliJ IDEA.
  User: Эдуард
  Date: 02.08.15
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <h1><strong>Регистрация</strong></h1>
  <h5>Все поля являются обязательными!</h5>
    <title>Регистрация</title>
</head>
<body bgcolor=  #20b2aa >
<div style="font-size: 18px; color: red !important; clear: both;">
  <FORM action="registration" method="post">
    <%= request.getAttribute("")%>
    <%= session.getAttribute("")%>
    Имя: <input type="text" name="name" size="30"><br>
    Фамилия: <input type="text" name="lastname" size="30"><br>
    Отчество: <input type="text" name="firsname" size="30"><br>
    Телефон: <input type="text" name="telefon" size="15"><br>
    Электронный адрес: <input type="text" name="email" size="70"><br>
    Имя пользователя: <input type="text" name="login" size="70"><br>
    Индификационный код: <input type="text" name="ID" size="70"><br>
    Пароль: <input type="password" name="pasword" size="70"><br>
    Проверка пароля: <input type="password" name="checkPasword" size="70"><br>

    <INPUT value="Зарегестрироваться" type="submit"  style="color: darkviolet"  name="registrations" >
  </Form>
  </div>
</body>
</html>



