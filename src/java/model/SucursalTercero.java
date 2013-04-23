package model;
// Generated 23/04/2013 02:19:35 PM by Hibernate Tools 3.2.1.GA



/**
 * SucursalTercero generated by hbm2java
 */
public class SucursalTercero  implements java.io.Serializable {


     private Integer idSucursalTercero;
     private Tercero tercero;
     private Sucursal sucursal;
     private int sucTerEstado;

    public SucursalTercero() {
    }

    public SucursalTercero(Tercero tercero, Sucursal sucursal, int sucTerEstado) {
       this.tercero = tercero;
       this.sucursal = sucursal;
       this.sucTerEstado = sucTerEstado;
    }
   
    public Integer getIdSucursalTercero() {
        return this.idSucursalTercero;
    }
    
    public void setIdSucursalTercero(Integer idSucursalTercero) {
        this.idSucursalTercero = idSucursalTercero;
    }
    public Tercero getTercero() {
        return this.tercero;
    }
    
    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }
    public Sucursal getSucursal() {
        return this.sucursal;
    }
    
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    public int getSucTerEstado() {
        return this.sucTerEstado;
    }
    
    public void setSucTerEstado(int sucTerEstado) {
        this.sucTerEstado = sucTerEstado;
    }




}


