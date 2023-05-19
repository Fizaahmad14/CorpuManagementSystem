package BusniessLogic;

public class InterestedPeopl extends User{
	private Unit unit = new Unit();
	private String preference;

	public InterestedPeopl(int id, String name, String email,String qualString, String avail, String u, String p) {
		super(id, name, email,qualString, avail);
		// TODO Auto-generated constructor stub
		this.unit.setName(u);
		this.preference=p;
	}

	public InterestedPeopl() {
		// TODO Auto-generated constructor stub
		super();
		this.unit= new Unit();
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
