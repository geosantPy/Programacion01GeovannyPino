package entities;
public class Reservation {
    private String reservationCode;
    private Passenger passenger;
    private Routes route;
    private int reservedSeats;
    private String reservationDate;
    private double totalPrice;
    private String reservationStatus;

    public Reservation(String reservationCode, Passenger passenger, Routes route, int reservedSeats, String reservationDate, double totalPrice, String reservationStatus) {
        this.reservationCode = reservationCode;
        this.passenger = passenger;
        this.route = route;
        this.reservedSeats = reservedSeats;
        this.reservationDate = reservationDate;
        this.totalPrice = totalPrice;
        this.reservationStatus = reservationStatus;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Routes getRoute() {
        return route;
    }

    public void setRoute(Routes route) {
        this.route = route;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return "Reserva: " + reservationCode + " | Pasajero: " + passenger.getFirstName() + " " + passenger.getLastName() + " | Ruta: " + route.getRouteCode() + " | Asientos: " + reservedSeats + " | Total: $" + totalPrice + " | Estado: " + reservationStatus;
    }
}
