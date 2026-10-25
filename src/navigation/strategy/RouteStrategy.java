package navigation.strategy;

import navigation.model.Route;

public interface RouteStrategy {
    Route buildRoute(String origin, String destination, double baseDistanceKm);
}