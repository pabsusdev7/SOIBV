/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_dao;

import ec.edu.espe.distribuidas.soibv_modelo.GrupoTrabajo;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Pablin
 */
@Stateless
@LocalBean
public class GrupoTrabajoFacade extends AbstractFacade<GrupoTrabajo> {
    

    public GrupoTrabajoFacade() {
        super(GrupoTrabajo.class);
    }
    
}
