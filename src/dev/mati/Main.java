package dev.mati;

public class Main {
    public static void main(String[] args) {
        System.out.println((char) ('A' + 4));

        Theater theater = new Theater("ROMA musical theater",15,20);
        theater.getSeats();

        reserveSeat(theater,"H11");
        reserveSeat(theater,"H11");
        reserveSeat(theater,"H80");

    }

    private static void reserveSeat(Theater theater, String seat) {
        if(theater.reserveSeat(seat)) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is already taken, or does not exist");
        }
    }
}
