/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.OperadorDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Operador;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "OperadorBean")
@SessionScoped
public class OperadorBean
{

    private Operador obj;
    private OperadorDao daoObj;
    private List<Operador> listObj;
    private List<Operador> listObjFiltro;

    public void prepararUpdate(int id)
    {
        obj = daoObj.getOne(id);
        if (obj == null)
        {
            System.out.println("esta mierda es null");
        }

        System.out.println("seteando Operador " + id);
    }

    public void update()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoObj.update(obj);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operador Actualizado", null);
            obj = new Operador();
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
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operador Creado", null);
            obj = new Operador();
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public OperadorBean()
    {
        obj = new Operador();
        daoObj = new OperadorDao();
        //listTercero= daoTercero.getAll();
    }

    public List<Operador> getListObjFiltro()
    {
        return listObjFiltro;
    }

    public void setListObjFiltro(List<Operador> listObjFiltro)
    {
        this.listObjFiltro = listObjFiltro;
    }

    public Operador getObj()
    {
        return obj;
    }

    public void setObj(Operador obj)
    {
        this.obj = obj;
    }

    public List<Operador> getListObj()
    {
        return listObj;
    }

    public void setListObj(List<Operador> listObj)
    {
        this.listObj = listObj;
    }
}
