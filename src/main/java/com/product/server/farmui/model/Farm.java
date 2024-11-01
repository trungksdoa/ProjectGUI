package com.product.server.farmui.model;



import java.util.List;

public class Farm {
    private Long id;
    private String name;
    private String location;
    private String description;

    private List<KoiFish> koiFishes;

    private List<Tour> tours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<KoiFish> getKoiFishes() {
        return koiFishes;
    }

    public void setKoiFishes(List<KoiFish> koiFishes) {
        this.koiFishes = koiFishes;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }
}
