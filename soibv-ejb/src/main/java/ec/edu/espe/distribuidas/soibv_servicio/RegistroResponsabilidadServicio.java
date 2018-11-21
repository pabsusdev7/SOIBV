/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_servicio;

import ec.edu.espe.distribuidas.soibv_dao.ColaboradorFacade;
import ec.edu.espe.distribuidas.soibv_dao.ColaboradorMinisterioFacade;
import ec.edu.espe.distribuidas.soibv_dao.GrupoTrabajoFacade;
import ec.edu.espe.distribuidas.soibv_dao.MiembroFacade;
import ec.edu.espe.distribuidas.soibv_dao.MinisterioFacade;
import ec.edu.espe.distribuidas.soibv_dao.ResponsabilidadColaboradorFacade;
import ec.edu.espe.distribuidas.soibv_dao.ResponsabilidadFacade;
import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.GrupoTrabajo;
import ec.edu.espe.distribuidas.soibv_modelo.Ministerio;
import ec.edu.espe.distribuidas.soibv_modelo.Responsabilidad;
import ec.edu.espe.distribuidas.soibv_modelo.ResponsabilidadColaborador;
import ec.edu.espe.distribuidas.soibv_modelo.Usuario;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Pablin
 */
@Stateless
@LocalBean
public class RegistroResponsabilidadServicio {

    @EJB
    private ResponsabilidadColaboradorFacade responsabilidadColaboradorFacade;
    @EJB
    private ResponsabilidadFacade responsabilidadFacade;
    @EJB
    private ColaboradorFacade colaboradorFacade;
    @EJB
    private MiembroFacade miembroFacade;
    @EJB
    private MinisterioFacade ministerioFacade;
    @EJB
    private GrupoTrabajoFacade grupoTrabajoFacade;
     @EJB
    private ColaboradorMinisterioFacade colaboradorMinisterioFacade;
     
 
             
    
   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public ResponsabilidadColaborador registroResponsabilidadColaborador(Usuario codUsuario, Colaborador codColaborador, Responsabilidad codResponsabilidad)
   {
   
      
       ResponsabilidadColaborador respcol=new ResponsabilidadColaborador(codResponsabilidad,codColaborador,codUsuario);
       this.responsabilidadColaboradorFacade.create(respcol);
       return respcol;
   
   }
   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public Responsabilidad registroResponsabilidad(String descripcionResponsabilidad, Date fechaResponsabilidad, String detalleResponsabilidad)
   {
       Responsabilidad resp=new Responsabilidad(descripcionResponsabilidad,fechaResponsabilidad,detalleResponsabilidad);
       this.responsabilidadFacade.create(resp);
       return resp;
       
   }
   
   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public void crearRC(ResponsabilidadColaborador respcol)
   {
   
      
       
       this.responsabilidadColaboradorFacade.create(respcol);
      
   
   }
   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public void crearR(Responsabilidad resp)
   {
       
       this.responsabilidadFacade.create(resp);
       
       
   }
   
   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public void editarRC(ResponsabilidadColaborador respcol)
   {
   
      
       
       this.responsabilidadColaboradorFacade.edit(respcol);
      
   
   }
   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public void editarR(Responsabilidad resp)
   {
       
       this.responsabilidadFacade.edit(resp);
       
       
   }

   
   @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public Responsabilidad edicionResponsabilidad(String descripcionResponsabilidad, Date fechaResponsabilidad, String detalleResponsabilidad,Responsabilidad resp)
   {
       
       resp.setDescripcionResponsabilidad(descripcionResponsabilidad);
       resp.setDetalleResponsabilidad(detalleResponsabilidad);
       resp.setFechaResponsabilidad(fechaResponsabilidad);
       this.responsabilidadFacade.edit(resp);
       return resp;
       
   }
  
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public ResponsabilidadColaborador edicionResponsabilidadColaborador(Usuario codUsuario, Colaborador codColaborador, Responsabilidad codResponsabilidad, ResponsabilidadColaborador respcol)
   {
   
       respcol.setCodColaborador(codColaborador);
       respcol.setCodUsuario(codUsuario);
       respcol.setCodResponsabilidad(codResponsabilidad);
       this.responsabilidadColaboradorFacade.edit(respcol);
       return respcol;
   
   }
    
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
   public void eliminarResponsabilidadColaborador( Responsabilidad resp)
   {
       List<ResponsabilidadColaborador> lrc=this.findbyResp(resp.getCodResponsabilidad());
       for(int i=0;i<lrc.size();i++)
            this.responsabilidadColaboradorFacade.remove(lrc.get(i));
       
       this.responsabilidadFacade.remove(resp);
      
   
   }
   
   public Colaborador obtenerColPorCedula(String cedulaMiembro)
   {
       Integer codcol=this.colaboradorFacade.findByMiembroCedula1(cedulaMiembro);
       return this.colaboradorFacade.find(codcol);
   
   }
   
   public List<ResponsabilidadColaborador> obtenerLRCPorColaborador(Integer codColaborador)
   {
       List<ResponsabilidadColaborador> respscol=this.responsabilidadColaboradorFacade.findByCodColaborador(codColaborador);
       
       return respscol;
       
   }
   
   public Responsabilidad obtenerRPorCodigo(Integer codResponsabilidad)
   {
       Responsabilidad resp=this.responsabilidadFacade.find(codResponsabilidad);
       return resp;
   }
   
//   public Miembro obtenerMPorUsuario(Integer codUsuario)
//   {
//       Miembro m=this.miembroFacade.findByCodUsuario(codUsuario);
//       return m;
//       
//   }
//   
//    public Miembro obtenerMPorColaborador(Integer codColaborador)
//   {
//       Miembro m=this.miembroFacade.findByCodColaborador(codColaborador);
//       return m;
//       
//   }
    
    public ResponsabilidadColaborador obtnerRPPorCodigo(Integer codRespCol)
    {
        return this.responsabilidadColaboradorFacade.find(codRespCol);
    }
    
     public List<Ministerio> findAllMin()
    {
        return this.ministerioFacade.findAll();
    }
    
    public List<GrupoTrabajo> findAllGTrabajo()
    {
        return this.grupoTrabajoFacade.findAll();
    }
    
    public List<Colaborador> findbyCodMin(Integer codmin)
    {
        return this.colaboradorFacade.colsByMinisterio(codmin);
    }
    
    public List<Responsabilidad> findAllResp()
    {
        return this.responsabilidadFacade.findAll();
    }
    
    public List<ResponsabilidadColaborador> findbyResp(Integer codr)
    {
        return this.responsabilidadColaboradorFacade.findByResp(codr);
    }
    
    public List<ResponsabilidadColaborador> findAll()
    {
        return this.responsabilidadColaboradorFacade.findAll();
    }
         
    public List<Colaborador> obtenerAll() {
        return this.colaboradorFacade.findAll();
    }
    
    public List<Colaborador> findbyResponsabilidad(Integer resp)
    {
        return this.responsabilidadFacade.findByResp(resp);
    }
    
    public Colaborador findbyCod(Integer cod)
    {
        return this.colaboradorFacade.find(cod);
    }
    
    public List<Colaborador> distribCarga(Integer min)
    {
        Integer r,m;
        Double pr=0.65,pm=0.35,res,resr,resm,aux2,aux3=100.00;
        List<Colaborador> dc=this.findbyCodMin(min);
        Integer n=dc.size();
        
        Colaborador [] aux=new Colaborador[dc.size()]; 
       Double [] aux4=new Double[dc.size()];
        Double [] aux1=new Double[dc.size()];
        
        
        for(int i=0;i<dc.size();i++){
            aux[i]=dc.get(i);
            r=this.responsabilidadColaboradorFacade.countByCodCol(dc.get(i).getCodColaborador());
            m=this.colaboradorMinisterioFacade.countByCodCol(dc.get(i).getCodColaborador());
            resr=r*pr;
            resm=m*pm;
            res=resr+resm;
            aux1[i]=res;
                       
        }
        for(int j=0;j<aux1.length;j++)
        {
            aux2=aux1[j];
            for(int k=0;k<aux1.length;k++)
                if(aux2>aux1[k] && aux2<aux3)
                    aux2=aux1[k];
            aux3=aux2;
            aux4[j]=aux3;
            
        }
        for(int h=0;h<aux4.length;h++)
            for(int g=0;g<aux4.length;g++)
                if(aux4[h]==aux1[g]){
                    dc.set(h, dc.get(g));
                    break;
                }
            
        return dc;
    }
}
