package programming.collections.entities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Galaxy", 8, 12);
//        theatre.getSeats();

        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry seat is taken");
        }

//        List<Seat> seatsCopy = new ArrayList<>(theatre.getSeats());

//        Collections.reverse(seatsCopy);
//        seatsCopy.forEach(n -> System.out.println(n.getSeatNumber() + " price: " + n.getPrice()));

//        Seat minSeat = Collections.min(seatsCopy);
//        Seat maxSeat = Collections.max(seatsCopy);
//        System.out.println("Min " + minSeat.getSeatNumber());
//        System.out.println("Max " + maxSeat.getSeatNumber());

//        theatre.getSeats().forEach(n -> System.out.println(n.getSeatNumber() + " price: " + n.getPrice()));

//        theatre.getSeats().sort(Seat.PRICE_ORDER);
//        theatre.getSeats().forEach(n -> System.out.println(n.getSeatNumber() + " price = " + n.getPrice()));

        List<Seat> seatsCopy = new ArrayList<>(theatre.getSeats());
        seatsCopy.sort(Seat.PRICE_ORDER);
        seatsCopy.forEach(n -> System.out.println(n.getSeatNumber() + " price = " + n.getPrice()));
    }
}
