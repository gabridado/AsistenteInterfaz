package co.diseno.interfaces.controladores;

/**
 * Abstract factory para los controladores.
 * 
 * @author Gabriel.
 */
public class ControladorFactory {

    /**
     * Obtiene un controlador.
     * 
     * @param tipo Tipo de controlador.
     * @return Controlador.
     */
    public static Controlador getControlador(String tipo) {
        tipo = tipo.toLowerCase();
        
        switch (tipo) {
            case "principal":
                return new PrincipalControlador();
            default:
                return null;
        }
    }
}
