/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.EmpresaDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Empresa;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "EmpresaBean")
@SessionScoped
public class EmpresaBean
{

    private Empresa objEmpresa;
    private EmpresaDao daoEmpresa;
    private List<Empresa> listEmpresaFiltro;
    private List<Empresa> listEmpresa;

    public void prepararUpdate(int id)
    {
        objEmpresa = daoEmpresa.getOne(id);
        if (objEmpresa == null)
        {
            System.out.println("esta mierda es null");
        }

        System.out.println("seteando empresa " + id);
    }

    public void update()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoEmpresa.actualizar(objEmpresa);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa Actualizada", null);
            objEmpresa = new Empresa();
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
            daoEmpresa.insertar(objEmpresa);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa Creada", null);
            objEmpresa = new Empresa();
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Empresa> getListTerceroFiltro()
    {
        return listEmpresaFiltro;
    }

    public EmpresaBean()
    {
        objEmpresa = new Empresa();
        daoEmpresa = new EmpresaDao();
    }

    public Empresa getObjEmpresa()
    {
        return objEmpresa;
    }

    public void setObjEmpresa(Empresa objEmpresa)
    {
        this.objEmpresa = objEmpresa;
    }

    public List<Empresa> getListEmpresaFiltro()
    {
        return listEmpresaFiltro;
    }

    public void setListEmpresaFiltro(List<Empresa> listEmpresaFiltro)
    {
        this.listEmpresaFiltro = listEmpresaFiltro;
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
}
