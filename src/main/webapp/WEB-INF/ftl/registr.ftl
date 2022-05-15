
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">
    <title>Регистрация</title>
</head>
<body>
<header class="header">
    <div class="nav">
        <div class="navigation">
            <a href="/main" class="logo">
                <img src="/resources/image/logo.svg" alt="логотип">
            </a>
            <div class="menu">
                <a href="/main" class="btn-main">Главная</a>
                <a href="/main" class="btn-about-project">О проекте</a>
                <a href="/main" class="btn-timetable">Расписание матчей</a>
                <a href="/main" class="btn-request" >Заявка</a>
                <a href="/chatP" class="chat"  >Чат</a>
            </div>

            <div class="additional-menu">
                <div class="sign-in">
                    <a href="#" class="voity">Войти</a>
                </div>

                <div class="log-in">
                    <a href="/registration" class="registr">Зарегистрироваться</a>
                </div>
            </div>
        </div>
    </div>

    <div class="registrate">
        <h1>
            Регистрация
        </h1>
            <form action="/registration" method="post" class="form" >
                <input type="text" placeholder="Имя" name="first_name" min="3" max="10" maxlength="30" minlength="3" required>
                <input type="text" placeholder="Фамилия" name="second_name" min="3" max="30" maxlength="30" minlength="3" required>
                <input type="text" placeholder="Логин" name="login" min="3" max="30" maxlength="30" minlength="3" required>
                <input type="password" placeholder="Пароль" name="password" min="3" max="30" maxlength="30" minlength="3" required>
                <input type="password" placeholder="Повторите пароль" name="repassword" min="3" max="30" maxlength="30" minlength="3" required>
                <input type="email" placeholder="E-mail" name="email" min="3" max="30" maxlength="30" minlength="3" required>
                <button type="submit" class="btn-registrate">Зарегистрироваться</button>
            </form>
        <#if validation??>
            <p class="info-text">${validation}</p>
        </#if>
    </div>
</header>
<script  src="/resources/js/jquery-3.6.0.min.js"></script>
<script src="/resources/js/main.js"></script>
</body>
</html>