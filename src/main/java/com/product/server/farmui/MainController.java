package com.product.server.farmui;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

public class MainController {
    @FXML
    private TabPane mainTabPane;

    @FXML
    private void initialize() {
        // Initialize main controller
        setupTabs();
    }

    private void setupTabs() {
        // You can add any tab-specific initialization here
        mainTabPane.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            // Handle tab changes if needed
            System.out.println("Selected tab: " + newTab.getText());
        });
    }
} 