package com.example.chatgptbasedcookingingredients.model;

import java.util.List;


public record OpenAIResponse(List<OpenAIChoice> choices) {

}
