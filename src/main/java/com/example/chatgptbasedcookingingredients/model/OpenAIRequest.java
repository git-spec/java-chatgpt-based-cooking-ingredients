package com.example.chatgptbasedcookingingredients.model;

import java.util.List;


public record OpenAIRequest(
    String model,
    List<OpenAIMessage> messages
) {

}
