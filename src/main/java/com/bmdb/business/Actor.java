package com.bmdb.business;

import java.time.LocalDate;

public class Actor {
	
	private int id;
	private String fName;
	private String lName;
	private String gender;
	private LocalDate birthDate;
	
	public Actor(int id, String fName, String lName, String gender, LocalDate birthDate) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.birthDate = birthDate;
		
	}

	public Actor(String fName, String lName, String gender, LocalDate birthDate) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.birthDate = birthDate;
	}

	public Actor() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Actor "+id + "\n"
				+ "Name: " + fName + " "+lName + "\n"
				+ "Gender: "+ gender+ ", Birth date: "+ birthDate + "\n";
	}
	
	public String getFullName() {
		return fName +" "+lName;
	}
}

	
	