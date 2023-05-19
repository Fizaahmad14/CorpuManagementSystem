package BusniessLogic;

import java.util.ArrayList;
import java.util.List;

import DataBase.DbHandler;

public class PermanentStaff extends User {
	DbHandler db = new DbHandler();
	
	private List<Unit> managedUnits;
	
    public PermanentStaff(int id, String name, String email, String phone, String qualString, String avail, String u, String p) {
		super(id, name, email,phone,qualString, avail,u,p);

	}

    public PermanentStaff() {
    	super();
	}
    

	public List<Unit> getManagedUnits() {
        return managedUnits;
    }

    public void setManagedUnits(List<Unit> managedUnits) {
        this.managedUnits = managedUnits;
    }

    public void addManagedUnit(Unit unit) {
        managedUnits.add(unit);
    }

    public void removeManagedUnit(Unit unit) {
        managedUnits.remove(unit);
    }

    public ArrayList<String> loadUnits()
    {
    	ArrayList<String> unitNamesList = db.readUnits();
    	return unitNamesList;
    }
    
    public ArrayList<String> loadPreferences()
    {
    	ArrayList<String> preferenceNamesList = db.readPreferences();
    	return preferenceNamesList;
    }
    
    public ArrayList<String> loadAvailabilities()
    {
    	ArrayList<String> availabilityList = db.readAvailabilities();
    	return availabilityList;
    }
    
	public void hireSessionalStaff(InterestedPeopl att) {
		
		// TODO Auto-generated method stub
		int id = att.getId();
		SessionalStaff ss = new SessionalStaff(att.getId(),att.getName(),att.getEmail(),att.getPhone(),att.getQualifications(),att.getAvailablilityList(),att.getUnit().getName(),att.getPreference()); 
		db.writeSessionalData(ss);
		db.deleteInterested(id);	
	}

	public ArrayList<InterestedPeopl> loadUsersApplied(){
		ArrayList<InterestedPeopl> pplList = db.readUsersApplied();
		return pplList;
	}

}
