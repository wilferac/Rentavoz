/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.SimcardDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Simcard;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "SimcardBean")
@SessionScoped
public class SimcardBean
{

    private Simcard obj;
    private SimcardDao daoObj;
    private List<Simcard> listObj;
    private List<Simcard> listObjFiltro;

    public void prepararUpdate(int id)
    {
        obj = daoObj.getOne(id);
        if (obj == null)
        {
            System.out.println("esta mierda es null");
        }

        System.out.println("seteando Simcard " + id);
    }

    public void update()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoObj.update(obj);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Simcard Actualizado", null);
            obj = new Simcard();
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
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Simcard Creado", null);
            obj = new Simcard();
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public SimcardBean()
    {
        obj = new Simcard();
        daoObj = new SimcardDao();
        //listTercero= daoTercero.getAll();
    }

    public List<Simcard> getListObjFiltro()
    {
        return listObjFiltro;
    }

    public void setListObjFiltro(List<Simcard> listObjFiltro)
    {
        this.listObjFiltro = listObjFiltro;
    }

    public Simcard getObj()
    {
        return obj;
    }

    public void setObj(Simcard obj)
    {
        this.obj = obj;
    }

    public List<Simcard> getListObj()
    {
        return listObj;
    }

    public void setListObj(List<Simcard> listObj)
    {
        this.listObj = listObj;
    }
}
