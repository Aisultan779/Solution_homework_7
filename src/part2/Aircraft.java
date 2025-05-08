package part2;

public abstract class Aircraft {
    protected final String id;
    protected final TowerMediator tower;
    private final boolean landing;

    public Aircraft(String id, boolean landing, TowerMediator tower) {
        this.id = id;
        this.landing = landing;
        this.tower = tower;
    }

    public String getId() { return id; }
    public boolean isLanding() { return landing; }
    public void send(String msg) { tower.broadcast(msg, this); }
    public void requestRunway() { tower.requestRunway(this); }
    public abstract void receive(String msg);
}