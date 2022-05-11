<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/profile.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Профиль</title>
</head>
<body>

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

    <div class="profile_page_wrapper">
        <div class="profile_information_wrapper">
                <h1>
                    Личная информация
                </h1>
                <div>
                    <img alt="фотка профиля" class="image-profile" src="/resources/image/profile.png">
                    <hr></hr>
                    <div class="information_row">
                        <h3>
                            Имя:
                        </h3>
                        <p>
                            ${user.first_name}
                        </p>
                    </div>
                    <div class="information_row">
                        <h3>
                            Фамилия:
                        </h3>
                        <p>
                            ${user.second_name}
                        </p>
                    </div>
                    <div class="information_row">
                        <h3>
                            Email:
                        </h3>
                        <p>
                            ${user.email}
                        </p>
                    </div>
                    <div class="information_row">
                        <h3>
                            Логин:
                        </h3>
                        <p>
                            ${user.login}
                        </p>
                    </div>
                </div>
        </div>
    </div>
</body>
</html>