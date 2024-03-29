package model;
// Generated 23/04/2013 02:19:35 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Ciudad generated by hbm2java
 */
public class Ciudad  implements java.io.Serializable {


     private int idCiudad;
     private Departamento departamento;
     private String ciuNombre;
     private Set<Sucursal> sucursals = new HashSet<Sucursal>(0);

    public Ciudad() {
    }

	
    public Ciudad(int idCiudad, Departamento departamento, String ciuNombre) {
        this.idCiudad = idCiudad;
        this.departamento = departamento;
        this.ciuNombre = ciuNombre;
    }
    public Ciudad(int idCiudad, Departamento departamento, String ciuNombre, Set<Sucursal> sucursals) {
       this.idCiudad = idCiudad;
       this.departamento = departamento;
       this.ciuNombre = ciuNombre;
       this.sucursals = sucursals;
    }
   
    public int getIdCiudad() {
        return this.idCiudad;
    }
    
    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    public Departamento getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public String getCiuNombre() {
        return this.ciuNombre;
    }
    
    public void setCiuNombre(String ciuNombre) {
        this.ciuNombre = ciuNombre;
    }
    public Set<Sucursal> getSucursals() {
        return this.sucursals;
    }
    
    public void setSucursals(Set<Sucursal> sucursals) {
        this.sucursals = sucursals;
    }




}


