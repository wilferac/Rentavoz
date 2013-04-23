package model;
// Generated 23/04/2013 02:19:35 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Rol generated by hbm2java
 */
public class Rol  implements java.io.Serializable {


     private Integer idRol;
     private String rolNombre;
     private String rolDescripcion;
     private Set<Roles> roleses = new HashSet<Roles>(0);

    public Rol() {
    }

	
    public Rol(String rolNombre) {
        this.rolNombre = rolNombre;
    }
    public Rol(String rolNombre, String rolDescripcion, Set<Roles> roleses) {
       this.rolNombre = rolNombre;
       this.rolDescripcion = rolDescripcion;
       this.roleses = roleses;
    }
   
    public Integer getIdRol() {
        return this.idRol;
    }
    
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    public String getRolNombre() {
        return this.rolNombre;
    }
    
    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }
    public String getRolDescripcion() {
        return this.rolDescripcion;
    }
    
    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }
    public Set<Roles> getRoleses() {
        return this.roleses;
    }
    
    public void setRoleses(Set<Roles> roleses) {
        this.roleses = roleses;
    }




}


