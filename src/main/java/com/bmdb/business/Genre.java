package com.bmdb.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Genre {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Name;
	
	
	public Genre(int id, String name) {
		super();
		Id = id;
		Name = name;
	}
	
	public Genre(String name) {
		super();
			Name = name;
	}
	

	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}



	@Override
	public String toString() {
		return "Genre [Id=" + Id + ", Name=" + Name + "]";
	}



	

}
