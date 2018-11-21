/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Pablin
 */
@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_TIPO_USUARIO", nullable = false)
    private Integer codTipoUsuario;
    @Column(name = "NOMBRE_TIPO_USUARIO", nullable = false, length = 20)
    private String nombreTipoUsuario;
    @Column(name = "ACTIVO", nullable = false)
    private boolean activo;
    @OneToMany(mappedBy = "codTipoUsuario")
    private List<Usuario> usuarioList;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer codTipoUsuario) {
        this.codTipoUsuario = codTipoUsuario;
    }

    public TipoUsuario(Integer codTipoUsuario, String nombreTipoUsuario, boolean activo) {
        this.codTipoUsuario = codTipoUsuario;
        this.nombreTipoUsuario = nombreTipoUsuario;
        this.activo = activo;
    }

    public Integer getCodTipoUsuario() {
        return codTipoUsuario;
    }

    public void setCodTipoUsuario(Integer codTipoUsuario) {
        this.codTipoUsuario = codTipoUsuario;
    }

    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoUsuario != null ? codTipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.codTipoUsuario == null && other.codTipoUsuario != null) || (this.codTipoUsuario != null && !this.codTipoUsuario.equals(other.codTipoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.soibv_modelo.TipoUsuario[ codTipoUsuario=" + codTipoUsuario + " ]";
    }
    
}
