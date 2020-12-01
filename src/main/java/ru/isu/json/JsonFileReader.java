package ru.isu.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import ru.isu.Product;
import ru.isu.Sale;
import ru.isu.Seller;
import ru.isu.SellerProduct;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Класс - singleton для чтения json файлов
 * @author Сергей
 */

public class JsonFileReader implements AutoCloseable {
    public static final JsonFileReader INSTANCE = new JsonFileReader();
    JsonReader reader;
    Gson gson;

    private JsonFileReader() {
        gson = new Gson();
    }

    /**
     * Получение товаров из json файла
     * @return список товаров
     * @throws FileNotFoundException если файл не найден
     */
    public List<Product> getProductsList() throws FileNotFoundException {
        File file = new File("product.json");
        reader = new JsonReader(new FileReader(file));
        return gson.fromJson(reader, new TypeToken<List<Product>>() {
        }.getType());
    }

    /**
     * Получение продаж из json файла
     * @return список продаж
     * @throws FileNotFoundException если файл не найден
     */
    public List<Sale> getSaleList() throws FileNotFoundException {
        File file = new File("sale.json");
        reader = new JsonReader(new FileReader(file));
        return gson.fromJson(reader, new TypeToken<List<Sale>>() {
        }.getType());

    }

    /**
     * Получение продавцов из json файла
     * @return список продавцов
     * @throws FileNotFoundException если файл не найден
     */
    public List<Seller> getSellerList() throws FileNotFoundException {
        File file = new File("seller.json");
        reader = new JsonReader(new FileReader(file));
        return gson.fromJson(reader, new TypeToken<List<Seller>>() {
        }.getType());

    }

    /**
     * Получение товаров у продавцов из json файла
     * @return список наличия товаров у продавцов
     * @throws FileNotFoundException если файл не найден
     */
    public List<SellerProduct> getSellerProductList() throws FileNotFoundException {

        File file = new File("sellerProduct.json");
        reader = new JsonReader(new FileReader(file));
        return gson.fromJson(reader, new TypeToken<List<SellerProduct>>() {
        }.getType());

    }


    @Override
    public void close() throws Exception {
        reader.close();
    }
}
