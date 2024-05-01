package com.currencyexchange.exchangeconversor.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class JsonArchive {
    public void saveJson(String currencyDataAPI) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(("Historial.json"));
        escritura.write(gson.toJson(currencyDataAPI));
        escritura.close();
    }


}
