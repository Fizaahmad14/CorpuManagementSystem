package BusniessLogic;

public class psAccount {
	private String email;
	private String pass;
	private int id;
	
	public psAccount(int id, String email, String pass) {
		this.setId(id);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
