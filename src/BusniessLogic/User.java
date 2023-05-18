package BusniessLogic;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
    private String name;
    private String email;
    private String pass;
    private String qualifications;
    private String availablilityList;
		

    public User(int id, String name, String email,String pass, String qualString,String avail) {
    	this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
//        this.phone = phone;
        this.qualifications=qualString;
        this.availablilityList=avail;
    }

    // Getters and setters for the fields

    public User() {
    	this.id = 0;
        this.name = null;
        this.email = null;
        this.pass = null;
//        this.phone = phone;
        this.qualifications=null;
        this.availablilityList=null;
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

//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }


	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + ", qualifications="
				+ qualifications + ", availablilityList=" + availablilityList + "]";
	}
	
}

