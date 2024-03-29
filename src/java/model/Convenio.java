package model;
// Generated 23/04/2013 02:19:35 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Convenio generated by hbm2java
 */
public class Convenio  implements java.io.Serializable {


     private Integer idConvenio;
     private Empresa empresa;
     private Plan plan;
     private short conComision;
     private Date conFechaInicio;
     private short conValorFijo;
     private int conEstado;

    public Convenio() {
    }

    public Convenio(Empresa empresa, Plan plan, short conComision, Date conFechaInicio, short conValorFijo, int conEstado) {
       this.empresa = empresa;
       this.plan = plan;
       this.conComision = conComision;
       this.conFechaInicio = conFechaInicio;
       this.conValorFijo = conValorFijo;
       this.conEstado = conEstado;
    }
   
    public Integer getIdConvenio() {
        return this.idConvenio;
    }
    
    public void setIdConvenio(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public Plan getPlan() {
        return this.plan;
    }
    
    public void setPlan(Plan plan) {
        this.plan = plan;
    }
    public short getConComision() {
        return this.conComision;
    }
    
    public void setConComision(short conComision) {
        this.conComision = conComision;
    }
    public Date getConFechaInicio() {
        return this.conFechaInicio;
    }
    
    public void setConFechaInicio(Date conFechaInicio) {
        this.conFechaInicio = conFechaInicio;
    }
    public short getConValorFijo() {
        return this.conValorFijo;
    }
    
    public void setConValorFijo(short conValorFijo) {
        this.conValorFijo = conValorFijo;
    }
    public int getConEstado() {
        return this.conEstado;
    }
    
    public void setConEstado(int conEstado) {
        this.conEstado = conEstado;
    }




}


