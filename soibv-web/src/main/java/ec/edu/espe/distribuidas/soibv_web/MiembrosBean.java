/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_web;

import ec.edu.espe.distribuidas.soibv_modelo.ColaboradorMinisterio;
import ec.edu.espe.distribuidas.soibv_modelo.GrupoPoder;
import ec.edu.espe.distribuidas.soibv_modelo.Miembro;
import ec.edu.espe.distribuidas.soibv_modelo.Ministerio;
import ec.edu.espe.distribuidas.soibv_servicio.RegMiembroServicio;
import ec.edu.espe.distribuidas.tarde.web.util.MensajesGenericos;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.event.CaptureEvent;

/**
 *
 * @author Pablo Albuja
 */
@ManagedBean
@ViewScoped
public class MiembrosBean extends BotonesBean implements Serializable {

    @EJB
    private RegMiembroServicio registroMiembroServicio;
    private List<Miembro> miembros;
    private List<Miembro> miembrosfilt;
    private Miembro miembro;
    private Miembro miembroSeleccionado;
    private String btm;
    private String enc;
    private String smin;
    private Integer min;
    private Integer codmin;
    private List<Integer> lcodmin;
    private List<Ministerio> ministerios;
    private String sgdp;
    private Integer gdp;
    private Integer codgdp;
    private List<GrupoPoder> gdps;
    private List<ColaboradorMinisterio> lcm;

    @PostConstruct
    @Override
    public void postConstructor() {
        super.sinSeleccion();
        this.miembros = this.registroMiembroServicio.findAllMiembros();
        this.ministerios = this.registroMiembroServicio.obtenerAllMin();
        this.gdps = this.registroMiembroServicio.obtenerAllGDP();

    }

    public void filaSeleccionada(ActionEvent evento) {
        if (this.miembroSeleccionado instanceof Miembro) {
            super.seleccionadoUno();
        } else {
            super.sinSeleccion();
        }
    }

    public void nuevo(ActionEvent evento) {

        this.miembro = new Miembro();
        this.lcodmin = new ArrayList<Integer>();
        this.btm = null;
        this.enc = null;
        this.sgdp = null;
        this.smin = null;
        this.min = null;
        this.codmin = null;
        this.gdp = null;
        this.codgdp = null;
        super.camposC();
        super.crear();
    }

//    public void guardar(ActionEvent evento) {
//        System.out.println("En guardar");
//        this.usuarioServicio.crear(this.usuario);
//        this.usuarios = this.usuarioServicio.obtenerEjecutivos();
//        this.enNuevo = Boolean.FALSE;
//    }
    public void hdCombos() {
        if (this.btm.equals("1")) {
            super.eB();
        }
        if (this.btm.equals("0")) {
            super.dB();
        }
        if (this.smin.equals("1")) {
            super.eM();
        }
        if (this.smin.equals("0")) {
            super.dM();
        }
        if (this.sgdp.equals("1")) {
            super.eG();
        }
        if (this.sgdp.equals("0")) {
            super.dG();
        }
    }

    public void modificar(ActionEvent evento) {
        this.miembro = new Miembro();
        this.lcodmin = new ArrayList<Integer>();
        this.btm = null;
        this.enc = null;
        this.sgdp = null;
        this.smin = null;
        this.min = null;
        this.codmin = null;
        this.gdp = null;
        this.codgdp = null;
        super.camposC();
        try {
            BeanUtils.copyProperties(this.miembro, this.miembroSeleccionado);
            if (this.miembro.getBautismoMiembro()) {
                this.btm = "1";
                super.eB();
            } else {
                this.btm = "0";
                this.miembro.setLugbautismoMiembro(null);
            }
            if (this.miembro.getEncuentroMiembro()) {
                this.enc = "1";

            } else {
                this.enc = "0";
            }
            if (this.miembro.getCodGrupoPoder() != null) {
                this.sgdp = "1";
                this.codgdp = this.miembro.getCodGrupoPoder().getCodGrupoPoder();
                super.eG();
            } else {
                this.sgdp = "0";
            }
            if (this.registroMiembroServicio.countColMinsByCodMiembro(this.miembro.getCodMiembro()) > 0) {
                this.smin = "1";
                super.eM();
                this.lcm = this.registroMiembroServicio.obtenerPorCol(this.registroMiembroServicio.findByMiembro(this.miembro));
                for (int i = 0; i < this.lcm.size(); i++) {
                    this.lcodmin.add(this.lcm.get(i).getCodMinisterio().getCodMinisterio());
                }



            } else {
                this.smin = "0";
            }






            super.modificar();
        } catch (Exception ex) {
            MensajesGenericos.errorCopyProperties();
        }
    }

    public void eliminar(ActionEvent evento) {
        this.registroMiembroServicio.elimMiembro(this.miembroSeleccionado);
        this.miembros.remove(this.miembroSeleccionado);
        super.sinSeleccion();
    }

    public void foto(ActionEvent evento) {
        this.miembro = new Miembro();
        try {
            BeanUtils.copyProperties(this.miembro, this.miembroSeleccionado);



            super.tomarFoto();
        } catch (Exception ex) {
            MensajesGenericos.errorCopyProperties();
        }

    }

    public void cancelar(ActionEvent evento) {
        if (super.getEnRegistro()) {
            super.sinSeleccion();
        } else {
            super.seleccionadoUno();
        }
        MensajesGenericos.infoCancelar();
    }

    public void aceptar(ActionEvent evento) {
        try {
            if (super.getEnRegistro()) {
                if (this.btm.equals("1")) {
                    this.miembro.setBautismoMiembro(true);
                } else {
                    this.miembro.setBautismoMiembro(false);
                }
                if (this.enc.equals("1")) {
                    this.miembro.setEncuentroMiembro(true);
                } else {
                    this.miembro.setEncuentroMiembro(false);
                }
                if (this.sgdp.equals("1") && this.codgdp != null) {
                    this.miembro.setCodGrupoPoder(this.registroMiembroServicio.findGrupoPoderPorCodigo(this.codgdp));
                }
                if (this.smin.equals("1") && !this.lcodmin.isEmpty()) {
                    for (int i = 0; i < this.lcodmin.size(); i++) {
                        this.registroMiembroServicio.registroColMin(this.registroMiembroServicio.obtenerPorCodigo(this.lcodmin.get(i)), this.miembro);
                    }
                }
                this.registroMiembroServicio.registrarMiembro1(this.miembro);
                MensajesGenericos.infoCrear("Miembro", this.miembro.getNombreMiembro().concat(" - ").concat(this.miembro.getCedulaMiembro()), Boolean.TRUE);
                super.sinSeleccion();
                this.miembros.add(this.miembro);
            } else {
                if (this.btm.equals("1")) {
                    this.miembro.setBautismoMiembro(true);
                } else {
                    this.miembro.setBautismoMiembro(false);
                }
                if (this.enc.equals("1")) {
                    this.miembro.setEncuentroMiembro(true);
                } else {
                    this.miembro.setEncuentroMiembro(false);
                }
                if (this.sgdp.equals("1") && this.codgdp != null) {
                    this.miembro.setCodGrupoPoder(this.registroMiembroServicio.findGrupoPoderPorCodigo(this.codgdp));
                } else {
                    this.miembro.setCodGrupoPoder(null);
                }
                if (this.smin.equals("1") && !this.lcodmin.isEmpty()) {
                    this.registroMiembroServicio.editColMin(this.miembro, this.lcodmin);
                    //this.registroMiembroServicio.editColMin(this.registroMiembroServicio.obtenerPorCodigo(this.lcodmin.get(i)), this.miembro);
                } else {
                    this.registroMiembroServicio.elimColMin(this.miembro);
                }
                this.registroMiembroServicio.editarMiembro1(this.miembro);
                MensajesGenericos.infoModificar("Miembro", this.miembro.getNombreMiembro().concat(" - ").concat(this.miembro.getCedulaMiembro()), Boolean.TRUE);
                super.seleccionadoUno();
            }
        } catch (Exception e) {
            MensajesGenericos.errorGuardar();
            e.printStackTrace();
        }
    }

    public void aceptarFoto(ActionEvent evento) {
        try {
            if (super.getEnFoto()) {

                super.sinSeleccion();
                //MensajesGenericos.infoModificar("Foto Miembro", this.miembro.getNombreMiembro().concat(" - ").concat(this.miembro.getCedulaMiembro()), Boolean.TRUE);
            }
        } catch (Exception e) {
            MensajesGenericos.errorGuardar();
            e.printStackTrace();
        }
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public Miembro getMiembroSeleccionado() {
        return miembroSeleccionado;
    }

    public void setMiembroSeleccionado(Miembro miembroSeleccionado) {
        this.miembroSeleccionado = miembroSeleccionado;
    }

    public Integer getCodmin() {
        return codmin;
    }

    public void setCodmin(Integer codmin) {
        this.codmin = codmin;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public List<Ministerio> getMinisterios() {
        return ministerios;
    }

    public Integer getCodgdp() {
        return codgdp;
    }

    public void setCodgdp(Integer codgdp) {
        this.codgdp = codgdp;
    }

    public Integer getGdp() {
        return gdp;
    }

    public void setGdp(Integer gdp) {
        this.gdp = gdp;
    }

    public List<GrupoPoder> getGdps() {
        return gdps;
    }

    public String getBtm() {
        return btm;
    }

    public void setBtm(String btm) {
        this.btm = btm;
    }

    public String getSgdp() {
        return sgdp;
    }

    public void setSgdp(String sgdp) {
        this.sgdp = sgdp;
    }

    public String getSmin() {
        return smin;
    }

    public void setSmin(String smin) {
        this.smin = smin;
    }

    public String getEnc() {
        return enc;
    }

    public void setEnc(String enc) {
        this.enc = enc;
    }

    public List<Miembro> getMiembrosfilt() {
        return miembrosfilt;
    }

    public void setMiembrosfilt(List<Miembro> miembrosfilt) {
        this.miembrosfilt = miembrosfilt;
    }
    /*----- FOTOS ----------------------*/
    private List<String> photos = new ArrayList<String>();

    private String getRandomImageName() {
        int i = (int) (Math.random() * 10000000);

        return String.valueOf(i);
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void oncapture(CaptureEvent captureEvent) {
        String photo = getRandomImageName();

        byte[] data = captureEvent.getData();

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String newFileName = servletContext.getRealPath("") + File.separator + "paginas" + File.separator + "imagenes" + File.separator + "fotos" + File.separator + this.miembro.getCedulaMiembro() + ".jpg";

        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(newFileName));
            imageOutput.write(data, 0, data.length);

            imageOutput.close();
        } catch (Exception e) {
            throw new FacesException("Error in writing captured image.");
        }
    }

    public List<Integer> getLcodmin() {
        return lcodmin;
    }

    public void setLcodmin(List<Integer> lcodmin) {
        this.lcodmin = lcodmin;
    }
}
