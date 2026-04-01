public class SeatedPassenger extends Passenger {

    public SeatedPassenger() {
        super();
    }

    @Override
    public void board(Transport t, int stops) throws TransportAccessException {
        if (t.getAvailableSeats() > 0) {
            t.occupiedSeats++;
            setBoarded(t, true, stops);
            t.pickUp(this);
            System.out.println("SeatedPassenger boarded and is seated.");
        } else {
            throw new TransportAccessException("No seats available. SeatedPassenger refused to board.");
        }
    }

    @Override
    public String toString() { return "SeatedPassenger"; }
}
