package BusniessLogic;

public class InterestedPeopl extends User{
	private Unit unit;
	private String preference;

	public InterestedPeopl(int id, String name, String email, String pass, String qualString, String avail, Unit u, String p) {
		super(id, name, email, pass, qualString, avail);
		// TODO Auto-generated constructor stub
		this.unit=u;
		this.preference=p;
	}

	public InterestedPeopl() {
		// TODO Auto-generated constructor stub
		super();
		this.unit=null;
		this.preference=null;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}
	
}
