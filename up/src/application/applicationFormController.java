package application;

import java.io.IOException;

import BusniessLogic.Availability;
import BusniessLogic.Controller;
import BusniessLogic.InterestedPeopl;
import BusniessLogic.SessionalStaff;
import DataBase.DbHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class applicationFormController {
    InterestedPeopl intr = new InterestedPeopl();
	DbHandler db = new DbHandler();
	//SelectUnitPageController supc = new SelectUnitPageController();
	
	
    @FXML
    private Button GoBackButton;
    
	@FXML
    private TextField EmailField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField QualificationField;

    @FXML
    private Button applyButton;
    
    @FXML
    private ComboBox<String> timeSlot;
    
    @FXML
    public void initialize() {
    	timeSlot.getItems().addAll(
            "Monday (10:00AM - 5:00PM)",
            "Tuesday (10:00AM - 5:00PM)",
            "Wednesday (10:00AM - 5:00PM)",
            "Thursday (10:00AM - 5:00PM)",
            "Friday (10:00AM - 5:00PM)",
            "Saturday (10:00AM - 5:00PM)",
            "Sunday (10:00AM - 5:00PM)",
            "Monday (6:00PM - 11:00PM)",
            "Tuesday (6:00PM - 11:00PM)",
            "Wednesday (6:00PM - 11:00PM)"
        );
    }

    //This is the apply button go back to home where a prmompt will be shown to user saying that your application has been successfully submitted
    @FXML
    void BackToHome(ActionEvent event) throws IOException {
    	intr.setName(NameField.getText());
    	intr.setEmail(EmailField.getText());
    	intr.setQualifications(QualificationField.getText());
//    	intr.setAvailablilityList(null);
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
//    	Availability availability = new Availability();
//    	availability = availability.parseAvailabilityString(selectedTime);
    			
    }

}