package ru.kpfu.itis.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.kpfu.itis.dto.MessageDto;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MessageWebSocketHandler extends TextWebSocketHandler {

    private static Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String messageAsString = (String) message.getPayload();
        MessageDto messageDto = objectMapper.readValue(messageAsString, MessageDto.class);

        if (messageDto.getText().equals("Присоединился к чату!")) {
            sessions.put(messageDto.getAuthor(), session);
        }

        for (WebSocketSession currentSession : sessions.values()) {
            currentSession.sendMessage(new TextMessage(messageAsString));
        }
    }
}
