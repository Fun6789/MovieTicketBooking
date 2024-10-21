package com.PersonalProject.MovieTicketBooking;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double totalPrice;
    private String paymentMode;
    private int ticketNumber;
    private double totalAfterAddingGST;

    @ManyToOne
    @JoinColumn(name = "cinema_hall_id")
    private CinemaHall cinemaHall;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String date;

    public Payment() {}

    public Payment(double totalPrice, String paymentOption, int ticketNumber, double gst, CinemaHall cinemaHall, User user, String date) {
        this.totalPrice = totalPrice;
        this.paymentMode = paymentOption;
        this.ticketNumber = ticketNumber;
        this.totalAfterAddingGST = gst;
        this.cinemaHall = cinemaHall;
        this.user = user;
        this.date = date;
    }

    // Getters and Setter

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentOption) {
		this.paymentMode = paymentOption;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public double getTotalAfterAddingGst() {
		return totalAfterAddingGST;
	}

	public void setTotalAfterAddingGst(double gst) {
		this.totalAfterAddingGST = gst;
	}

	public CinemaHall getCinemaHall() {
		return cinemaHall;
	}

	public void setCinemaHall(CinemaHall cinemaHall) {
		this.cinemaHall = cinemaHall;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


    
}

