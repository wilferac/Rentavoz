/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.ConvenioDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Convenio;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "ConvenioBean")
@SessionScoped
public class ConvenioBean implements Serializable
{

    private Convenio obj;
    private ConvenioDao daoObj;
    private List<Convenio> listObj;
    private List<Convenio> listObjFiltro;

    public void prepararUpdate(int id)
    {
        obj = daoObj.getOne(id);
        if (obj == null)
        {
            System.out.println("esta mierda es null");
        }

        System.out.println("seteando Convenio " + id);
    }

    public void update()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoObj.update(obj);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Convenio Actualizado", null);
            obj = new Convenio();
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
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Convenio Creado", null);
            obj = new Convenio();
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public ConvenioBean()
    {
        obj = new Convenio();
        daoObj = new ConvenioDao();
        //listTercero= daoTercero.getAll();
    }

    public List<Convenio> getListObjFiltro()
    {
        return listObjFiltro;
    }

    public void setListObjFiltro(List<Convenio> listObjFiltro)
    {
        this.listObjFiltro = listObjFiltro;
    }

    public Convenio getObj()
    {
        return obj;
    }

    public void setObj(Convenio obj)
    {
        this.obj = obj;
    }

    public List<Convenio> getListObj()
    {
        return listObj;
    }

    public void setListObj(List<Convenio> listObj)
    {
        this.listObj = listObj;
    }
}
