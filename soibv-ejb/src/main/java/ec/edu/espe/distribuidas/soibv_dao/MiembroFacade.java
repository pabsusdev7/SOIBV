/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_dao;

import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.GrupoPoder;
import ec.edu.espe.distribuidas.soibv_modelo.Miembro;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author Pablin
 */
@Stateless
@LocalBean
public class MiembroFacade extends AbstractFacade<Miembro> {
   

    public MiembroFacade() {
        super(Miembro.class);
    }
    
//    public Miembro findByCodUsuario(Integer codUsuario) {
//        String sql = "SELECT obj FROM Miembro obj JOIN Colaborador c ON obj.codMiembro=c.miembro.codMiembro JOIN Usuario u ON c.codColaborador=u.colaborador.codColaborador WHERE u.codUsuario=?1";
//        Query qry = super.getEntityManager().createQuery(sql);
//        qry.setParameter(1, codUsuario);
//        return (Miembro)qry.getSingleResult();
//    }
    
//    public Miembro findByCodColaborador(Integer codColaborador) {
//        String sql = "SELECT obj FROM Miembro obj JOIN Colaborador c ON obj.codMiembro=c.miembro.codMiembro WHERE c.codColaborador=?1";
//        Query qry = super.getEntityManager().createQuery(sql);
//        qry.setParameter(1, codColaborador);
//        return (Miembro)qry.getSingleResult();
//    }
    
     public List<String> findAllLiderGrupoo() {
        String sql = "SELECT NOMBRE_MIEMBRO FROM MIEMBRO m JOIN COLABORADOR c ON m.COD_MIEMBRO=c.COD_MIEMBRO JOIN GRUPO_PODER g ON c.COD_COLABORADOR=g.COD_LIDER";
        Query qry = super.getEntityManager().createNativeQuery(sql);
        try {
            List<String> lideres = qry.getResultList();
            return lideres;
        }catch (NoResultException e) {
            return new ArrayList<String>();
        }
    }
     
     
     public List<Integer> findAllCodGrupoo() {
        String sql = "SELECT COD_GRUPO_PODER FROM GRUPO_PODER g JOIN COLABORADOR c ON c.COD_COLABORADOR=g.COD_LIDER";
        Query qry = super.getEntityManager().createNativeQuery(sql);
        try {
            List<Integer> lideres = qry.getResultList();
            return lideres;
        }catch (NoResultException e) {
            return new ArrayList<Integer>();
        }
    }
     
     
    
    public Miembro findByCedula(String cedula) {
        String sql = "SELECT obj FROM Miembro obj WHERE obj.cedulaMiembro=?1";
        Query qry = super.getEntityManager().createQuery(sql);
        qry.setParameter(1, cedula);
        return (Miembro)qry.getSingleResult();
    }
    
    public List<Miembro> findByGrupoPoder(GrupoPoder gp)
    {
        String sql = "SELECT obj FROM Miembro obj WHERE obj.codGrupoPoder=?1";
        Query qry = super.getEntityManager().createQuery(sql);
        qry.setParameter(1, gp);
        return qry.getResultList();
    }
    
    public List<Integer> findJovenes()
    {
        String sql = "SELECT COD_MIEMBRO FROM miembro WHERE YEAR(FECHANAC_MIEMBRO) BETWEEN (YEAR(CURDATE())-35) AND (YEAR(CURDATE())-12)";
        Query qry = super.getEntityManager().createNativeQuery(sql);
        try {
            List<Integer> jovenes = qry.getResultList();
            return jovenes;
        }catch (NoResultException e) {
            return new ArrayList<Integer>();
        }
    }
    
    
    
   
    
}
