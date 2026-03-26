package cl.aerofly.dao;

import cl.aerofly.model.Booking;

/**
 * Interfaz DAO que define las operaciones de persistencia para las Reservas.
 * Permite la creación y almacenamiento de registros de reservación en el sistema.
 */
public interface BookingDAO {

    /**
     * Almacena una nueva reserva en la base de datos de manera persistente.
     * @param booking objeto de tipo Booking que contiene los datos a registrar.
     * @return true si la reserva se guardó correctamente; false en caso contrario.
     */
    boolean persistBooking(Booking booking);

}
