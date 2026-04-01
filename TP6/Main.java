public class Main {
    public static void main(String[] args) {
        // Bus with 5 seats and 12 standing places
        Bus bus = new Bus(5, 12);

        SeatedPassenger alice    = new SeatedPassenger();
        SeatedPassenger bob      = new SeatedPassenger();
        UncrowdedPassenger carol = new UncrowdedPassenger();

        // Board passengers 
        try {
            alice.board(bus, 2);
            bob.board(bus, 4);
            carol.board(bus, 3);
        } catch (TransportAccessException e) {
            System.out.println("Access denied: " + e.getMessage());
        }

        System.out.println("\nUnique passengers so far: " + bus.getTotalUniquePassengers());
        System.out.println("Alice seated? " + alice.isSeated());
        System.out.println("Carol seated? " + carol.isSeated());

        // Simulate stops 
        System.out.println("\n--- Stop 1 ---");
        bus.nextStop();

        System.out.println("\n--- Stop 2 ---");
        bus.nextStop(); // Alice leaves here

        System.out.println("\n--- Stop 3 ---");
        bus.nextStop(); // Carol leaves here

        System.out.println("\n--- Stop 4 ---");
        bus.nextStop(); // Bob leaves here

        System.out.println("\nTotal unique passengers ever: " + bus.getTotalUniquePassengers());

        //  Test denial scenarios 
        System.out.println("\n--- Testing denial scenarios ---");

        // 1 seat, 10 standing — UncrowdedPassenger needs strictly MORE than 10, so 10 is not enough
        Bus smallBus = new Bus(1, 10);
        SeatedPassenger dave     = new SeatedPassenger();
        SeatedPassenger eve      = new SeatedPassenger();
        UncrowdedPassenger frank = new UncrowdedPassenger();

        try {
            dave.board(smallBus, 5);
        } catch (TransportAccessException e) {
            System.out.println("Dave denied: " + e.getMessage());
        }

        try {
            eve.board(smallBus, 5); // seat already taken
        } catch (TransportAccessException e) {
            System.out.println("Eve denied: " + e.getMessage());
        }

        try {
            frank.board(smallBus, 5); // 11 standing <= 10 threshold
        } catch (TransportAccessException e) {
            System.out.println("Frank denied: " + e.getMessage());
        }
    }
}
