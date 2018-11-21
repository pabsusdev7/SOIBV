/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_dao;

import ec.edu.espe.distribuidas.soibv_modelo.Ministerio;
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
public class MinisterioFacade extends AbstractFacade<Ministerio> {
   

    public MinisterioFacade() {
        super(Ministerio.class);
    }
    
}
