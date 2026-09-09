/*
 * ============================================================
 *  CINEMA TICKET MANAGEMENT SYSTEM
 * ============================================================
 *  Student Name : Jayakavya K
 *  S.No         : 37
 *  Roll No      : VH15001
 *  Register No  : 113025205037
 *  Batch No     : 13A
 * ============================================================
 *  Description:
 *  A console-based Java application that simplifies cinema
 *  ticket booking. It records customer details, ticket
 *  category and seat count, then calculates the total
 *  amount payable. Built using arrays, classes and control
 *  statements (if-else, switch, for, while).
 * ============================================================
 */

import java.util.Scanner;

// ---------- Class representing a single customer's booking ----------
class Customer {
    String name;
    String category;   // Silver / Gold / Platinum
    int seats;
    double amount;

    Customer(String name, String category, int seats, double amount) {
        this.name = name;
        this.category = category;
        this.seats = seats;
        this.amount = amount;
    }
}

// ---------- Class that manages ticket pricing and booking logic ----------
class TicketBookingManager {

    // Prices per seat by category (in Rs.)
    static final double SILVER_PRICE = 150.0;
    static final double GOLD_PRICE = 250.0;
    static final double PLATINUM_PRICE = 400.0;

    // Fixed-size array to store up to 50 bookings for one show
    Customer[] bookings = new Customer[50];
    int bookingCount = 0;

    // Calculates ticket price based on category using a switch statement
    double calculateAmount(String category, int seats) {
        double pricePerSeat;

        switch (category.toUpperCase()) {
            case "SILVER":
                pricePerSeat = SILVER_PRICE;
                break;
            case "GOLD":
                pricePerSeat = GOLD_PRICE;
                break;
            case "PLATINUM":
                pricePerSeat = PLATINUM_PRICE;
                break;
            default:
                pricePerSeat = 0.0;
        }
        return pricePerSeat * seats;
    }

    // Adds a new booking to the array, if there is room
    boolean addBooking(String name, String category, int seats) {
        if (bookingCount >= bookings.length) {
            System.out.println("Booking list is full. Cannot add more customers.");
            return false;
        }
        if (seats <= 0) {
            System.out.println("Seat count must be greater than zero.");
            return false;
        }

        double amount = calculateAmount(category, seats);
        if (amount == 0.0) {
            System.out.println("Invalid ticket category entered.");
            return false;
        }

        bookings[bookingCount] = new Customer(name, category.toUpperCase(), seats, amount);
        bookingCount++;
        return true;
    }

    // Displays every booking recorded so far
    void displayAllBookings() {
        if (bookingCount == 0) {
            System.out.println("No bookings recorded yet.");
            return;
        }

        System.out.println("\n---------------------------------------------------------");
        System.out.printf("%-4s%-15s%-12s%-8s%-10s%n", "No", "Customer", "Category", "Seats", "Amount");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < bookingCount; i++) {
            Customer c = bookings[i];
            System.out.printf("%-4d%-15s%-12s%-8d%-10.2f%n",
                    (i + 1), c.name, c.category, c.seats, c.amount);
        }
        System.out.println("---------------------------------------------------------");
    }

    // Calculates the total revenue across all bookings
    double calculateTotalRevenue() {
        double total = 0.0;
        for (int i = 0; i < bookingCount; i++) {
            total += bookings[i].amount;
        }
        return total;
    }

    // Counts total seats booked per category
    void categorySummary() {
        int silverSeats = 0, goldSeats = 0, platinumSeats = 0;

        for (int i = 0; i < bookingCount; i++) {
            Customer c = bookings[i];
            if (c.category.equals("SILVER")) {
                silverSeats += c.seats;
            } else if (c.category.equals("GOLD")) {
                goldSeats += c.seats;
            } else if (c.category.equals("PLATINUM")) {
                platinumSeats += c.seats;
            }
        }

        System.out.println("\nSeats booked by category:");
        System.out.println("  Silver   : " + silverSeats);
        System.out.println("  Gold     : " + goldSeats);
        System.out.println("  Platinum : " + platinumSeats);
    }
}

// ---------- Main class with the menu-driven console interface ----------
public class CinemaTicketManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketBookingManager manager = new TicketBookingManager();
        int choice;

        System.out.println("============================================");
        System.out.println("   CINEMA TICKET MANAGEMENT SYSTEM");
        System.out.println("============================================");

        do {
            System.out.println("\n1. Book a Ticket");
            System.out.println("2. View All Bookings");
            System.out.println("3. View Total Revenue");
            System.out.println("4. View Category-wise Seat Summary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter ticket category (Silver/Gold/Platinum): ");
                    String category = sc.nextLine();

                    System.out.print("Enter number of seats: ");
                    int seats = sc.nextInt();

                    boolean success = manager.addBooking(name, category, seats);
                    if (success) {
                        System.out.println("Booking successful! Total amount: Rs. "
                                + manager.bookings[manager.bookingCount - 1].amount);
                    }
                    break;

                case 2:
                    manager.displayAllBookings();
                    break;

                case 3:
                    System.out.printf("Total revenue collected: Rs. %.2f%n", manager.calculateTotalRevenue());
                    break;

                case 4:
                    manager.categorySummary();
                    break;

                case 5:
                    System.out.println("Thank you for using the Cinema Ticket Management System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select between 1 and 5.");
            }

        } while (choice != 5);

        sc.close();
    }
}
