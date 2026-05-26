package entities;
public class NationalRoutes extends Routes {
    private int estimatedHours;
    private boolean hasRestStops;

    public NationalRoutes(String routeCode, String originCity, String destinationCity, String departureDate, String departureTime, String arrivalTime, int totalSeats, double basePrice, String routeStatus, int estimatedHours, boolean hasRestStops) {
        super(routeCode, originCity, destinationCity, departureDate, departureTime, arrivalTime, totalSeats, basePrice, routeStatus);
        this.estimatedHours = estimatedHours;
        this.hasRestStops = hasRestStops;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice();
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(int estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public boolean isHasRestStops() {
        return hasRestStops;
    }

    public void setHasRestStops(boolean hasRestStops) {
        this.hasRestStops = hasRestStops;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Nacional | Horas: " + estimatedHours + " | Paradas: " + (hasRestStops ? "Sí" : "No");
    }
}
