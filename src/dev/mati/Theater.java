package dev.mati;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theater {
    private final String mName;
    private List<Seat> seats = new ArrayList<>();

    public Theater(String mName, int numRows, int seatsPerRow) {
        this.mName = mName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
              Seat seat = new Seat(row + String.format("%02d",seatNum));
              seats.add(seat);
            }
        }
    }

    public String getmName() {
        return mName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestSeat,null);
        if(foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }
    public void getSeats() {
        for(Seat seat: seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean reserve() {
            if(!reserved) {
                reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }
        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }

        }
    }
}