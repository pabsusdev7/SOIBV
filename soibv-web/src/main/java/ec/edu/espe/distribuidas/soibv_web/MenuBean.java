/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_web;

  
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;  
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;  

@ManagedBean
@ViewScoped
public class MenuBean implements Serializable{  
      
    public void logout() { 
       
        addMessage("Logging Out!");  
    }  
      
    public void update() {  
        addMessage("Data updated");  
    }  
      
    public void delete() {  
        addMessage("Data deleted");  
    }  
      
    public void addMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
}  
