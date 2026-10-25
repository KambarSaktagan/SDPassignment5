package navigation.strategy;

import navigation.model.Route;

public class PublicTransitStrategy implements RouteStrategy {
    private static final String MODE_NAME = "Public Transit";
    private static final double AVERAGE_BUS_SPEED_KMH = 28.0;
    private static final int AVERAGE_WAIT_TIME_MINUTES = 7;
    private static final double MINUTES_PER_HOUR = 60.0;

    @Override
    public Route buildRoute(String origin, String destination, double baseDistanceKm) {
        int estimatedMinutes = calculateTransitMinutes(baseDistanceKm);
        String directions = "Via dedicated bus lanes with 1 transfer stop";

        return new Route(
                MODE_NAME,
                origin,
                destination,
                baseDistanceKm,
                estimatedMinutes,
                directions
        );
    }

    private int calculateTransitMinutes(double distanceKm) {
        double travelMinutes = (distanceKm / AVERAGE_BUS_SPEED_KMH) * MINUTES_PER_HOUR;
        return (int) Math.ceil(travelMinutes) + AVERAGE_WAIT_TIME_MINUTES;
    }
}