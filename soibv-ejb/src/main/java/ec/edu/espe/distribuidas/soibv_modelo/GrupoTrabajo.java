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
@Table(name = "grupo_trabajo")
public class GrupoTrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_GRUPO_TRABAJO", nullable = false)
    private Integer codGrupoTrabajo;
    @Column(name = "DESCRIPCION", nullable = false, length = 20)
    private String descripcion;
    @Column(name = "ACTIVO", nullable = false, length = 20)
    private String activo;
    @OneToMany(mappedBy = "codGrupoTrabajo")
    private List<GrupoTrabajoColaborador> grupoTrabajoColaboradorList;

    public GrupoTrabajo() {
    }

    public GrupoTrabajo(Integer codGrupoTrabajo) {
        this.codGrupoTrabajo = codGrupoTrabajo;
    }

    public GrupoTrabajo(Integer codGrupoTrabajo, String descripcion, String activo) {
        this.codGrupoTrabajo = codGrupoTrabajo;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Integer getCodGrupoTrabajo() {
        return codGrupoTrabajo;
    }

    public void setCodGrupoTrabajo(Integer codGrupoTrabajo) {
        this.codGrupoTrabajo = codGrupoTrabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public List<GrupoTrabajoColaborador> getGrupoTrabajoColaboradorList() {
        return grupoTrabajoColaboradorList;
    }

    public void setGrupoTrabajoColaboradorList(List<GrupoTrabajoColaborador> grupoTrabajoColaboradorList) {
        this.grupoTrabajoColaboradorList = grupoTrabajoColaboradorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codGrupoTrabajo != null ? codGrupoTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoTrabajo)) {
            return false;
        }
        GrupoTrabajo other = (GrupoTrabajo) object;
        if ((this.codGrupoTrabajo == null && other.codGrupoTrabajo != null) || (this.codGrupoTrabajo != null && !this.codGrupoTrabajo.equals(other.codGrupoTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.soibv_modelo.GrupoTrabajo[ codGrupoTrabajo=" + codGrupoTrabajo + " ]";
    }
    
}
