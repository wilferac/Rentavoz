package model;
// Generated 23/04/2013 02:19:35 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Simcard generated by hbm2java
 */
public class Simcard  implements java.io.Serializable {


     private Integer idSimcard;
     private Linea linea;
     private String simIccid;
     private int simEstado;
     private Date fecha;
     private Set<SucursalSimcard> sucursalSimcards = new HashSet<SucursalSimcard>(0);

    public Simcard() {
    }

	
    public Simcard(Linea linea, String simIccid, int simEstado, Date fecha) {
        this.linea = linea;
        this.simIccid = simIccid;
        this.simEstado = simEstado;
        this.fecha = fecha;
    }
    public Simcard(Linea linea, String simIccid, int simEstado, Date fecha, Set<SucursalSimcard> sucursalSimcards) {
       this.linea = linea;
       this.simIccid = simIccid;
       this.simEstado = simEstado;
       this.fecha = fecha;
       this.sucursalSimcards = sucursalSimcards;
    }
   
    public Integer getIdSimcard() {
        return this.idSimcard;
    }
    
    public void setIdSimcard(Integer idSimcard) {
        this.idSimcard = idSimcard;
    }
    public Linea getLinea() {
        return this.linea;
    }
    
    public void setLinea(Linea linea) {
        this.linea = linea;
    }
    public String getSimIccid() {
        return this.simIccid;
    }
    
    public void setSimIccid(String simIccid) {
        this.simIccid = simIccid;
    }
    public int getSimEstado() {
        return this.simEstado;
    }
    
    public void setSimEstado(int simEstado) {
        this.simEstado = simEstado;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Set<SucursalSimcard> getSucursalSimcards() {
        return this.sucursalSimcards;
    }
    
    public void setSucursalSimcards(Set<SucursalSimcard> sucursalSimcards) {
        this.sucursalSimcards = sucursalSimcards;
    }




}


