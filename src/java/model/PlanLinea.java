package model;
// Generated 23/04/2013 02:19:35 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * PlanLinea generated by hbm2java
 */
public class PlanLinea  implements java.io.Serializable {


     private Integer idPlanLinea;
     private Plan plan;
     private Linea linea;
     private Date fecha;
     private int plaEstado;

    public PlanLinea() {
    }

    public PlanLinea(Plan plan, Linea linea, Date fecha, int plaEstado) {
       this.plan = plan;
       this.linea = linea;
       this.fecha = fecha;
       this.plaEstado = plaEstado;
    }
   
    public Integer getIdPlanLinea() {
        return this.idPlanLinea;
    }
    
    public void setIdPlanLinea(Integer idPlanLinea) {
        this.idPlanLinea = idPlanLinea;
    }
    public Plan getPlan() {
        return this.plan;
    }
    
    public void setPlan(Plan plan) {
        this.plan = plan;
    }
    public Linea getLinea() {
        return this.linea;
    }
    
    public void setLinea(Linea linea) {
        this.linea = linea;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getPlaEstado() {
        return this.plaEstado;
    }
    
    public void setPlaEstado(int plaEstado) {
        this.plaEstado = plaEstado;
    }




}


