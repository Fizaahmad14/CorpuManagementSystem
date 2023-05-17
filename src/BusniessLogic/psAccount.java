package BusniessLogic;

import java.util.ArrayList;
import java.util.List;

public class psAccount {
	private String email;
	private String pass;
	
	public psAccount(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
