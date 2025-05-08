package part2;

public class CargoPlane extends Aircraft {
    public CargoPlane(String id, TowerMediator tower) {
        super(id, false, tower);
    }
    @Override public void receive(String msg) { System.out.printf("CargoPlane %s console: %s%n", id, msg); }
}
