package model;
// Generated 23/04/2013 02:19:35 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Operador generated by hbm2java
 */
public class Operador  implements java.io.Serializable {


     private Integer idOperador;
     private String opeNombre;
     private Set<Plan> plans = new HashSet<Plan>(0);

    public Operador() {
    }

	
    public Operador(String opeNombre) {
        this.opeNombre = opeNombre;
    }
    public Operador(String opeNombre, Set<Plan> plans) {
       this.opeNombre = opeNombre;
       this.plans = plans;
    }
   
    public Integer getIdOperador() {
        return this.idOperador;
    }
    
    public void setIdOperador(Integer idOperador) {
        this.idOperador = idOperador;
    }
    public String getOpeNombre() {
        return this.opeNombre;
    }
    
    public void setOpeNombre(String opeNombre) {
        this.opeNombre = opeNombre;
    }
    public Set<Plan> getPlans() {
        return this.plans;
    }
    
    public void setPlans(Set<Plan> plans) {
        this.plans = plans;
    }




}

