package com.PersonalProject.MovieTicketBooking;
import java.util.*;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 

{
	
	Scanner sc= new Scanner(System.in);
	public int userRegistration(User user, Session session) {
		System.out.println("Enter your name.");
		user.setName(sc.nextLine());
		System.out.println("Enter your age.");
		user.setAge(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter your city.");
	    user.setLocation(sc.nextLine());
	    System.out.println("Enter your preferred Languages.");
	    user.setLanguage(sc.nextLine());
	    System.out.println("Enter 1 if your are movie watcher, otherwise 2.");
	    user.setTypeOfCustomer(sc.nextInt());
	    sc.nextLine();
	    if(user.getTypeOfCustomer()==1) {
	    System.out.println("Enter your interest.");
	    user.setInterest(sc.nextLine());
	    }
	    if(user.getTypeOfCustomer()==1 || user.getTypeOfCustomer()==2)
	    session.save(user);
	    
	    
	    
	    // Get the ID of the saved user
	    if(user.getTypeOfCustomer()==2) {
	    int userId = user.getId();
	    cinemaHallRegisteration(session,userId);
	    }
	  
	    
	    return user.getTypeOfCustomer();
	}
	
	public Movie setMovies(Session session) {
		Movie movies= new Movie();
		System.out.println("Enter name of movie.");
		movies.setName(sc.nextLine());
		System.out.println("Enter the rating recived by the movie on IMBd.");
		movies.setRating(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter release date of the movie.");
	    movies.setReleaseDate(sc.nextLine());
	    System.out.println("Enter the languages in which this movie is available.");
	    movies.setLanguage(sc.nextLine());
//	    System.out.println("Enter 1 if your are movie watcher, otherwise 2.");
//	    user.setTypeOfCustomer(sc.nextInt());
//	    sc.nextLine();
//	    if(user.getTypeOfCustomer()==2) {
//	    System.out.println("Enter your interest.");
//	    user.setInterest(sc.nextLine());
//	    }
	    session.save(movies);
	    session.flush();
	    return movies;
	}
	
	public void cinemaHallRegisteration(Session session, int userId) {
		CinemaHall cinemaHall= new CinemaHall();
		cinemaHall.setId(userId);
		System.out.println("Enter your cinema hall rating you have recieved on Google out of 10.");
		cinemaHall.setRating(sc.nextDouble());
		System.out.println("Enter your venue seating capacity.");
		cinemaHall.setSeatingCapacity(sc.nextInt());
		System.out.println("Enter the total number of time slot in which this movie is played  movie.");
		int totalnumber= sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the time slot in 12- hours basis in the format of HH:MM AM/PM like 02:00 PM , 04:45 PM ");
		List<String> timing= new ArrayList<>();
		for(int i=0;i<totalnumber; i++) {
			timing.add(sc.nextLine());
		}
		cinemaHall.setMoviesAndTimings(timing);
		System.out.println("Enter cinema hall complete location.");
		cinemaHall.setLocation(sc.nextLine());
		Movie movie=setMovies(session);
		cinemaHall.setMovie(movie);
		session.save(cinemaHall);
	}
	
	public String bookMovie(Session session, int id) {
		
		List<Movie> movies = session.createQuery("FROM Movie", Movie.class).list();
		System.out.println("Enter the movie id of the movie you want to watch.");
		 for (Movie movie : movies) {
			System.out.println(movie.getId()+" " +movie.getName()+ " "+movie.getRating()+" "+movie.getLanguage()+" "+movie.getReleaseDate());
		}
		 int choice= sc.nextInt();
	    System.out.println("Enter the cinema hall id in which you to love watch movie");
	    List<CinemaHall> cinemaHall = session.createQuery("FROM CinemaHall", CinemaHall.class).list();
	    for(CinemaHall cinemaHalls:cinemaHall) {
	    	if(cinemaHalls.getMovie().getId()==choice) {
	    	System.out.println(cinemaHalls.getId()+" "+cinemaHalls.getLocation() +" "+cinemaHalls.getRating()+" "+cinemaHalls.getMoviesAndTimings());
	    }
	    	
	    	int cinemahallChoice= sc.nextInt();
	    	
	    	System.out.println("Enter the time in same format as given.");
	    	String timeChosen= sc.nextLine();
	    	int ticketNumber =0;
	    	for(String time:cinemaHalls.getMoviesAndTimings()) {
	    		if(time.equalsIgnoreCase(timeChosen)) {
	    			ticketNumber=paymentOfTicket(session, seatBooking());
	    		}
	    	}
	    	User user= session.get(User.class, id);
	    	CinemaHall cinema = session.get(CinemaHall.class, cinemahallChoice);
	    	bookingDetails(session, ticketNumber, user , cinema);
	    }
	    	
	    	
		return "Thank You for choosing us";
		
	}
	    public int seatBooking() {
	    	System.out.println("Enter the type of seat you want to select-");
			System.out.println("1. Silver - Rs.150\n2. Gold - Rs.170\n3. Premium - Rs240");
			int seatChoice= sc.nextInt(), price=0;
			
			if(seatChoice == 1) {
				price= 150;
			}else if(seatChoice==2) {
				price = 170;
			}else {
				price=240;
			}
			
			System.out.println("Enter the number of people.");
			int noOfPeople= sc.nextInt();
			return noOfPeople*price;
	    }
	    
	    public int paymentOfTicket(Session session, int totalPrice) {
	    	Payment payment = new Payment();
	    	payment.setTotalPrice(totalPrice);
	    	payment.setTotalAfterAddingGst(totalPrice*=0.18);
	    	System.out.println("Through which medium you want to complete the payment.");
	    	System.out.println("Debit card, Credit card, UPI, NetBanking, Wallet");
	    	payment.setPaymentMode(sc.nextLine());
	    	System.out.println("Have you completed your payment.");
	    	boolean confirmation= sc.nextBoolean();
	    	if(confirmation) {
	    		payment.setTicketNumber((int)Math.random());
	    	}else {
	    		System.out.println("Sorry for this time, come back again.");
	    	}
	    	
	    	return payment.getTicketNumber();
	    			}
	
	    public void bookingDetails(Session session, int ticketNumber, User user, CinemaHall cinemaHallChoice ) {
	    	Booking booking= new Booking();
	    	booking.setTicketNumber(ticketNumber);
	    	booking.setCinemaHall(cinemaHallChoice);
	    	booking.setUser(user);
	    	session.save(booking);
	    }
	   
	   
	
    public static void main( String[] args )
    {
    	 Configuration con = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Movie.class).addAnnotatedClass(CinemaHall.class).addAnnotatedClass(SeatingLayout.class).addAnnotatedClass(Payment.class).addAnnotatedClass(Booking.class);
         SessionFactory sfactory = con.buildSessionFactory();
         Session session = sfactory.openSession();
         Transaction tt= session.beginTransaction();
         User u1= new User();
         App app= new App();
        int typeOfCustomer= app.userRegistration(u1, session);
        
        switch(typeOfCustomer) {
        case 1:app.bookMovie(session, u1.getId()); break;
        case 2:app.setMovies(session); break;
        	default: System.out.println("You have given wrong detail in the registeration, please re- register yourself");
        }
        
         tt.commit();
         session.close();
         
         
    }
}
