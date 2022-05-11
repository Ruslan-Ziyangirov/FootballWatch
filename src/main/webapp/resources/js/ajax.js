function sendRequest() {
    let firstNameRequest = document.getElementById('firstNameRequest').value
    let secondNameRequest = document.getElementById('secondNameRequest').value
    let emailRequest = document.getElementById('emailRequest').value
    var request = {
        firstName: firstNameRequest,
        secondName: secondNameRequest,
        email: emailRequest
    }

    console.log(request)

    $.ajax({
        url: '/request',
        method: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(request),
        success: function (data) {
            alert("Сообщение отправлено!")
        }
    })
}

function authorization() {
    let login = document.getElementById('login').value
    let password = document.getElementById('password').value
    var author = {
        login: login,
        password: password
    }

    $.ajax({
        url: '/s',
        method: 'post',
        dataType: 'json',
        data: {author: JSON.stringify(author)},
        success: function (data) {
            $("#myModal").html("Запрос удался");
        }

    })


}