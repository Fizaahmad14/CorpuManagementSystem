package application;

import java.io.IOException;
import java.util.ArrayList;

import BusniessLogic.PermanentStaff;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class SelectUnitPageController {
	
	private String selectedUnit;
	
	private String selectedPreference;
	
	
	PermanentStaff ps = new PermanentStaff();
	
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
    	ArrayList<String> unitList = ps.loadUnits();
    	ArrayList<String> preferenceList = ps.loadPreferences();
    	unit.getItems().addAll(unitList);
    	preference.getItems().addAll(preferenceList);
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("HomePage.fxml");
    }

    //this is the next button
    @FXML
    void toApplicationForm(ActionEvent event) throws IOException {
    	
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ApplicationForm.fxml"));
        Parent root = loader.load();
        
        applicationFormController controller = loader.getController();
        controller.setUnitAndPreference(selectedUnit, selectedPreference);
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) nextButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
//    	Main m = new Main();
//    	m.changeScene("ApplicationForm.fxml");
    }
    
    @FXML
    void handlePreference(ActionEvent event) {
    	this.selectedPreference = preference.getValue();
    	System.out.println("User Selected Preference: "+selectedPreference);
    }

    @FXML
    void handleUnits(ActionEvent event) {
    	this.selectedUnit = unit.getValue();
    	System.out.println("User Selected Unit: "+selectedUnit);
    }
}
