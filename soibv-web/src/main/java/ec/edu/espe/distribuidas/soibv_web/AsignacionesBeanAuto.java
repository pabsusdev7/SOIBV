/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_web;

import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.Ministerio;
import ec.edu.espe.distribuidas.soibv_modelo.Responsabilidad;
import ec.edu.espe.distribuidas.soibv_modelo.ResponsabilidadColaborador;
import ec.edu.espe.distribuidas.soibv_modelo.Usuario;
import ec.edu.espe.distribuidas.soibv_servicio.RegistroResponsabilidadServicio;
import ec.edu.espe.distribuidas.tarde.web.util.MensajesGenericos;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Pablo Albuja
 */
@ManagedBean
@ViewScoped
public class AsignacionesBeanAuto extends BotonesBean implements Serializable{

    @EJB
    private RegistroResponsabilidadServicio registroResponsabilidadServicio;
    
    private List<ResponsabilidadColaborador> respcols;
    private ResponsabilidadColaborador respcol;
    private ResponsabilidadColaborador respcolSeleccionado;
    private List<Responsabilidad> resps;
    private Responsabilidad resp;
    private Responsabilidad respSeleccionado;
    private Usuario usuario;
    private Colaborador col;
    private Integer cresp;
    private Integer ccol;
    private Integer cuser;
    private List<Colaborador> cols;
    private List<Colaborador> colss;
    private List<Integer> ccolss;
    private Integer num;
    private Integer cmin;
    private List<Ministerio> lmin;
    

    @PostConstruct
    @Override
    public void postConstructor() {
        super.sinSeleccion();
        this.resps=this.registroResponsabilidadServicio.findAllResp();
        this.respcols=this.registroResponsabilidadServicio.findAll();
        this.cols=this.registroResponsabilidadServicio.obtenerAll();
        this.lmin=this.registroResponsabilidadServicio.findAllMin();
       
    }
    public void filaSeleccionada(ActionEvent evento) {
        if (this.respSeleccionado instanceof Responsabilidad) {
            super.seleccionadoUno();
        } else {
            super.sinSeleccion();
        }
    }

    

    public void nuevo(ActionEvent evento) {
        
        this.resp=new Responsabilidad();
        this.respcol= new ResponsabilidadColaborador();
        this.ccol=null;
        this.cresp=null;
        this.cuser=null;
        
        super.crear();
    }

//    public void guardar(ActionEvent evento) {
//        System.out.println("En guardar");
//        this.usuarioServicio.crear(this.usuario);
//        this.usuarios = this.usuarioServicio.obtenerEjecutivos();
//        this.enNuevo = Boolean.FALSE;
//    }

    public void modificar(ActionEvent evento) {
        
        try {
            BeanUtils.copyProperties(this.resp, this.respSeleccionado);
//            this.resp=this.respcol.getCodResponsabilidad();
//            this.col=this.respcol.getCodColaborador();
//            this.usuario=this.respcol.getCodUsuario();
            this.cresp=this.resp.getCodResponsabilidad();
            //this.respcols=this.registroResponsabilidadServicio.findbyResp(this.cresp);
            this.colss=this.registroResponsabilidadServicio.findbyResponsabilidad(this.cresp);
            for(int j=0;j<this.colss.size();j++)
                this.ccolss.set(j, this.colss.get(j).getCodColaborador());
            
            
            super.modificar();
        } catch (Exception ex) {
            MensajesGenericos.errorCopyProperties();
        } 
    }
    
    public void eliminar(ActionEvent evento) {
        this.registroResponsabilidadServicio.eliminarResponsabilidadColaborador(this.respSeleccionado);
        this.resps.remove(this.respSeleccionado);
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
                this.registroResponsabilidadServicio.crearR(this.resp);
                for(int i=0;i<this.num;i++){
                this.respcol.setCodColaborador(this.registroResponsabilidadServicio.distribCarga(this.cmin).get(this.registroResponsabilidadServicio.distribCarga(this.cmin).size()-(i+1)));
                this.respcol.setCodUsuario((Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user"));
                this.respcol.setCodResponsabilidad(this.resp);
                this.registroResponsabilidadServicio.crearRC(this.respcol);}
                MensajesGenericos.infoCrear("Responsabilidad", this.resp.getDescripcionResponsabilidad().concat(" - ").concat(this.resp.getFechaResponsabilidadtxt()), Boolean.TRUE);
                super.sinSeleccion();
                this.resps.add(this.resp);
            } else {
                
                this.registroResponsabilidadServicio.editarR(this.resp);
                for(int i=0;i<this.num;i++){
                this.respcol.setCodColaborador(this.registroResponsabilidadServicio.distribCarga(this.cmin).get(this.registroResponsabilidadServicio.distribCarga(this.cmin).size()-(i+1)));
                this.respcol.setCodUsuario((Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user"));
                this.respcol.setCodResponsabilidad(this.resp);
                
                this.registroResponsabilidadServicio.editarRC(this.respcol);}
                MensajesGenericos.infoModificar("Responsabilidad", this.resp.getDescripcionResponsabilidad().concat(" - ").concat(this.resp.getFechaResponsabilidadtxt()), Boolean.TRUE);
                super.seleccionadoUno();
            }
        } catch (Exception e) {
            MensajesGenericos.errorGuardar();
            e.printStackTrace();
        }
    }

    public Responsabilidad getResp() {
        return resp;
    }

    public void setResp(Responsabilidad resp) {
        this.resp = resp;
    }

    public ResponsabilidadColaborador getRespcol() {
        return respcol;
    }

    public void setRespcol(ResponsabilidadColaborador respcol) {
        this.respcol = respcol;
    }

    public ResponsabilidadColaborador getRespcolSeleccionado() {
        return respcolSeleccionado;
    }

    public void setRespcolSeleccionado(ResponsabilidadColaborador respcolSeleccionado) {
        this.respcolSeleccionado = respcolSeleccionado;
    }

    public List<ResponsabilidadColaborador> getRespcols() {
        return respcols;
    }

    public void setRespcols(List<ResponsabilidadColaborador> respcols) {
        this.respcols = respcols;
    }

    public Colaborador getCol() {
        return col;
    }

    public void setCol(Colaborador col) {
        this.col = col;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public void setCols(List<Colaborador> cols) {
        this.cols = cols;
    }

    public Integer getCresp() {
        return cresp;
    }

    public void setCresp(Integer cresp) {
        this.cresp = cresp;
    }

    public Integer getCuser() {
        return cuser;
    }

    public void setCuser(Integer cuser) {
        this.cuser = cuser;
    }

    public Responsabilidad getRespSeleccionado() {
        return respSeleccionado;
    }

    public void setRespSeleccionado(Responsabilidad respSeleccionado) {
        this.respSeleccionado = respSeleccionado;
    }

    public List<Responsabilidad> getResps() {
        return resps;
    }

    public void setResps(List<Responsabilidad> resps) {
        this.resps = resps;
    }

    public List<Colaborador> getColss() {
        return colss;
    }

    public void setColss(List<Colaborador> colss) {
        this.colss = colss;
    }

    public List<Integer> getCcolss() {
        return ccolss;
    }

    public void setCcolss(List<Integer> ccolss) {
        this.ccolss = ccolss;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<Ministerio> getLmin() {
        return lmin;
    }

    public Integer getCmin() {
        return cmin;
    }

    public void setCmin(Integer cmin) {
        this.cmin = cmin;
    }
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    

   

  

}
