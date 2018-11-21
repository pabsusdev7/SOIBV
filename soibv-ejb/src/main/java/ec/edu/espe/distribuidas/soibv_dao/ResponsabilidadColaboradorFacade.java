/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_dao;

import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.ResponsabilidadColaborador;
import ec.edu.espe.distribuidas.soibv_modelo.Usuario;
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
public class ResponsabilidadColaboradorFacade extends AbstractFacade<ResponsabilidadColaborador> {
   

    public ResponsabilidadColaboradorFacade() {
        super(ResponsabilidadColaborador.class);
    }
    
     public List<ResponsabilidadColaborador> findByCodColaborador(Integer codColaborador) {
        String sql = "SELECT obj FROM ResponsabilidadColaborador obj WHERE obj.codColaborador.codColaborador=?1";
        Query qry = super.getEntityManager().createQuery(sql);
        qry.setParameter(1, codColaborador);
        return qry.getResultList();
    }
     
      public List<ResponsabilidadColaborador> findByUsuario(Usuario u) {
        String sql = "SELECT obj FROM ResponsabilidadColaborador obj WHERE obj.codUsuario=?1";
        Query qry = super.getEntityManager().createQuery(sql);
        qry.setParameter(1, u);
        return qry.getResultList();
    }
      
       public List<ResponsabilidadColaborador> findByResp(Integer resp) {
        String sql = "SELECT obj FROM ResponsabilidadColaborador obj WHERE obj.codResponsabilidad.codResponsabilidad=?1";
        Query qry = super.getEntityManager().createQuery(sql);
        qry.setParameter(1, resp);
        return qry.getResultList();
    }
       
        public Integer countByCodCol(Integer col) {
        String sql = "SELECT COUNT(COD_COLABORADOR) FROM RESPONSABILIDAD_COLABORADOR WHERE COD_COLABORADOR="+col;
        Query qry = super.getEntityManager().createNativeQuery(sql);
        try {
            Integer cont = Integer.parseInt(Long.toString((Long)qry.getSingleResult()));
            return cont;
        }catch (NoResultException e) {
            return new Integer(0);
        }
    }
        
         public List<Colaborador> findResp() {
        String sql = "SELECT DISTINCT obj.codColaborador FROM ResponsabilidadColaborador obj";
        Query qry = super.getEntityManager().createQuery(sql);
        
        return qry.getResultList();
    }
      
     
     
     
    
}
