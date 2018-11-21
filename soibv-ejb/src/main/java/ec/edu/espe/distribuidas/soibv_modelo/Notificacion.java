/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Pablin
 */
@Entity
@Table(name = "notificacion")
public class Notificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_NOTIFICACION", nullable = false)
    private Integer codNotificacion;
    @JoinColumn(name = "COD_RESPONSABILIDAD_COLABORADOR", referencedColumnName = "COD_RESPONSABILIDAD_COLABORADOR", nullable = false)
    @ManyToOne(optional = false)
    private ResponsabilidadColaborador codResponsabilidadColaborador;

    public Notificacion() {
    }

    public Notificacion(Integer codNotificacion) {
        this.codNotificacion = codNotificacion;
    }

    public Integer getCodNotificacion() {
        return codNotificacion;
    }

    public void setCodNotificacion(Integer codNotificacion) {
        this.codNotificacion = codNotificacion;
    }

    public ResponsabilidadColaborador getCodResponsabilidadColaborador() {
        return codResponsabilidadColaborador;
    }

    public void setCodResponsabilidadColaborador(ResponsabilidadColaborador codResponsabilidadColaborador) {
        this.codResponsabilidadColaborador = codResponsabilidadColaborador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNotificacion != null ? codNotificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificacion)) {
            return false;
        }
        Notificacion other = (Notificacion) object;
        if ((this.codNotificacion == null && other.codNotificacion != null) || (this.codNotificacion != null && !this.codNotificacion.equals(other.codNotificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.soibv_modelo.Notificacion[ codNotificacion=" + codNotificacion + " ]";
    }
    
}
