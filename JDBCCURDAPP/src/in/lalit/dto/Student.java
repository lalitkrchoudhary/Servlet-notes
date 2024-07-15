package in.lalit.dto;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersion =1L;
	
	private Integer id;
	private String name;
	private String country;
	private String city;
	private String email;
	
	static {
		System.out.println("Student.class is loading....");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", country=" + country + ", city=" + city + ", email=" + email
				+ "]";
	}
}
	
	