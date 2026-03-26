package cl.aerofly.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de Utilidad para la gestión de la conexión con la base de datos MySQL.
 * Provee un método estático para obtener un objeto Connection configurado para AeroFly.
 */
public class DBConnection {

    private static final String URL = "jdbc:mysql://db:3306/aerofly?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = "root";

    /**
     * Establece y devuelve una conexión activa con el servidor MySQL del sistema.
     * @return objeto Connection listo para realizar consultas SQL.
     * @throws SQLException si ocurre un error al cargar el driver o al conectar.
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
    }

}
