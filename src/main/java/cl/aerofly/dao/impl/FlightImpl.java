package cl.aerofly.dao.impl;

import cl.aerofly.dao.FlightDAO;
import cl.aerofly.model.Flight;
import cl.aerofly.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz FlightDAO utilizando JDBC para conectarse a una base de datos.
 * Esta clase se encarga de la lógica concreta de acceso y recuperación de información de vuelos.
 */
public class FlightImpl implements FlightDAO {

    /**
     * Consulta y recupera todos los registros de la tabla de vuelos en la base de datos.
     * @return lista de objetos Flight representando los registros encontrados.
     */
    @Override
    public List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flights";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Flight flight = new Flight();
                flight.setId(rs.getInt("id"));
                flight.setFlightNumber(rs.getString("flight_number"));
                flight.setOrigin(rs.getString("origin"));
                flight.setDestination(rs.getString("destination"));
                flight.setDepartureTime(rs.getString("departure_time"));
                flights.add(flight);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    /**
     * Busca y devuelve los datos de un vuelo específico dado su identificador único.
     * @param id identificador único del vuelo a buscar.
     * @return objeto Flight poblado con los datos o null si el identificador no existe.
     */
    @Override
    public Flight getFlightById(int id) {
        String sql = "SELECT * FROM flights WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Flight flight = new Flight();
                    flight.setId(rs.getInt("id"));
                    flight.setFlightNumber(rs.getString("flight_number"));
                    flight.setOrigin(rs.getString("origin"));
                    flight.setDestination(rs.getString("destination"));
                    flight.setDepartureTime(rs.getString("departure_time"));
                    return flight;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
