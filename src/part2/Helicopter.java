package part2;

public class Helicopter extends Aircraft {
    public Helicopter(String id, TowerMediator tower) { super(id, true, tower); }
    @Override public void receive(String msg) { System.out.printf("Helicopter %s console: %s%n", id, msg); }
}