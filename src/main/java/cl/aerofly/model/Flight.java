package cl.aerofly.model;

/**
 * Clase de Modelo que representa un Vuelo en el sistema.
 * Contiene la información básica del trayecto, horario y número de identificación.
 */
public class Flight {

    private int id;
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;

    /**
     * Constructor por defecto de la clase Flight.
     */
    public Flight() {
    }

    /**
     * Obtiene el identificador único del vuelo.
     * @return id del vuelo.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del vuelo.
     * @param id identificador a asignar.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el código alfanumérico del vuelo.
     * @return número de vuelo.
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Establece el código alfanumérico del vuelo.
     * @param flightNumber número de vuelo a asignar.
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * Obtiene el lugar de origen del vuelo.
     * @return ciudad o aeropuerto de origen.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Establece el lugar de origen del vuelo.
     * @param origin ciudad de origen a asignar.
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Obtiene el destino del vuelo.
     * @return ciudad o aeropuerto de destino.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Establece el destino del vuelo.
     * @param destination ciudad de destino a asignar.
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Obtiene la hora y fecha de salida del vuelo.
     * @return horario de salida.
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Establece la hora y fecha de salida del vuelo.
     * @param departureTime horario a asignar.
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
