/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.LineaDao;
import dao.SimcardDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Linea;
import model.Simcard;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "SimcardBean")
@SessionScoped
public class SimcardBean implements Serializable
{

    private Simcard obj;
    private SimcardDao daoObj;
    private List<Simcard> listObj;
    private List<Simcard> listObjFiltro;
    private Integer idLinea;
    private List<Linea> listLinea;
    private LineaDao daoLinea;

    public void prepararUpdate(int id)
    {
        System.out.println("seteando Simcard " + id);
        obj = daoObj.getOne(id);
        try
        {
            idLinea = obj.getLinea().getIdLinea();

        } catch (NullPointerException e)
        {
            System.out.println("la simcard no tiene asignada ninguna linea");
        }
        if (obj == null)
        {
            System.out.println("esta mierda es null");
        }


    }

    public void update()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            Linea li = new Linea();
            if (idLinea == 0)
            {
                li = null;
            } else
            {
                li.setIdLinea(idLinea);
            }
            obj.setLinea(li);
            obj.setSimEstado(1);
            daoObj.update(obj);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Simcard Actualizado", null);
            obj = new Simcard();
            daoObj.closeSession();
            daoObj = new SimcardDao();
            idLinea = 0;
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
            daoObj.closeSession();
            daoObj = new SimcardDao();
            idLinea = 0;
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void prepararInsert()
    {
        idLinea = 0;
        obj = new Simcard();
        System.out.println("preparando el insert " + listLinea.size());
    }

    public void guardar()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            Linea li = new Linea();
            if (idLinea == 0)
            {
                li = null;
            } else
            {
                li.setIdLinea(idLinea);
            }
            obj.setLinea(li);
            obj.setSimEstado(1);
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
        if (daoObj != null)
        {
            daoObj.closeSession();
        }

        obj = new Simcard();
        daoObj = new SimcardDao();
        //obtengo todas las lineas
        idLinea = 0; //no esta asociada a ninguna linea
        daoLinea = new LineaDao();
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
        listObj = daoObj.getAll();
        return listObj;
    }

    public void setListObj(List<Simcard> listObj)
    {
        this.listObj = listObj;
    }

    public Integer getIdLinea()
    {
        return idLinea;
    }

    public void setIdLinea(Integer idLinea)
    {
        this.idLinea = idLinea;
    }

    public List<Linea> getListLinea()
    {
        listLinea = daoLinea.getFreeLines();
        return listLinea;
    }

    public void setListLinea(List<Linea> listLinea)
    {
        this.listLinea = listLinea;
    }
}
