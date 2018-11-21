/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_web;

import ec.edu.espe.distribuidas.soibv_modelo.Asistencia;
import ec.edu.espe.distribuidas.soibv_servicio.RegMiembroServicio;
import ec.edu.espe.distribuidas.soibv_servicio.ReporteAsistenciaServicio;
import ec.edu.espe.distribuidas.tarde.web.util.MensajesGenericos;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class RepAsistenciasBean extends BotonesBean implements Serializable {

    @EJB
    private RegMiembroServicio regMiembroServicio;
    @EJB
    private ReporteAsistenciaServicio reporteAsistenciaServicio;
    private List<Asistencia> asistencia;
    private List<Asistencia> rasistencia;
    private Asistencia a;
    private Asistencia as;
    private Date finicio;
    private Date ffin;
    private String tipo;
    private Double padultos;
    private Double pninos;
    private Double pjovenes;
    private Double pnuevos;
    private Double ptotal;
    private String spadultos;
    private String spninos;
    private String spjovenes;
    private String spnuevos;
    private String sptotal;

    @PostConstruct
    @Override
    public void postConstructor() {
        super.sinSeleccion();
        this.rasistencia = this.regMiembroServicio.obtenerAllAsistencias();
        this.ffin = null;
        this.finicio = null;
        this.tipo = null;
        this.padultos = 0.0;
        this.pninos = 0.0;
        this.pjovenes = 0.0;
        this.pnuevos = 0.0;
        this.ptotal = 0.0;
        this.spadultos = "";
        this.spninos = "";
        this.spjovenes = "";
        this.spnuevos = "";
        this.sptotal = "";


    }

    public void filaSeleccionada(ActionEvent evento) {
        if (this.as instanceof Asistencia) {
            super.seleccionadoUno();
        } else {
            super.sinSeleccion();
        }
    }

    public void nuevo(ActionEvent evento) {

        this.a = new Asistencia();

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

    public Integer convertidor(String s) {
        Integer n = Integer.parseInt(s);
        return n;
    }

    public void aceptar(ActionEvent evento) {
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            this.padultos = 0.0;
            this.pninos = 0.0;
            this.pjovenes = 0.0;
            this.pnuevos = 0.0;
            this.ptotal = 0.0;
            this.spadultos = "";
            this.spninos = "";
            this.spjovenes = "";
            this.spnuevos = "";
            this.sptotal = "";

            this.rasistencia = this.reporteAsistenciaServicio.obtReporte(this.finicio, this.ffin, this.tipo);
            for (int i = 0; i < this.rasistencia.size(); i++) {
                this.padultos += this.rasistencia.get(i).getNumAdultos().doubleValue();
                this.pninos += this.rasistencia.get(i).getNumNinos().doubleValue();
                this.pjovenes += this.rasistencia.get(i).getNumJovenes().doubleValue();
                this.pnuevos += this.rasistencia.get(i).getTotalAsistencia().doubleValue();
                this.ptotal += (this.rasistencia.get(i).getNumAdultos().doubleValue() + this.rasistencia.get(i).getNumNinos().doubleValue() + this.rasistencia.get(i).getNumJovenes().doubleValue());

            }
            this.padultos = this.padultos / this.rasistencia.size();
            this.pninos = this.pninos / this.rasistencia.size();
            this.pjovenes = this.pjovenes / this.rasistencia.size();
            this.pnuevos = this.pnuevos / this.rasistencia.size();
            this.ptotal = this.ptotal / this.rasistencia.size();
            this.spadultos = df.format(this.padultos);
            this.spninos = df.format(this.pninos);
            this.spjovenes = df.format(this.pjovenes);
            this.spnuevos = df.format(this.pnuevos);
            this.sptotal = df.format(this.ptotal);

            super.enReporte();

        } catch (Exception e) {
            MensajesGenericos.errorReporte();
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

    public Date getFfin() {
        return ffin;
    }

    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }

    public Date getFinicio() {
        return finicio;
    }
    public String getFfintxt() {
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(this.ffin);
        
    }

    public String getFiniciotxt() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(this.finicio);
        
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Asistencia> getRasistencia() {
        return rasistencia;
    }

    public void setRasistencia(List<Asistencia> rasistencia) {
        this.rasistencia = rasistencia;
    }

    public Double getPadultos() {
        return padultos;
    }

    public void setPadultos(Double padultos) {
        this.padultos = padultos;
    }

    public Double getPjovenes() {
        return pjovenes;
    }

    public void setPjovenes(Double pjovenes) {
        this.pjovenes = pjovenes;
    }

    public Double getPninos() {
        return pninos;
    }

    public void setPninos(Double pninos) {
        this.pninos = pninos;
    }

    public Double getPtotal() {
        return ptotal;
    }

    public void setPtotal(Double ptotal) {
        this.ptotal = ptotal;
    }

    public Double getPnuevos() {
        return pnuevos;
    }

    public void setPnuevos(Double pnuevos) {
        this.pnuevos = pnuevos;
    }

    public String getSpadultos() {
        return spadultos;
    }

    public void setSpadultos(String spadultos) {
        this.spadultos = spadultos;
    }

    public String getSpjovenes() {
        return spjovenes;
    }

    public void setSpjovenes(String spjovenes) {
        this.spjovenes = spjovenes;
    }

    public String getSpninos() {
        return spninos;
    }

    public void setSpninos(String spninos) {
        this.spninos = spninos;
    }

    public String getSpnuevos() {
        return spnuevos;
    }

    public void setSpnuevos(String spnuevos) {
        this.spnuevos = spnuevos;
    }

    public String getSptotal() {
        return sptotal;
    }

    public void setSptotal(String sptotal) {
        this.sptotal = sptotal;
    }
    
    
}
