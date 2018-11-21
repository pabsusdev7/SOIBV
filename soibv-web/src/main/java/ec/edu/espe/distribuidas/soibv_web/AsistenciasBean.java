/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_web;

import ec.edu.espe.distribuidas.soibv_modelo.Asistencia;
import ec.edu.espe.distribuidas.soibv_servicio.RegMiembroServicio;
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
public class AsistenciasBean extends BotonesBean implements Serializable{

    @EJB
    private RegMiembroServicio regMiembroServicio;
    
    private List<Asistencia> asistencia;
    private Asistencia a;
    private Asistencia as;


    @PostConstruct
    @Override
    public void postConstructor() {
        super.sinSeleccion();
        this.asistencia=this.regMiembroServicio.obtenerAllAsistencias();
        
       
    }
    public void filaSeleccionada(ActionEvent evento) {
        if (this.as instanceof Asistencia) {
            super.seleccionadoUno();
        } else {
            super.sinSeleccion();
        }
    }

    

    public void nuevo(ActionEvent evento) {
        
        this.a= new Asistencia();
        
        super.crear();
    }

//    public void guardar(ActionEvent evento) {
//        System.out.println("En guardar");
//        this.usuarioServicio.crear(this.usuario);
//        this.usuarios = this.usuarioServicio.obtenerEjecutivos();
//        this.enNuevo = Boolean.FALSE;
//    }

    public void modificar(ActionEvent evento) {
        this.a = new Asistencia();
        try {
            BeanUtils.copyProperties(this.a, this.as);
            
            super.modificar();
        } catch (Exception ex) {
            MensajesGenericos.errorCopyProperties();
        } 
    }
    
    public void eliminar(ActionEvent evento) {
        this.regMiembroServicio.elimAs(this.as);
        this.asistencia.remove(this.as);
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
                
                this.regMiembroServicio.regAs(this.a);
                MensajesGenericos.infoCrear("Registro Asistencia", this.a.getCodAsistencia().toString().concat(" - ").concat(this.a.getTipoEvento()), Boolean.TRUE);
                super.sinSeleccion();
                this.asistencia.add(this.a);
            } else {
                
                this.regMiembroServicio.ediAs(this.a);
               MensajesGenericos.infoCrear("Registro Asistencia", this.a.getCodAsistencia().toString().concat(" - ").concat(this.a.getTipoEvento()), Boolean.TRUE);
                super.seleccionadoUno();
            }
        } catch (Exception e) {
            MensajesGenericos.errorGuardar();
            e.printStackTrace();
        }
    }

    public Asistencia getA() {
        return a;
    }

    public void setA(Asistencia a) {
        this.a = a;
    }

    public Asistencia getAs() {
        return as;
    }

    public void setAs(Asistencia as) {
        this.as = as;
    }

    public List<Asistencia> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(List<Asistencia> asistencia) {
        this.asistencia = asistencia;
    }

   
    

   

  

}
