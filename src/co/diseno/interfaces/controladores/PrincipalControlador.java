package co.diseno.interfaces.controladores;

import java.util.List;

import co.diseno.interfaces.conexion.ConexionBD;
import co.diseno.interfaces.modelos.Dispositivo;

public class PrincipalControlador implements Controlador {

    private ConexionBD conexionBD;

    public PrincipalControlador() {
        conexionBD = ConexionBD.getInstance();
    }

    public boolean crearDispositivo(Dispositivo dispositivo) {
        return conexionBD.crearDispositivo(dispositivo);
    }

    /**
     * Comprueba si un dispositivo existe por nombre.
     *
     * @param nombre Nombre del dispositivo.
     * @return True si existe, false si no existe.
     */
    public boolean existeDispositivo(String nombre) {
        return conexionBD.existeDispositivo(nombre);
    }

    /**
     * Actualiza un dispositivo.
     *
     * @param dispositivo Dispositivo a actualizar.
     * @return True si se actualizó, false si no se actualizó.
     */
    public boolean actualizarDispositivo(Dispositivo dispositivo) {
        return conexionBD.actualizarDispositivo(dispositivo);
    }

    /**
     * Elimina un dispositivo.
     *
     * @param nombre Nombre del dispositivo.
     * @return True si se eliminó, false si no se eliminó.
     */
    public boolean eliminarDispositivo(String nombre) {
        return conexionBD.eliminarDispositivo(nombre);
    }

    /**
     * Obtiene la descripción del controlador.
     * 
     * @return Descripción del controlador.
     */
    @Override
    public String getDescripcion() {
        return "Controlador principal";
    }

    /**
     * Busca dispositivo por dirección IP.
     * 
     * @param ip Dirección IP.
     * @return Dispositivo.
     */
    public Dispositivo buscarDispositivoPorIp(String ip) {
        return conexionBD.buscarDispositivoPorIp(ip);
    }

    /**
     * Busca dispositivo por dirección MAC.
     * 
     * @param direccionMac Dirección MAC.
     * @return Dispositivo.
     */
    public Dispositivo buscarDispositivoPorMac(String mac) {
        return conexionBD.buscarDispositivoPorMac(mac);
    }

    /**
     * Obtiene todos los dispositivos.
     * 
     * @return Lista de dispositivos.
     */
    public List<Dispositivo> obtenerDispositivos() {
        return conexionBD.obtenerDispositivos();
    }

    /**
     * Buscar un dispositivo por nombre.
     * 
     * @param nombre Nombre del dispositivo.
     * @return Dispositivo.
     */
    public Dispositivo buscarDispositivoPorNombre(String nombre) {
        return conexionBD.buscarDispositivoPorNombre(nombre);
    }

    /**
     * Eliminar dispositivo por IP.
     * @param ip IP del dispositivo.
     * @return True si se eliminó, false si no se eliminó.
     */
    public boolean eliminarDispositivoPorIp(String ip) {
        return conexionBD.eliminarDispositivoPorIp(ip);
    }
}
