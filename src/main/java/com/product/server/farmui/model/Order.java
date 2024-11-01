package com.product.server.farmui.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private Long id;
    
    private String orderNumber;
    private LocalDateTime orderDate;

    private String status; // Possible values: PENDING, PROCESSING, COMPLETED, CANCELLED
    private BigDecimal totalAmount;
    private String specialRequests;
    

    private UserInfo customer;
    

    private Tour tour;

    private List<KoiPurchase> koiPurchases;
    
    /**
     * List of feedbacks for this order.
     * Feedbacks can only be added when order status is COMPLETED.
     */
    private List<Feedback> feedbacks;

    /**
     * Adds a feedback to the order if the order is completed.
     * @param feedback The feedback to add
     * @throws IllegalStateException if order is not completed
     */
    public void addFeedback(Feedback feedback) {
        if (!"COMPLETED".equals(this.status)) {
            throw new IllegalStateException("Cannot add feedback to non-completed order");
        }
        feedback.setOrder(this);
        this.feedbacks.add(feedback);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    public UserInfo getCustomer() {
        return customer;
    }

    public void setCustomer(UserInfo customer) {
        this.customer = customer;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public List<KoiPurchase> getKoiPurchases() {
        return koiPurchases;
    }

    public void setKoiPurchases(List<KoiPurchase> koiPurchases) {
        this.koiPurchases = koiPurchases;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
