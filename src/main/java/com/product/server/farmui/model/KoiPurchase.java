package com.product.server.farmui.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;


public class KoiPurchase {

    private Long id;
    private LocalDateTime purchaseDate;
    private BigDecimal price;
    private BigDecimal depositAmount;
    private LocalDateTime expectedDeliveryDate;
    private String status; // ORDERED, IN_TRANSIT, DELIVERED

    private Order order;

    private KoiFish koiFish;

    private Farm farm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public LocalDateTime getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDateTime expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public KoiFish getKoiFish() {
        return koiFish;
    }

    public void setKoiFish(KoiFish koiFish) {
        this.koiFish = koiFish;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}
