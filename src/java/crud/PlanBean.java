/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.PlanDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Plan;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "PlanBean")
@SessionScoped
public class PlanBean
{

    private Plan obj;
    private PlanDao daoObj;
    private List<Plan> listObj;
    private List<Plan> listObjFiltro;

    public void prepararUpdate(int id)
    {
        obj = daoObj.getOne(id);
        if (obj == null)
        {
            System.out.println("esta mierda es null");
        }

        System.out.println("seteando Plan " + id);
    }

    public void update()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoObj.update(obj);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Plan Actualizado", null);
            obj = new Plan();
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
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Plan Creado", null);
            obj = new Plan();
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public PlanBean()
    {
        obj = new Plan();
        daoObj = new PlanDao();
        //listTercero= daoTercero.getAll();
    }

    public List<Plan> getListObjFiltro()
    {
        return listObjFiltro;
    }

    public void setListObjFiltro(List<Plan> listObjFiltro)
    {
        this.listObjFiltro = listObjFiltro;
    }

    public Plan getObj()
    {
        return obj;
    }

    public void setObj(Plan obj)
    {
        this.obj = obj;
    }

    public List<Plan> getListObj()
    {
        return listObj;
    }

    public void setListObj(List<Plan> listObj)
    {
        this.listObj = listObj;
    }
}
