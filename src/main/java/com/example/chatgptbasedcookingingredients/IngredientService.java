package com.example.chatgptbasedcookingingredients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class IngredientService {
    RestClient restClient;

    public IngredientService(RestClient.Builder clientBuilder, @Value("API_KEY") String apiKey) {
        this.restClient = clientBuilder
            .baseUrl("https://api.openai.com/v1/chat/completions")
            .defaultHeader("Authorisation", "Bearer ", apiKey)
            .build();
    }
}
