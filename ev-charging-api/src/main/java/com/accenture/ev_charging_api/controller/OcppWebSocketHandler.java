package com.accenture.ev_charging_api.controller;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.ConcurrentHashMap;

public class OcppWebSocketHandler extends TextWebSocketHandler {

    // store active chargers
    private static final ConcurrentHashMap<String, WebSocketSession> chargers = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        String uri = session.getUri().toString();

        // extract chargerId from URL
        String chargerId = uri.substring(uri.lastIndexOf("/") + 1);

        chargers.put(chargerId, session);

        System.out.println("Charger connected: " + chargerId);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        String payload = message.getPayload();
        System.out.println("Received: " + payload);

        // simple echo for now (we improve later)
        session.sendMessage(new TextMessage("ACK: " + payload));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        chargers.values().remove(session);
        System.out.println("Charger disconnected");
    }
}