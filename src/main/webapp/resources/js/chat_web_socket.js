var webSocket;

function connect(id) {
    document.cookie = 'X-Authorization=' + '123456' + ';path=/';
    webSocket = new WebSocket('ws://localhost:8080/chat');
    console.log("я в процессе")

    webSocket.onmessage = function receiveMessage(response) {
        let data = response['data'];
        let json = JSON.parse(data);
        console.log("Сообщение отправилось")
        $('#messagesList').last().before("<div class='one_message'>"+"<li>" + "<h5>"+ json['author']+ "</h5>" + " " +  json['text'] + "</li>"+"</div>")
    };

    webSocket.onerror = function errorShow() {
        alert('Ошибка авторизации')
    }
}

function sendMessage(from, text) {
    let message = {
        "author": from,
        "text": text
    };

    webSocket.send(JSON.stringify(message));
}