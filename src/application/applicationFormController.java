package application;

import java.io.IOException;
import java.util.ArrayList;

import BusniessLogic.InterestedPeopl;
import BusniessLogic.PermanentStaff;
import BusniessLogic.Unit;
import DataBase.DbHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class applicationFormController {
	
	PermanentStaff ps = new PermanentStaff(); 
    InterestedPeopl intr = new InterestedPeopl();
	DbHandler db = new DbHandler();
	
    @FXML
    private Button GoBackButton;
    
	@FXML
    private TextField EmailField;

    @FXML
    private TextField NameField;
    
    @FXML
    private TextField phone;

    @FXML
    private TextField QualificationField;

    @FXML
    private Button applyButton;
    
    @FXML
    private ComboBox<String> timeSlot;
    
    @FXML
    public void initialize() {
    	
    	ArrayList<String> availablilityList = ps.loadAvailabilities();
    	timeSlot.getItems().addAll(availablilityList);
    }

    //This is the apply button go back to home where a prmompt will be shown to user saying that your application has been successfully submitted
    @FXML
    void apply(ActionEvent event) throws IOException {
    	intr.setName(NameField.getText());
    	intr.setEmail(EmailField.getText());
    	intr.setPhone(phone.getText());
    	intr.setQualifications(QualificationField.getText());
    	db.writeInterestedData(intr);
    	Main m = new Main();
    	m.changeScene("HomePage.fxml");
    }
    
    //This is the go back button where user will simply go back to the homepage portal
    @FXML
    void gotoHome(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("SelectUnitPage.fxml");
    }
    
    @FXML
    void selectTimeSlots(ActionEvent event) {
    	String selectedTime = timeSlot.getValue();
    	intr.setAvailablilityList(selectedTime);
    	System.out.println("User Selected TimeSlot: "+selectedTime);
    }
    
    public void setUnitAndPreference(String unit, String preference) {
    	Unit unitObj = new Unit(unit);
        intr.setPreference(preference);
        intr.setUnit(unitObj);
    }

}
