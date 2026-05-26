package controllers;

import entities.Reservation;
import services.FluxioBusService;

public class FluxioBusController {

    private FluxioBusService service;

    public FluxioBusController() {
        service = new FluxioBusService();
    }

    public void registerPassenger(String id, String firstName, String lastName,
                                  int age, String email, String phoneNumber,
                                  String passportNumber, String nationality) {

        service.registerPassenger(id, firstName, lastName, age, email,
                phoneNumber, passportNumber, nationality);
    }

    public void createNationalRoute(String routeCode, String originCity,
                                    String destinationCity, String departureDate,
                                    String departureTime, String arrivalTime,
                                    int totalSeats, double basePrice,
                                    int estimatedHours, boolean hasRestStops) {

        service.createNationalRoute(routeCode, originCity, destinationCity,
                departureDate, departureTime, arrivalTime,
                totalSeats, basePrice, estimatedHours, hasRestStops);
    }

    public void createInternationalRoute(String routeCode, String originCity,
                                         String destinationCity, String departureDate,
                                         String departureTime, String arrivalTime,
                                         int totalSeats, double basePrice,
                                         String destinationCountry,
                                         boolean requiresPassport,
                                         double internationalFee) {

        service.createInternationalRoute(routeCode, originCity, destinationCity,
                departureDate, departureTime, arrivalTime,
                totalSeats, basePrice, destinationCountry,
                requiresPassport, internationalFee);
    }

    public void createReservation(String reservationCode, String passengerId,
                                  String routeCode, int reservedSeats,
                                  String reservationDate) {

        service.createReservation(reservationCode, passengerId,
                routeCode, reservedSeats, reservationDate);
    }

    public void cancelReservation(String reservationCode) {
        service.cancelReservation(reservationCode);
    }

    public Reservation findReservationByCode(String reservationCode) {
        return service.findReservationByCode(reservationCode);
    }

    public void showReservationsByPassenger(String passengerId) {
        service.showReservationsByPassenger(passengerId);
    }

    public void showTotalPassengers() {
        service.showTotalPassengers();
    }

    public void showAllRoutes() {
        service.showAllRoutes();
    }

    public void showAllReservations() {
        service.showAllReservations();
    }

}