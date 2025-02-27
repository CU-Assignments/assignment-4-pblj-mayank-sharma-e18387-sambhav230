import java.util.Scanner;

class TicketBookingSystem {
    private int availableSeats = 10; // Total number of available seats

    // Method to book a ticket (synchronized to prevent double booking)
    public synchronized void bookTicket(String customerType) {
        if (availableSeats > 0) {
            // Simulate some processing time
            try {
                Thread.sleep(500); // simulate booking time
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            // Book the ticket
            availableSeats--;
            System.out.println(customerType + " booked a ticket. Seats left: " + availableSeats);
        } else {
            System.out.println(customerType + " tried to book, but no seats are available.");
        }
    }
}

class VIPBookingThread extends Thread {
    private TicketBookingSystem system;

    VIPBookingThread(TicketBookingSystem system) {
        this.system = system;
        setPriority(Thread.MAX_PRIORITY); // VIP bookings should have the highest priority
    }

    @Override
    public void run() {
        system.bookTicket("VIP");
    }
}

class RegularBookingThread extends Thread {
    private TicketBookingSystem system;

    RegularBookingThread(TicketBookingSystem system) {
        this.system = system;
        setPriority(Thread.MIN_PRIORITY); // Regular bookings have the lowest priority
    }

    @Override
    public void run() {
        system.bookTicket("Regular");
    }
}

public class TicketBookingSystemMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketBookingSystem system = new TicketBookingSystem();

        while (true) {
            System.out.println("\nTicket Booking System");
            System.out.println("1. VIP Booking");
            System.out.println("2. Regular Booking");
            System.out.println("3. Exit");
            System.out.print("Please enter your choice (1/2/3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left after nextInt()

            if (choice == 1) {
                // Create and start a VIP booking thread
                Thread vipThread = new VIPBookingThread(system);
                vipThread.start();
            } else if (choice == 2) {
                // Create and start a regular booking thread
                Thread regularThread = new RegularBookingThread(system);
                regularThread.start();
            } else if (choice == 3) {
                // Exit the program
                System.out.println("Exiting the Ticket Booking System.");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }

            // Small delay to simulate user experience (optional)
            try {
                Thread.sleep(1000); // Adjust this as needed
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        scanner.close();
    }
}
