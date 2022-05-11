<!doctype html>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet"  type="text/css" href="/resources/css/chatPage.css" />
        <title>Chat</title>
    </head>
    <body onload="connect('${id}')">
        <header>
            <div class="header-wrapper">
                <a href="#header" class="logo">
                    <img src="/resources/image/logo.svg">
                </a>

                <nav class="menu">
                    <a href="/main">Главная</a>
                    <a>Расписание</a>
                    <a>Заявка</a>
                    <a>О проекте</a>
                    <a>Чат</a>
                </nav>

                <div class="additional-menu">
                    <a class="sign-in">
                        <img src="/resources/image/user.svg">
                        <p>Войти</p>
                    </a>

                    <div class="log-in">
                        <a href="/r" class="registr">Зарегистрироваться</a>
                    </div>
                </div>
            </div>

            <div class="chat_area_wrapper">
                <div class="back_and_connect">
                    <a href="/chatP">
                        <img src="/resources/image/Arrow_left_long.png">
                    </a>
                </div>


                <h2>
                    Нижний Новгород - Спартак
                </h2>

                <button class="connect" onclick="sendMessage('${id}', 'Присоединился к чату!')">Присоединиться к чату</button>
                <div class="messagesList">

                    <ul id="messagesList">

                    </ul>
                </div>

                <br>
                <input class="message_area" name="message" id="message" placeholder="Сообщение">
                <div class="btns_wrapper">
                    <button onclick="sendMessage('${id}', $('#message').val())" id="sendMessageButton">Отправить</button>
                    <a>
                        Cмотреть матч
                    </a>
                </div>

            </div>
        </header>
        <br>


        <script src="/resources/js/jquery-3.6.0.min.js"></script>
        <script src="/resources/js/ajax.js"></script>
        <script src="/resources/js/chat_web_socket.js"></script>
    </body>
</html>