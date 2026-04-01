import java.util.ArrayList;
import java.util.List;

public class Bus extends Transport {
    private List<Passenger> passengers;
    private List<Passenger> allTimePassengers;

    public Bus(int seats, int standing) {
        super(seats, standing);
        this.passengers = new ArrayList<>();
        this.allTimePassengers = new ArrayList<>();
    }

    @Override
    public boolean pickUp(Passenger p) throws TransportAccessException {
        if (!allTimePassengers.contains(p)) {
            allTimePassengers.add(p);
        }
        passengers.add(p);
        return true;
    }

    @Override
    public void nextStop() {
        System.out.println("Bus: next stop!");
        List<Passenger> snapshot = new ArrayList<>(passengers);
        for (Passenger p : snapshot) {
            p.onNextStop();
            if (!p.isOnTransport()) {
                passengers.remove(p);
            }
        }
    }

    public int getTotalUniquePassengers() {
        return allTimePassengers.size();
    }
}
