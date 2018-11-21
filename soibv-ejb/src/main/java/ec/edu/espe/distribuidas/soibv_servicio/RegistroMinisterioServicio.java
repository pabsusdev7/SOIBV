/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_servicio;

import ec.edu.espe.distribuidas.soibv_dao.ColaboradorFacade;
import ec.edu.espe.distribuidas.soibv_dao.ColaboradorMinisterioFacade;
import ec.edu.espe.distribuidas.soibv_dao.MinisterioFacade;
import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.ColaboradorMinisterio;
import ec.edu.espe.distribuidas.soibv_modelo.Miembro;
import ec.edu.espe.distribuidas.soibv_modelo.Ministerio;
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
public class RegistroMinisterioServicio {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    private MinisterioFacade ministerioFacade;
    @EJB
    private ColaboradorFacade colaboradorFacade;
    @EJB
    private ColaboradorMinisterioFacade colaboradorMinisterioFacade;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Ministerio registrarMin(String cedulalid, String nombre)
    {
            Colaborador col=this.colaboradorFacade.find(this.colaboradorFacade.findByMiembroCedula1(cedulalid));
            Ministerio m=new Ministerio(nombre,col);
            this.ministerioFacade.create(m);
            return m;
        
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Ministerio editarMin(String cedulalid, String nombre,Ministerio m1)
    {
            Colaborador col=this.colaboradorFacade.find(this.colaboradorFacade.findByMiembroCedula1(cedulalid));
            m1.setCodLider(col);
            m1.setNombreMinisterio(nombre);
            this.ministerioFacade.edit(m1);
            return m1;
        
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Ministerio m)
    {
            
            this.ministerioFacade.create(m);
            
        
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void editar(Ministerio m)
    {
           
            this.ministerioFacade.edit(m);
            
        
    }
    
    
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminarMin(Ministerio m)
    {
        for(int i=0;i<this.obtenerPorMin(m).size();i++)
            this.colaboradorMinisterioFacade.remove(this.obtenerPorMin(m).get(i));
        
        this.ministerioFacade.remove(m);
    }
    
    public List<Ministerio> findAllMin()
    {
        return this.ministerioFacade.findAll();
    }
    
    public Ministerio findPorCod(Integer cod)
    {
        Ministerio m=this.ministerioFacade.find(cod);
        return m;
    }
     public List<ColaboradorMinisterio> obtenerPorMin(Ministerio m)
    {
        List<ColaboradorMinisterio> cm=this.colaboradorMinisterioFacade.findByMinisterio(m);
        return cm;
    }
     
      public List<Colaborador> obtenerAll() {
        return this.colaboradorFacade.findAll();
    }
      
        public Colaborador findByCod(Integer cod)
    {
        Colaborador c=this.colaboradorFacade.find(cod);
        return c;
    }
    
}
