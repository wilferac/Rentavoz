package model;
// Generated 23/04/2013 02:19:35 PM by Hibernate Tools 3.2.1.GA



/**
 * Roles generated by hbm2java
 */
public class Roles  implements java.io.Serializable {


     private int rolId;
     private Tercero tercero;
     private Rol rol;

    public Roles() {
    }

    public Roles(int rolId, Tercero tercero, Rol rol) {
       this.rolId = rolId;
       this.tercero = tercero;
       this.rol = rol;
    }
   
    public int getRolId() {
        return this.rolId;
    }
    
    public void setRolId(int rolId) {
        this.rolId = rolId;
    }
    public Tercero getTercero() {
        return this.tercero;
    }
    
    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }




}


