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
                <a href="/main">Расписание</a>
                <a href="/main">Заявка</a>
                <a href="/main">О проекте</a>
                <a href="/chatP">Чат</a>
            </nav>

            <#if user??>
                <a href="/profile">
                    <img src="/resources/image/user.svg">${(user.first_name)!}
                </a>
            <#else>
                <div class="additional-menu">
                    <div class="sign-in">
                        <a href="#" class="voity">Войти</a>
                    </div>

                    <div class="log-in">
                        <a href="/registration" class="registr">Зарегистрироваться</a>
                    </div>
                </div>

            </#if>
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
                    <#list matches as match>
                        <hr></hr>
                        <div class="row_matches">
                            <div class="mini_information">
                                <h3>
                                    ${match.first_team}
                                </h3>
                                <p>
                                    ${match.time}
                                </p>
                                <h3>
                                    ${match.second_team}
                                </h3>
                            </div>
                            <a href="/chatPage/${match.id_match}" class="go_to_chat">
                                <p>
                                    Перейти в чат
                                </p>
                                <img src="/resources/image/Arrow_right_light.png" alt="переход в чат">
                            </a>
                        </div>
                        <hr></hr>
                    </#list>
                </div>
            </div>

        </div>

    </section>

</body>
</html>