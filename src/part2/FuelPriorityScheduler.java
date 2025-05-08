package part2;

import java.util.Queue;

public class FuelPriorityScheduler implements RunwayScheduler {
    @Override
    public Aircraft selectNext(Queue<Aircraft> landingQueue, Queue<Aircraft> takeoffQueue) {
        return landingQueue.stream()
                .min((a, b) -> Integer.compare(((PassengerPlane) a).getFuelLevel(), ((PassengerPlane) b).getFuelLevel()))
                .orElseGet(() -> takeoffQueue.poll());
    }
}