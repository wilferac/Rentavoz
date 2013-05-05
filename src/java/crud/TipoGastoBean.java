/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.TipoGastoDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.TipoGasto;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "TipoGastoBean")
@SessionScoped
public class TipoGastoBean
{

    private TipoGasto obj;
    private TipoGastoDao daoObj;
    private List<TipoGasto> listObj;
    private List<TipoGasto> listObjFiltro;

    public void prepararUpdate(int id)
    {
        obj = daoObj.getOne(id);
        if (obj == null)
        {
            System.out.println("esta mierda es null");
        }

        System.out.println("seteando TipoGasto " + id);
    }

    public void updateTercero()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoObj.update(obj);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "TipoGasto Actualizado", null);
            obj = new TipoGasto();
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
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "TipoGasto Creado", null);
            obj = new TipoGasto();
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public TipoGastoBean()
    {
        obj = new TipoGasto();
        daoObj = new TipoGastoDao();
        //listTercero= daoTercero.getAll();
    }

    public List<TipoGasto> getListObjFiltro()
    {
        return listObjFiltro;
    }

    public void setListObjFiltro(List<TipoGasto> listObjFiltro)
    {
        this.listObjFiltro = listObjFiltro;
    }

    public TipoGasto getObj()
    {
        return obj;
    }

    public void setObj(TipoGasto obj)
    {
        this.obj = obj;
    }

    public List<TipoGasto> getListObj()
    {
        return listObj;
    }

    public void setListObj(List<TipoGasto> listObj)
    {
        this.listObj = listObj;
    }
}
