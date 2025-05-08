package part2;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;

public class Simulation {
    public static void main(String[] args) {
        RunwayScheduler scheduler = new FuelPriorityScheduler();
        ControlTower tower = new ControlTower(scheduler);

        List<Aircraft> fleet = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 1; i <= 10; i++) {
            int type = rnd.nextInt(3);
            Aircraft a = switch (type) {
                case 0 -> new PassengerPlane("PP" + i, rnd.nextInt(20) + 5, tower);
                case 1 -> new CargoPlane("CP" + i, tower);
                default -> new Helicopter("H" + i, tower);
            };
            fleet.add(a);
        }

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleAtFixedRate(() -> {
            Aircraft a = fleet.get(rnd.nextInt(fleet.size()));
            System.out.printf("\n[%s] Action by %s%n",  LocalTime.now(), a.getId());
            if (a instanceof PassengerPlane) ((PassengerPlane) a).tick();
            else a.requestRunway();
        }, 0, 1, TimeUnit.SECONDS);
    }
}