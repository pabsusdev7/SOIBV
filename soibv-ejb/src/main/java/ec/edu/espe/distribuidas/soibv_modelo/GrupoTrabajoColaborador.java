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
@Table(name = "grupo_trabajo_colaborador")
public class GrupoTrabajoColaborador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_GRUPO_TRABAJO_COLABORADOR", nullable = false)
    private Integer codGrupoTrabajoColaborador;
    @JoinColumn(name = "COD_COLABORADOR", referencedColumnName = "COD_COLABORADOR", nullable = false)
    @ManyToOne(optional = false)
    private Colaborador codColaborador;
    @JoinColumn(name = "COD_GRUPO_TRABAJO", referencedColumnName = "COD_GRUPO_TRABAJO")
    @ManyToOne
    private GrupoTrabajo codGrupoTrabajo;

    public GrupoTrabajoColaborador() {
    }

    public GrupoTrabajoColaborador(Integer codGrupoTrabajoColaborador) {
        this.codGrupoTrabajoColaborador = codGrupoTrabajoColaborador;
    }

    public Integer getCodGrupoTrabajoColaborador() {
        return codGrupoTrabajoColaborador;
    }

    public void setCodGrupoTrabajoColaborador(Integer codGrupoTrabajoColaborador) {
        this.codGrupoTrabajoColaborador = codGrupoTrabajoColaborador;
    }

    public Colaborador getCodColaborador() {
        return codColaborador;
    }

    public void setCodColaborador(Colaborador codColaborador) {
        this.codColaborador = codColaborador;
    }

    public GrupoTrabajo getCodGrupoTrabajo() {
        return codGrupoTrabajo;
    }

    public void setCodGrupoTrabajo(GrupoTrabajo codGrupoTrabajo) {
        this.codGrupoTrabajo = codGrupoTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codGrupoTrabajoColaborador != null ? codGrupoTrabajoColaborador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoTrabajoColaborador)) {
            return false;
        }
        GrupoTrabajoColaborador other = (GrupoTrabajoColaborador) object;
        if ((this.codGrupoTrabajoColaborador == null && other.codGrupoTrabajoColaborador != null) || (this.codGrupoTrabajoColaborador != null && !this.codGrupoTrabajoColaborador.equals(other.codGrupoTrabajoColaborador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.soibv_modelo.GrupoTrabajoColaborador[ codGrupoTrabajoColaborador=" + codGrupoTrabajoColaborador + " ]";
    }
    
}
