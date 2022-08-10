package programming.collections.entities;

import java.util.Comparator;

public class Seat implements Comparable<Seat>{
    private final String seatNumber;
    private double price;
    private boolean reserved = false;
    public static final Comparator<Seat> PRICE_ORDER = (s1, s2) -> Double.compare(s2.getPrice(), s1.getPrice());


    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Seat(String seatNumber, double seatPrice) {
        this.seatNumber = seatNumber;
        this.price = seatPrice;
    }

    public boolean reserve() {
        if (!this.reserved) {
            this.reserved = true;
            System.out.println("Seat " + seatNumber + " reserved");
            return true;
        } else {
            return false;
        }
    }

    public boolean cancel() {
        if (this.reserved) {
            this.reserved = false;
            System.out.println("Reservation of seat " + seatNumber + " cancelled");
            return true;
        } else {
            return false;
        }
    }

    public double getPrice() {
        return price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public int compareTo(Seat seat) {
        return this.seatNumber.compareToIgnoreCase(seat.seatNumber);
    }
}
