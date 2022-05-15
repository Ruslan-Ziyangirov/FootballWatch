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
            <a href="/main">Расписание</a>
            <a href="/main">Заявка</a>
            <a href="/main">О проекте</a>
            <a href="/chatP">Чат</a>
        </nav>

        <#if user??><a href="/profile">${(user.first_name)!}</a>
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

    <div class="profile_page_wrapper">
        <div class="profile_information_wrapper">
                <h1>
                    Личная информация
                </h1>
                <div>
                    <#if path??>
                        <img alt="фотка профиля" class="image-profile" src="/photo/${path}">
                    <#else>
                        <img alt="фотка профиля" class="image-profile" src="/resources/image/default.png">
                    </#if>

                    <form method="POST" action="/uploadFile" enctype="multipart/form-data">
                        <input type="file" name="file" class="change-photo" value="Поменять фотографию" />
                        <input type="submit" value="Поменять" class="change-photo-btn"  />
                    </form>
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