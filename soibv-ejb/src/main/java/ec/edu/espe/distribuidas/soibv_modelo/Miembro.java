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
@Table(name = "miembro")
public class Miembro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_MIEMBRO", nullable = false)
    private Integer codMiembro;
    @Column(name = "CEDULA_MIEMBRO", length = 10)
    private String cedulaMiembro;
    @Column(name = "NOMBRE_MIEMBRO", nullable = false, length = 70)
    private String nombreMiembro;
    @Column(name = "FECHANAC_MIEMBRO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechanacMiembro;
    @Column(name = "TELFCASA_MIEMBRO", length = 9)
    private String telfcasaMiembro;
    @Column(name = "DIRCASA_MIEMBRO", length = 150)
    private String dircasaMiembro;
    @Column(name = "CELULAR_MIEMBRO", length = 10)
    private String celularMiembro;
    @Column(name = "EMAIL_MIEMBRO", length = 50)
    private String emailMiembro;
    @Column(name = "ECIVIL_MIEMBRO", nullable = false, length = 10)
    private String ecivilMiembro;
    @Column(name = "NHIJOS_MIEMBRO")
    private Integer nhijosMiembro;
    @Column(name = "PROFESION_MIEMBRO", length = 50)
    private String profesionMiembro;
    @Column(name = "OCUPACION_MIEMBRO", length = 70)
    private String ocupacionMiembro;
    @Column(name = "LUGARTRABAJO_MIEMBRO", length = 40)
    private String lugartrabajoMiembro;
    @Column(name = "DIRTRABAJO_MIEMBRO", length = 150)
    private String dirtrabajoMiembro;
    @Column(name = "TELFTRABAJO_MIEMBRO", length = 30)
    private String telftrabajoMiembro;
    @Column(name = "BAUTISMO_MIEMBRO", nullable = false)
    private boolean bautismoMiembro;
    @Column(name = "LUGBAUTISMO_MIEMBRO", length = 50)
    private String lugbautismoMiembro;
    @Column(name = "ENCUENTRO_MIEMBRO", nullable = false)
    private boolean encuentroMiembro;
    @Column(name = "PATH_FOTO", length = 70)
    private String pathFoto;
    @Column(name = "FECHA_CENSO")
    @Temporal(TemporalType.DATE)
    private Date fechaCenso;
    @Column(name = "EDAD_JOV")
    private Integer edadJov;
    @Column(name = "EDUC_JOV", length = 20)
    private String educJov;
    @Column(name = "MIN_JOV", length = 20)
    private String minJov;
    @Column(name = "PAS_JOV", length = 50)
    private String pasJov;
    @Column(name = "SEC_JOV", length = 70)
    private String secJov;
    @Column(name = "FB_JOV", length = 100)
    private String fbJov;
    @Column(name = "GENERO_JOV", length = 10)
    private String generoJov;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMiembro")
    private List<Colaborador> colaboradorList;
    @JoinColumn(name = "COD_GRUPO_PODER", referencedColumnName = "COD_GRUPO_PODER")
    @ManyToOne
    private GrupoPoder codGrupoPoder;

    public Miembro() {
    }

     public Miembro(String cedulaMiembro, String nombreMiembro, Date fechanacMiembro, String telfcasaMiembro, String dircasaMiembro, String celularMiembro, String emailMiembro, String ecivilMiembro, Integer nhijosMiembro, String profesionMiembro, String ocupacionMiembro, String lugartrabajoMiembro, String dirtrabajoMiembro, String telftrabajoMiembro, boolean bautismoMiembro, String lugbautismoMiembro, boolean encuentroMiembro, GrupoPoder codGrupoPoder) {
        this.cedulaMiembro = cedulaMiembro;
        this.nombreMiembro = nombreMiembro;
        this.fechanacMiembro = fechanacMiembro;
        this.telfcasaMiembro = telfcasaMiembro;
        this.dircasaMiembro = dircasaMiembro;
        this.celularMiembro = celularMiembro;
        this.emailMiembro = emailMiembro;
        this.ecivilMiembro = ecivilMiembro;
        this.nhijosMiembro = nhijosMiembro;
        this.profesionMiembro = profesionMiembro;
        this.ocupacionMiembro = ocupacionMiembro;
        this.lugartrabajoMiembro = lugartrabajoMiembro;
        this.dirtrabajoMiembro = dirtrabajoMiembro;
        this.telftrabajoMiembro = telftrabajoMiembro;
        this.bautismoMiembro = bautismoMiembro;
        this.lugbautismoMiembro = lugbautismoMiembro;
        this.encuentroMiembro = encuentroMiembro;
        this.codGrupoPoder = codGrupoPoder;
    }
    
    public Miembro(Integer codMiembro) {
        this.codMiembro = codMiembro;
    }

    public Miembro(Integer codMiembro, String nombreMiembro, Date fechanacMiembro, String ecivilMiembro, boolean bautismoMiembro, boolean encuentroMiembro) {
        this.codMiembro = codMiembro;
        this.nombreMiembro = nombreMiembro;
        this.fechanacMiembro = fechanacMiembro;
        this.ecivilMiembro = ecivilMiembro;
        this.bautismoMiembro = bautismoMiembro;
        this.encuentroMiembro = encuentroMiembro;
    }

    public Integer getCodMiembro() {
        return codMiembro;
    }

    public void setCodMiembro(Integer codMiembro) {
        this.codMiembro = codMiembro;
    }
    
    public Integer getEdadjov() {
        return edadJov;
    }

    public void setEdadjov(Integer edadjov) {
        this.edadJov = edadjov;
    }

    public String getCedulaMiembro() {
        return cedulaMiembro;
    }

    public void setCedulaMiembro(String cedulaMiembro) {
        this.cedulaMiembro = cedulaMiembro;
    }
    
    public String getEducJov() {
        return educJov;
    }

    public void setEducJov(String educjov) {
        this.educJov = educjov;
    }
    
    public String getMinJov() {
        return minJov;
    }

    public void setMinJov(String minjov) {
        this.minJov = minjov;
    }
    
    public String getPasJov() {
        return pasJov;
    }

    public void setPasJov(String pasjov) {
        this.pasJov = pasjov;
    }
    
    public String getSecJov() {
        return secJov;
    }

    public void setSecJov(String secjov) {
        this.secJov = secjov;
    }
    
    public String getFbJov() {
        return fbJov;
    }

    public void setFbJov(String fbjov) {
        this.fbJov = fbjov;
    }
    
    public String getGeneroJov() {
        return generoJov;
    }

    public void setGeneroJov(String genero) {
        this.generoJov = genero;
    }


    public String getNombreMiembro() {
        return nombreMiembro;
    }

    public void setNombreMiembro(String nombreMiembro) {
        this.nombreMiembro = nombreMiembro;
    }

    public Date getFechanacMiembro() {
        return fechanacMiembro;
    }
    
    
     public String getFechanacMiembrotxt() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(this.fechanacMiembro);
    }
    

    public void setFechanacMiembro(Date fechanacMiembro) {
        this.fechanacMiembro = fechanacMiembro;
    }

    public String getTelfcasaMiembro() {
        return telfcasaMiembro;
    }

    public void setTelfcasaMiembro(String telfcasaMiembro) {
        this.telfcasaMiembro = telfcasaMiembro;
    }

    public String getDircasaMiembro() {
        return dircasaMiembro;
    }

    public void setDircasaMiembro(String dircasaMiembro) {
        this.dircasaMiembro = dircasaMiembro;
    }

    public String getCelularMiembro() {
        return celularMiembro;
    }

    public void setCelularMiembro(String celularMiembro) {
        this.celularMiembro = celularMiembro;
    }

    public String getEmailMiembro() {
        return emailMiembro;
    }

    public void setEmailMiembro(String emailMiembro) {
        this.emailMiembro = emailMiembro;
    }

    public String getEcivilMiembro() {
        return ecivilMiembro;
    }

    public void setEcivilMiembro(String ecivilMiembro) {
        this.ecivilMiembro = ecivilMiembro;
    }

    public Integer getNhijosMiembro() {
        return nhijosMiembro;
    }

    public void setNhijosMiembro(Integer nhijosMiembro) {
        this.nhijosMiembro = nhijosMiembro;
    }

    public String getProfesionMiembro() {
        return profesionMiembro;
    }

    public void setProfesionMiembro(String profesionMiembro) {
        this.profesionMiembro = profesionMiembro;
    }

    public String getOcupacionMiembro() {
        return ocupacionMiembro;
    }

    public void setOcupacionMiembro(String ocupacionMiembro) {
        this.ocupacionMiembro = ocupacionMiembro;
    }

    public String getLugartrabajoMiembro() {
        return lugartrabajoMiembro;
    }

    public void setLugartrabajoMiembro(String lugartrabajoMiembro) {
        this.lugartrabajoMiembro = lugartrabajoMiembro;
    }

    public String getDirtrabajoMiembro() {
        return dirtrabajoMiembro;
    }

    public void setDirtrabajoMiembro(String dirtrabajoMiembro) {
        this.dirtrabajoMiembro = dirtrabajoMiembro;
    }

    public String getTelftrabajoMiembro() {
        return telftrabajoMiembro;
    }

    public void setTelftrabajoMiembro(String telftrabajoMiembro) {
        this.telftrabajoMiembro = telftrabajoMiembro;
    }

    public boolean getBautismoMiembro() {
        return bautismoMiembro;
    }

    public void setBautismoMiembro(boolean bautismoMiembro) {
        this.bautismoMiembro = bautismoMiembro;
    }

    public String getLugbautismoMiembro() {
        return lugbautismoMiembro;
    }

    public void setLugbautismoMiembro(String lugbautismoMiembro) {
        this.lugbautismoMiembro = lugbautismoMiembro;
    }

    public boolean getEncuentroMiembro() {
        return encuentroMiembro;
    }

    public void setEncuentroMiembro(boolean encuentroMiembro) {
        this.encuentroMiembro = encuentroMiembro;
    }

    public String getPathFoto() {
        return pathFoto;
    }

    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
    }
    
    public Date getFechaCenso() {
        return fechaCenso;
    }
    
    
     public String getFechaCensotxt() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(this.fechaCenso);
    }
     
     public void setFechaCenso(Date fechaCenso) {
        this.fechaCenso = fechaCenso;
    }
    public List<Colaborador> getColaboradorList() {
        return colaboradorList;
    }

    public void setColaboradorList(List<Colaborador> colaboradorList) {
        this.colaboradorList = colaboradorList;
    }

    public GrupoPoder getCodGrupoPoder() {
        return codGrupoPoder;
    }

    public void setCodGrupoPoder(GrupoPoder codGrupoPoder) {
        this.codGrupoPoder = codGrupoPoder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMiembro != null ? codMiembro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Miembro)) {
            return false;
        }
        Miembro other = (Miembro) object;
        if ((this.codMiembro == null && other.codMiembro != null) || (this.codMiembro != null && !this.codMiembro.equals(other.codMiembro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.soibv_modelo.Miembro[ codMiembro=" + codMiembro + " ]";
    }
    
}
