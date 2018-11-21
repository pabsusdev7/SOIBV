/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pablin
 */
@Entity
@Table(name = "grupo_poder")
public class GrupoPoder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_GRUPO_PODER", nullable = false)
    private Integer codGrupoPoder;
    @Column(name = "DIRECCION_GRUPO_PODER", length = 150)
    private String direccionGrupoPoder;
    @Column(name = "DIAREUNION", length = 10)
    private String diareunion;
    @Column(name = "HORAREUNION")
    @Temporal(TemporalType.TIME)
    private Date horareunion;
    @JoinColumn(name = "COD_LIDER", referencedColumnName = "COD_COLABORADOR", nullable = false)
    @ManyToOne(optional = false)
    private Colaborador codLider;
    @OneToMany(mappedBy = "codGrupoPoder")
    private List<Miembro> miembroList;

    public GrupoPoder() {
    }

    public GrupoPoder(String direccionGrupoPoder, String diareunion, Date horareunion, Colaborador codLider) {
        this.direccionGrupoPoder = direccionGrupoPoder;
        this.diareunion = diareunion;
        this.horareunion = horareunion;
        this.codLider = codLider;
    }

    public GrupoPoder(Integer codGrupoPoder) {
        this.codGrupoPoder = codGrupoPoder;
    }

    public Integer getCodGrupoPoder() {
        return codGrupoPoder;
    }

    public void setCodGrupoPoder(Integer codGrupoPoder) {
        this.codGrupoPoder = codGrupoPoder;
    }

    public String getDireccionGrupoPoder() {
        return direccionGrupoPoder;
    }

    public void setDireccionGrupoPoder(String direccionGrupoPoder) {
        this.direccionGrupoPoder = direccionGrupoPoder;
    }

    public String getDiareunion() {
        return diareunion;
    }
    
    public String getDiareunionS()
    {
        if(diareunion=="1")
            return "Lunes";
        else if(diareunion=="2")
            return "Martes";
        else if(diareunion=="3")
            return "Miércoles";
        else if(diareunion=="4")
            return "Jueves";
        else if(diareunion=="5")
            return "Viernes";
        else if(diareunion=="6")
            return "Sábado";
        else 
            return "Domingo";
    }

    public void setDiareunion(String diareunion) {
        this.diareunion = diareunion;
    }

    public Date getHorareunion() {
        return horareunion;
    }
    
    public String getHorareuniontxt() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(this.horareunion);
    }

    public void setHorareunion(Date horareunion) {
        this.horareunion = horareunion;
    }

    public Colaborador getCodLider() {
        return codLider;
    }

    public void setCodLider(Colaborador codLider) {
        this.codLider = codLider;
    }

    public List<Miembro> getMiembroList() {
        return miembroList;
    }

    public void setMiembroList(List<Miembro> miembroList) {
        this.miembroList = miembroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codGrupoPoder != null ? codGrupoPoder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoPoder)) {
            return false;
        }
        GrupoPoder other = (GrupoPoder) object;
        if ((this.codGrupoPoder == null && other.codGrupoPoder != null) || (this.codGrupoPoder != null && !this.codGrupoPoder.equals(other.codGrupoPoder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.soibv_modelo.GrupoPoder[ codGrupoPoder=" + codGrupoPoder + " ]";
    }
    
}
