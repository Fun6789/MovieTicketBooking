package com.PersonalProject.MovieTicketBooking;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double rating;
    private String releaseDate;   // reason of using date type.
    
    private String time; // list of timing
    private String language; // list of language
    
    @OneToOne(mappedBy = "movie")  // Bidirectional mapping
    private CinemaHall cinemaHall;

    public Movie() {}
    
    public Movie(String name, double rating, String releaseString, String time, String language,CinemaHall cinemaHall) {
        this.name = name;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.cinemaHall=cinemaHall;
        this.time = time;
        this.language = language;
    }

    // Getters and Setters
    
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	public CinemaHall getCinemaHall() {
		return cinemaHall;
	}

	public void setCinemaHall(CinemaHall cinemaHall) {
		this.cinemaHall = cinemaHall;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	
}
