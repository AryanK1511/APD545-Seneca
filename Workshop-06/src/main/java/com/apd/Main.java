package com.apd;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ExchangeRate> exchangeRates = readExchangeRates("exchange-rates.txt");
        List<String> conversionResults = new ArrayList<>();

        for (ExchangeRate exchangeRate : exchangeRates) {
            double amount = 100.0;
            double convertedAmount = amount * exchangeRate.rate;
            String result = "From " + exchangeRate.fromCurrency + " to " + exchangeRate.toCurrency + ": " + convertedAmount + " " + exchangeRate.toCurrency;
            conversionResults.add(result);
        }

        writeConversionResults("output-file.txt", conversionResults);
    }

    public static List<ExchangeRate> readExchangeRates(String filename) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                String fromCurrency = parts[0].split(": ")[1];
                String toCurrency = parts[1].split(": ")[1];
                double rate = Double.parseDouble(parts[2].split(": ")[1]);
                exchangeRates.add(new ExchangeRate(fromCurrency, toCurrency, rate));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exchangeRates;
    }

    public static void writeConversionResults(String filename, List<String> conversionResults) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write("Conversion Results:\n");
            for (String result : conversionResults) {
                bw.write(result);
                bw.newLine();
            }
            System.out.println("Data has been written to output-file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}