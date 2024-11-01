package com.product.server.farmui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HomeController {
    @FXML
    private GridPane farmGrid;
    @FXML
    private GridPane koiGrid;

    @FXML
    private void initialize() {
        setupFarmCards();
        setupKoiCards();
    }

    private void setupFarmCards() {
        // Mock farm data
        String[][] farmData = {
            {"Sakai Fish Farm", "Hiroshima, Japan", 
             "Established in 1945, specializing in high-quality Kohaku and Sanke varieties. Known for producing multiple All-Japan Koi Show champions."},
            {"Dainichi Koi Farm", "Niigata, Japan", 
             "Famous for their unique Showa and Goshiki bloodlines. Over 60 years of breeding excellence."},
            {"Momotaro Koi Farm", "Okayama, Japan", 
             "Renowned for innovative breeding techniques and exceptional Sanke varieties. State-of-the-art facilities."},
            {"Marujyu Koi Farm", "Niigata, Japan", 
             "Specializes in metallic Koi varieties. Award-winning Gin Rin and Doitsu bloodlines."}
        };

        for (int i = 0; i < farmData.length; i++) {
            VBox card = createFarmCard(farmData[i][0], farmData[i][1], farmData[i][2]);
            farmGrid.add(card, i % 2, i / 2);
        }
    }

    private void setupKoiCards() {
        // Mock koi variety data
        String[][] koiData = {
            {"Kohaku", "The most popular variety featuring a white body with red patterns. Symbolizes success and perseverance."},
            {"Sanke", "Tri-colored koi with white body, red and black markings. Known for their elegant appearance."},
            {"Showa", "Black-based koi with red and white patterns. Represents strength and power."},
            {"Goshiki", "Five-colored koi featuring black, red, white, blue and dark blue. Highly prized for their unique coloration."}
        };

        for (int i = 0; i < koiData.length; i++) {
            VBox card = createKoiCard(koiData[i][0], koiData[i][1]);
            koiGrid.add(card, i % 2, i / 2);
        }
    }

    private VBox createFarmCard(String name, String location, String description) {
        VBox card = new VBox(10);
        card.getStyleClass().add("farm-card");

        Label nameLabel = new Label(name);
        nameLabel.getStyleClass().add("farm-name");

        Label locationLabel = new Label(location);
        locationLabel.getStyleClass().add("farm-location");

        Label descLabel = new Label(description);
        descLabel.getStyleClass().add("farm-description");
        descLabel.setWrapText(true);

        card.getChildren().addAll(nameLabel, locationLabel, descLabel);
        return card;
    }

    private VBox createKoiCard(String name, String description) {
        VBox card = new VBox(10);
        card.getStyleClass().add("koi-card");

        Label nameLabel = new Label(name);
        nameLabel.getStyleClass().add("koi-name");

        Label descLabel = new Label(description);
        descLabel.getStyleClass().add("koi-description");
        descLabel.setWrapText(true);

        card.getChildren().addAll(nameLabel, descLabel);
        return card;
    }
} 