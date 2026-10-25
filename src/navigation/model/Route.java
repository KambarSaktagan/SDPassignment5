package navigation.model;

public class Route {
    private final String transportMode;
    private final String origin;
    private final String destination;
    private final double effectiveDistanceKm;
    private final int estimatedDurationMinutes;
    private final String pathDescription;

    public Route(
            String transportMode,
            String origin,
            String destination,
            double effectiveDistanceKm,
            int estimatedDurationMinutes,
            String pathDescription
    ) {
        this.transportMode = transportMode;
        this.origin = origin;
        this.destination = destination;
        this.effectiveDistanceKm = effectiveDistanceKm;
        this.estimatedDurationMinutes = estimatedDurationMinutes;
        this.pathDescription = pathDescription;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getEffectiveDistanceKm() {
        return effectiveDistanceKm;
    }

    public int getEstimatedDurationMinutes() {
        return estimatedDurationMinutes;
    }

    public String getPathDescription() {
        return pathDescription;
    }

    @Override
    public String toString() {
        return String.format(
                "[%s] %s -> %s | Distance: %.2f km | ETA: %d min | Route: %s",
                transportMode,
                origin,
                destination,
                effectiveDistanceKm,
                estimatedDurationMinutes,
                pathDescription
        );
    }
}