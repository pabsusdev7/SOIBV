/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_web;

import ec.edu.espe.distribuidas.soibv_modelo.GrupoTrabajo;
import ec.edu.espe.distribuidas.soibv_modelo.Ministerio;
import ec.edu.espe.distribuidas.soibv_servicio.RegistroGrupoTrabajoServicio;
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
public class GruposTrabajoBean extends BotonesBean implements Serializable{

    @EJB
    private RegistroGrupoTrabajoServicio registroGrupoTrabajoServicio;
    
    private List<GrupoTrabajo> grupostrabajo;
    private GrupoTrabajo gto;
    private GrupoTrabajo gtSeleccionado;

    @PostConstruct
    @Override
    public void postConstructor() {
        super.sinSeleccion();
        this.grupostrabajo=this.registroGrupoTrabajoServicio.findAll();
       
    }
    public void filaSeleccionada(ActionEvent evento) {
        if (this.gtSeleccionado instanceof GrupoTrabajo) {
            super.seleccionadoUno();
        } else {
            super.sinSeleccion();
        }
    }

    

    public void nuevo(ActionEvent evento) {
        
        this.gto= new GrupoTrabajo();
        super.crear();
    }

//    public void guardar(ActionEvent evento) {
//        System.out.println("En guardar");
//        this.usuarioServicio.crear(this.usuario);
//        this.usuarios = this.usuarioServicio.obtenerEjecutivos();
//        this.enNuevo = Boolean.FALSE;
//    }

    public void modificar(ActionEvent evento) {
        this.gto = new GrupoTrabajo();
        try {
            BeanUtils.copyProperties(this.gto, this.gtSeleccionado);
            super.modificar();
        } catch (Exception ex) {
            MensajesGenericos.errorCopyProperties();
        } 
    }
    
    public void eliminar(ActionEvent evento) {
        this.registroGrupoTrabajoServicio.eliminar(this.gtSeleccionado);
        this.grupostrabajo.remove(this.gtSeleccionado);
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
                this.registroGrupoTrabajoServicio.crear(this.gto);
                MensajesGenericos.infoCrear("Grupo Trabajo", this.gto.getDescripcion().concat(" - ").concat(this.gto.getCodGrupoTrabajo().toString()), Boolean.TRUE);
                super.sinSeleccion();
                this.grupostrabajo.add(this.gto);
            } else {
                this.registroGrupoTrabajoServicio.editar(this.gto);
                MensajesGenericos.infoModificar("Grupo Trabajo", this.gto.getDescripcion().concat(" - ").concat(this.gto.getCodGrupoTrabajo().toString()), Boolean.TRUE);
                super.seleccionadoUno();
            }
        } catch (Exception e) {
            MensajesGenericos.errorGuardar();
            e.printStackTrace();
        }
    }

    public List<GrupoTrabajo> getGrupostrabajo() {
        return grupostrabajo;
    }

    public void setGrupostrabajo(List<GrupoTrabajo> grupostrabajo) {
        this.grupostrabajo = grupostrabajo;
    }

    public GrupoTrabajo getGto() {
        return gto;
    }

    public void setGto(GrupoTrabajo gt) {
        this.gto = gt;
    }

    public GrupoTrabajo getGtSeleccionado() {
        return gtSeleccionado;
    }

    public void setGtSeleccionado(GrupoTrabajo gtSeleccionado) {
        this.gtSeleccionado = gtSeleccionado;
    }

    

  

}
