package co.diseno.interfaces.util;

/**
 *
 * @author Gabriel.
 */
public final class Utilidades {
    public static boolean esDireccionIpValida(String direccionIp) {
        return direccionIp.matches("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$");
    }

    public static boolean esDireccionMacValida(String direccionMac) {
        return direccionMac.matches("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");
    }
}
