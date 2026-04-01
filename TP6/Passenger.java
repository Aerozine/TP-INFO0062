import java.util.ArrayList;
import java.util.List;

public abstract class Passenger {
    private Transport currentTransport;
    private boolean isSeated;
    private int stopsAfterBoarding;
    private int stopsToRide;

    public Passenger() {
        this.currentTransport = null;
        this.isSeated = false;
        this.stopsAfterBoarding = -1;
        this.stopsToRide = 0;
    }

    public abstract void board(Transport t, int stops) throws TransportAccessException;

    public void onNextStop() {
        if (currentTransport != null) {
            stopsAfterBoarding++;
            if (stopsAfterBoarding >= stopsToRide) {
                leave();
            }
        }
    }

    protected void setBoarded(Transport t, boolean seated, int stops) {
        this.currentTransport = t;
        this.isSeated = seated;
        this.stopsAfterBoarding = 0;
        this.stopsToRide = stops;
    }

    public void leave() {
        if (currentTransport != null) {
            if (isSeated) currentTransport.occupiedSeats--;
            else currentTransport.occupiedStanding--;
            System.out.println(this + " has left the transport.");
            currentTransport = null;
            stopsAfterBoarding = -1;
        }
    }

    public boolean isOnTransport()       { return currentTransport != null; }
    public boolean isSeated()            { return isSeated; }
    public int getStopsAfterBoarding()   { return stopsAfterBoarding; }
    public Transport getCurrentTransport() { return currentTransport; }
}
