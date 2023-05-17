package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SelectUnitPageController {
	@FXML
    private Button GoBackButton;

    @FXML
    private Button nextButton;

    @FXML
    private ComboBox<String> preference;

    @FXML
    private ComboBox<String> unit;
    
    @FXML
    public void initialize() {
    	unit.getItems().addAll("DLD", "AI", "CyberSecurity", "Algo","PDC", "Nummerical");
    	preference.getItems().addAll("Calculus", "Linear Algebra", "DLD", "AI", "CyberSecurity", "Algo", "SE", "PDC", "Nummerical");
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("HomePage.fxml");
    }

    //this is the next button
    @FXML
    void toApplicationForm(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("ApplicationForm.fxml");
    }
    
    @FXML
    void handlePreference(ActionEvent event) {
    	String selectedPreference= preference.getValue();
    	System.out.println("User Selected Preference: "+selectedPreference);
    }

    @FXML
    void handleUnits(ActionEvent event) {
    	String selectedUnit = unit.getValue();
    	System.out.println("User Selected Unit: "+selectedUnit);
    }
}
