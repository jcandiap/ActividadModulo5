package cl.aerofly.controller;

import cl.aerofly.dao.FlightDAO;
import cl.aerofly.dao.impl.FlightImpl;
import cl.aerofly.model.Flight;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Controlador Servlet que gestiona la visualización de los vuelos disponibles.
 * Recupera los vuelos de la capa DAO y los redirige a la vista correspondiente.
 */
@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    /**
     * Procesa las peticiones HTTP GET para mostrar el listado de vuelos.
     * @param request objeto que contiene la información de la petición.
     * @param response objeto que permite enviar la respuesta al cliente.
     * @throws ServletException si ocurre un error específico del servlet.
     * @throws IOException si ocurre un error de entrada o salida.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlightDAO flightDAO = new FlightImpl();
        List<Flight> flights = flightDAO.getFlights();

        request.setAttribute("flights", flights);
        request.getRequestDispatcher("/views/flights.jsp").forward(request, response);
    }

}
