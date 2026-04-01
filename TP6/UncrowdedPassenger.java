public class UncrowdedPassenger extends Passenger {
    private static final int MIN_STANDING_THRESHOLD = 10;

    public UncrowdedPassenger() {
        super();
    }

    @Override
    public void board(Transport t, int stops) throws TransportAccessException {
        if (t.getAvailableStanding() > MIN_STANDING_THRESHOLD) {
            t.occupiedStanding++;
            setBoarded(t, false, stops);
            t.pickUp(this);
            System.out.println("UncrowdedPassenger boarded (standing, not crowded).");
        } else {
            throw new TransportAccessException(
                "Transport is too crowded (<=10 standing places left). UncrowdedPassenger refused to board.");
        }
    }

    @Override
    public String toString() { return "UncrowdedPassenger"; }
}
