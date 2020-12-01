package ru.isu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import ru.isu.json.JsonFileReader;
import ru.isu.xml.XmlFileWriter;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        try (JsonFileReader jsonFileReader = JsonFileReader.INSTANCE) {

            //Получаем нужные списки

            List<Sale> sales = jsonFileReader.getSaleList();
            List<Seller> sellers = jsonFileReader.getSellerList();


            Map<Integer, Integer> sellerWithSale = new HashMap<>();
            Map<LocalDate, Integer> saleDateWithSale = new HashMap<>();

            //Заполняем отображения
            sales.forEach(sale -> {
                try {
                    sellerWithSale.put(sale.getSellerId(), sellerWithSale.get(sale.getSellerId()) + sale.getSoldProductQuantity());
                } catch (NullPointerException e) {
                    sellerWithSale.put(sale.getSellerId(), sale.getSoldProductQuantity());
                }

                try {
                    saleDateWithSale.put(sale.getDate(), saleDateWithSale.get(sale.getDate()) + sale.getSoldProductQuantity());
                } catch (NullPointerException e) {
                    saleDateWithSale.put(sale.getDate(), sale.getSoldProductQuantity());
                }
            });

            XmlFileWriter writer = XmlFileWriter.INSTANCE;

            //Сортируем отображения и передаем данные в writer
            sellerWithSale.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(5)
                    .forEach(v -> sellers.forEach(seller -> {
                        if (seller.getId() == v.getKey())
                            writer.getRoot().addSeller(seller.getFirstName(), seller.getSecondName(), v.getValue());
                    }));
            saleDateWithSale.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(5)
                    .forEach(s -> writer.getRoot().addDate(s.getKey(), s.getValue()));

            //Пишем данные в файл
            writer.writeXmlFile();
        } catch (FileNotFoundException e) {
            System.out.println("FIle not found");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
