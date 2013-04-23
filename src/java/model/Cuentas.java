package model;
// Generated 23/04/2013 02:19:35 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Cuentas generated by hbm2java
 */
public class Cuentas  implements java.io.Serializable {


     private Integer idCuentas;
     private String cueNombre;
     private String cueNumero;
     private BigDecimal cueSaldo;
     private Set<Pago> pagos = new HashSet<Pago>(0);
     private Set<Gasto> gastos = new HashSet<Gasto>(0);

    public Cuentas() {
    }

	
    public Cuentas(String cueNombre, String cueNumero, BigDecimal cueSaldo) {
        this.cueNombre = cueNombre;
        this.cueNumero = cueNumero;
        this.cueSaldo = cueSaldo;
    }
    public Cuentas(String cueNombre, String cueNumero, BigDecimal cueSaldo, Set<Pago> pagos, Set<Gasto> gastos) {
       this.cueNombre = cueNombre;
       this.cueNumero = cueNumero;
       this.cueSaldo = cueSaldo;
       this.pagos = pagos;
       this.gastos = gastos;
    }
   
    public Integer getIdCuentas() {
        return this.idCuentas;
    }
    
    public void setIdCuentas(Integer idCuentas) {
        this.idCuentas = idCuentas;
    }
    public String getCueNombre() {
        return this.cueNombre;
    }
    
    public void setCueNombre(String cueNombre) {
        this.cueNombre = cueNombre;
    }
    public String getCueNumero() {
        return this.cueNumero;
    }
    
    public void setCueNumero(String cueNumero) {
        this.cueNumero = cueNumero;
    }
    public BigDecimal getCueSaldo() {
        return this.cueSaldo;
    }
    
    public void setCueSaldo(BigDecimal cueSaldo) {
        this.cueSaldo = cueSaldo;
    }
    public Set<Pago> getPagos() {
        return this.pagos;
    }
    
    public void setPagos(Set<Pago> pagos) {
        this.pagos = pagos;
    }
    public Set<Gasto> getGastos() {
        return this.gastos;
    }
    
    public void setGastos(Set<Gasto> gastos) {
        this.gastos = gastos;
    }




}

