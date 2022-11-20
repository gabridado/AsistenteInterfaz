package co.diseno.interfaces.modelos;

/**
 *
 * @author Gabriel
 */
public class Dispositivo {
    private String nombre;
    private String localizacion;
    private String foto;
    private String ip;
    private String direccionMac;

    public Dispositivo() {
    }

    public Dispositivo(String nombre, String localizacion, String foto, String ip, String direccionMac) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.foto = foto;
        this.ip = ip;
        this.direccionMac = direccionMac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDireccionMac() {
        return direccionMac;
    }

    public void setDireccionMac(String direccionMac) {
        this.direccionMac = direccionMac;
    }

    @Override
    public String toString() {
        return "Dispositivo{" + "nombre=" + nombre + ", localizacion=" + localizacion + ", foto=" + foto + ", ip=" + ip + ", direccionMac=" + direccionMac + '}';
    }
}
