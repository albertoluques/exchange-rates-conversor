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
                        \n*************************************************
                        Select the currency number of the following list:
                        1. ARS - Argentine Peso
                        2. BOB - Bolivian Boliviano
                        3. BRL - Brazilian Real
                        4. CLP - Chilean Peso
                        5. COP - Colombian Peso
                        6. USD - United States Dollar
                        7. MXN - Mexican Peso
                        9. Exit
                        *************************************************""";
            try {

                // seleccion de divisa base
                System.out.println(messaje);
                System.out.println("Select the base currency: ");
                int baseCode = Integer.valueOf(scan.nextLine());

                if (baseCode == 9) {
                    System.out.println("Closing the program, thanks for using!");
                    break;
                } else if (baseCode <= 0 || baseCode >= 10) {
                    System.out.println("Option not available, restarting the program");
                    continue;
                }

                // seleccion de divisa de conversion
                System.out.println(messaje);
                System.out.println("Select your target currency: ");
                int targetCode = Integer.valueOf(scan.nextLine());

                if (targetCode == 9) {
                    System.out.println("Closing the program, thanks for using!");
                    break;
                }  else if (targetCode <= 0 || targetCode >= 10) {
                    System.out.println("Option not available, restarting the program");
                    continue;
                }


                //


                // switch de conversion

                ConversionAString valor1 = new ConversionAString();
                valor1.ConversionIntAString(baseCode);
                ConversionAString valor2 = new ConversionAString();
                valor2.ConversionIntAString(targetCode);

                System.out.println("Write the value you want to convert: ");
                double value1 = Double.parseDouble(scan.nextLine());

                CurrencyDataAPI currency = conversionRate.currencySolicitation(valor1.divisaBase(), valor2.divisaTarget());

                String mensaje = "The value of %.2f [%s] equals to: %.2f [%s]".formatted(value1, valor1.divisaBase(), (value1 * currency.conversion_rate()), valor2.divisaTarget());
                System.out.printf(mensaje);

                JsonArchive json = new JsonArchive();
                json.saveJson(mensaje);
            } catch (Exception e) {
                throw new NumberFormatException("The program only accepts numbers");
            }
        }
    }
}
