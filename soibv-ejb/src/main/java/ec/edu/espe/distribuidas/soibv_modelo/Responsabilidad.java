/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pablin
 */
@Entity
@Table(name = "responsabilidad")
public class Responsabilidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_RESPONSABILIDAD", nullable = false)
    private Integer codResponsabilidad;
    @Column(name = "DESCRIPCION_RESPONSABILIDAD", nullable = false, length = 40)
    private String descripcionResponsabilidad;
    @Column(name = "FECHA_RESPONSABILIDAD", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaResponsabilidad;
    @Column(name = "DETALLE_RESPONSABILIDAD", length = 150)
    private String detalleResponsabilidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codResponsabilidad")
    private List<ResponsabilidadColaborador> responsabilidadColaboradorList;

    public Responsabilidad() {
    }

    public Responsabilidad(String descripcionResponsabilidad, Date fechaResponsabilidad, String detalleResponsabilidad) {
        this.descripcionResponsabilidad = descripcionResponsabilidad;
        this.fechaResponsabilidad = fechaResponsabilidad;
        this.detalleResponsabilidad = detalleResponsabilidad;
    }

    public Responsabilidad(Integer codResponsabilidad) {
        this.codResponsabilidad = codResponsabilidad;
    }

    public Responsabilidad(Integer codResponsabilidad, String descripcionResponsabilidad, Date fechaResponsabilidad) {
        this.codResponsabilidad = codResponsabilidad;
        this.descripcionResponsabilidad = descripcionResponsabilidad;
        this.fechaResponsabilidad = fechaResponsabilidad;
        
    }

    public Integer getCodResponsabilidad() {
        return codResponsabilidad;
    }

    public void setCodResponsabilidad(Integer codResponsabilidad) {
        this.codResponsabilidad = codResponsabilidad;
    }

    public String getDescripcionResponsabilidad() {
        return descripcionResponsabilidad;
    }

    public void setDescripcionResponsabilidad(String descripcionResponsabilidad) {
        this.descripcionResponsabilidad = descripcionResponsabilidad;
    }

    public Date getFechaResponsabilidad() {
        return fechaResponsabilidad;
    }
    
    public String getFechaResponsabilidadtxt() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        return sdf.format(this.fechaResponsabilidad);
    }
    
    

    public void setFechaResponsabilidad(Date fechaResponsabilidad) {
        this.fechaResponsabilidad = fechaResponsabilidad;
    }

    public String getDetalleResponsabilidad() {
        return detalleResponsabilidad;
    }

    public void setDetalleResponsabilidad(String detalleResponsabilidad) {
        this.detalleResponsabilidad = detalleResponsabilidad;
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
        hash += (codResponsabilidad != null ? codResponsabilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsabilidad)) {
            return false;
        }
        Responsabilidad other = (Responsabilidad) object;
        if ((this.codResponsabilidad == null && other.codResponsabilidad != null) || (this.codResponsabilidad != null && !this.codResponsabilidad.equals(other.codResponsabilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.soibv_modelo.Responsabilidad[ codResponsabilidad=" + codResponsabilidad + " ]";
    }
    
}
