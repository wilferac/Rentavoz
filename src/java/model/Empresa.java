package model;
// Generated 23/04/2013 02:19:35 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Empresa generated by hbm2java
 */
public class Empresa  implements java.io.Serializable {


     private Integer idEmpresa;
     private String empNombre;
     private String empNit;
     private String empDireccion;
     private String empTelefono;
     private String empContacto;
     private String empAlias;
     private Set<Convenio> convenios = new HashSet<Convenio>(0);
     private Set<Linea> lineas = new HashSet<Linea>(0);

    public Empresa() {
    }

	
    public Empresa( String empNombre, String empNit, String empDireccion, String empAlias) {
        
        this.empNombre = empNombre;
        this.empNit = empNit;
        this.empDireccion = empDireccion;
        this.empAlias = empAlias;
    }
    public Empresa( String empNombre, String empNit, String empDireccion, String empTelefono, String empContacto, String empAlias, Set<Convenio> convenios, Set<Linea> lineas) {
       
       this.empNombre = empNombre;
       this.empNit = empNit;
       this.empDireccion = empDireccion;
       this.empTelefono = empTelefono;
       this.empContacto = empContacto;
       this.empAlias = empAlias;
       this.convenios = convenios;
       this.lineas = lineas;
    }
   
    public Integer getIdEmpresa() {
        return this.idEmpresa;
    }
    
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public String getEmpNombre() {
        return this.empNombre;
    }
    
    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }
    public String getEmpNit() {
        return this.empNit;
    }
    
    public void setEmpNit(String empNit) {
        this.empNit = empNit;
    }
    public String getEmpDireccion() {
        return this.empDireccion;
    }
    
    public void setEmpDireccion(String empDireccion) {
        this.empDireccion = empDireccion;
    }
    public String getEmpTelefono() {
        return this.empTelefono;
    }
    
    public void setEmpTelefono(String empTelefono) {
        this.empTelefono = empTelefono;
    }
    public String getEmpContacto() {
        return this.empContacto;
    }
    
    public void setEmpContacto(String empContacto) {
        this.empContacto = empContacto;
    }
    public String getEmpAlias() {
        return this.empAlias;
    }
    
    public void setEmpAlias(String empAlias) {
        this.empAlias = empAlias;
    }
    public Set<Convenio> getConvenios() {
        return this.convenios;
    }
    
    public void setConvenios(Set<Convenio> convenios) {
        this.convenios = convenios;
    }
    public Set<Linea> getLineas() {
        return this.lineas;
    }
    
    public void setLineas(Set<Linea> lineas) {
        this.lineas = lineas;
    }




}


