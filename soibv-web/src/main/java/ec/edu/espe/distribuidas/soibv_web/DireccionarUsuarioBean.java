/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_web;

import ec.edu.espe.distribuidas.soibv.NTipoUsuario;
import ec.edu.espe.distribuidas.soibv_modelo.Usuario;

/**
 *
 * @author Pablin
 */
public class DireccionarUsuarioBean {
    
    public String direccionarUsuario(Usuario usuario) 
    {
        if (NTipoUsuario.DIGITADOR.equals(usuario.getCodTipoUsuario().getNombreTipoUsuario())) 
            {
                return "menu";
            } 
        else if(NTipoUsuario.FUNCIONARIO.equals(usuario.getCodTipoUsuario().getNombreTipoUsuario()))
            {
                return "menu";
            }
        else  if(NTipoUsuario.ADMINISTRADOR.equals(usuario.getCodTipoUsuario().getNombreTipoUsuario()))
            {
                return "menu";
            }
        else  if(NTipoUsuario.COLABORADOR.equals(usuario.getCodTipoUsuario().getNombreTipoUsuario()))
            {
                return "menu";
            }
        else  if(NTipoUsuario.ADMINISTRADORARK.equals(usuario.getCodTipoUsuario().getNombreTipoUsuario()))
            {
                return "menu_ark_adm";
            }
        else  if(NTipoUsuario.DIGITADORARK.equals(usuario.getCodTipoUsuario().getNombreTipoUsuario()))
            {
                return "menu_ark_dgt";
            }
        else
            return "inicio";
    }
    
}
