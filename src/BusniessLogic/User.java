package BusniessLogic;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
    private String name;
    private String email;
    private String phone;
    private String pass;
    private List<Qualification> qualifications;
    private List<Availability> availablilityList;
		

    public User(int id, String name, String email,String pass, String phone) {
    	this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.qualifications = new ArrayList<>();
    }

    // Getters and setters for the fields

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

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

	public List<Availability> getAvailablilityList() {
		return availablilityList;
	}

	public void setAvailablilityList(List<Availability> availablilityList) {
		this.availablilityList = availablilityList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", qualifications="
				+ qualifications + ", availablilityList=" + availablilityList
				+ "]";
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}

