/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_web;

import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.GrupoPoder;
import ec.edu.espe.distribuidas.soibv_servicio.RegistroGrupoPoderServicio;
import ec.edu.espe.distribuidas.tarde.web.util.MensajesGenericos;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Pablo Albuja
 */
@ManagedBean
@ViewScoped
public class GDPsBean extends BotonesBean implements Serializable{

    @EJB
    private RegistroGrupoPoderServicio registroGrupoPoderServicio;
    
    private List<GrupoPoder> gruposPoder;
    private GrupoPoder gp;
    private GrupoPoder gps;
    private Integer ccol;
    private List<Colaborador> cols;

    @PostConstruct
    @Override
    public void postConstructor() {
        super.sinSeleccion();
        this.gruposPoder=this.registroGrupoPoderServicio.findAllGP();
        this.cols=this.registroGrupoPoderServicio.obtenerAll();
       
    }
    public void filaSeleccionada(ActionEvent evento) {
        if (this.gps instanceof GrupoPoder) {
            super.seleccionadoUno();
        } else {
            super.sinSeleccion();
        }
    }

    

    public void nuevo(ActionEvent evento) {
        
        this.gp= new GrupoPoder();
        this.ccol=null;
        super.crear();
    }

//    public void guardar(ActionEvent evento) {
//        System.out.println("En guardar");
//        this.usuarioServicio.crear(this.usuario);
//        this.usuarios = this.usuarioServicio.obtenerEjecutivos();
//        this.enNuevo = Boolean.FALSE;
//    }

    public void modificar(ActionEvent evento) {
        this.gp = new GrupoPoder();
        try {
            BeanUtils.copyProperties(this.gp, this.gps);
            ccol=this.gp.getCodLider().getCodColaborador();
            super.modificar();
        } catch (Exception ex) {
            MensajesGenericos.errorCopyProperties();
        } 
    }
    
    public void eliminar(ActionEvent evento) {
        this.registroGrupoPoderServicio.elimGP(this.gps);
        this.gruposPoder.remove(this.gps);
        super.sinSeleccion();
    }
    
    public void cancelar(ActionEvent evento) {
        if (super.getEnRegistro()) {
            super.sinSeleccion();
        } else {
            super.seleccionadoUno();
        }
        MensajesGenericos.infoCancelar();
    }
    
    
    public Integer convertidor(String s)
    {
        Integer n=Integer.parseInt(s);
        return n;
    }
    
    public void aceptar(ActionEvent evento) {
        try {
            if (super.getEnRegistro()) {
                this.gp.setCodLider(this.registroGrupoPoderServicio.obtenerporCod(this.ccol));
                this.registroGrupoPoderServicio.crear(this.gp);
                MensajesGenericos.infoCrear("Grupo de Poder", this.gp.getCodLider().getCodMiembro().getNombreMiembro().concat(" - ").concat(this.gp.getCodGrupoPoder().toString()), Boolean.TRUE);
                super.sinSeleccion();
                this.gruposPoder.add(this.gp);
            } else {
                this.gp.setCodLider(this.registroGrupoPoderServicio.obtenerporCod(this.ccol));
                this.registroGrupoPoderServicio.editar(this.gp);
                MensajesGenericos.infoModificar("Grupo de Poder", this.gp.getCodLider().getCodMiembro().getNombreMiembro().concat(" - ").concat(this.gp.getCodGrupoPoder().toString()), Boolean.TRUE);
                super.seleccionadoUno();
            }
        } catch (Exception e) {
            MensajesGenericos.errorGuardar();
            e.printStackTrace();
        }
    }

    public GrupoPoder getGp() {
        return gp;
    }

    public void setGp(GrupoPoder gp) {
        this.gp = gp;
    }

    public GrupoPoder getGps() {
        return gps;
    }

    public void setGps(GrupoPoder gps) {
        this.gps = gps;
    }

    public List<GrupoPoder> getGruposPoder() {
        return gruposPoder;
    }

    public void setGruposPoder(List<GrupoPoder> gruposPoder) {
        this.gruposPoder = gruposPoder;
    }

    public Integer getCcol() {
        return ccol;
    }

    public void setCcol(Integer ccol) {
        this.ccol = ccol;
    }

    public List<Colaborador> getCols() {
        return cols;
    }
    

   

  

}
