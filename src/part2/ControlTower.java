package part2;

import java.util.LinkedList;
import java.util.Queue;

public class ControlTower implements TowerMediator {
    private final Queue<Aircraft> landingQueue = new LinkedList<>();
    private final Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private Aircraft runwayOccupiedBy;
    private RunwayScheduler scheduler;

    public ControlTower(RunwayScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public synchronized void setScheduler(RunwayScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public synchronized void broadcast(String msg, Aircraft sender) {
        System.out.printf("Tower received from %s: '%s'%n", sender.getId(), msg);
        if ("MAYDAY".equalsIgnoreCase(msg)) {
            handleEmergency(sender);
        } else {
            getAllRegistered().forEach(a -> { if (a != sender) a.receive(msg); });
        }
    }

    @Override
    public synchronized boolean requestRunway(Aircraft a) {
        if (a.isLanding()) landingQueue.add(a);
        else takeoffQueue.add(a);
        System.out.printf("%s queued for %s.%n", a.getId(), a.isLanding() ? "landing" : "takeoff");
        scheduleNext();
        return runwayOccupiedBy == a;
    }

    private void handleEmergency(Aircraft emergencyPlane) {
        System.out.printf("!!! EMERGENCY at %s !!!%n", emergencyPlane.getId());
        runwayOccupiedBy = emergencyPlane;
        getAllRegistered().forEach(a -> { if (a != emergencyPlane) a.receive("Hold position: emergency on runway"); });
        System.out.printf("Runway granted immediately to %s%n", emergencyPlane.getId());
        runwayOccupiedBy = null;
    }

    private void scheduleNext() {
        if (runwayOccupiedBy != null) return;
        Aircraft next = scheduler.selectNext(landingQueue, takeoffQueue);
        if (next != null) {
            // remove if still in queue
            landingQueue.remove(next);
            takeoffQueue.remove(next);
            runwayOccupiedBy = next;
            System.out.printf("Runway granted to %s (%s)%n", next.getId(), next.isLanding() ? "landing" : "takeoff");
            next.receive("Cleared for " + (next.isLanding() ? "landing" : "takeoff"));
            runwayOccupiedBy = null;
        }
    }

    private java.util.List<Aircraft> getAllRegistered() {
        // Simplified: gather from both queues
        java.util.List<Aircraft> list = new java.util.ArrayList<>();
        list.addAll(landingQueue);
        list.addAll(takeoffQueue);
        return list;
    }
}