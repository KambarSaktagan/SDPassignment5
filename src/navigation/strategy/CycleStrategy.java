package navigation.strategy;

import navigation.model.Route;

public class CycleStrategy implements RouteStrategy {
    private static final String MODE_NAME = "Cycle";
    private static final double AVERAGE_SPEED_KMH = 18.0;
    private static final double BIKE_LANE_DISTANCE_FACTOR = 0.92;
    private static final double MINUTES_PER_HOUR = 60.0;

    @Override
    public Route buildRoute(String origin, String destination, double baseDistanceKm) {
        double bikeDistanceKm = baseDistanceKm * BIKE_LANE_DISTANCE_FACTOR;
        int estimatedMinutes = calculateCyclingMinutes(bikeDistanceKm);
        String directions = "Via dedicated cycle lanes and greenbelt paths (avoiding highways)";

        return new Route(
                MODE_NAME,
                origin,
                destination,
                bikeDistanceKm,
                estimatedMinutes,
                directions
        );
    }

    private int calculateCyclingMinutes(double distanceKm) {
        double rawMinutes = (distanceKm / AVERAGE_SPEED_KMH) * MINUTES_PER_HOUR;
        return (int) Math.ceil(rawMinutes);
    }
}