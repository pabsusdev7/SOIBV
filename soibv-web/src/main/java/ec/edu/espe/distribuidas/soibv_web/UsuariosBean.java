/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_web;

import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.TipoUsuario;
import ec.edu.espe.distribuidas.soibv_modelo.Usuario;
import ec.edu.espe.distribuidas.soibv_servicio.RegistroUsuarioServicio;
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
public class UsuariosBean extends BotonesBean implements Serializable{

    @EJB
    private RegistroUsuarioServicio registroUsuarioServicio;
    
    private List<Usuario> usuarios;
    private List<TipoUsuario> tiposusuario;
    private List<Colaborador> colaboradores;
    private Usuario usuario;
    private Usuario usuarioSeleccionado;
    private Colaborador col;
    private TipoUsuario tu;
    private Integer ctu;
    private Integer ccol;

    @PostConstruct
    @Override
    public void postConstructor() {
        super.sinSeleccion();
        this.usuarios=this.registroUsuarioServicio.obtenerAllU();
        this.tiposusuario=this.registroUsuarioServicio.obtenerTiposUsuarios();
        this.colaboradores=this.registroUsuarioServicio.obtenerAll();
       
    }
    public void filaSeleccionada(ActionEvent evento) {
        if (this.usuarioSeleccionado instanceof Usuario) {
            super.seleccionadoUno();
        } else {
            super.sinSeleccion();
        }
    }

    

    public void nuevo(ActionEvent evento) {
        
        this.usuario= new Usuario();
        this.ccol=null;
        this.ctu=null;
        super.crear();
    }

//    public void guardar(ActionEvent evento) {
//        System.out.println("En guardar");
//        this.usuarioServicio.crear(this.usuario);
//        this.usuarios = this.usuarioServicio.obtenerEjecutivos();
//        this.enNuevo = Boolean.FALSE;
//    }

    public void modificar(ActionEvent evento) {
        this.usuario = new Usuario();
        try {
            BeanUtils.copyProperties(this.usuario, this.usuarioSeleccionado);
            this.col=this.usuario.getCodColaborador();
            this.tu=this.usuario.getCodTipoUsuario();
            ctu=this.tu.getCodTipoUsuario();
            ccol=this.col.getCodColaborador();
            super.modificar();
        } catch (Exception ex) {
            MensajesGenericos.errorCopyProperties();
        } 
    }
    
    public void eliminar(ActionEvent evento) {
        this.registroUsuarioServicio.elimUsuario(this.usuarioSeleccionado);
        this.usuarios.remove(this.usuarioSeleccionado);
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
                this.usuario.setCodColaborador(this.registroUsuarioServicio.obtenerporCod(this.ccol));
                this.usuario.setCodTipoUsuario(this.registroUsuarioServicio.obtenerPorCodigo(this.ctu));
                this.registroUsuarioServicio.crear(this.usuario);
                MensajesGenericos.infoCrear("Usuario", this.usuario.getNombreUsuario().concat(" - ").concat(this.usuario.getCodColaborador().getCodMiembro().getNombreMiembro()), Boolean.TRUE);
                super.sinSeleccion();
                this.usuarios.add(this.usuario);
            } else {
                this.usuario.setCodColaborador(this.registroUsuarioServicio.obtenerporCod(this.ccol));
                this.usuario.setCodTipoUsuario(this.registroUsuarioServicio.obtenerPorCodigo(this.ctu));
                this.registroUsuarioServicio.editar(this.usuario);
                MensajesGenericos.infoModificar("Usuario", this.usuario.getNombreUsuario().concat(" - ").concat(this.usuario.getCodColaborador().getCodMiembro().getNombreMiembro()), Boolean.TRUE);
                super.seleccionadoUno();
            }
        } catch (Exception e) {
            MensajesGenericos.errorGuardar();
            e.printStackTrace();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Colaborador getCol() {
        return col;
    }

    public Integer getCtu() {
        return ctu;
    }

    public void setCtu(Integer ctu) {
        this.ctu = ctu;
    }
    

    public void setCol(Colaborador col) {
        this.col = col;
    }

    public TipoUsuario getTu() {
        return tu;
    }

    public void setTu(TipoUsuario tu) {
        this.tu = tu;
    }

   
   

    public List<TipoUsuario> getTiposusuario() {
        return tiposusuario;
    }

    public void setTiposusuario(List<TipoUsuario> tiposusuario) {
        this.tiposusuario = tiposusuario;
    }

    public Integer getCcol() {
        return ccol;
    }

    public void setCcol(Integer ccol) {
        this.ccol = ccol;
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }
    
    
    
    
    
    
    

   

  

}
