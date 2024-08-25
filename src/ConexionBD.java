import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
    public static void main(String[] args) {
        Connection conexion = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establecer la conexión a la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/arepas_db", "root", "adivinela1994");

            // Crear una sentencia
            stmt = conexion.createStatement();

            // Ejecutar una consulta
            rs = stmt.executeQuery("SELECT * FROM usuarios");

            // Procesar el ResultSet
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_usuario") + ", Nombre: " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}