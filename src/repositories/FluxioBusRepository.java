package repositories;

import java.util.ArrayList;

import entities.Passenger;
import entities.Reservation;
import entities.Routes;

public class FluxioBusRepository {

    public ArrayList<Passenger> passengers;
    public ArrayList<Routes> routes;
    public ArrayList<Reservation> reservations;

    public FluxioBusRepository() {
        passengers = new ArrayList<>();
        routes = new ArrayList<>();
        reservations = new ArrayList<>();
    }

}