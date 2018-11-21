/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_web;

import ec.edu.espe.distribuidas.soibv.NTipoUsuario;
import ec.edu.espe.distribuidas.soibv_modelo.Usuario;
import ec.edu.espe.distribuidas.soibv_servicio.AutenticacionServicio;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * 
 */
@ManagedBean
@ViewScoped
public class InicioBean implements Serializable{
    
    private String nombreUsuario;
    private String clave;
    private DireccionarUsuarioBean direccionarUsuarioBean=new DireccionarUsuarioBean();
    private String nusr;
    
    @EJB
    private AutenticacionServicio autenticacionServicio;
    
    public String validarUsuario() {
        Usuario usuario = this.autenticacionServicio.autenticar(nombreUsuario, clave);
        //System.out.println("En el BB "+usuario);
        if (usuario!=null) {
            String dir=this.direccionarUsuarioBean.direccionarUsuario(usuario);
            FacesContext context= FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("user", usuario);
            nusr=usuario.getCodColaborador().getCodMiembro().getNombreMiembro();
            return dir;
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login Incorrecto", "No coincide la informacion!"));
            return "inicio";
        }
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNusr() {
        return nusr;
    }

    public void setNusr(String nusr) {
        this.nusr = nusr;
    }
    
    
    
    
    
}
