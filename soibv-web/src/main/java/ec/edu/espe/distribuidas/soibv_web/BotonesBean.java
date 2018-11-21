/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.soibv_web;

import javax.annotation.PostConstruct;

/**
 * @author Gustavo Lozada
 */
public class BotonesBean {

    private Boolean disabledNuevo;
    private Boolean disabledModificar;
    private Boolean disabledEliminar;
    private Boolean uno;
    private Boolean varios;
    private Boolean noSeleccionados;
    private Boolean enEdicion;
    private Boolean enRegistro;
    private Boolean enFoto;
    private Boolean soloLectura;
    private Boolean enabledB;
    private Boolean enabledM;
    private Boolean enabledG;
    private Boolean enGenReporte;

    @PostConstruct
    public void postConstructor() {
        this.sinSeleccion();
    }

    public void sinSeleccion() {
        this.reset();
        this.disabledModificar = Boolean.TRUE;
        this.disabledEliminar = Boolean.TRUE;
        this.noSeleccionados = Boolean.TRUE;
    }

    public void seleccionadoUno() {
        this.reset();
        this.uno = Boolean.TRUE;
    }

    public void seleccionadoVarios() {
        this.reset();
        this.disabledModificar = Boolean.TRUE;
        this.varios = Boolean.TRUE;
    }

    public void crear() {
        this.reset();
        this.disabledNuevo = Boolean.TRUE;
        this.disabledModificar = Boolean.TRUE;
        this.disabledEliminar = Boolean.TRUE;
        this.enRegistro = Boolean.TRUE;
    }

    public void modificar() {
        this.reset();
        this.disabledNuevo = Boolean.TRUE;
        this.disabledModificar = Boolean.TRUE;
        this.disabledEliminar = Boolean.TRUE;
        this.enEdicion = Boolean.TRUE;
    }
    public void tomarFoto() {
        this.reset();
        this.enFoto=Boolean.TRUE;
    }
    
    public void enReporte()
    {
        this.reset();
        this.enGenReporte=Boolean.TRUE;
    }
    
    public void camposC()
    {
        this.enabledB=Boolean.FALSE;
        this.enabledM=Boolean.FALSE;
        this.enabledG=Boolean.FALSE;
    }
    
    public void eB()
    {
        this.enabledB=Boolean.TRUE;
    }
     public void eM()
    {
        this.enabledM=Boolean.TRUE;
    }
      public void eG()
    {
        this.enabledG=Boolean.TRUE;
    }
      
      public void dB()
    {
        this.enabledB=Boolean.FALSE;
    }
     public void dM()
    {
        this.enabledM=Boolean.FALSE;
    }
      public void dG()
    {
        this.enabledG=Boolean.FALSE;
    }
    

    public void verDetalles() {
        this.reset();
        this.disabledNuevo = Boolean.TRUE;
        this.disabledModificar = Boolean.TRUE;
        this.disabledEliminar = Boolean.TRUE;
        this.soloLectura = Boolean.TRUE;
    }

    private void reset() {
        this.disabledNuevo = Boolean.FALSE;
        this.disabledModificar = Boolean.FALSE;
        this.disabledEliminar = Boolean.FALSE;
        this.uno = Boolean.FALSE;
        this.varios = Boolean.FALSE;
        this.noSeleccionados = Boolean.FALSE;
        this.enEdicion = Boolean.FALSE;
        this.enRegistro = Boolean.FALSE;
        this.enFoto=Boolean.FALSE;
        this.soloLectura = Boolean.FALSE;
        this.enGenReporte=Boolean.FALSE;
    }

    public Boolean getDisabledEliminar() {
        return disabledEliminar;
    }

    public void setDisabledEliminar(Boolean disabledEliminar) {
        this.disabledEliminar = disabledEliminar;
    }

    public Boolean getDisabledModificar() {
        return disabledModificar;
    }

    public void setDisabledModificar(Boolean disabledModificar) {
        this.disabledModificar = disabledModificar;
    }

    public Boolean getDisabledNuevo() {
        return disabledNuevo;
    }

    public void setDisabledNuevo(Boolean disabledNuevo) {
        this.disabledNuevo = disabledNuevo;
    }

    public Boolean getEnEdicion() {
        return enEdicion;
    }

    public Boolean getEnRegistro() {
        return enRegistro;
    }

    public void setEnEdicion(Boolean enEdicion) {
        this.enEdicion = enEdicion;
    }

    public Boolean getSoloLectura() {
        return soloLectura;
    }

    public Boolean getNoSeleccionados() {
        return noSeleccionados;
    }

    public void setNoSeleccionados(Boolean noSeleccionados) {
        this.noSeleccionados = noSeleccionados;
    }

    public Boolean getUno() {
        return uno;
    }

    public void setUno(Boolean uno) {
        this.uno = uno;
    }

    public Boolean getVarios() {
        return varios;
    }

    public void setVarios(Boolean varios) {
        this.varios = varios;
    }

    public Boolean getEnFoto() {
        return enFoto;
    }

    public void setEnFoto(Boolean enFoto) {
        this.enFoto = enFoto;
    }

    public Boolean getEnabledB() {
        return enabledB;
    }

    public void setEnabledB(Boolean enabledB) {
        this.enabledB = enabledB;
    }

    public Boolean getEnabledG() {
        return enabledG;
    }

    public void setEnabledG(Boolean enabledG) {
        this.enabledG = enabledG;
    }

    public Boolean getEnabledM() {
        return enabledM;
    }

    public void setEnabledM(Boolean enabledM) {
        this.enabledM = enabledM;
    }

    public Boolean getEnGenReporte() {
        return enGenReporte;
    }

    public void setEnGenReporte(Boolean enGenReporte) {
        this.enGenReporte = enGenReporte;
    }
    
    

    
    
    
}
