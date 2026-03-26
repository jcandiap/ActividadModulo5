package cl.aerofly.dao.impl;

import cl.aerofly.dao.BookingDAO;
import cl.aerofly.model.Booking;
import cl.aerofly.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Implementación de la interfaz BookingDAO para persistir datos utilizando JDBC.
 * Gestiona el almacenamiento permanente de las reservaciones en la base de datos MySQL.
 */
public class BookingImpl implements BookingDAO {

    /**
     * Inserta un nuevo registro de reserva vinculando un pasajero con un vuelo específico.
     * @param booking objeto de tipo Booking que contiene los datos a registrar.
     * @return true si la inserción fue exitosa; false en caso de error o parámetros nulos.
     */
    @Override
    public boolean persistBooking(Booking booking) {
        String sql = "INSERT INTO bookings (flight_id, passenger_name, email) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, booking.getFlightId());
            ps.setString(2, booking.getPassengerName());
            ps.setString(3, booking.getEmail());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
