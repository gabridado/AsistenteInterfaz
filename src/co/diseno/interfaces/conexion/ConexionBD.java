package co.diseno.interfaces.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.diseno.interfaces.modelos.Dispositivo;

/**
 *
 * @author Gabriel.
 */
public class ConexionBD {

    private static final String URL = "jdbc:sqlite:dispositivos.db";
    private static final String TABLA = "dispositivo";
    private Connection conexion;

    private static ConexionBD conexionBD;

    private ConexionBD() {
        conexion = conectar();
        if (!existeTabla(TABLA)) {
            crearTablaDispositivo();
        }
    }

    public static ConexionBD getInstance() {
        if (conexionBD == null) {
            conexionBD = new ConexionBD();
        }
        return conexionBD;
    }

    // Connection to database:
    public Connection conectar() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void desconectar(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean existeTabla(String nombreTabla) {
        final String SQL = "SELECT name FROM sqlite_master WHERE type='table' AND name=?";

        try (PreparedStatement pstmt = conexion.prepareStatement(SQL)) {
            pstmt.setString(1, nombreTabla);
            ResultSet rs = pstmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return false;
    }

    public void crearTablaDispositivo() {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLA + " (\n"
                + " nombre text NOT NULL,\n"
                + " localizacion text NOT NULL,\n"
                + " foto text NOT NULL,\n"
                + " ip text NOT NULL,\n"
                + " direccionMac text NOT NULL,\n"
                + " PRIMARY KEY (nombre)\n"
                + ");";

        System.out.println(sql);

        try {
            conexion.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public boolean crearDispositivo(Dispositivo dispositivo) {
        final String sql = "INSERT INTO " + TABLA
                + " (nombre, localizacion, foto, ip, direccionMac) VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dispositivo.getNombre());
            ps.setString(2, dispositivo.getLocalizacion());
            ps.setString(3, dispositivo.getFoto());
            ps.setString(4, dispositivo.getIp());
            ps.setString(5, dispositivo.getDireccionMac());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return false;
    }

    /**
     * Comprueba si un dispositivo existe por nombre.
     * 
     * @param nombre Nombre del dispositivo.
     * @return True si existe, false si no existe.
     */
    public boolean existeDispositivo(String nombre) {
        final String sql = "SELECT nombre FROM " + TABLA + " WHERE nombre = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);

            return ps.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return false;
    }

    /**
     * Actualiza un dispositivo.
     * 
     * @param dispositivo Dispositivo a actualizar.
     * @return True si se actualizó, false si no se actualizó.
     */
    public boolean actualizarDispositivo(Dispositivo dispositivo) {
        final String sql = "UPDATE " + TABLA
                + " SET localizacion = ?, foto = ? WHERE nombre = ? OR ip = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dispositivo.getLocalizacion());
            ps.setString(2, dispositivo.getFoto());
            ps.setString(3, dispositivo.getNombre());
            ps.setString(4, dispositivo.getIp());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return false;
    }

    /**
     * Elimina un dispositivo.
     * 
     * @param nombre Nombre del dispositivo.
     * @return True si se eliminó, false si no se eliminó.
     */
    public boolean eliminarDispositivo(String nombre) {
        final String sql = "DELETE FROM " + TABLA + " WHERE nombre = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return false;
    }

    /**
     * Eliminar dispositivo por IP.
     * @param ip IP del dispositivo.
     * @return True si se eliminó, false si no se eliminó.
     */
    public boolean eliminarDispositivoPorIp(String ip) {
        final String sql = "DELETE FROM " + TABLA + " WHERE ip = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, ip);

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return false;
    }

    /**
     * Obtiene un dispositivo por nombre.
     * 
     * @param nombre Nombre del dispositivo.
     * @return Dispositivo.
     */
    public Dispositivo obtenerDispositivo(String nombre) {
        final String sql = "SELECT * FROM " + TABLA + " WHERE nombre = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Dispositivo(rs.getString("nombre"), rs.getString("localizacion"), rs.getString("foto"),
                        rs.getString("ip"), rs.getString("direccionMac"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return null;
    }

    /**
     * Busca dispositivo por dirección IP.
     * 
     * @param ip Dirección IP.
     * @return Dispositivo.
     */
    public Dispositivo buscarDispositivoPorIp(String ip) {
        final String sql = "SELECT * FROM " + TABLA + " WHERE ip = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, ip);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Dispositivo(rs.getString("nombre"), rs.getString("localizacion"), rs.getString("foto"),
                        rs.getString("ip"), rs.getString("direccionMac"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return null;
    }

    /**
     * Busca dispositivo por dirección MAC.
     * 
     * @param direccionMac Dirección MAC.
     * @return Dispositivo.
     */
    public Dispositivo buscarDispositivoPorMac(String mac) {
        final String sql = "SELECT * FROM " + TABLA + " WHERE direccionMac = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, mac);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Dispositivo(rs.getString("nombre"), rs.getString("localizacion"), rs.getString("foto"),
                        rs.getString("ip"), rs.getString("direccionMac"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return null;
    }

    /**
     * Obtiene todos los dispositivos.
     * 
     * @return Lista de dispositivos.
     */
    public List<Dispositivo> obtenerDispositivos() {
        final String sql = "SELECT * FROM " + TABLA;

        List<Dispositivo> dispositivos = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                dispositivos.add(new Dispositivo(rs.getString("nombre"), rs.getString("localizacion"),
                        rs.getString("foto"), rs.getString("ip"), rs.getString("direccionMac")));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return dispositivos;
    }

    /**
     * Buscar un dispositivo por nombre.
     * 
     * @param nombre Nombre del dispositivo.
     * @return Dispositivo.
     */
    public Dispositivo buscarDispositivoPorNombre(String nombre) {
        final String sql = "SELECT * FROM " + TABLA + " WHERE nombre = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Dispositivo(rs.getString("nombre"), rs.getString("localizacion"), rs.getString("foto"),
                        rs.getString("ip"), rs.getString("direccionMac"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return null;
    }
}
