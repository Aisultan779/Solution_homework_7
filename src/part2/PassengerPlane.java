package part2;

public class PassengerPlane extends Aircraft {
    private int fuel;

    public PassengerPlane(String id, int fuel, TowerMediator tower) {
        super(id, true, tower);
        this.fuel = fuel;
    }

    public int getFuelLevel() { return fuel; }

    public void tick() {
        fuel--;
        if (fuel < 5) send("MAYDAY");
        else requestRunway();
    }

    @Override
    public void receive(String msg) {
        System.out.printf("PassengerPlane %s console: %s%n", id, msg);
    }
}
