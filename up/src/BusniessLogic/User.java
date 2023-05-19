package BusniessLogic;

public class User {
	private int id;
    private String name;
    private String email;
    private String phone;
    private String qualifications;
    private String availablilityList;
    private Unit unit = new Unit();
    private String preference;
		

    public User(int id, String name, String email,String phone,String qualString,String avail,String unit, String preference) {
    	this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.qualifications = qualString;
        this.availablilityList = avail;
        this.unit = new Unit(unit);
        this.preference = preference;
        
    }

    // Getters and setters for the fields

    public User() {
    	this.id = 0;
        this.name = null;
        this.email = null;
        this.phone = null;
        this.qualifications=null;
        this.availablilityList=null;
        this.unit = new Unit();
        this.preference = null;
	}

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

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public String getAvailablilityList() {
		return availablilityList;
	}

	public void setAvailablilityList(String availablilityList) {
		this.availablilityList = availablilityList;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", qualifications=" + qualifications
				+ ", availablilityList=" + availablilityList + ", unit=" + unit + ", preference=" + preference + "]";
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

