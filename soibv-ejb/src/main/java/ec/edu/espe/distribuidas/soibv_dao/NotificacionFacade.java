/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_dao;

import ec.edu.espe.distribuidas.soibv_modelo.Notificacion;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pablin
 */
@Stateless
@LocalBean
public class NotificacionFacade extends AbstractFacade<Notificacion> {
    

    public NotificacionFacade() {
        super(Notificacion.class);
    }
    
}
