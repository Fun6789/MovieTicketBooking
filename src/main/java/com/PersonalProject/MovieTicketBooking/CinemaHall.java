package com.PersonalProject.MovieTicketBooking;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cinema_halls")
public class CinemaHall {

    @Id
    
    private int id;
	private String name;
    private double rating;
    private String location;
    private int seatingCapacity;
    
    @OneToOne
    @JoinColumn(name = "movie_id") 
    private Movie movie;


    public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@ElementCollection
    private List<String> moviesAndTimings; // recommendation: use manytoMany relationship between cinemahall and movie.
                                           // bifurcate it into two variable movies and tmimng
    public CinemaHall() {}

    public CinemaHall(String name, double rating, String location, int seatingCapacity, List<String> moviesAndTimings) {
        this.name = name;
        this.rating = rating;
        this.location = location;
        this.seatingCapacity = seatingCapacity;
        this.moviesAndTimings = moviesAndTimings;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int userId) {
		this.id = userId;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public List<String> getMoviesAndTimings() {
		return moviesAndTimings;
	}

	public void setMoviesAndTimings(List<String> moviesAndTimings) {
		this.moviesAndTimings = moviesAndTimings;
	}



  
}




