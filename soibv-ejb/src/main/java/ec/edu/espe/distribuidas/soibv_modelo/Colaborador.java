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
@Table(name = "colaborador")
public class Colaborador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_COLABORADOR", nullable = false)
    private Integer codColaborador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codColaborador")
    private List<GrupoTrabajoColaborador> grupoTrabajoColaboradorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codColaborador")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLider")
    private List<Ministerio> ministerioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codColaborador")
    private List<ColaboradorMinisterio> colaboradorMinisterioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codColaborador")
    private List<ResponsabilidadColaborador> responsabilidadColaboradorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codLider")
    private List<GrupoPoder> grupoPoderList;
    @JoinColumn(name = "COD_MIEMBRO", referencedColumnName = "COD_MIEMBRO", nullable = false)
    @ManyToOne(optional = false)
    private Miembro codMiembro;

    public Colaborador() {
    }
    
    
    
    public Colaborador(Miembro codMiembro) {
        this.codMiembro = codMiembro;
    }

    public Colaborador(Integer codColaborador) {
        this.codColaborador = codColaborador;
    }

    public Integer getCodColaborador() {
        return codColaborador;
    }

    public void setCodColaborador(Integer codColaborador) {
        this.codColaborador = codColaborador;
    }

    public List<GrupoTrabajoColaborador> getGrupoTrabajoColaboradorList() {
        return grupoTrabajoColaboradorList;
    }

    public void setGrupoTrabajoColaboradorList(List<GrupoTrabajoColaborador> grupoTrabajoColaboradorList) {
        this.grupoTrabajoColaboradorList = grupoTrabajoColaboradorList;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<Ministerio> getMinisterioList() {
        return ministerioList;
    }

    public void setMinisterioList(List<Ministerio> ministerioList) {
        this.ministerioList = ministerioList;
    }

    public List<ColaboradorMinisterio> getColaboradorMinisterioList() {
        return colaboradorMinisterioList;
    }

    public void setColaboradorMinisterioList(List<ColaboradorMinisterio> colaboradorMinisterioList) {
        this.colaboradorMinisterioList = colaboradorMinisterioList;
    }

    public List<ResponsabilidadColaborador> getResponsabilidadColaboradorList() {
        return responsabilidadColaboradorList;
    }

    public void setResponsabilidadColaboradorList(List<ResponsabilidadColaborador> responsabilidadColaboradorList) {
        this.responsabilidadColaboradorList = responsabilidadColaboradorList;
    }

    public List<GrupoPoder> getGrupoPoderList() {
        return grupoPoderList;
    }

    public void setGrupoPoderList(List<GrupoPoder> grupoPoderList) {
        this.grupoPoderList = grupoPoderList;
    }

    public Miembro getCodMiembro() {
        return codMiembro;
    }

    public void setCodMiembro(Miembro codMiembro) {
        this.codMiembro = codMiembro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codColaborador != null ? codColaborador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.codColaborador == null && other.codColaborador != null) || (this.codColaborador != null && !this.codColaborador.equals(other.codColaborador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.soibv_modelo.Colaborador[ codColaborador=" + codColaborador + " ]";
    }
    
}
