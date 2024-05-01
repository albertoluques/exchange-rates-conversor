package com.currencyexchange.exchangeconversor.modelos;

import com.google.gson.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientSolicitation{
    public CurrencyDataAPI currencySolicitation(String baseCode, String targetCode) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String apiKey = "b4be4b0df5286553a037c020";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+ apiKey +"/pair/" + baseCode + "/" + targetCode);


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri((direccion))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), CurrencyDataAPI.class);


        } catch(Exception e) {
            throw new RuntimeException("Value not found");
        }
    }
}


