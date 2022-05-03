<!doctype html>
<html lang="en">
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/main.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Football Watch</title>
</head>

<body>
<header class="header" id="header">
    <!--Шапка:начало-->
    <div class="nav">
        <div class="navigation">
            <a href="#header" class="logo">
                <img src="/resources/image/logo.svg" alt="логотип">
            </a>
            <div class="menu">
                <a href="#header" class="btn-main">Главная</a>
                <a href="#about-project" class="btn-about-project">О проекте</a>
                <a href="#timetable" class="btn-timetable">Расписание матчей</a>
                <a href="#send" class="btn-request" >Заявка</a>
                <a href="/chat" class="chat"  >Чат</a>
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
    <!--Шапка:конец-->

    <img src="/resources/image/bumbles1.svg" class="bubbles1">

    <!--Оффер:начало-->
    <div class="offer">
        <div class="text">
            <p>Мучаешься с поиском трансляции любимой игры?</p>
            <h1>
                <font color="#0075FF">Заполни заявку</font> и получи расписание ближайших игр с <font color="#0075FF">ссылками на трансляции!</font>
            </h1>
            <form action="#send">
                <button class="btn-submit">Заполнить заявку</button>
            </form>
        </div>

        <div class="image">
            <img src="/resources/image/messi-offer.png" class="messi-offer">
        </div>
    </div>
    <!--Оффер:конец-->
</header>




<!--О проекте:начало-->
<section id="about-project">
    <div class="about-project">
        <h2>О проекте</h2>
        <div class="square">
        </div>
        <p class="this-site">Данный сайт был разработан к семестровой работе 2-го курса института “ИТИС”</p>
        <hr></hr>
        <p align = "right" class="the-project-is">Проект представляет из себя сайт для тех, кто постоянно находится  в поиске футбольных трансляций. Схема очень проста: человек регистрируется, заполняет заявку, ему на почту приходит письмо с расписанием ближайших игр и ссылками, где можно их посмотреть.</p>
        <p class="interested"><b>Заинтересовало???</b> Тогда быстрее опробуй наш сервис!</p>
    </div>
</section>

<img src="/resources/image/ronaldo.png" class="ronaldo">
<img src="/resources/image/cubs.svg" class="cubs">

<section class="timetable" id="timetable">
    <div class="timetable-wrapper">
        <h2>Расписание матчей на ближайшие дни</h2>

        <div class="games">

            <div class="game-item">
                <img src="/resources/image/russia.png">
                <div class="game-content">
                    <p class="tinkoff">Чемпионат Мира 2022</p>
                    <p class="place">ГАЗПРОМ Арена</p>
                    <div class="teams">
                        <p class="team1">Россия</p>
                        <p class="team2">Кипр</p>
                    </div>
                    <h3 class="time">20:00</h3>
                    <p class="date">11.11.2021</p>
                </div>
                <img src="/resources/image/cipr.png">
            </div>

            <div class="game-item">
                <img src="/resources/image/croatia.png">
                <div class="game-content">
                    <p class="tinkoff">Чемпионат Мира 2022</p>
                    <p class="place">Полюд</p>
                    <div class="teams">
                        <p class="team1">Хорватия</p>
                        <p class="team2">Россия</p>
                    </div>
                    <h3 class="time">22:00</h3>
                    <p class="date">02.10.2021</p>
                </div>
                <img src="/resources/image/russia2.png">
            </div>
        </div>
    </div>
</section>

<section class="send-and-facts" id="send">
    <div class="send-and-facts-wrapper">
        <div class="send-a-request">
            <h2>
                Оставить заявку
            </h2>
            <input type="text" placeholder="Имя" id="firstNameRequest" required>
            <input type="text" placeholder="Фамилия" id="secondNameRequest" required>
            <input type="email" placeholder="E-mail" id="emailRequest" required>
            <button type="reset" onclick="sendRequest();" class="btn-send">
                Отправить
            </button>

        </div>
        <div class="facts-of-week">
            <h2>Факт недели</h2>
            <p align="right">В 2002 году на Чемпионате Мира Оливер Кан стал первым и единственным вратарём, выигравшим Золотой мяч.</p>
        </div>
    </div>

</section>

<img src="/resources/image/barc.png" class="barc">
<img src="/resources/image/holland.png" class="holland">

<form method="post" action="/s" id="myModal">
    <p class="avtorisation">Авторизация</p>
    <div class="wrapper-input">
        <input type="text" placeholder="Логин" name="login" required>
        <input type="password" placeholder="Пароль" name="password" required>
        <button type="submit" class="btn-send-auth">
            Войти
        </button>
        <h4 style="
        color: #0a54ea;
        font-size: 15px;
        margin: 0 auto;
        width: 250px;
        ">

        </h4>
        <h4 style="
        color: #0a54ea;
        font-size: 15px;
        margin: 0 auto;
        width: 250px;
        ">

        </h4>

        <span id="myModal__close" class="close">ₓ</span>
    </div>
</form>

<div id="myOverlay">
</div>

    <div class="popup-bg">
        <div class="popup">
            <span id="myModal___close" class="close">ₓ</span>
            <h2>
                Письмо отправлено вам на почту!
            </h2>
            <p>
                Наша компания благодарит вас за оставленную заявку, надеемся, что она принесет вам пользу!
            </p>
        </div>
    </div>


<footer class="footer" id="footer">
    <div class="nav">
        <div class="navigation">
            <a href="#header" class="logo">
                <img src="/resources/image/logo.svg">
            </a>

            <div class="menu">
                <a href="#header" class="btn-main">Главная</a>
                <a href="#about-project" class="btn-about-project">О проекте</a>
                <a href="#timetable" class="btn-timetable">Расписание матчей</a>
                <a href="#send" class="btn-request" >Заявка</a>
                <a href="#send" class="chat" >Чат</a>
            </div>

            <a href="#header" class="arrow">
                <img src="/resources/image/arrow.svg">
            </a>
        </div>
    </div>
</footer>

<script src="/resources/js/jquery-3.6.0.min.js"></script>
<script src="/resources/js/ajax.js"></script>
<script src="/resources/js/main.js"></script>
</body>
</html>