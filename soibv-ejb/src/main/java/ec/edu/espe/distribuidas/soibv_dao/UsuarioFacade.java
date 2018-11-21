/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_dao;

import ec.edu.espe.distribuidas.soibv_modelo.Usuario;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pablin
 */
@Stateless
@LocalBean
public class UsuarioFacade extends AbstractFacade<Usuario> {
  

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario findByNombre(String nombreUsuario) {
        String sql = "SELECT obj FROM Usuario obj WHERE obj.nombreUsuario=?1";
        Query qry = super.getEntityManager().createQuery(sql);
        qry.setParameter(1, nombreUsuario);
        return (Usuario)qry.getSingleResult();
    }
    
}
