package entities;
public abstract class Routes {
    private String routeCode;
    private String originCity;
    private String destinationCity;
    private String departureDate;
    private String departureTime;
    private String arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private double basePrice;
    private String routeStatus;

    public Routes(String routeCode, String originCity, String destinationCity, String departureDate, String departureTime, String arrivalTime, int totalSeats, double basePrice, String routeStatus) {
        this.routeCode = routeCode;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.basePrice = basePrice;
        this.routeStatus = routeStatus;
    }

    public abstract double calculateFinalPrice();

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getRouteStatus() {
        return routeStatus;
    }

    public void setRouteStatus(String routeStatus) {
        this.routeStatus = routeStatus;
    }

    @Override
    public String toString() {
        return "Ruta: " + routeCode + " | De: " + originCity + " a " + destinationCity + " | Fecha: " + departureDate + " | Puestos: " + availableSeats + "/" + totalSeats + " | Estado: " + routeStatus;
    }
}
