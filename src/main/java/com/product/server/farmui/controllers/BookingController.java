package com.product.server.farmui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BookingController {
    @FXML
    private ComboBox<String> tourTypeComboBox;
    @FXML
    private DatePicker preferredDatePicker;
    @FXML
    private TextField customerNameField;
    @FXML
    private TextField contactNumberField;
    @FXML
    private TextField emailField;
    @FXML
    private Spinner<Integer> participantsSpinner;
    @FXML
    private TextArea specialRequirementsArea;

    @FXML
    private void initialize() {
        setupControls();
    }

    private void setupControls() {
        // Initialize tour types
        tourTypeComboBox.getItems().addAll(
            "Standard Farm Tour",
            "Premium Selection Tour",
            "Custom Tour"
        );
        
        // Setup spinner
        SpinnerValueFactory<Integer> valueFactory = 
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        participantsSpinner.setValueFactory(valueFactory);
    }

    @FXML
    private void handleClear() {
        customerNameField.clear();
        contactNumberField.clear();
        emailField.clear();
        tourTypeComboBox.getSelectionModel().clearSelection();
        preferredDatePicker.setValue(null);
        participantsSpinner.getValueFactory().setValue(1);
        specialRequirementsArea.clear();
    }

    @FXML
    private void handleBooking() {
        // Validate inputs
        if (!validateInputs()) {
            return;
        }

        // TODO: Implement booking logic
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Booking Confirmation");
        alert.setHeaderText("Booking Submitted");
        alert.setContentText("Your booking request has been submitted successfully!");
        alert.showAndWait();
        
        // Clear form after successful booking
        handleClear();
    }

    private boolean validateInputs() {
        StringBuilder errors = new StringBuilder();

        if (customerNameField.getText().trim().isEmpty()) {
            errors.append("- Please enter customer name\n");
        }
        if (contactNumberField.getText().trim().isEmpty()) {
            errors.append("- Please enter contact number\n");
        }
        if (emailField.getText().trim().isEmpty()) {
            errors.append("- Please enter email\n");
        }
        if (tourTypeComboBox.getValue() == null) {
            errors.append("- Please select tour type\n");
        }
        if (preferredDatePicker.getValue() == null) {
            errors.append("- Please select preferred date\n");
        }

        if (errors.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setHeaderText("Please correct the following errors:");
            alert.setContentText(errors.toString());
            alert.showAndWait();
            return false;
        }

        return true;
    }
} 
