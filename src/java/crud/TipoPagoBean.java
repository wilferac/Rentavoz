/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.TipoPagoDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.TipoPago;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "TipoPagoBean")
@SessionScoped
public class TipoPagoBean
{

    private TipoPago obj;
    private TipoPagoDao daoObj;
    private List<TipoPago> listObj;
    private List<TipoPago> listObjFiltro;

    public void prepararUpdate(int id)
    {
        obj = daoObj.getOne(id);
        if (obj == null)
        {
            System.out.println("esta mierda es null");
        }

        System.out.println("seteando TipoPago " + id);
    }

    public void update()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoObj.update(obj);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "TipoPago Actualizado", null);
            obj = new TipoPago();
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
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "TipoPago Creado", null);
            obj = new TipoPago();
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public TipoPagoBean()
    {
        obj = new TipoPago();
        daoObj = new TipoPagoDao();
        //listTercero= daoTercero.getAll();
    }

    public List<TipoPago> getListObjFiltro()
    {
        return listObjFiltro;
    }

    public void setListObjFiltro(List<TipoPago> listObjFiltro)
    {
        this.listObjFiltro = listObjFiltro;
    }

    public TipoPago getObj()
    {
        return obj;
    }

    public void setObj(TipoPago obj)
    {
        this.obj = obj;
    }

    public List<TipoPago> getListObj()
    {
        return listObj;
    }

    public void setListObj(List<TipoPago> listObj)
    {
        this.listObj = listObj;
    }
}
