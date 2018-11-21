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
@Table(name = "ministerio")
public class Ministerio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_MINISTERIO", nullable = false)
    private Integer codMinisterio;
    @Column(name = "NOMBRE_MINISTERIO", nullable = false, length = 50)
    private String nombreMinisterio;
    @JoinColumn(name = "COD_LIDER", referencedColumnName = "COD_COLABORADOR", nullable = false)
    @ManyToOne(optional = false)
    private Colaborador codLider;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMinisterio")
    private List<ColaboradorMinisterio> colaboradorMinisterioList;

    public Ministerio() {
    }

    public Ministerio(String nombreMinisterio, Colaborador codLider) {
        this.nombreMinisterio = nombreMinisterio;
        this.codLider = codLider;
    }

    public Ministerio(Integer codMinisterio) {
        this.codMinisterio = codMinisterio;
    }

    public Ministerio(Integer codMinisterio, String nombreMinisterio) {
        this.codMinisterio = codMinisterio;
        this.nombreMinisterio = nombreMinisterio;
    }

    public Integer getCodMinisterio() {
        return codMinisterio;
    }

    public void setCodMinisterio(Integer codMinisterio) {
        this.codMinisterio = codMinisterio;
    }

    public String getNombreMinisterio() {
        return nombreMinisterio;
    }

    public void setNombreMinisterio(String nombreMinisterio) {
        this.nombreMinisterio = nombreMinisterio;
    }

    public Colaborador getCodLider() {
        return codLider;
    }

    public void setCodLider(Colaborador codLider) {
        this.codLider = codLider;
    }

    public List<ColaboradorMinisterio> getColaboradorMinisterioList() {
        return colaboradorMinisterioList;
    }

    public void setColaboradorMinisterioList(List<ColaboradorMinisterio> colaboradorMinisterioList) {
        this.colaboradorMinisterioList = colaboradorMinisterioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMinisterio != null ? codMinisterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ministerio)) {
            return false;
        }
        Ministerio other = (Ministerio) object;
        if ((this.codMinisterio == null && other.codMinisterio != null) || (this.codMinisterio != null && !this.codMinisterio.equals(other.codMinisterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.soibv_modelo.Ministerio[ codMinisterio=" + codMinisterio + " ]";
    }
    
}
