package com.example.demo;


import java.net.SocketOption;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ReservationSystemUI {
    private ReservationSystem reservationSystem = new ReservationSystem();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Make a reservation");
            System.out.println("2. View all reservations");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Date: ");
                    String date = scanner.nextLine();
                    System.out.println("Number of guests: ");
                    int numberOfGuests = scanner.nextInt();
                    scanner.nextLine();

                    Reservation reservation = reservationSystem.makeReservation(name, date, numberOfGuests);
                    System.out.println("Reservation made with ID " + reservation.getId());
                    break;
                case 2:
                    System.out.println("Reservations:");
                    for (Reservation r : reservationSystem.getReservations()) {
                        System.out.println(r.getId() + " - " + r.getName() + " - " + r.getDate() + " - " + r.getNumberOfGuests());
                    }
                    break;
                    case 3:
                        System.out.println("Reservation ID to cancel: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        if (reservationSystem.cancelReservation(id)) {
                            System.out.println("Reservation cancelled");
                        } else {
                            System.out.println("Reservation not found");
                        }
                        break;
                case 4:
                    return;
                default:
                    System.out.println("Invaid choice");
            }
            System.out.println();
        }

    }
}
