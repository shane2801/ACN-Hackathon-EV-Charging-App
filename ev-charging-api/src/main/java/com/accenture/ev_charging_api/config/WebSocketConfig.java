package com.accenture.ev_charging_api.config;

import com.accenture.ev_charging_api.service.InfrastructureService;
import com.accenture.ev_charging_api.websocket.OcppWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final InfrastructureService infrastructureService;

    public WebSocketConfig(InfrastructureService infrastructureService) {
        this.infrastructureService = infrastructureService;
    }

    @Bean
    public OcppWebSocketHandler ocppWebSocketHandler() {
        return new OcppWebSocketHandler(infrastructureService);
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(
                ocppWebSocketHandler(),
                "/ocpp/*"
        ).setAllowedOrigins("*");
    }
}