package com.PersonalProject.MovieTicketBooking;

import javax.persistence.*;

@Entity
@Table(name = "seating_layout")
public class SeatingLayout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numberOfSeats;
    private String seatPreference; // right, left, center, etc.
    private double seatPrice;
    private String cinemaHallName;

    public SeatingLayout() {}

    public SeatingLayout(int numberOfSeats, String seatPreference, double seatPrice, String cinemaHallName) {
        this.numberOfSeats = numberOfSeats;
        this.seatPreference = seatPreference;
        this.seatPrice = seatPrice;
        this.cinemaHallName = cinemaHallName;
    }

    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getSeatPreference() {
		return seatPreference;
	}

	public void setSeatPreference(String seatPreference) {
		this.seatPreference = seatPreference;
	}

	public double getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}

	public String getCinemaHallName() {
		return cinemaHallName;
	}

	public void setCinemaHallName(String cinemaHallName) {
		this.cinemaHallName = cinemaHallName;
	}

}



