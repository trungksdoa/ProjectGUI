package com.product.server.farmui.model;


import java.time.LocalDateTime;

public class Feedback {

    private Long id;
    private Integer rating;
    private String comment;
    private LocalDateTime createdDate;

    private Order order;

    private UserInfo customer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public UserInfo getCustomer() {
        return customer;
    }

    public void setCustomer(UserInfo customer) {
        this.customer = customer;
    }
}
