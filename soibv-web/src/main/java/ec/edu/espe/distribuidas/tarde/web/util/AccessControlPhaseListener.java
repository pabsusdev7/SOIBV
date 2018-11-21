/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.tarde.web.util;

import ec.edu.espe.distribuidas.soibv_web.InicioBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrador
 */
public class AccessControlPhaseListener implements PhaseListener {
 
    @Override
    public void afterPhase(PhaseEvent event) { 
        FacesContext context = event.getFacesContext();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        InicioBean inicioBean = (InicioBean) session.getAttribute("inicioBean");
        if (!context.getViewRoot().getViewId().contains("inicio.xhtml") && (inicioBean==null || inicioBean.getNombreUsuario()==null)) {
            context.getApplication().getNavigationHandler().handleNavigation(context, null, "inicio");
        }
    }
   
    @Override
    public PhaseId getPhaseId() {
        //ALL access go through RESTORE_VIEW and RENDER_VIEW (even direct url)
        return PhaseId.RESTORE_VIEW;
    } 

    @Override
    public void beforePhase(PhaseEvent event) {
        
    }
    
    
}
