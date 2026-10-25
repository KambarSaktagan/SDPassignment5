package navigation.context;

import navigation.model.Route;
import navigation.strategy.RouteStrategy;

import java.util.Objects;

public class Navigator {
    private RouteStrategy routeStrategy;

    public Navigator(RouteStrategy initialStrategy) {
        setRouteStrategy(initialStrategy);
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = Objects.requireNonNull(
                routeStrategy,
                "RouteStrategy must not be null"
        );
    }

    public Route planRoute(String origin, String destination, double distanceKm) {
        validateRouteParameters(origin, destination, distanceKm);
        return routeStrategy.buildRoute(origin, destination, distanceKm);
    }

    private void validateRouteParameters(String origin, String destination, double distanceKm) {
        if (origin == null || origin.isBlank()) {
            throw new IllegalArgumentException("Origin must not be empty");
        }
        if (destination == null || destination.isBlank()) {
            throw new IllegalArgumentException("Destination must not be empty");
        }
        if (distanceKm <= 0) {
            throw new IllegalArgumentException("Distance must be greater than 0 km");
        }
    }
}