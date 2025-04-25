package com.example.chatgptbasedcookingingredients;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatgptbasedcookingingredients.model.OpenAIMessage;
import com.example.chatgptbasedcookingingredients.model.OpenAIRequest;
import com.example.chatgptbasedcookingingredients.model.OpenAIResponse;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService service;

    @PostMapping
    public String categorizeIngredient(@RequestBody String ingredient) {
        OpenAIMessage message = new OpenAIMessage(
            "user", 
            ingredient + ": Is it vegan, vegeterian or normal? Please select only one of this words."
        );
        List<OpenAIMessage> messages = List.of(message);
        OpenAIRequest request = new OpenAIRequest("gpt-4.1", messages);
        OpenAIResponse response = service.getFoodType(request);
        return response.choices().getFirst().message().content();
    }

}
