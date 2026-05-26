package services;
import entities.Passenger;
import entities.Routes;
import entities.Reservation;
import entities.NationalRoutes;
import entities.InternationalRoutes;
import java.util.ArrayList;

public class FluxioBusService {
    private ArrayList<Passenger> passengers;
    private ArrayList<Routes> routes;
    private ArrayList<Reservation> reservations;

    public FluxioBusService() {
        this.passengers = new ArrayList<Passenger>();
        this.routes = new ArrayList<Routes>();
        this.reservations = new ArrayList<Reservation>();
    }

    public void registerPassenger(String id, String firstName, String lastName, int age, String email, String phoneNumber, String passportNumber, String nationality) {
        if (findPassengerById(id) != null) {
            System.out.println("Ya existe un pasajero con esa cédula.");
            return;
        }
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getPassportNumber().equals(passportNumber)) {
                System.out.println("Ya existe un pasajero con ese número de pasaporte.");
                return;
            }
        }
        if (!email.contains("@")) {
            System.out.println("El email debe contener el símbolo @.");
            return;
        }
        if (age < 0) {
            System.out.println("La edad debe ser mayor o igual a cero.");
            return;
        }

        try {

            Passenger newPassenger = new Passenger(id, firstName, lastName, age, email, phoneNumber, passportNumber, nationality);
            passengers.add(newPassenger);
            System.out.println("Pasajero registrado exitosamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void createNationalRoute(String routeCode, String originCity, String destinationCity, String departureDate, String departureTime, String arrivalTime, int totalSeats, double basePrice, int estimatedHours, boolean hasRestStops) {
        if (findRouteByCode(routeCode) != null) {
            System.out.println("Ya existe una ruta con ese código.");
            return;
        }
        if (totalSeats <= 0 || totalSeats > 32) {
            System.out.println("El número de asientos debe estar entre 1 y 32.");
            return;
        }
        if (basePrice <= 0) {
            System.out.println("El precio de la ruta debe ser mayor a cero.");
            return;
        }

        NationalRoutes newRoute = new NationalRoutes(routeCode, originCity, destinationCity, departureDate, departureTime, arrivalTime, totalSeats, basePrice, "Programada", estimatedHours, hasRestStops);
        routes.add(newRoute);
        System.out.println("Ruta nacional creada exitosamente.");
    }

    public void createInternationalRoute(String routeCode, String originCity, String destinationCity, String departureDate, String departureTime, String arrivalTime, int totalSeats, double basePrice, String destinationCountry, boolean requiresPassport, double internationalFee) {
        if (findRouteByCode(routeCode) != null) {
            System.out.println("Ya existe una ruta con ese código.");
            return;
        }
        if (totalSeats <= 0 || totalSeats > 32) {
            System.out.println("El número de asientos debe estar entre 1 y 32.");
            return;
        }
        if (basePrice <= 0) {
            System.out.println("El precio de la ruta debe ser mayor a cero.");
            return;
        }

        InternationalRoutes newRoute = new InternationalRoutes(routeCode, originCity, destinationCity, departureDate, departureTime, arrivalTime, totalSeats, basePrice, "Programada", destinationCountry, requiresPassport, internationalFee);
        routes.add(newRoute);
        System.out.println("Ruta internacional creada exitosamente.");
    }

    public void createReservation(String reservationCode, String passengerId, String routeCode, int reservedSeats, String reservationDate) {
        if (findReservationByCode(reservationCode) != null) {
            System.out.println("Ya existe una reserva con ese código.");
            return;
        }

        Passenger passenger = findPassengerById(passengerId);
        if (passenger == null) {
            System.out.println("No se encontró el pasajero con esa cédula.");
            return;
        }

        Routes route = findRouteByCode(routeCode);
        if (route == null) {
            System.out.println("No se encontró la ruta con ese código.");
            return;
        }

        if (!route.getRouteStatus().equals("Programada")) {
            System.out.println("La ruta no está disponible para reservas.");
            return;
        }

        if (reservedSeats < 1 || reservedSeats > 5) {
            System.out.println("No se pueden reservar más de 5 puestos por reserva y mínimo 1.");
            return;
        }

        if (route.getAvailableSeats() < reservedSeats) {
            System.out.println("No hay puestos disponibles para esta ruta.");
            return;
        }

        double totalPrice = route.calculateFinalPrice() * reservedSeats;
        try {
            Reservation newReservation = new Reservation(
                    reservationCode,
                    passenger,
                    route,
                    reservedSeats,
                    reservationDate,
                    totalPrice,
                    "Confirmada"
            );

            route.setAvailableSeats(route.getAvailableSeats() - reservedSeats);
            reservations.add(newReservation);
            System.out.println("Reserva creada exitosamente. Total a pagar: $" + totalPrice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelReservation(String reservationCode) {
        Reservation reservation = findReservationByCode(reservationCode);
        if (reservation == null) {
            System.out.println("No se encontró la reserva con ese código.");
            return;
        }

        if (reservation.getReservationStatus().equals("Cancelada")) {
            System.out.println("La reserva ya está cancelada.");
            return;
        }

        reservation.setReservationStatus("Cancelada");
        Routes route = reservation.getRoute();
        route.setAvailableSeats(route.getAvailableSeats() + reservation.getReservedSeats());
        System.out.println("Reserva cancelada exitosamente.");
    }

    public Passenger findPassengerById(String id) {
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getId().equals(id)) {
                return passengers.get(i);
            }
        }
        return null;
    }

    public Routes findRouteByCode(String code) {
        for (int i = 0; i < routes.size(); i++) {
            if (routes.get(i).getRouteCode().equals(code)) {
                return routes.get(i);
            }
        }
        return null;
    }

    public Reservation findReservationByCode(String code) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getReservationCode().equals(code)) {
                return reservations.get(i);
            }
        }
        return null;
    }

    public void showReservationsByPassenger(String passengerId) {
        boolean found = false;
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getPassenger().getId().equals(passengerId)) {
                System.out.println(reservations.get(i).toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No se encontraron reservas para este pasajero.");
        }
    }

    public void showTotalPassengers() {
        System.out.println("Total de pasajeros registrados: " + passengers.size());
        for (int i = 0; i < passengers.size(); i++) {
            System.out.println(passengers.get(i).toString());
        }
    }

    public void showAllRoutes() {
        if (routes.isEmpty()) {
            System.out.println("No hay rutas registradas.");
            return;
        }
        for (int i = 0; i < routes.size(); i++) {
            System.out.println(routes.get(i).toString());
        }
    }

    public void showAllReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }
        for (int i = 0; i < reservations.size(); i++) {
            System.out.println(reservations.get(i).toString());
        }
    }
}
