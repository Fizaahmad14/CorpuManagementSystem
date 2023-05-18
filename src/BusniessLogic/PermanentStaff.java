package BusniessLogic;

import java.util.ArrayList;
import java.util.List;

import DataBase.DbHandler;

public class PermanentStaff extends User {
	DbHandler db = new DbHandler();
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private List<Unit> managedUnits;
    private int id;
    private String name;
    private String email;
    private String pass;
    private String phone;
    public PermanentStaff(int id, String name,String email, String pass,String phone) {
        this.managedUnits = new ArrayList<>();
    }

    public PermanentStaff() {
    	super();
		// TODO Auto-generated constructor stub
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

	public void hireSessionalStaff(InterestedPeopl att) {
		
		// TODO Auto-generated method stub
		id = att.getId();
		SessionalStaff ss = new SessionalStaff(att.getId(),att.getName(),att.getEmail(),att.getQualifications(),att.getAvailablilityList(),att.getUnit().getName(),att.getPreference()); 
		db.writeSessionalData(ss);
		db.deleteInterested(id);	
	}

	public ArrayList<InterestedPeopl> loadUsersApplied(){
		ArrayList<InterestedPeopl> pplList = db.readUsersApplied();
		return pplList;
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
