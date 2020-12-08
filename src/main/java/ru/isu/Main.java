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




            //Заполняем отображения
            Map<Integer, Integer> sellerWithSale = sales.stream()
                    .collect(Collectors.groupingBy(Sale::getSellerId,
                            Collectors.summingInt(Sale::getSoldProductQuantity)));
            Map<LocalDate, Integer> saleDateWithSale = sales.stream()
                    .collect(Collectors.groupingBy(Sale::getDate,
                            Collectors.summingInt(Sale::getSoldProductQuantity)));



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
