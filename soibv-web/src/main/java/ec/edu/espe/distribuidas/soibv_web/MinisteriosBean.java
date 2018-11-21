/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_web;

import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.Ministerio;
import ec.edu.espe.distribuidas.soibv_servicio.RegistroMinisterioServicio;
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
public class MinisteriosBean extends BotonesBean implements Serializable {

    @EJB
    private RegistroMinisterioServicio registroMinisterioServicio;
    private List<Ministerio> ministerios;
    private Ministerio ministerio;
    private Ministerio ministerioSeleccionado;
    private Integer ccol;
    private List<Colaborador> cols;

    @PostConstruct
    @Override
    public void postConstructor() {
        super.sinSeleccion();
        this.ministerios = this.registroMinisterioServicio.findAllMin();
        this.cols = this.registroMinisterioServicio.obtenerAll();

    }

    public void filaSeleccionada(ActionEvent evento) {
        if (this.ministerioSeleccionado instanceof Ministerio) {
            super.seleccionadoUno();
        } else {
            super.sinSeleccion();
        }
    }

    public void nuevo(ActionEvent evento) {

        this.ministerio = new Ministerio();
        this.ccol = null;
        super.crear();
    }

//    public void guardar(ActionEvent evento) {
//        System.out.println("En guardar");
//        this.usuarioServicio.crear(this.usuario);
//        this.usuarios = this.usuarioServicio.obtenerEjecutivos();
//        this.enNuevo = Boolean.FALSE;
//    }
    public void modificar(ActionEvent evento) {
        this.ministerio = new Ministerio();
        try {
            BeanUtils.copyProperties(this.ministerio, this.ministerioSeleccionado);
            this.ccol = this.ministerio.getCodLider().getCodColaborador();
            super.modificar();
        } catch (Exception ex) {
            MensajesGenericos.errorCopyProperties();
        }
    }

    public void eliminar(ActionEvent evento) {
        this.registroMinisterioServicio.eliminarMin(this.ministerioSeleccionado);
        this.ministerios.remove(this.ministerioSeleccionado);
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
            if (super.getEnRegistro()) {
                this.ministerio.setCodLider(this.registroMinisterioServicio.findByCod(this.ccol));
                this.registroMinisterioServicio.crear(this.ministerio);
                MensajesGenericos.infoCrear("Ministerio", this.ministerio.getNombreMinisterio().concat(" - ").concat(this.ministerio.getCodMinisterio().toString()), Boolean.TRUE);
                super.sinSeleccion();
                this.ministerios.add(this.ministerio);
            } else {
                this.ministerio.setCodLider(this.registroMinisterioServicio.findByCod(this.ccol));
                this.registroMinisterioServicio.editar(this.ministerio);
                MensajesGenericos.infoModificar("Ministerio", this.ministerio.getNombreMinisterio().concat(" - ").concat(this.ministerio.getCodMinisterio().toString()), Boolean.TRUE);
                super.seleccionadoUno();
            }
        } catch (Exception e) {
            MensajesGenericos.errorGuardar();
            e.printStackTrace();
        }
    }

    public Ministerio getMinisterio() {
        return ministerio;
    }

    public void setMinisterio(Ministerio ministerio) {
        this.ministerio = ministerio;
    }

    public Ministerio getMinisterioSeleccionado() {
        return ministerioSeleccionado;
    }

    public void setMinisterioSeleccionado(Ministerio ministerioSeleccionado) {
        this.ministerioSeleccionado = ministerioSeleccionado;
    }

    public List<Ministerio> getMinisterios() {
        return ministerios;
    }

    public void setMinisterios(List<Ministerio> ministerios) {
        this.ministerios = ministerios;
    }

    public Integer getCcol() {
        return ccol;
    }

    public List<Colaborador> getCols() {
        return cols;
    }

    public void setCcol(Integer ccol) {
        this.ccol = ccol;
    }
}
