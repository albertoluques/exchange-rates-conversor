package com.currencyexchange.exchangeconversor;

import com.currencyexchange.exchangeconversor.calculos.ConversionAString;
import com.currencyexchange.exchangeconversor.modelos.ClientSolicitation;
import com.currencyexchange.exchangeconversor.modelos.CurrencyDataAPI;
import com.currencyexchange.exchangeconversor.modelos.JsonArchive;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        ClientSolicitation conversionRate = new ClientSolicitation();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();




        while (true) {
            String messaje = """
                        \n ___________________________________________
                        Seleccione una divisa del siguiente listado
                        1. ARS - Peso argentino
                        2. BOB - Bolivares 
                        3. BRL - Real brasileño
                        4. CLP - Peso chileno
                        5. COP - Peso colombiano
                        6. USD - Dolar estadounidense
                        7. MXN - Peso mexicano
                        9. Salir; 
                        ___________________________________________\n
                        """;
            try {

                // seleccion de divisa base
                System.out.println(messaje);
                System.out.println("Eliga la divisa de la que partira ");
                int baseCode = Integer.valueOf(scan.nextLine());

                if (baseCode == 9) {
                    System.out.println("Saliendo del programa, gracias por utilizar!");
                    break;
                } else if (baseCode <= 0 || baseCode >= 10) {
                    System.out.println("Opcion no disponible, reiniciando programa");
                    continue;
                }

                // seleccion de divisa de conversion
                System.out.println(messaje);
                System.out.println("Elija el numero de divisa desea convertir:");
                int targetCode = Integer.valueOf(scan.nextLine());

                if (targetCode == 9) {
                    System.out.println("Saliendo del programa, gracias por utilizar!");
                    break;
                }  else if (targetCode <= 0 || targetCode >= 10) {
                    System.out.println("Opcion no disponible, reiniciando programa");
                    continue;
                }


                //


                // switch de conversion

                ConversionAString valor1 = new ConversionAString();
                valor1.ConversionIntAString(baseCode);
                ConversionAString valor2 = new ConversionAString();
                valor2.ConversionIntAString(targetCode);

                System.out.println("Escriba la cantidad que desea convertir: ");
                double value1 = Double.parseDouble(scan.nextLine());

                CurrencyDataAPI currency = conversionRate.currencySolicitation(valor1.divisaBase(), valor2.divisaTarget());

                String mensaje = "El valor %.2f [%s] equivale a: %.2f [%s]".formatted(value1, valor1.divisaBase(), (value1 * currency.conversion_rate()), valor2.divisaTarget());
                System.out.printf(mensaje);

                JsonArchive json = new JsonArchive();
                json.saveJson(mensaje);
            } catch (Exception e) {
                throw new NumberFormatException("El programa solo acepta numeros");
            }
        }
    }
}
