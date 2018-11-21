/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_dao;

import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.Miembro;
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
public class ColaboradorFacade extends AbstractFacade<Colaborador> {
    

    public ColaboradorFacade() {
        super(Colaborador.class);
    }
    
  
    
    public Integer findByMiembroCedula1(String cedulaMiembro) {
        String sql = "SELECT COD_COLABORADOR FROM COLABORADOR c JOIN MIEMBRO m ON m.COD_MIEMBRO=c.COD_MIEMBRO WHERE m.CEDULA_MIEMBRO='"+cedulaMiembro+"'";
        Query qry = super.getEntityManager().createNativeQuery(sql);
        try {
            Integer codigo = (Integer)qry.getSingleResult();
            return codigo;
        }catch (NoResultException e) {
            return new Integer(0);
        }
    }
    
    public Colaborador findByMiembro(Miembro m) {
        String sql = "SELECT obj FROM Colaborador obj WHERE obj.codMiembro=?1";
        Query qry = super.getEntityManager().createQuery(sql);
        qry.setParameter(1, m);
        return (Colaborador)qry.getSingleResult();
    }
    
     public Integer countByCodMiembro(Integer codMiembro) {
        String sql = "SELECT COUNT(COD_COLABORADOR) FROM COLABORADOR WHERE COD_MIEMBRO="+codMiembro;
        Query qry = super.getEntityManager().createNativeQuery(sql);
        try {
            Integer cont = Integer.parseInt(Long.toString((Long)qry.getSingleResult()));
            return cont;
        }catch (NoResultException e) {
            return new Integer(0);
        }
    }
     
     public List<Colaborador> colsByMinisterio(Integer colmin)
     {
         String sql = "SELECT obj.codColaborador FROM ColaboradorMinisterio obj WHERE obj.codMinisterio.codMinisterio=?1";
        Query qry = super.getEntityManager().createQuery(sql);
        qry.setParameter(1, colmin);
        return qry.getResultList();
     }
    
   
    
}
