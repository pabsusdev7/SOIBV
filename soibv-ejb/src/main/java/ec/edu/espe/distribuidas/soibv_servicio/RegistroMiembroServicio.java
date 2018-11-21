/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_servicio;
import ec.edu.espe.distribuidas.soibv_dao.ColaboradorFacade;
import ec.edu.espe.distribuidas.soibv_dao.ColaboradorMinisterioFacade;
import ec.edu.espe.distribuidas.soibv_dao.GrupoPoderFacade;
import ec.edu.espe.distribuidas.soibv_dao.MiembroFacade;
import ec.edu.espe.distribuidas.soibv_dao.MinisterioFacade;
import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.ColaboradorMinisterio;
import ec.edu.espe.distribuidas.soibv_modelo.GrupoPoder;
import ec.edu.espe.distribuidas.soibv_modelo.Miembro;
import ec.edu.espe.distribuidas.soibv_modelo.Ministerio;
import java.util.ArrayList;
import javax.ejb.EJB;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Pablin
 */
@Stateless
@LocalBean
public class RegistroMiembroServicio {

    @EJB
    private MiembroFacade miembroFacade;
    
     @EJB
    private GrupoPoderFacade grupoPoderFacade;
     
     @EJB
     private MinisterioFacade ministerioFacade;
     
     @EJB
     private ColaboradorFacade colaboradorFacade;
     
      @EJB
     private ColaboradorMinisterioFacade colaboradorMinisterioFacade;
    
       @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Miembro registrarMiembro(String cedulaMiembro, String nombreMiembro, Date fechanacMiembro, String telfcasaMiembro, String dircasaMiembro, String celularMiembro, String emailMiembro, String ecivilMiembro, Integer nhijosMiembro, String profesionMiembro, String ocupacionMiembro, String lugartrabajoMiembro, String dirtrabajoMiembro, String telftrabajoMiembro, boolean bautismoMiembro, String lugbautismoMiembro, boolean encuentroMiembro,GrupoPoder codGrupoPoder)
    {
        //this.miembrofacade.insertIntoMiembro(codgrupoPoder, cedulaMiembro, nombreMiembro, fechanacMiembro, telfcasaMiembro, dircasaMiembro, celularMiembro, emailMiembro, ecivilMiembro, nhijosMiembro, profesionMiembro, ocupacionMiembro, lugartrabajoMiembro, dirtrabajoMiembro, telftrabajoMiembro, bautismoMiembro, lugbautismoMiembro, encuentroMiembro);
        
        Miembro miembro=new Miembro(cedulaMiembro, nombreMiembro, fechanacMiembro, telfcasaMiembro, dircasaMiembro,  celularMiembro,  emailMiembro,ecivilMiembro, nhijosMiembro, profesionMiembro,  ocupacionMiembro,  lugartrabajoMiembro, dirtrabajoMiembro,  telftrabajoMiembro, bautismoMiembro, lugbautismoMiembro, encuentroMiembro,codGrupoPoder);
        
        miembroFacade.create(miembro);
        
        return miembro;
        
   
    }
       
        @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void registrarMiembro1(Miembro m)
    {
        //this.miembrofacade.insertIntoMiembro(codgrupoPoder, cedulaMiembro, nombreMiembro, fechanacMiembro, telfcasaMiembro, dircasaMiembro, celularMiembro, emailMiembro, ecivilMiembro, nhijosMiembro, profesionMiembro, ocupacionMiembro, lugartrabajoMiembro, dirtrabajoMiembro, telftrabajoMiembro, bautismoMiembro, lugbautismoMiembro, encuentroMiembro);
        
        miembroFacade.create(m);
   
    }
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
     public Miembro editarMiembro(String cedulaMiembro, String nombreMiembro, Date fechanacMiembro, String telfcasaMiembro, String dircasaMiembro, String celularMiembro, String emailMiembro, String ecivilMiembro, Integer nhijosMiembro, String profesionMiembro, String ocupacionMiembro, String lugartrabajoMiembro, String dirtrabajoMiembro, String telftrabajoMiembro, boolean bautismoMiembro, String lugbautismoMiembro, boolean encuentroMiembro,GrupoPoder codGrupoPoder, Miembro miembro)
    {
        //this.miembrofacade.insertIntoMiembro(codgrupoPoder, cedulaMiembro, nombreMiembro, fechanacMiembro, telfcasaMiembro, dircasaMiembro, celularMiembro, emailMiembro, ecivilMiembro, nhijosMiembro, profesionMiembro, ocupacionMiembro, lugartrabajoMiembro, dirtrabajoMiembro, telftrabajoMiembro, bautismoMiembro, lugbautismoMiembro, encuentroMiembro);
        
        //Miembro miembro1=new Miembro(cedulaMiembro, nombreMiembro, fechanacMiembro, telfcasaMiembro, dircasaMiembro,  celularMiembro,  emailMiembro,ecivilMiembro, nhijosMiembro, profesionMiembro,  ocupacionMiembro,  lugartrabajoMiembro, dirtrabajoMiembro,  telftrabajoMiembro, bautismoMiembro, lugbautismoMiembro, encuentroMiembro,codGrupoPoder);
        miembro.setBautismoMiembro(bautismoMiembro);
        miembro.setCedulaMiembro(cedulaMiembro);
        miembro.setCelularMiembro(celularMiembro);
        miembro.setCodGrupoPoder(codGrupoPoder);
        miembro.setDircasaMiembro(dircasaMiembro);
        miembro.setEcivilMiembro(ecivilMiembro);
        miembro.setEmailMiembro(emailMiembro);
        miembro.setEncuentroMiembro(encuentroMiembro);
        miembro.setFechanacMiembro(fechanacMiembro);
        miembro.setLugartrabajoMiembro(lugartrabajoMiembro);
        miembro.setLugbautismoMiembro(lugbautismoMiembro);
        miembro.setNhijosMiembro(nhijosMiembro);
        miembro.setNombreMiembro(nombreMiembro);
        miembro.setOcupacionMiembro(ocupacionMiembro);
        miembro.setProfesionMiembro(profesionMiembro);
        miembro.setTelfcasaMiembro(telfcasaMiembro);
        miembro.setTelftrabajoMiembro(telftrabajoMiembro);
        miembro.setDirtrabajoMiembro(dirtrabajoMiembro);
        
        miembroFacade.edit(miembro);
        
        return miembro;
        
   
    }
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
     public void editarMiembro1(Miembro m)
     {
         this.miembroFacade.edit(m);
     }
      @TransactionAttribute(TransactionAttributeType.REQUIRED)
     public void elimMiembro(Miembro m)
     {
         if(this.countByCodMiembro(m.getCodMiembro())!=0){
         this.eliminarColMins(this.obtenerPorCol(this.colaboradorFacade.findByMiembro(m)));
         this.colaboradorFacade.remove(this.findByMiembro(m));}
         this.miembroFacade.remove(m);
     }
    
    public Colaborador findByMiembro(Miembro m)
    {
        Colaborador c=this.colaboradorFacade.findByMiembro(m);
        return c;
    }
     
    public Colaborador registroColaborador(Miembro miembro)
    {
        Colaborador col=new Colaborador(miembro);
        this.colaboradorFacade.create(col);
        return col;
        
    }
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public ColaboradorMinisterio registroColMin(Ministerio m, Colaborador c)
    {
        ColaboradorMinisterio cm=new ColaboradorMinisterio(c,m);
        this.colaboradorMinisterioFacade.create(cm);
        return cm;
        
    }
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public ColaboradorMinisterio editarColMin(Ministerio m, Colaborador c, ColaboradorMinisterio cm)
    {
        ColaboradorMinisterio cm1=new ColaboradorMinisterio(c,m);
        cm=cm1;
        this.colaboradorMinisterioFacade.edit(cm);
        return cm;
        
    }
     
     public void eliminarColMins(List<ColaboradorMinisterio> lcolmin)
     {
         for(int i=0;i<lcolmin.size();i++)
             this.colaboradorMinisterioFacade.remove(lcolmin.get(i));
         
     }
     
     public void eliminarCol(Colaborador c)
     {
         this.colaboradorFacade.remove(c);
     }
    
    public Miembro findByCedula(String cedula)
    {
        Miembro m=this.miembroFacade.findByCedula(cedula);
        return m;
    }
    
    public List<ColaboradorMinisterio> obtenerPorCol(Colaborador c)
    {
        List<ColaboradorMinisterio> cm=this.colaboradorMinisterioFacade.findByColaborador(c);
        return cm;
    }
    
    
    
    public Ministerio obtenerPorCodigo(Integer colmin)
    {
        Ministerio m=this.ministerioFacade.find(colmin);
        return m;
    }
    
    public GrupoPoder findGrupoPoderPorCodigo(Integer codGrupoPoder)
    {
        GrupoPoder gp=this.grupoPoderFacade.find(codGrupoPoder);
        return gp;
    }
    
    public List<Ministerio> obtenerMinisterios()
    {
        List<Ministerio> min=new ArrayList<Ministerio>();
        
        min=this.ministerioFacade.findAll();
        return min;
    }
    public List<String> findAllLideresGrupo()
    {
        return this.miembroFacade.findAllLiderGrupoo();
    }
   
     public List<Integer> findAllCodGrupo()
    {
        return this.miembroFacade.findAllCodGrupoo();
    }
    
     public List<GrupoPoder> findAllGP()
     {
         return this.grupoPoderFacade.findAll();
     }
     
     public Integer countByCodMiembro(Integer codMiembro)
     {
         return this.colaboradorFacade.countByCodMiembro(codMiembro);
     }    
     
     public List<Miembro> findAllMiembros()
     {
         return this.miembroFacade.findAll();
     }
    
}
