package com.technician.Springboot.model;
//DAO
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RegisteredTechnician")
public class Technician {

	@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long TechID;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gender")
  private String gender;
	
	@Column(name = "password")
  private String password;
	
	@Column(name = "permanentaddress")
  private String permanentaddress;
	
	@Column(name = "communicationaddress")
  private String communicationaddress;
  
  
  public Technician() {
  	
  	
  }
  
  
  
	public Technician(String name, String number, String email, String gender, String password, String permanentaddress, String communicationaddress) {
		super();
		this.name = name;
		this.number = number;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.permanentaddress = permanentaddress;
		this.communicationaddress = communicationaddress;
	}
	public long getTechID() {
		return TechID;
	}
	public void setTechID(long techID) {
		TechID = techID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getPermanentAddress() {
		return permanentaddress;
	}
	public void setPermanentAddress(String permanentaddress) {
		this.permanentaddress = permanentaddress;
	}
	
	
	public String getCommunicationAddress() {
		return communicationaddress;
	}
	public void setCommunicationAddress(String communicationaddress) {
		this.communicationaddress = communicationaddress;
	}



}





