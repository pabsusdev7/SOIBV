/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_dao;

import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.GrupoPoder;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Pablin
 */
@Stateless
@LocalBean
public class GrupoPoderFacade extends AbstractFacade<GrupoPoder> {
    

    public GrupoPoderFacade() {
        super(GrupoPoder.class);
    }
    
    public GrupoPoder findByColaborador(Colaborador c) {
        String sql = "SELECT obj FROM GrupoPoder obj WHERE obj.codLider=?1";
        Query qry = super.getEntityManager().createQuery(sql);
        qry.setParameter(1, c);
        return (GrupoPoder)qry.getSingleResult();
    }
    
    public Integer countByCodCol(Integer col) {
        String sql = "SELECT COUNT(*) FROM GRUPO_PODER WHERE COD_LIDER="+col;
        Query qry = super.getEntityManager().createNativeQuery(sql);
        try {
            Integer cont = Integer.parseInt(Long.toString((Long)qry.getSingleResult()));
            return cont;
        }catch (NoResultException e) {
            return new Integer(0);
        }
    }
    
}
