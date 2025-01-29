package circularlinkedlist.onlineticketreservationsystem;
import java.time.LocalDateTime;

public class TicketReservationController {
    public static void main(String[] args) {
        TicketReservationSystem reservationSystem = new TicketReservationSystem();

        // Adding tickets
        reservationSystem.addTicket(1, "Rahul", "RRR", "A1");
        reservationSystem.addTicket(2, "Priya", "Pushpa", "B2");
        reservationSystem.addTicket(3, "Anil", "KGF", "C3");

        // Display tickets
        reservationSystem.displayTickets();

        // Search for a ticket by customer name
        reservationSystem.searchTicket("Priya");

        // Search for a ticket by movie name
        reservationSystem.searchTicket("KGF");

        // Remove a ticket by Ticket ID
        reservationSystem.removeTicketByID(2);

        // Display tickets after removal
        reservationSystem.displayTickets();

        // Display total tickets
        reservationSystem.totalTickets();
    }
}
