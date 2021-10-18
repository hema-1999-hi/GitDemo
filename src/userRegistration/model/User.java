package userRegistration.model;

public class User {
	private int id;
	private String name;
	private String email;
	private String phonenum;
	private String country;
	public User(int id, String name, String email, String phonenum, String country) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonenum = phonenum;
		this.country = country;
	}
	public User() {
		super();
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
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phonenum=" + phonenum + ", country="
				+ country + "]";
	}
	
	

}
