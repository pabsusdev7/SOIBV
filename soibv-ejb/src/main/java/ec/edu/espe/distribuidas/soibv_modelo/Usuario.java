/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_USUARIO", nullable = false)
    private Integer codUsuario;
    @Column(name = "NOMBRE_USUARIO", nullable = false, length = 20)
    private String nombreUsuario;
    @Column(name = "CONTRASENA_USUARIO", nullable = false, length = 20)
    private String contrasenaUsuario;
    @JoinColumn(name = "COD_COLABORADOR", referencedColumnName = "COD_COLABORADOR", nullable = false)
    @ManyToOne(optional = false)
    private Colaborador codColaborador;
    @JoinColumn(name = "COD_TIPO_USUARIO", referencedColumnName = "COD_TIPO_USUARIO")
    @ManyToOne
    private TipoUsuario codTipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUsuario")
    private List<ResponsabilidadColaborador> responsabilidadColaboradorList;

    public Usuario() {
    }

    public Usuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Usuario(Integer codUsuario, String nombreUsuario, String contrasenaUsuario) {
        this.codUsuario = codUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public Usuario(String nombreUsuario, String contrasenaUsuario, Colaborador codColaborador, TipoUsuario codTipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.codColaborador = codColaborador;
        this.codTipoUsuario = codTipoUsuario;
    }

    
    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public Colaborador getCodColaborador() {
        return codColaborador;
    }

    public void setCodColaborador(Colaborador codColaborador) {
        this.codColaborador = codColaborador;
    }

    public TipoUsuario getCodTipoUsuario() {
        return codTipoUsuario;
    }

    public void setCodTipoUsuario(TipoUsuario codTipoUsuario) {
        this.codTipoUsuario = codTipoUsuario;
    }

    public List<ResponsabilidadColaborador> getResponsabilidadColaboradorList() {
        return responsabilidadColaboradorList;
    }

    public void setResponsabilidadColaboradorList(List<ResponsabilidadColaborador> responsabilidadColaboradorList) {
        this.responsabilidadColaboradorList = responsabilidadColaboradorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.soibv_modelo.Usuario[ codUsuario=" + codUsuario + " ]";
    }
    
}
