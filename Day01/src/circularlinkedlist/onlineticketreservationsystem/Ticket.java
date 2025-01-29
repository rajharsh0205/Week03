package circularlinkedlist.onlineticketreservationsystem;

import java.time.LocalDateTime;

public class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    Ticket next; // Pointer to the next ticket in the circular linked list

    // Constructor
    public Ticket(int ticketID, String customerName, String movieName, String seatNumber) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = LocalDateTime.now(); // Automatically set booking time to current time
        this.next = null;
    }
}
