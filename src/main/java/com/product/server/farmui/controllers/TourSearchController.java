package com.product.server.farmui.controllers;

import com.product.server.farmui.model.Tour;
import com.product.server.farmui.model.Farm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TourSearchController {
    @FXML
    private ComboBox<String> farmComboBox;
    @FXML
    private ComboBox<String> koiVarietyComboBox;
    @FXML
    private DatePicker tourDatePicker;
    @FXML
    private TextField minPriceField;
    @FXML
    private TextField maxPriceField;
    @FXML
    private TableView<Tour> tourTableView;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @FXML
    private void initialize() {
        setupComboBoxes();
        setupTableView();
        loadMockData();
        setupTableViewSelection();
    }

    private void setupTableViewSelection() {
        // Add selection listener
        tourTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                showTourDetails(newSelection);
            }
        });

        // Add click listener
        tourTableView.setRowFactory(tv -> {
            TableRow<Tour> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Tour tour = row.getItem();
                    showTourDetails(tour);
                }
            });
            return row;
        });
    }

    private void showTourDetails(Tour tour) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Tour Details");
        dialog.setHeaderText("Details for " + tour.getName());

        // Create content
        DialogPane dialogPane = dialog.getDialogPane();
        VBox content = new VBox(10);
        content.getStyleClass().add("tour-details");

        // Add tour information
        content.getChildren().addAll(
            createDetailLabel("Tour Name", tour.getName()),
            createDetailLabel("Farm", tour.getFarm().getName()),
            createDetailLabel("Start Date", DATE_FORMATTER.format(tour.getStartDate())),
            createDetailLabel("Price", tour.getPrice().toString()),
            createDetailLabel("Max Participants", tour.getMaxParticipants().toString()),
            createDetailLabel("Status", tour.getStatus()),
            createDetailLabel("Guide", tour.getGuide()),
            createDetailLabel("Description", tour.getDescription())
        );

        if (tour.getItinerary() != null && !tour.getItinerary().isEmpty()) {
            content.getChildren().add(createDetailLabel("Itinerary", tour.getItinerary()));
        }

        dialogPane.setContent(content);
        dialogPane.getButtonTypes().add(ButtonType.CLOSE);

        // Add styling
        dialog.getDialogPane().getStylesheets().add(
            getClass().getResource("/com/product/server/farmui/styles.css").toExternalForm()
        );

        dialog.showAndWait();
    }

    private Label createDetailLabel(String title, String value) {
        return new Label(title + ": " + (value != null ? value : "N/A"));
    }

    private void setupComboBoxes() {
        // Mock farm data
        farmComboBox.getItems().addAll(
            "Sakai Fish Farm",
            "Dainichi Koi Farm",
            "Momotaro Koi Farm",
            "Marujyu Koi Farm"
        );

        // Mock koi varieties
        koiVarietyComboBox.getItems().addAll(
            "Kohaku",
            "Sanke",
            "Showa",
            "Goshiki",
            "Shiro Utsuri",
            "Chagoi"
        );
    }

    private void setupTableView() {
        TableColumn<Tour, String> nameCol = new TableColumn<>("Tour Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setPrefWidth(150);

        TableColumn<Tour, String> farmCol = new TableColumn<>("Farm");
        farmCol.setCellValueFactory(cellData -> {
            Farm farm = cellData.getValue().getFarm();
            return farm != null ? javafx.beans.binding.Bindings.createStringBinding(
                () -> farm.getName()) : null;
        });
        farmCol.setPrefWidth(150);

        TableColumn<Tour, LocalDateTime> startDateCol = new TableColumn<>("Start Date");
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        startDateCol.setCellFactory(column -> new TableCell<Tour, LocalDateTime>() {
            @Override
            protected void updateItem(LocalDateTime date, boolean empty) {
                super.updateItem(date, empty);
                if (empty || date == null) {
                    setText(null);
                } else {
                    setText(DATE_FORMATTER.format(date));
                }
            }
        });
        startDateCol.setPrefWidth(150);

        TableColumn<Tour, BigDecimal> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceCol.setPrefWidth(100);

        TableColumn<Tour, Integer> maxParticipantsCol = new TableColumn<>("Max Participants");
        maxParticipantsCol.setCellValueFactory(new PropertyValueFactory<>("maxParticipants"));
        maxParticipantsCol.setPrefWidth(120);

        TableColumn<Tour, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusCol.setPrefWidth(100);

        TableColumn<Tour, String> guideCol = new TableColumn<>("Guide");
        guideCol.setCellValueFactory(new PropertyValueFactory<>("guide"));
        guideCol.setPrefWidth(120);

        tourTableView.getColumns().addAll(
            nameCol, farmCol, startDateCol, priceCol, 
            maxParticipantsCol, statusCol, guideCol
        );
    }

    private void loadMockData() {
        ObservableList<Tour> mockData = FXCollections.observableArrayList();
        
        // Create mock farms
        Farm sakaiForm = new Farm();
        sakaiForm.setName("Sakai Fish Farm");
        
        Farm dainichiFarm = new Farm();
        dainichiFarm.setName("Dainichi Koi Farm");

        // Create mock tours
        Tour tour1 = new Tour();
        tour1.setName("Premium Koi Tour");
        tour1.setFarm(sakaiForm);
        tour1.setStartDate(LocalDateTime.now().plusDays(7));
        tour1.setPrice(new BigDecimal("2500.00"));
        tour1.setMaxParticipants(10);
        tour1.setStatus("SCHEDULED");
        tour1.setGuide("Tanaka San");

        Tour tour2 = new Tour();
        tour2.setName("Expert Selection Tour");
        tour2.setFarm(dainichiFarm);
        tour2.setStartDate(LocalDateTime.now().plusDays(14));
        tour2.setPrice(new BigDecimal("3000.00"));
        tour2.setMaxParticipants(5);
        tour2.setStatus("SCHEDULED");
        tour2.setGuide("Suzuki San");

        mockData.addAll(tour1, tour2);
        tourTableView.setItems(mockData);
    }

    @FXML
    private void handleSearch() {
        String selectedFarm = farmComboBox.getValue();
        String selectedVariety = koiVarietyComboBox.getValue();
        LocalDateTime selectedDate = tourDatePicker.getValue() != null ? 
            tourDatePicker.getValue().atStartOfDay() : null;

        BigDecimal minPrice = null;
        BigDecimal maxPrice = null;
        try {
            if (!minPriceField.getText().isEmpty()) {
                minPrice = new BigDecimal(minPriceField.getText());
            }
            if (!maxPriceField.getText().isEmpty()) {
                maxPrice = new BigDecimal(maxPriceField.getText());
            }
        } catch (NumberFormatException e) {
            showAlert("Invalid price format", "Please enter valid numbers for price range.");
            return;
        }

        BigDecimal finalMinPrice = minPrice;
        BigDecimal finalMaxPrice = maxPrice;
        ObservableList<Tour> filteredData = tourTableView.getItems().filtered(tour ->
            (selectedFarm == null || tour.getFarm().getName().equals(selectedFarm)) &&
            (selectedDate == null || tour.getStartDate().toLocalDate().equals(selectedDate.toLocalDate())) &&
            (finalMinPrice == null || tour.getPrice().compareTo(finalMinPrice) >= 0) &&
            (finalMaxPrice == null || tour.getPrice().compareTo(finalMaxPrice) <= 0)
        );

        tourTableView.setItems(filteredData);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
} 