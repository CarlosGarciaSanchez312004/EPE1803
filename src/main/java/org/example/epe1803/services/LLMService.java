package org.example.epe1803.services;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.stereotype.Service;

@Service
public class LLMService {
    private final OllamaChatModel chatModel;

    public LLMService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String generateRecomendacion(String seed){
        var response = chatModel.call(
                new Prompt(
                        "Dame un mensaje de recomendacion generico para un producto de una tienda con un id entre el 1 y el 25",
                        OllamaChatOptions.builder()
                                .model("llama3")
                                .temperature(1.0)
                                .build()
                ));
        return  response.getResult().getOutput().getText();
    }
}
