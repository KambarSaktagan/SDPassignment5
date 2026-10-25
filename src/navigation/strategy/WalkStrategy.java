package navigation.strategy;

import navigation.model.Route;

public class WalkStrategy implements RouteStrategy {
    private static final String MODE_NAME = "Walk";
    private static final double AVERAGE_SPEED_KMH = 5.0;
    private static final double PEDESTRIAN_SHORTCUT_FACTOR = 0.85;
    private static final double MINUTES_PER_HOUR = 60.0;

    @Override
    public Route buildRoute(String origin, String destination, double baseDistanceKm) {
        double shortcutDistanceKm = baseDistanceKm * PEDESTRIAN_SHORTCUT_FACTOR;
        int estimatedMinutes = calculateWalkingMinutes(shortcutDistanceKm);
        String directions = "Via pedestrian walkways, park footpaths, and crosswalks";

        return new Route(
                MODE_NAME,
                origin,
                destination,
                shortcutDistanceKm,
                estimatedMinutes,
                directions
        );
    }

    private int calculateWalkingMinutes(double distanceKm) {
        double rawMinutes = (distanceKm / AVERAGE_SPEED_KMH) * MINUTES_PER_HOUR;
        return (int) Math.ceil(rawMinutes);
    }
}