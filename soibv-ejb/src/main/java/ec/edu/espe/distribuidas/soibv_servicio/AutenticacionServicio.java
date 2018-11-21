/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_servicio;
import ec.edu.espe.distribuidas.soibv_dao.UsuarioFacade;
import ec.edu.espe.distribuidas.soibv_modelo.Usuario;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Pablin
 */
@Stateless
@LocalBean
public class AutenticacionServicio {

    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    public Usuario autenticar(String nombreUsuario, String clave) {
        Usuario usuario = this.usuarioFacade.findByNombre(nombreUsuario);
        if (usuario!=null && clave.equals(usuario.getContrasenaUsuario())) {
            return usuario;
        }
        return null;
    }
    
}
