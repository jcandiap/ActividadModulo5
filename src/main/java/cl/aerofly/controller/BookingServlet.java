package cl.aerofly.controller;

import cl.aerofly.dao.BookingDAO;
import cl.aerofly.dao.FlightDAO;
import cl.aerofly.dao.impl.BookingImpl;
import cl.aerofly.dao.impl.FlightImpl;
import cl.aerofly.model.Booking;
import cl.aerofly.model.Flight;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Controlador Servlet encargado de la gestión de reservaciones de vuelos.
 * Coordina la carga de información de vuelo, validación de datos del pasajero y su persistencia.
 */
@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
    private BookingDAO bookingDAO = new BookingImpl();
    private FlightDAO flightDAO = new FlightImpl();

    /**
     * Prepara la vista de reserva cargando los detalles del vuelo seleccionado.
     * @param request objeto que contiene el parámetro flightId.
     * @param response objeto para redirigir la respuesta al cliente.
     * @throws ServletException si ocurre un error específico del servlet.
     * @throws IOException si ocurre un error de comunicación.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightIdStr = request.getParameter("flightId");
        if (flightIdStr != null) {
            int flightId = Integer.parseInt(flightIdStr);
            Flight flight = flightDAO.getFlightById(flightId);
            request.setAttribute("flight", flight);
            request.setAttribute("flightId", flightId);
        }

        request.getRequestDispatcher("/views/booking.jsp").forward(request, response);
    }

    /**
     * Procesa el formulario de reserva, valida los datos y registra la información en el sistema.
     * @param request contiene los datos del pasajero y el ID del vuelo.
     * @param response redirige a la lista de vuelos con un mensaje de éxito o error.
     * @throws ServletException si ocurre un error en el procesamiento del servlet.
     * @throws IOException si ocurre un error al redirigir o procesar la petición.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightIdStr = request.getParameter("flightId");
        String name = request.getParameter("passengerName");
        String email = request.getParameter("email");

        if (name == null || name.trim().isEmpty() || email == null || !email.contains("@")) {
            request.setAttribute("error", "Invalid name or email format.");
            request.setAttribute("flightId", flightIdStr);
            
            if (flightIdStr != null) {
                Flight flight = flightDAO.getFlightById(Integer.parseInt(flightIdStr));
                request.setAttribute("flight", flight);
            }
            
            request.getRequestDispatcher("/views/booking.jsp").forward(request, response);
            return;
        }

        Booking newBooking = new Booking();
        newBooking.setFlightId(Integer.parseInt(flightIdStr));
        newBooking.setPassengerName(name);
        newBooking.setEmail(email);

        if (bookingDAO.persistBooking(newBooking)) {
            response.sendRedirect("flights?success=true");
        } else {
            response.sendRedirect("flights?success=false");
        }
    }
}
