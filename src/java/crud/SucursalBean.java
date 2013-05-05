/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.SucursalDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Sucursal;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "SucursalBean")
@SessionScoped
public class SucursalBean
{

    private Sucursal obj;
    private SucursalDao daoObj;
    private List<Sucursal> listObj;
    private List<Sucursal> listObjFiltro;

    public void prepararUpdate(int id)
    {
        obj = daoObj.getOne(id);
        if (obj == null)
        {
            System.out.println("esta mierda es null");
        }

        System.out.println("seteando Sucursal " + id);
    }

    public void update()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoObj.update(obj);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucursal Actualizado", null);
            obj = new Sucursal();
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void guardar()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoObj.insert(obj);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucursal Creado", null);
            obj = new Sucursal();
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public SucursalBean()
    {
        obj = new Sucursal();
        daoObj = new SucursalDao();
        //listTercero= daoTercero.getAll();
    }

    public List<Sucursal> getListObjFiltro()
    {
        return listObjFiltro;
    }

    public void setListObjFiltro(List<Sucursal> listObjFiltro)
    {
        this.listObjFiltro = listObjFiltro;
    }

    public Sucursal getObj()
    {
        return obj;
    }

    public void setObj(Sucursal obj)
    {
        this.obj = obj;
    }

    public List<Sucursal> getListObj()
    {
        return listObj;
    }

    public void setListObj(List<Sucursal> listObj)
    {
        this.listObj = listObj;
    }
}
