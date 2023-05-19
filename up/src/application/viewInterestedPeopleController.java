package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import BusniessLogic.InterestedPeopl;
import BusniessLogic.PermanentStaff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class viewInterestedPeopleController implements Initializable{
	PermanentStaff ps = new PermanentStaff();
	
	private String selectedPreference = null;
	@FXML
    private Button HireButton;
	
	@FXML
    private Button GoBackButton;
	
    @FXML
    private ComboBox<String> search;

    @FXML
    private Label unit_name;

    @FXML
    private TableColumn<InterestedPeopl, String> peopleAppliedAvailability;

    @FXML
    private TableColumn<InterestedPeopl, String> peopleAppliedEmail;

    @FXML
    private TableColumn<InterestedPeopl, String> peopleAppliedID;

    @FXML
    private TableColumn<InterestedPeopl, String> peopleAppliedName;

    @FXML
    private TableColumn<InterestedPeopl, String> peopleAppliedQualification;
    
    @FXML
    private TableView<InterestedPeopl> table;
    
    @FXML
    public void initializeCombobox() {  	
    	System.out.println("initializee");
    	ArrayList<String> preferenceList = ps.loadPreferences();
    	search.getItems().addAll(preferenceList);
    }

    //This is the hire button and will prompt that the selected user has been successfully hired
    @FXML
    void hire(ActionEvent event) throws IOException {
    	
    	InterestedPeopl att = table.getSelectionModel().getSelectedItem();
		ps.hireSessionalStaff(att);
		
		Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
		alertObj.setHeaderText("HIRED");
		alertObj.setTitle("Successfull");
		alertObj.setContentText("Sessional member has been hired successfully!");
		alertObj.showAndWait();
		
    	Main m = new Main();
		m.changeScene("ViewInterestedPeople.fxml");
    }
    
    //this is the go back button that will take the user back to the amdin portal
    @FXML
    void goToHome(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("adminPortal.fxml");
    }

    @FXML
    void searchPreference(ActionEvent event) throws IOException {
    	this.selectedPreference = search.getValue();
    	System.out.println("Admin Selected Preference: "+selectedPreference);
    	Main m = new Main();
		m.changeScene("ViewInterestedPeople.fxml");
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	initializeCombobox();
    	int id = ps.currentAdmin();
    	String unitName = ps.currentUnit();
    	unit_name.setText(unitName); 
    	ArrayList<InterestedPeopl> attList = null;
    	
    	if(selectedPreference == null)
    	{
    		attList = ps.loadUsersApplied(id);
    	}
    	else
    	{
    		attList = ps.showSpecificPreference(id,this.selectedPreference);
    	}
   	
		ObservableList<InterestedPeopl> data = FXCollections.observableArrayList(attList);
		
		peopleAppliedID.setCellValueFactory(new PropertyValueFactory<InterestedPeopl,String>("id"));
		
		peopleAppliedName.setCellValueFactory(new PropertyValueFactory<InterestedPeopl,String>("name"));
		
		peopleAppliedEmail.setCellValueFactory(new PropertyValueFactory<InterestedPeopl,String>("email"));

		peopleAppliedQualification.setCellValueFactory(new PropertyValueFactory<InterestedPeopl,String>("qualifications"));
		
		peopleAppliedAvailability.setCellValueFactory(new PropertyValueFactory<InterestedPeopl,String>("availablilityList"));
		
		table.setItems(data);

	}

	public String getSelectedPreference() {
		return selectedPreference;
	}

	public void setSelectedPreference(String selectedPreference) {
		this.selectedPreference = selectedPreference;
	}

}
