package com.PersonalProject.MovieTicketBooking;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String city;
    private String language;
    private int typeOfCustomer;
	private String interest;

    public User() {}

    public User(int id,String name, int age, String city, String language, String interest,int typeOfCustomer) {
       this.id=id;
    	this.name = name;
        this.age = age;
        this.typeOfCustomer= typeOfCustomer;
        this.city = city;
        this.language = language;
        this.interest = interest;
    }

	// Getter and setter method for each attribute 
   
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return city;
	}

	public void setLocation(String location) {
		this.city = location;
	}

	public String getLanguage() {
		return city;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	public int getTypeOfCustomer() {
		return typeOfCustomer;
	}

	public void setTypeOfCustomer(int typeOfCustomer) {
		this.typeOfCustomer = typeOfCustomer;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}


    // Getters and Setters
}