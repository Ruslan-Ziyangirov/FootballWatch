<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Регистрация</title>
</head>
<body>
<header class="header">
    <div class="nav">
        <a href="/m" class="logo">
            <img src="image/logo.svg">
        </a>

        <ul class="menu">
            <li>
                <a href="/m" class="btn-main">Главная</a>
            </li>
            <li>
                <a href="/m" class="btn-about-project">О проекте</a>
            </li>
            <li>
                <a href="/m" class="btn-timetable">Расписание матчей</a>
            </li>
            <li class="btn-request">
                <a href="/m" >Заявка</a>
            </li>
        </ul>

        <div class="sign-in">
            <a href="/m" class="voity">Войти</a>
        </div>

        <div class="log-in">
            <a href="/r" class="registr">Зарегистрироваться</a>
        </div>
    </div>

    <div class="registrate">
        <h1>
            Регистрация
        </h1>
        <form action="/r" method="post" class="form" onsubmit="return sendformRegistration();">
            <input type="text" placeholder="Имя" name="first_name" min="3" max="10" maxlength="30" minlength="3" required>
            <input type="text" placeholder="Фамилия" name="second_name" min="3" max="30" maxlength="30" minlength="3" required>
            <input type="text" placeholder="Логин" name="login" min="3" max="30" maxlength="30" minlength="3" required>
            <input type="password" placeholder="Пароль" name="password" min="3" max="30" maxlength="30" minlength="3" required>
            <input type="email" placeholder="E-mail" name="email" min="3" max="30" maxlength="30" minlength="3" required>
            <button type="submit" class="btn-registrate">Зарегистрироваться</button>
        </form>
    </div>
</header>
<script  src="js/jquery-3.6.0.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>