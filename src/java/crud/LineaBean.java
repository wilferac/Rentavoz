/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.EmpresaDao;
import dao.EstadoLineaDao;
import dao.LineaDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Empresa;
import model.EstadoLinea;
import model.Linea;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "LineaBean")
@SessionScoped
public class LineaBean
{

    private Integer idEmpresa;
    private Linea objLinea;
    private LineaDao daoLinea;
    private EmpresaDao daoEmpresa;
    private List<Linea> listLineaFiltro;
    private List<Linea> listLinea;
    private List<Empresa> listEmpresa;
    private EstadoLineaDao daoEstadoLinea;
    private List<EstadoLinea> listEstados;
    private Integer idEstado;
    private EstadoLinea objEstado;

    public void prepararUpdate(int id)
    {
        objLinea = daoLinea.getOne(id);
        idEmpresa = objLinea.getEmpresa().getIdEmpresa();
        idEstado = objLinea.getEstadoLinea().getIdEstadoLinea();
        if (objLinea == null)
        {
            System.out.println("esta mierda es null");
        }

        System.out.println("seteando Linea " + id);
    }

    public void prepararInsert()
    {
        idEmpresa = 0;
        objLinea = new Linea();
    }

    public void update()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            objEstado = new EstadoLinea();
            objEstado.setIdEstadoLinea(idEstado);
            Empresa empre = new Empresa();
            empre.setIdEmpresa(idEmpresa);
            //  Empresa empre=daoEmpresa.getOne(idEmpresa);
            objLinea.setEstadoLinea(objEstado);
            objLinea.setEmpresa(empre);
            daoLinea.update(objLinea);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea actualizada", null);
            objLinea = new Linea();
            daoLinea.cerrar();
            daoLinea = new LineaDao();
            idEmpresa = 0;
            idEstado = 0;

        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void save()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            objEstado = new EstadoLinea();
            objEstado.setIdEstadoLinea(1);
            Empresa empre = new Empresa();
            empre.setIdEmpresa(idEmpresa);
            //  Empresa empre=daoEmpresa.getOne(idEmpresa);
            objLinea.setEstadoLinea(objEstado);
            objLinea.setEmpresa(empre);
            daoLinea.insert(objLinea);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa Creada", null);
            objLinea = new Linea();
            idEmpresa = 0;
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Linea> getListTerceroFiltro()
    {
        return listLineaFiltro;
    }

    public LineaBean()
    {
        objLinea = new Linea();
        daoLinea = new LineaDao();
        daoEmpresa = new EmpresaDao();
        daoEstadoLinea = new EstadoLineaDao();
        listEmpresa = daoEmpresa.getAll();
        listEstados = daoEstadoLinea.getAll();
        idEmpresa = 0;

    }

    public Integer getIdEstado()
    {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado)
    {
        this.idEstado = idEstado;
    }

    public List<EstadoLinea> getListEstados()
    {
        listEstados = daoEstadoLinea.getAll();
        return listEstados;
    }

    public void setListEstados(List<EstadoLinea> listEstados)
    {
        this.listEstados = listEstados;
    }

    public List<Empresa> getListEmpresa()
    {
        listEmpresa = daoEmpresa.getAll();
        return listEmpresa;
    }

    public void setListEmpresa(List<Empresa> listEmpresa)
    {
        this.listEmpresa = listEmpresa;
    }

    public Linea getObjLinea()
    {
        return objLinea;
    }

    public void setObjLinea(Linea objLinea)
    {
        this.objLinea = objLinea;
    }

    public List<Linea> getListLineaFiltro()
    {
        return listLineaFiltro;
    }

    public void setListLineaFiltro(List<Linea> listLineaFiltro)
    {
        this.listLineaFiltro = listLineaFiltro;
    }

    public List<Linea> getListLinea()
    {
        listLinea = daoLinea.getAll();
        return listLinea;
    }

    public void setListLinea(List<Linea> listLinea)
    {
        this.listLinea = listLinea;
    }

    public int getIdEmpresa()
    {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa)
    {
        this.idEmpresa = idEmpresa;
    }
}
