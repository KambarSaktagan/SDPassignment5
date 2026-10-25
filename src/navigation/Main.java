package navigation;

import navigation.context.Navigator;
import navigation.model.Route;
import navigation.strategy.CarStrategy;
import navigation.strategy.CycleStrategy;
import navigation.strategy.PublicTransitStrategy;
import navigation.strategy.WalkStrategy;

public class Main {
    public static void main(String[] args) {
        String origin = "Astana IT University";
        String destination = "Khan Shatyr";
        double baseDistanceKm = 6.5;

        System.out.println("=== Strategy Pattern: Navigation Route Planner ===");

        // 1. Initialize Navigator with CarStrategy
        Navigator navigator = new Navigator(new CarStrategy());
        Route carRoute = navigator.planRoute(origin, destination, baseDistanceKm);
        System.out.println(carRoute);

        // 2. Switch strategy at runtime to WalkStrategy
        navigator.setRouteStrategy(new WalkStrategy());
        Route walkRoute = navigator.planRoute(origin, destination, baseDistanceKm);
        System.out.println(walkRoute);

        // 3. Switch strategy at runtime to CycleStrategy
        navigator.setRouteStrategy(new CycleStrategy());
        Route cycleRoute = navigator.planRoute(origin, destination, baseDistanceKm);
        System.out.println(cycleRoute);

        // 4. Switch strategy at runtime to PublicTransitStrategy (Extensibility demo)
        navigator.setRouteStrategy(new PublicTransitStrategy());
        Route transitRoute = navigator.planRoute(origin, destination, baseDistanceKm);
        System.out.println(transitRoute);
    }
}