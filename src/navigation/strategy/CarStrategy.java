package navigation.strategy;

import navigation.model.Route;

public class CarStrategy implements RouteStrategy {
    private static final String MODE_NAME = "Car";
    private static final double AVERAGE_SPEED_KMH = 45.0;
    private static final double TRAFFIC_DELAY_MULTIPLIER = 1.25;
    private static final double MINUTES_PER_HOUR = 60.0;

    @Override
    public Route buildRoute(String origin, String destination, double baseDistanceKm) {
        int estimatedMinutes = calculateDrivingMinutes(baseDistanceKm);
        String directions = "Via main avenues and highway overpass (traffic factored in)";

        return new Route(
                MODE_NAME,
                origin,
                destination,
                baseDistanceKm,
                estimatedMinutes,
                directions
        );
    }

    private int calculateDrivingMinutes(double distanceKm) {
        double rawMinutes = (distanceKm / AVERAGE_SPEED_KMH) * MINUTES_PER_HOUR;
        return (int) Math.ceil(rawMinutes * TRAFFIC_DELAY_MULTIPLIER);
    }
}