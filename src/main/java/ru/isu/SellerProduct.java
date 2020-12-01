package ru.isu;

/**
 * Модель наличия товаров у продаца
 * @author Сергей
 */
public class SellerProduct {
    private int sellerId;
    private int productId;
    private int cost;
    private int quantity;

    public SellerProduct(int sellerId, int productId, int cost, int quantity) {
        this.sellerId = sellerId;
        this.productId = productId;
        this.cost = cost;
        this.quantity = quantity;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSellerId() {
        return sellerId;
    }

    public int getProductId() {
        return productId;
    }

    public int getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "SellerProduct{" +
                "sellerId=" + sellerId +
                ", productId=" + productId +
                ", cost=" + cost +
                ", quantity=" + quantity +
                '}';
    }
}
