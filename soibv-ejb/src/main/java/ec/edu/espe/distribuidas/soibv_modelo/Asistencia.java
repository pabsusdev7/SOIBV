/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pablin
 */
@Entity
@Table(name = "asistencia")

public class Asistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ASISTENCIA", nullable = false)
    private Integer codAsistencia;
    
    @Column(name = "FECHA_ASISTENCIA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsistencia;
    
    @Column(name = "TIPO_EVENTO", nullable = false, length = 35)
    private String tipoEvento;
    
    @Column(name = "NUM_ADULTOS", nullable = false)
    private Integer numAdultos;
    
    @Column(name = "NUM_NINOS", nullable = false)
    private Integer numNinos;
    
    @Column(name = "NUM_JOVENES", nullable = false)
    private Integer numJovenes;
    @Column(name = "NUM_NUEVOS")
    private Integer numNuevos;

    public Asistencia() {
    }

    public Asistencia(Integer codAsistencia) {
        this.codAsistencia = codAsistencia;
    }

    public Asistencia(Integer codAsistencia, Date fechaAsistencia, String tipoEvento, int numAdultos, int numNinos, int numJovenes, int numNuevos) {
        this.codAsistencia = codAsistencia;
        this.fechaAsistencia = fechaAsistencia;
        this.tipoEvento = tipoEvento;
        this.numAdultos = numAdultos;
        this.numNinos = numNinos;
        this.numJovenes = numJovenes;
        this.numNuevos=numNuevos;
    }

    public Integer getCodAsistencia() {
        return codAsistencia;
    }

    public void setCodAsistencia(Integer codAsistencia) {
        this.codAsistencia = codAsistencia;
    }

    public Date getFechaAsistencia() {
        return fechaAsistencia;
    }
    
     public String getFechaAsistenciatxt() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(this.fechaAsistencia);
    }

    public void setFechaAsistencia(Date fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Integer getNumAdultos() {
        return numAdultos;
    }

    public void setNumAdultos(Integer numAdultos) {
        this.numAdultos = numAdultos;
    }

    public Integer getNumNinos() {
        return numNinos;
    }

    public void setNumNinos(Integer numNinos) {
        this.numNinos = numNinos;
    }

    public Integer getNumJovenes() {
        return numJovenes;
    }

    public void setNumJovenes(Integer numJovenes) {
        this.numJovenes = numJovenes;
    }

    public Integer getTotalAsistencia() {
        return numNuevos;
    }

    public void setTotalAsistencia(Integer totalAsistencia) {
        this.numNuevos = totalAsistencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAsistencia != null ? codAsistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.codAsistencia == null && other.codAsistencia != null) || (this.codAsistencia != null && !this.codAsistencia.equals(other.codAsistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.soibv_modelo.Asistencia[ codAsistencia=" + codAsistencia + " ]";
    }
    
}
