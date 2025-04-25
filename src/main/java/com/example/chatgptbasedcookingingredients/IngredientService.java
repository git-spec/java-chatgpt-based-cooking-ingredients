package com.example.chatgptbasedcookingingredients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.chatgptbasedcookingingredients.model.OpenAIRequest;
import com.example.chatgptbasedcookingingredients.model.OpenAIResponse;


@Service
public class IngredientService {
    RestClient restClient;

    public IngredientService(RestClient.Builder clientBuilder, @Value("${API_KEY}") String apiKey) {
        this.restClient = clientBuilder
            .baseUrl("https://api.openai.com/v1/chat/completions")
            .defaultHeader("Authorization", "Bearer " + apiKey)
            .build();
    }

    public OpenAIResponse getFoodType(OpenAIRequest request) {
        return restClient
            .post()
            .accept(MediaType.APPLICATION_JSON)
            .body(request)
            .retrieve()
            .body(OpenAIResponse.class);
    }
}
