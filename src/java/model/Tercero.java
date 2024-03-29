package model;
// Generated 23/04/2013 02:19:35 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Tercero generated by hbm2java
 */
public class Tercero  implements java.io.Serializable {


     private Integer idTecero;
     private String terNombre;
     private String terApellidos;
     private String terTelefono;
     private String terDireccion;
     private int terDocumento;
     private String terClave;
     private Set<SucursalTercero> sucursalTerceros = new HashSet<SucursalTercero>(0);
     private Set<Plan> plans = new HashSet<Plan>(0);
     private Set<Roles> roleses = new HashSet<Roles>(0);
     private Set<TerceroVenta> terceroVentas = new HashSet<TerceroVenta>(0);

    public Tercero() {
    }

	
    public Tercero(String terNombre, String terTelefono, String terDireccion, int terDocumento, String terClave) {
        this.terNombre = terNombre;
        this.terTelefono = terTelefono;
        this.terDireccion = terDireccion;
        this.terDocumento = terDocumento;
        this.terClave = terClave;
    }
    public Tercero(String terNombre, String terApellidos, String terTelefono, String terDireccion, int terDocumento, String terClave, Set<SucursalTercero> sucursalTerceros, Set<Plan> plans, Set<Roles> roleses, Set<TerceroVenta> terceroVentas) {
       this.terNombre = terNombre;
       this.terApellidos = terApellidos;
       this.terTelefono = terTelefono;
       this.terDireccion = terDireccion;
       this.terDocumento = terDocumento;
       this.terClave = terClave;
       this.sucursalTerceros = sucursalTerceros;
       this.plans = plans;
       this.roleses = roleses;
       this.terceroVentas = terceroVentas;
    }
   
    public Integer getIdTecero() {
        return this.idTecero;
    }
    
    public void setIdTecero(Integer idTecero) {
        this.idTecero = idTecero;
    }
    public String getTerNombre() {
        return this.terNombre;
    }
    
    public void setTerNombre(String terNombre) {
        this.terNombre = terNombre;
    }
    public String getTerApellidos() {
        return this.terApellidos;
    }
    
    public void setTerApellidos(String terApellidos) {
        this.terApellidos = terApellidos;
    }
    public String getTerTelefono() {
        return this.terTelefono;
    }
    
    public void setTerTelefono(String terTelefono) {
        this.terTelefono = terTelefono;
    }
    public String getTerDireccion() {
        return this.terDireccion;
    }
    
    public void setTerDireccion(String terDireccion) {
        this.terDireccion = terDireccion;
    }
    public int getTerDocumento() {
        return this.terDocumento;
    }
    
    public void setTerDocumento(int terDocumento) {
        this.terDocumento = terDocumento;
    }
    public String getTerClave() {
        return this.terClave;
    }
    
    public void setTerClave(String terClave) {
        this.terClave = terClave;
    }
    public Set<SucursalTercero> getSucursalTerceros() {
        return this.sucursalTerceros;
    }
    
    public void setSucursalTerceros(Set<SucursalTercero> sucursalTerceros) {
        this.sucursalTerceros = sucursalTerceros;
    }
    public Set<Plan> getPlans() {
        return this.plans;
    }
    
    public void setPlans(Set<Plan> plans) {
        this.plans = plans;
    }
    public Set<Roles> getRoleses() {
        return this.roleses;
    }
    
    public void setRoleses(Set<Roles> roleses) {
        this.roleses = roleses;
    }
    public Set<TerceroVenta> getTerceroVentas() {
        return this.terceroVentas;
    }
    
    public void setTerceroVentas(Set<TerceroVenta> terceroVentas) {
        this.terceroVentas = terceroVentas;
    }




}


