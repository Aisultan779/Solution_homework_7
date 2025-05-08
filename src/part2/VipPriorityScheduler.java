package part2;

import java.util.Queue;

public class VipPriorityScheduler implements RunwayScheduler {
    @Override
    public Aircraft selectNext(Queue<Aircraft> landingQueue, Queue<Aircraft> takeoffQueue) {
        for (Aircraft a : takeoffQueue) {
            if (a instanceof CargoPlane) {
                takeoffQueue.remove(a);
                return a;
            }
        }
        return landingQueue.isEmpty() ? takeoffQueue.poll() : landingQueue.poll();
    }
}