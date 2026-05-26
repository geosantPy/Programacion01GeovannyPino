package entities;
public class InternationalRoutes extends Routes {
    private String destinationCountry;
    private boolean requiresPassport;
    private double internationalFee;

    public InternationalRoutes(String routeCode, String originCity, String destinationCity, String departureDate, String departureTime, String arrivalTime, int totalSeats, double basePrice, String routeStatus, String destinationCountry, boolean requiresPassport, double internationalFee) {
        super(routeCode, originCity, destinationCity, departureDate, departureTime, arrivalTime, totalSeats, basePrice, routeStatus);
        this.destinationCountry = destinationCountry;
        this.requiresPassport = requiresPassport;
        this.internationalFee = internationalFee;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + internationalFee;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public boolean isRequiresPassport() {
        return requiresPassport;
    }

    public void setRequiresPassport(boolean requiresPassport) {
        this.requiresPassport = requiresPassport;
    }

    public double getInternationalFee() {
        return internationalFee;
    }

    public void setInternationalFee(double internationalFee) {
        this.internationalFee = internationalFee;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Internacional | País: " + destinationCountry + " | Pasaporte: " + (requiresPassport ? "Sí" : "No") + " | Tasa: " + internationalFee;
    }
}
