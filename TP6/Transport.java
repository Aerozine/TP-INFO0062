public abstract class Transport {
    private final int totalSeats;
    private final int totalStanding;
    protected int occupiedSeats;
    protected int occupiedStanding;

    public Transport(int totalSeats, int totalStanding) {
        this.totalSeats = totalSeats;
        this.totalStanding = totalStanding;
        this.occupiedSeats = 0;
        this.occupiedStanding = 0;
    }

    public int getAvailableSeats() {
        return totalSeats - occupiedSeats;
    }

    public int getAvailableStanding() {
        return totalStanding - occupiedStanding;
    }

    public abstract boolean pickUp(Passenger p) throws TransportAccessException;

    public abstract void nextStop();
}
