/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_dao;

import ec.edu.espe.distribuidas.soibv_modelo.Asistencia;
import java.util.Date;
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
public class AsistenciaFacade extends AbstractFacade<Asistencia> {

    public AsistenciaFacade() {
        super(Asistencia.class);
    }

    public List<Asistencia> findReporte(Date finicio, Date ffin, String tipo) {
        String sql = "SELECT obj FROM Asistencia obj WHERE obj.tipoEvento=?3 AND obj.fechaAsistencia BETWEEN ?1 AND ?2";
        Query qry = super.getEntityManager().createQuery(sql);
        qry.setParameter(1, finicio);
        qry.setParameter(2, ffin);
        qry.setParameter(3, tipo);
        return qry.getResultList();
    }
}
