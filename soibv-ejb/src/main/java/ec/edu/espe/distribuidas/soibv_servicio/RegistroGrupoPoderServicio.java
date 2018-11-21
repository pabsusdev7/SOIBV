/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_servicio;

import ec.edu.espe.distribuidas.soibv_dao.ColaboradorFacade;
import ec.edu.espe.distribuidas.soibv_dao.GrupoPoderFacade;
import ec.edu.espe.distribuidas.soibv_dao.MiembroFacade;
import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.GrupoPoder;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Pablin
 */
@Stateless
@LocalBean
public class RegistroGrupoPoderServicio {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private GrupoPoderFacade grupoPoderFacade;
    @EJB
    private ColaboradorFacade colaboradorFacade;
    @EJB
    private MiembroFacade miembroFacade;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public GrupoPoder registrarGP(String cedulalid, String dir, String dia, Date hora) {
        Colaborador col = this.colaboradorFacade.find(this.colaboradorFacade.findByMiembroCedula1(cedulalid));
        GrupoPoder gp = new GrupoPoder(dir, dia, hora, col);
        this.grupoPoderFacade.create(gp);
        return gp;



    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public GrupoPoder editarGP(String cedulalid, String dir, String dia, Date hora, GrupoPoder gp1) {
        Colaborador col = this.colaboradorFacade.find(this.colaboradorFacade.findByMiembroCedula1(cedulalid));
        gp1.setCodLider(col);
        gp1.setDiareunion(dia);
        gp1.setDireccionGrupoPoder(dir);
        gp1.setHorareunion(hora);
        this.grupoPoderFacade.edit(gp1);
        return gp1;



    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(GrupoPoder gp) {


        this.grupoPoderFacade.create(gp);




    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void editar(GrupoPoder gp) {

        this.grupoPoderFacade.edit(gp);




    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void elimGP(GrupoPoder gp) {
        for (int i = 0; i < this.miembroFacade.findByGrupoPoder(gp).size(); i++) {
            this.miembroFacade.findByGrupoPoder(gp).get(i).setCodGrupoPoder(null);

        }
        this.grupoPoderFacade.remove(gp);
    }

    public GrupoPoder findbyCod(Integer cod) {
        return this.grupoPoderFacade.find(cod);
    }

    public List<String> findAllLideresGrupo() {
        return this.miembroFacade.findAllLiderGrupoo();
    }

    public List<Integer> findAllCodGrupo() {
        return this.miembroFacade.findAllCodGrupoo();
    }

    public List<GrupoPoder> findAllGP() {
        return this.grupoPoderFacade.findAll();
    }

    public List<Colaborador> obtenerAll() {
        return this.colaboradorFacade.findAll();
    }

    public Colaborador obtenerporCod(Integer cod) {
        return this.colaboradorFacade.find(cod);
    }
}
