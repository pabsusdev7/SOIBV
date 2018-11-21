/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_servicio;

import ec.edu.espe.distribuidas.soibv_dao.AsistenciaFacade;
import ec.edu.espe.distribuidas.soibv_dao.ColaboradorFacade;
import ec.edu.espe.distribuidas.soibv_dao.ColaboradorMinisterioFacade;
import ec.edu.espe.distribuidas.soibv_dao.GrupoPoderFacade;
import ec.edu.espe.distribuidas.soibv_dao.MiembroFacade;
import ec.edu.espe.distribuidas.soibv_dao.MinisterioFacade;
import ec.edu.espe.distribuidas.soibv_modelo.Asistencia;
import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.ColaboradorMinisterio;
import ec.edu.espe.distribuidas.soibv_modelo.GrupoPoder;
import ec.edu.espe.distribuidas.soibv_modelo.Miembro;
import ec.edu.espe.distribuidas.soibv_modelo.Ministerio;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
public class RegMiembroServicio {

    
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
      
       @EJB
     private AsistenciaFacade asistenciaFacade;
      
          @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void registrarMiembro1(Miembro m)
    {
        //this.miembrofacade.insertIntoMiembro(codgrupoPoder, cedulaMiembro, nombreMiembro, fechanacMiembro, telfcasaMiembro, dircasaMiembro, celularMiembro, emailMiembro, ecivilMiembro, nhijosMiembro, profesionMiembro, ocupacionMiembro, lugartrabajoMiembro, dirtrabajoMiembro, telftrabajoMiembro, bautismoMiembro, lugbautismoMiembro, encuentroMiembro);
        
        miembroFacade.create(m);
   
    }
          
    
           @TransactionAttribute(TransactionAttributeType.REQUIRED)
     public void editarMiembro1(Miembro m)
     {
         this.miembroFacade.edit(m);
     }
      @TransactionAttribute(TransactionAttributeType.REQUIRED)
     public void elimMiembro(Miembro m)
     {
         if(this.countColsByCodMiembro(m.getCodMiembro())!=0){
             if(this.countColMinsByCodMiembro(m.getCodMiembro())!=0)
                this.eliminarColMins(this.obtenerPorCol(this.colaboradorFacade.findByMiembro(m)));
             if(this.grupoPoderFacade.findByColaborador(this.findByMiembro(m))!=null)
                 for(int i=0;i<this.miembroFacade.findByGrupoPoder(this.grupoPoderFacade.findByColaborador(this.findByMiembro(m))).size();i++)
                 {
                     this.miembroFacade.findByGrupoPoder(this.grupoPoderFacade.findByColaborador(this.findByMiembro(m))).get(i).setCodGrupoPoder(null);
                     
                 }
                 this.grupoPoderFacade.remove(this.grupoPoderFacade.findByColaborador(this.findByMiembro(m)));
             
             
         this.colaboradorFacade.remove(this.findByMiembro(m));}
         this.miembroFacade.remove(m);
     }
      
       public Colaborador findByMiembro(Miembro m)
    {
        Colaborador c=this.colaboradorFacade.findByMiembro(m);
        return c;
    }
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Colaborador registroColaborador(Miembro miembro)
    {
        Colaborador col=new Colaborador(miembro);
        this.colaboradorFacade.create(col);
        return col;
        
    }
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public ColaboradorMinisterio registroColMin(Ministerio m, Miembro mi)
    {
        Colaborador c=new Colaborador();
        if(this.countColsByCodMiembro(mi.getCodMiembro())==0)
        c=this.registroColaborador(mi);
        else
          c=this.findByMiembro(mi);  
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
     
       @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void editColMin(Miembro mi, List<Integer> lcodmin)
    {
        Colaborador c=new Colaborador();
        ColaboradorMinisterio cm=new ColaboradorMinisterio();
        Integer n=0;String n1="";
        if(this.countColsByCodMiembro(mi.getCodMiembro())==0){
            
            c=this.registroColaborador(mi);
            //return this.registroColMin(m, mi);
        }
        else
       
            c=this.findByMiembro(mi);
        
        
            if(this.countColMinsByCodMiembro(mi.getCodMiembro())>0){
                this.eliminarColMins(this.obtenerPorCol(c));
            }
            
            for(int i=0;i<lcodmin.size();i++){
                n1=""+lcodmin.get(i);
                n=Integer.parseInt(n1);
                cm=new ColaboradorMinisterio(c, this.ministerioFacade.find(n));
                this.colaboradorMinisterioFacade.create(cm);
                
            
            }
                
        
        
        
        
        
    }
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
     public void eliminarColMins(List<ColaboradorMinisterio> lcolmin)
     {
         for(int i=0;i<lcolmin.size();i++)
             this.colaboradorMinisterioFacade.remove(lcolmin.get(i));
         
     }
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
     public void eliminarCol(Colaborador c)
     {
         this.colaboradorFacade.remove(c);
     }
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
     public void elimColMin(Miembro m)
     {
         if(this.countColMinsByCodMiembro(m.getCodMiembro())>0)
         {
             this.eliminarColMins(this.obtenerPorCol(this.findByMiembro(m)));
             if(this.grupoPoderFacade.countByCodCol(this.findByMiembro(m).getCodColaborador())==0)
             this.eliminarCol(this.findByMiembro(m));
         }
     }
     
      public Integer countColsByCodMiembro(Integer codMiembro)
     {
         return this.colaboradorFacade.countByCodMiembro(codMiembro);
     }  
      
       public Integer countColMinsByCodMiembro(Integer codMiembro)
     {
         if(this.countColsByCodMiembro(codMiembro)>0)
         return this.colaboradorMinisterioFacade.countByCodCol(this.findByMiembro(this.miembroFacade.find(codMiembro)).getCodColaborador());
         else
             return 0;
     } 
     
     public List<Miembro> findAllMiembros()
     {
         return this.miembroFacade.findAll();
     }
     
     public List<Miembro> findAllJovenes()
     {
         List<Integer> aux1=new ArrayList<Integer>();
         aux1= this.miembroFacade.findJovenes();
         List <Miembro> aux= new ArrayList<Miembro>();
         for(int i=0;i<aux1.size();i++)
             aux.add(this.miembroFacade.find(aux1.get(i)));
         
         
         return aux;
     }
     
     
      public List<ColaboradorMinisterio> obtenerPorCol(Colaborador c)
    {
        List<ColaboradorMinisterio> cm=this.colaboradorMinisterioFacade.findByColaborador(c);
        return cm;  
    }
       public GrupoPoder findGrupoPoderPorCodigo(Integer codGrupoPoder)
    {
        GrupoPoder gp=this.grupoPoderFacade.find(codGrupoPoder);
        return gp;
    }
      
      public List<Ministerio> obtenerAllMin()
      {
          return this.ministerioFacade.findAll();
      }
      
      public List<GrupoPoder> obtenerAllGDP()
      {
          return this.grupoPoderFacade.findAll();
      }
      
      public Ministerio obtenerPorCodigo(Integer colmin)
    {
        Ministerio m=this.ministerioFacade.find(colmin);
        return m;
    }
      
      public List<Asistencia> obtenerAllAsistencias()
      {
          return this.asistenciaFacade.findAll();
      }
      @TransactionAttribute(TransactionAttributeType.REQUIRED)
      public void regAs(Asistencia a)
      {
          this.asistenciaFacade.create(a);
      }
      @TransactionAttribute(TransactionAttributeType.REQUIRED)
      public void ediAs(Asistencia a)
      {
          this.asistenciaFacade.edit(a);
      }
      @TransactionAttribute(TransactionAttributeType.REQUIRED)
      public void elimAs(Asistencia a)
      {
          this.asistenciaFacade.remove(a);
      }
      
      
    
    
}
