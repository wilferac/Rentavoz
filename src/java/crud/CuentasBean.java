/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.CuentasDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Cuentas;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "CuentasBean")
@SessionScoped
public class CuentasBean
{

    private Cuentas obj;
    private CuentasDao daoObj;
    private List<Cuentas> listObj;
    private List<Cuentas> listObjFiltro;

    public void prepararUpdate(int id)
    {
        obj = daoObj.getOne(id);
        if (obj == null)
        {
            System.out.println("esta mierda es null");
        }

        System.out.println("seteando Cuentas " + id);
    }

    public void updateTercero()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoObj.update(obj);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cuentas Actualizado", null);
            obj = new Cuentas();
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
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cuentas Creado", null);
            obj = new Cuentas();
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public CuentasBean()
    {
        obj = new Cuentas();
        daoObj = new CuentasDao();
        //listTercero= daoTercero.getAll();
    }

    public List<Cuentas> getListObjFiltro()
    {
        return listObjFiltro;
    }

    public void setListObjFiltro(List<Cuentas> listObjFiltro)
    {
        this.listObjFiltro = listObjFiltro;
    }

    public Cuentas getObj()
    {
        return obj;
    }

    public void setObj(Cuentas obj)
    {
        this.obj = obj;
    }

    public List<Cuentas> getListObj()
    {
        return listObj;
    }

    public void setListObj(List<Cuentas> listObj)
    {
        this.listObj = listObj;
    }
}
