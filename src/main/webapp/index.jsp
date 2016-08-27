<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Комунальные платежи</title>
</head>
<style>
    h2{
        color: aqua;
        position: relative;
        top: 5px;
    }
    body{
        background-image:url("images/bilding.jpg") ;

        /*background-color: #e0e6ff;*/
    }
    input{border-radius:5px}
    #prise{
        position: relative;
        top: 50px;
        width: 100px;
        height: 50px;
        background-color: aqua;
        border-radius: 5px;
        font-size: 20px;
    }
    #reg{
        position: relative;
        top: 30px;
        right: 165px;
        background-color: aqua;
        border-radius: 5px;
    }
    #search{
        position: relative;
        left: 50%;
        top: 50%;
    }
</style>
<body>
<form method="post">
    <h2>Вход в акаунт</h2>
    <input type="text" placeholder="Номер диллера" name="j_username">
    <br>
    <input style="position: relative; top: 5px" type="password" placeholder="Пароль" name="j_password">
    <a id="reg" href="/registration">Регистрация</a>
</form>
<form method="get" action="/tariff">
    <button type="submit" id="prise">Тарифы</button>
</form>
<div id="search">
    <form method="get" action="/searchdata">
        <h2>Просмотреть задолженость</h2>
        <input type="text"  placeholder="Город" name="data">
        <br>
        <button type="submit">Найти</button>
    </form>
</div>
</body>
</html>