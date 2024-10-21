package com.PersonalProject.MovieTicketBooking;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cinema_hall_id")
    private CinemaHall cinemaHall;

    private int ticketNumber;

    public Booking() {}

    public Booking(User user, CinemaHall cinemaHall, int seatingNumber) {
        this.user = user;
        this.cinemaHall = cinemaHall;
        this.ticketNumber = seatingNumber;
    }

    // Getters and Setters
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CinemaHall getCinemaHall() {
		return cinemaHall;
	}

	public void setCinemaHall(CinemaHall cinemaHall) {
		this.cinemaHall = cinemaHall;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int seatingNumber) {
		this.ticketNumber = seatingNumber;
	}


}