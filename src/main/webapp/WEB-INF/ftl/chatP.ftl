<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet"  type="text/css" href="/resources/css/chatP.css" />
    <title>Football Watch</title>
</head>

<body>
    <header class="main-page-chat" >
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

        <div class="chat_page_wrapper">
            <div class="offer">
                <h1>
                    Опробуй нашу новую фишку!
                </h1>

                <p>
                    Чат с такими же фанатами как и ты!
                    Теперь для каждого матча будет отдельный чат, где ты можешь разделить с другими свое мнение.
                </p>

                <button class="btn-offer">
                    Заценить!
                </button>
            </div>
        </div>
    </header>

    <section class="matches_wrapper">
        <div class="matches_information_wrapper">

            <h2>Матчи</h2>

            <div class="image_and_table">
                <div>
                    <img src="/resources/image/aside-img.png" alt="картинка"/>
                </div>

                <div class="table_matches">
                    <hr></hr>
                    <div class="row_matches">
                        <div class="mini_information">
                            <h3>
                                Нижний Новгород
                            </h3>
                            <p>
                                14:00
                            </p>
                            <h3>
                                Спартак
                            </h3>
                        </div>
                        <a href="/main" class="go_to_chat">
                            <p>
                                Перейти в чат
                            </p>
                            <img src="/resources/image/Arrow_right_light.png" alt="переход в чат">
                        </a>
                    </div>
                    <hr></hr>
                    <div class="row_matches">
                        <div class="mini_information">
                            <h3>
                                Нижний Новгород
                            </h3>
                            <p>
                                14:00
                            </p>
                            <h3>
                                Спартак
                            </h3>
                        </div>
                        <a href="/chatPage" class="go_to_chat">
                            <p>
                                Перейти в чат
                            </p>
                            <img src="/resources/image/Arrow_right_light.png" alt="переход в чат">
                        </a>
                    </div>
                    <hr></hr>
                </div>
            </div>

        </div>

    </section>

</body>
</html>