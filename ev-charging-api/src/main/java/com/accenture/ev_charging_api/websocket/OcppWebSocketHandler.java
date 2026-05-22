package com.accenture.ev_charging_api.websocket;

import com.accenture.ev_charging_api.model.Charger;
import com.accenture.ev_charging_api.service.InfrastructureService;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.ConcurrentHashMap;

public class OcppWebSocketHandler extends TextWebSocketHandler {

    // store active chargers
    private static final ConcurrentHashMap<String, WebSocketSession> chargers = new ConcurrentHashMap<>();

    private final InfrastructureService infrastructureService;

    public OcppWebSocketHandler(InfrastructureService infrastructureService) {
        this.infrastructureService = infrastructureService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        String path = session.getUri().getPath();

        String chargerId = path.substring(path.lastIndexOf("/") + 1);

        chargers.put(chargerId, session);

        Charger charger = infrastructureService.getCharger(chargerId);

        if (charger != null) {

            charger.setOcppConnected(true);

            System.out.println("🔌 OCPP CONNECTED: " + chargerId);

        } else {

            System.out.println("❌ UNKNOWN CHARGER: " + chargerId);
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        String payload = message.getPayload();
        System.out.println("📩 OCPP MESSAGE: " + payload);

        // simple echo for now (we improve later)
        session.sendMessage(new TextMessage("ACK: " + payload));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {

        String path = session.getUri().getPath();

        String chargerId = path.substring(path.lastIndexOf("/") + 1);

        chargers.remove(chargerId);

        Charger charger = infrastructureService.getCharger(chargerId);

        if (charger != null) {
            charger.setOcppConnected(false);
        }

        System.out.println("❌ Charger disconnected: " + chargerId);

    }
}