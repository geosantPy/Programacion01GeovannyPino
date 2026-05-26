import java.util.Scanner;

import entities.Reservation;
import controllers.FluxioBusController;
public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FluxioBusController controller = new FluxioBusController();
        int option = 0;

        while (option != 11) {
            System.out.println("\n--- BIENVENIDO A FLUXIOBUS COLOMBIA ---");
            System.out.println("1. Registrar pasajero");
            System.out.println("2. Crear ruta nacional");
            System.out.println("3. Crear ruta internacional");
            System.out.println("4. Crear reserva");
            System.out.println("5. Cancelar reserva");
            System.out.println("6. Buscar reserva");
            System.out.println("7. Mostrar reservas por pasajero");
            System.out.println("8. Mostrar total de pasajeros");
            System.out.println("9. Mostrar rutas");
            System.out.println("10. Mostrar reservas");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Cédula: ");
                    String id = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Edad: ");
                    int age;
                    try {
                        age = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Ingrese una edad válida.");
                        break;
                    }
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Pasaporte: ");
                    String passportNumber = scanner.nextLine();
                    System.out.print("Nacionalidad: ");
                    String nationality = scanner.nextLine();
                    controller.registerPassenger(id, firstName, lastName, age, email, phoneNumber, passportNumber, nationality);
                    break;

                case 2:
                    System.out.print("Código de ruta: ");
                    String nCode = scanner.nextLine();
                    System.out.print("Ciudad origen: ");
                    String nOrigin = scanner.nextLine();
                    System.out.print("Ciudad destino: ");
                    String nDest = scanner.nextLine();
                    System.out.print("Fecha salida: ");
                    String nDate = scanner.nextLine();
                    System.out.print("Hora salida: ");
                    String nDepTime = scanner.nextLine();
                    System.out.print("Hora llegada: ");
                    String nArrTime = scanner.nextLine();
                    System.out.print("Total asientos: ");
                    int nSeats;
                    try {
                        nSeats = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Ingrese un número válido de asientos.");
                        break;
                    }
                    System.out.print("Precio base: ");
                    double nPrice;
                    try {
                        nPrice = Double.parseDouble(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Ingrese un precio válido.");
                        break;
                    }
                    System.out.print("Horas estimadas: ");
                    int nHours = Integer.parseInt(scanner.nextLine());
                    System.out.print("¿Tiene paradas de descanso? (true/false): ");
                    boolean nRest = Boolean.parseBoolean(scanner.nextLine());
                    controller.createNationalRoute(nCode, nOrigin, nDest, nDate, nDepTime, nArrTime, nSeats, nPrice, nHours, nRest);
                    break;

                case 3:
                    System.out.print("Código de ruta: ");
                    String iCode = scanner.nextLine();
                    System.out.print("Ciudad origen: ");
                    String iOrigin = scanner.nextLine();
                    System.out.print("Ciudad destino: ");
                    String iDest = scanner.nextLine();
                    System.out.print("Fecha salida (DD/MM/AAAA): ");
                    String iDate = scanner.nextLine();
                    System.out.print("Hora salida (HH:MM): ");
                    String iDepTime = scanner.nextLine();
                    System.out.print("Hora llegada (HH:MM): ");
                    String iArrTime = scanner.nextLine();
                    System.out.print("Total asientos: ");
                    int iSeats;
                    try {
                        iSeats = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Ingrese un número válido de asientos.");
                        break;
                    }
                    System.out.print("Precio base: ");
                    double iPrice;
                    try {
                        iPrice = Double.parseDouble(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Ingrese un precio válido.");
                        break;
                    }
                    System.out.print("País destino: ");
                    String iCountry = scanner.nextLine();
                    System.out.print("¿Requiere pasaporte? (true/false): ");
                    boolean iPass = Boolean.parseBoolean(scanner.nextLine());
                    System.out.print("Tasa internacional: ");
                    double iFee;
                    try {
                        iFee = Double.parseDouble(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Ingrese una tasa válida.");
                        break;
                    }
                    controller.createInternationalRoute(iCode, iOrigin, iDest, iDate, iDepTime, iArrTime, iSeats, iPrice, iCountry, iPass, iFee);
                    break;

                case 4:
                    System.out.print("Código de reserva: ");
                    String rCode = scanner.nextLine();
                    System.out.print("Cédula pasajero: ");
                    String rpId = scanner.nextLine();
                    System.out.print("Código de ruta: ");
                    String rrCode = scanner.nextLine();
                    System.out.print("Asientos a reservar: ");
                    int rSeats;
                    try {
                        rSeats = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Ingrese una cantidad válida de asientos.");
                        break;
                    }
                    System.out.print("Fecha de reserva: ");
                    String rDate = scanner.nextLine();
                    controller.createReservation(rCode, rpId, rrCode, rSeats, rDate);
                    break;

                case 5:
                    System.out.print("Código de reserva a cancelar: ");
                    String cCode = scanner.nextLine();
                    controller.cancelReservation(cCode);
                    break;

                case 6:
                    System.out.print("Código de reserva: ");
                    String fCode = scanner.nextLine();
                    Reservation foundRes = controller.findReservationByCode(fCode);
                    if (foundRes != null) {
                        System.out.println(foundRes);
                    } else {
                        System.out.println("No se encontró la reserva con ese código.");
                    }
                    break;

                case 7:
                    System.out.print("Cédula del pasajero: ");
                    String spId = scanner.nextLine();
                    controller.showReservationsByPassenger(spId);
                    break;

                case 8:
                    controller.showTotalPassengers();
                    break;

                case 9:
                    controller.showAllRoutes();
                    break;

                case 10:
                    controller.showAllReservations();
                    break;

                case 11:
                    System.out.println("Gracias por usar FluxioBus Colombia. ¡Buen viaje!");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        scanner.close();
    }
}
