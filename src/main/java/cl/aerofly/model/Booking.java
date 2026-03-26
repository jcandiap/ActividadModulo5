package cl.aerofly.model;

/**
 * Clase de Modelo que representa una Reserva en el sistema.
 * Almacena los datos del pasajero vinculados a un vuelo específico.
 */
public class Booking {

    private int id;
    private int flightId;
    private String passengerName;
    private String email;

    /**
     * Constructor por defecto de la clase Booking.
     */
    public Booking() {
    }

    /**
     * Obtiene el identificador único de la reserva.
     * @return id de la reserva.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la reserva.
     * @param id identificador a asignar.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del vuelo asociado a la reserva.
     * @return identificador del vuelo.
     */
    public int getFlightId() {
        return flightId;
    }

    /**
     * Establece el identificador del vuelo para esta reserva.
     * @param flightId identificador del vuelo a asignar.
     */
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    /**
     * Obtiene el nombre completo del pasajero.
     * @return nombre del pasajero.
     */
    public String getPassengerName() {
        return passengerName;
    }

    /**
     * Establece el nombre completo del pasajero.
     * @param passengerName nombre completo a asignar.
     */
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    /**
     * Obtiene la dirección de correo electrónico del pasajero.
     * @return email del pasajero.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece la dirección de correo electrónico del pasajero.
     * @param email dirección de correo a asignar.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
