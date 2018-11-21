/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_dao;

import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.ColaboradorMinisterio;
import ec.edu.espe.distribuidas.soibv_modelo.Ministerio;
import java.util.List;
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
public class ColaboradorMinisterioFacade extends AbstractFacade<ColaboradorMinisterio> {
    

    public ColaboradorMinisterioFacade() {
        super(ColaboradorMinisterio.class);
    }
    
    
    public List<ColaboradorMinisterio> findByColaborador(Colaborador c) {
        String sql = "SELECT obj FROM ColaboradorMinisterio obj WHERE obj.codColaborador=?1";
        Query qry = super.getEntityManager().createQuery(sql);
        qry.setParameter(1, c);
        return qry.getResultList();
    }
    public List<ColaboradorMinisterio> findByMinisterio(Ministerio m) {
        String sql = "SELECT obj FROM ColaboradorMinisterio obj WHERE obj.codMinisterio=?1";
        Query qry = super.getEntityManager().createQuery(sql);
        qry.setParameter(1, m);
        return qry.getResultList();
    }
    
      public Integer countByCodCol(Integer col) {
        String sql = "SELECT COUNT(COD_COLABORADOR) FROM COLABORADOR_MINISTERIO WHERE COD_COLABORADOR="+col;
        Query qry = super.getEntityManager().createNativeQuery(sql);
        try {
            Integer cont = Integer.parseInt(Long.toString((Long)qry.getSingleResult()));
            return cont;
        }catch (NoResultException e) {
            return new Integer(0);
        }
    }
}
