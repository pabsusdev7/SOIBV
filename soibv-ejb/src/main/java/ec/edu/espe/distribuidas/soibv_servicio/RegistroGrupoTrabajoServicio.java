/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_servicio;

import ec.edu.espe.distribuidas.soibv_dao.ColaboradorFacade;
import ec.edu.espe.distribuidas.soibv_dao.ColaboradorMinisterioFacade;
import ec.edu.espe.distribuidas.soibv_dao.GrupoTrabajoFacade;
import ec.edu.espe.distribuidas.soibv_modelo.ColaboradorMinisterio;
import ec.edu.espe.distribuidas.soibv_modelo.GrupoTrabajo;
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
public class RegistroGrupoTrabajoServicio {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    private GrupoTrabajoFacade grupoTrabajoFacade;
    @EJB
    private ColaboradorFacade colaboradorFacade;
    @EJB
    private ColaboradorMinisterioFacade colaboradorMinisterioFacade;
    
    
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(GrupoTrabajo gt)
    {
            
            this.grupoTrabajoFacade.create(gt);
            
        
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void editar(GrupoTrabajo gt)
    {
           
            this.grupoTrabajoFacade.edit(gt);
            
        
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(GrupoTrabajo gt)
    {
           
            this.grupoTrabajoFacade.remove(gt);
            
        
    }
    
    
    public List<GrupoTrabajo> findAll()
    {
        return this.grupoTrabajoFacade.findAll();
    }
    
}
