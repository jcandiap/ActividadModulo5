package cl.aerofly.dao;

import cl.aerofly.model.Flight;
import java.util.List;

/**
 * Interfaz DAO que define las operaciones de acceso a datos para los Vuelos.
 * Permite la recuperación y consulta de información de vuelos en la base de datos.
 */
public interface FlightDAO {

    /**
     * Obtiene la lista completa de vuelos disponibles en el sistema.
     * @return lista de objetos de tipo Flight.
     */
    List<Flight> getFlights();

    /**
     * Recupera un vuelo específico basado en su identificador único.
     * @param id identificador único del vuelo.
     * @return objeto de tipo Flight con los datos correspondientes o null si no se encuentra.
     */
    Flight getFlightById(int id);
}
