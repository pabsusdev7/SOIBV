/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_dao;

import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.Responsabilidad;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Pablin
 */
@Stateless
@LocalBean
public class ResponsabilidadFacade extends AbstractFacade<Responsabilidad> {
    

    public ResponsabilidadFacade() {
        super(Responsabilidad.class);
    }
    
    
     public List<Colaborador> findByResp(Integer resp) {
        String sql = "SELECT obj.codColaborador FROM ResponsabilidadColaborador obj WHERE obj.codResponsabilidad.codResponsabilidad=?1";
        Query qry = super.getEntityManager().createQuery(sql);
        qry.setParameter(1, resp);
        return qry.getResultList();
    }
    
    
    
}
