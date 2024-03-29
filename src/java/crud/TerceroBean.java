/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.TerceroDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Tercero;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "TerceroBean")
@SessionScoped
public class TerceroBean implements Serializable
{
    private Tercero objTercero;
    private TerceroDao daoTercero;
    private List<Tercero> listTercero;
    private List<Tercero> listTerceroFiltro;
    
    public void prepararUpdate(int id)
    {
        objTercero = daoTercero.getOne(id);
        if(objTercero== null)
        {
            System.out.println("esta mierda es null");
        }
       
        System.out.println("seteando tercero "+id);
    }
    
    public void updateTercero()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoTercero.actualizar(objTercero);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Actualizado", null);
            objTercero = new Tercero();
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
            daoTercero.insertar(objTercero);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
            objTercero = new Tercero();
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Tercero> getListTerceroFiltro()
    {
        return listTerceroFiltro;
    }

    public void setListTerceroFiltro(List<Tercero> listTerceroFiltro)
    {
        this.listTerceroFiltro = listTerceroFiltro;
    }
    
    public TerceroBean()
    {
        objTercero = new Tercero();
        daoTercero = new TerceroDao();
        //listTercero= daoTercero.getAll();
    }

    public List<Tercero> getListTercero()
    {
        listTercero= daoTercero.getAll();
        return listTercero;
    }

    public void setListTercero(List<Tercero> listTercero)
    {
        this.listTercero = listTercero;
    }

    public Tercero getObjTercero()
    {
        if (objTercero == null)
        {
            objTercero = new Tercero();
        }
        return objTercero;
    }

    public void setObjTercero(Tercero objTercero)
    {
        this.objTercero = objTercero;
    }
}
