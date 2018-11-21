/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_servicio;

import ec.edu.espe.distribuidas.soibv_dao.ColaboradorFacade;
import ec.edu.espe.distribuidas.soibv_dao.ResponsabilidadColaboradorFacade;
import ec.edu.espe.distribuidas.soibv_dao.TipoUsuarioFacade;
import ec.edu.espe.distribuidas.soibv_dao.UsuarioFacade;
import ec.edu.espe.distribuidas.soibv_modelo.Colaborador;
import ec.edu.espe.distribuidas.soibv_modelo.TipoUsuario;
import ec.edu.espe.distribuidas.soibv_modelo.Usuario;
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
public class RegistroUsuarioServicio {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private ColaboradorFacade colaboradorFacade;
    @EJB
    private TipoUsuarioFacade tipoUsuarioFacade;
    @EJB
    private ResponsabilidadColaboradorFacade responsabilidadColaboradorFacade;
    
    
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public  Usuario registrarUsuario(TipoUsuario tp,Colaborador c, String u, String clave)
    {
        Usuario us=new Usuario(u,clave,c,tp);
        this.usuarioFacade.create(us);
        return us;
    }
     
      @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public  void crear(Usuario u)
    {
        this.usuarioFacade.create(u);
    }
    
      @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public  Usuario editarUsuario(TipoUsuario tp,Colaborador c, String u, String clave,Usuario ur)
    {
        ur.setCodColaborador(c);
        ur.setCodTipoUsuario(tp);
        ur.setContrasenaUsuario(clave);
        ur.setNombreUsuario(u);
        this.usuarioFacade.edit(ur);
        return ur;
    }
      
       @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public  void editar(Usuario u)
    {
       
        this.usuarioFacade.edit(u);
       
    }
      
     @TransactionAttribute(TransactionAttributeType.REQUIRED) 
    public void elimUsuario(Usuario u)
    {
        for(int i=0;i<this.responsabilidadColaboradorFacade.findByUsuario(u).size();i++)
            this.responsabilidadColaboradorFacade.findByUsuario(u).get(i).setCodUsuario(null);
        this.usuarioFacade.remove(u);
    }
     
      public Colaborador obtenerColPorCedula(String cedulaMiembro)
   {
       Integer codcol=this.colaboradorFacade.findByMiembroCedula1(cedulaMiembro);
       return this.colaboradorFacade.find(codcol);
   
   }
      
      public List<TipoUsuario> obtenerTiposUsuarios()
      {
          List<TipoUsuario> lu=this.tipoUsuarioFacade.findAll();
          return lu;
      }
      
      public TipoUsuario obtenerPorCodigo(Integer cod)
      {
          return this.tipoUsuarioFacade.find(cod);
      }
      
      public List<Usuario> obtenerAllU()
      {
          return this.usuarioFacade.findAll();
      }
      
      public Usuario obtenerUserPorCodigo(Integer cod)
      {
          return this.usuarioFacade.find(cod);
      }
      
      public List<Colaborador> obtenerAll()
              
      {
          return this.colaboradorFacade.findAll();
      }
      
      public Colaborador obtenerporCod(Integer cod)
      {
          return this.colaboradorFacade.find(cod);
      }
}
