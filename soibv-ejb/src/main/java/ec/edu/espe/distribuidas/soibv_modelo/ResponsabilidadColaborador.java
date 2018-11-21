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

/**
 *
 * @author Pablin
 */
@Entity
@Table(name = "responsabilidad_colaborador")
public class ResponsabilidadColaborador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_RESPONSABILIDAD_COLABORADOR", nullable = false)
    private Integer codResponsabilidadColaborador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codResponsabilidadColaborador")
    private List<Notificacion> notificacionList;
    @JoinColumn(name = "COD_RESPONSABILIDAD", referencedColumnName = "COD_RESPONSABILIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Responsabilidad codResponsabilidad;
    @JoinColumn(name = "COD_COLABORADOR", referencedColumnName = "COD_COLABORADOR", nullable = false)
    @ManyToOne(optional = false)
    private Colaborador codColaborador;
    @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO", nullable = false)
    @ManyToOne(optional = false)
    private Usuario codUsuario;

    public ResponsabilidadColaborador() {
    }

    public ResponsabilidadColaborador(Responsabilidad codResponsabilidad, Colaborador codColaborador, Usuario codUsuario) {
        this.codResponsabilidad = codResponsabilidad;
        this.codColaborador = codColaborador;
        this.codUsuario = codUsuario;
    }

    public ResponsabilidadColaborador(Integer codResponsabilidadColaborador) {
        this.codResponsabilidadColaborador = codResponsabilidadColaborador;
    }

    public Integer getCodResponsabilidadColaborador() {
        return codResponsabilidadColaborador;
    }

    public void setCodResponsabilidadColaborador(Integer codResponsabilidadColaborador) {
        this.codResponsabilidadColaborador = codResponsabilidadColaborador;
    }

    public List<Notificacion> getNotificacionList() {
        return notificacionList;
    }

    public void setNotificacionList(List<Notificacion> notificacionList) {
        this.notificacionList = notificacionList;
    }

    public Responsabilidad getCodResponsabilidad() {
        return codResponsabilidad;
    }

    public void setCodResponsabilidad(Responsabilidad codResponsabilidad) {
        this.codResponsabilidad = codResponsabilidad;
    }

    public Colaborador getCodColaborador() {
        return codColaborador;
    }

    public void setCodColaborador(Colaborador codColaborador) {
        this.codColaborador = codColaborador;
    }

    public Usuario getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Usuario codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codResponsabilidadColaborador != null ? codResponsabilidadColaborador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponsabilidadColaborador)) {
            return false;
        }
        ResponsabilidadColaborador other = (ResponsabilidadColaborador) object;
        if ((this.codResponsabilidadColaborador == null && other.codResponsabilidadColaborador != null) || (this.codResponsabilidadColaborador != null && !this.codResponsabilidadColaborador.equals(other.codResponsabilidadColaborador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.soibv_modelo.ResponsabilidadColaborador[ codResponsabilidadColaborador=" + codResponsabilidadColaborador + " ]";
    }
    
}
