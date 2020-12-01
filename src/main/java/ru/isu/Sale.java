package ru.isu;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

/**
 * Модель продажи
 * @author Сергей
 */
public class Sale {
    private int saleId;
    private int sellerId;
    private int productId;
    @SerializedName("quantity")
    private int soldProductQuantity;
    private LocalDate date;

    public Sale(int saleId, int sellerId, int productId, int soldProductQuantity, LocalDate date) {
        this.saleId = saleId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.soldProductQuantity = soldProductQuantity;
        this.date = date;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setSoldProductQuantity(int soldProductQuantity) {
        this.soldProductQuantity = soldProductQuantity;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getSaleId() {
        return saleId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public int getProductId() {
        return productId;
    }

    public int getSoldProductQuantity() {
        return soldProductQuantity;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", sellerId=" + sellerId +
                ", productId=" + productId +
                ", soldProductQuantity=" + soldProductQuantity +
                ", date=" + date +
                '}';
    }
}
