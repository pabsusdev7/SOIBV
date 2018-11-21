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
@Table(name = "colaborador_ministerio")
public class ColaboradorMinisterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_COLABORADOR_MINISTERIO", nullable = false)
    private Integer codColaboradorMinisterio;
    @JoinColumn(name = "COD_COLABORADOR", referencedColumnName = "COD_COLABORADOR", nullable = false)
    @ManyToOne(optional = false)
    private Colaborador codColaborador;
    @JoinColumn(name = "COD_MINISTERIO", referencedColumnName = "COD_MINISTERIO", nullable = false)
    @ManyToOne(optional = false)
    private Ministerio codMinisterio;

    public ColaboradorMinisterio() {
    }

    public ColaboradorMinisterio(Colaborador codColaborador, Ministerio codMinisterio) {
        this.codColaborador = codColaborador;
        this.codMinisterio = codMinisterio;
    }
    
    

    public ColaboradorMinisterio(Integer codColaboradorMinisterio) {
        this.codColaboradorMinisterio = codColaboradorMinisterio;
    }

    public Integer getCodColaboradorMinisterio() {
        return codColaboradorMinisterio;
    }

    public void setCodColaboradorMinisterio(Integer codColaboradorMinisterio) {
        this.codColaboradorMinisterio = codColaboradorMinisterio;
    }

    public Colaborador getCodColaborador() {
        return codColaborador;
    }

    public void setCodColaborador(Colaborador codColaborador) {
        this.codColaborador = codColaborador;
    }

    public Ministerio getCodMinisterio() {
        return codMinisterio;
    }

    public void setCodMinisterio(Ministerio codMinisterio) {
        this.codMinisterio = codMinisterio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codColaboradorMinisterio != null ? codColaboradorMinisterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColaboradorMinisterio)) {
            return false;
        }
        ColaboradorMinisterio other = (ColaboradorMinisterio) object;
        if ((this.codColaboradorMinisterio == null && other.codColaboradorMinisterio != null) || (this.codColaboradorMinisterio != null && !this.codColaboradorMinisterio.equals(other.codColaboradorMinisterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.soibv_modelo.ColaboradorMinisterio[ codColaboradorMinisterio=" + codColaboradorMinisterio + " ]";
    }
    
}
