
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DatabaseConnection {
    private static final String URL =
    "jdbc:mysql://localhost:3306/GestionTaller";
    private static final String USUARIO = "user";
 
    private static final String CONTRASENA = "user";
 
public static Connection conectar() {
    try {
    return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    } catch (SQLException e) {
    System.out.println("Error al conectar a la base de datos: " +
    e.getMessage());
    return null;
    }
}
}
 