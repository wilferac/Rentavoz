/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.CiudadDao;
import dao.SucursalDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Ciudad;
import model.Sucursal;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "SucursalBean")
@SessionScoped
public class SucursalBean implements Serializable
{

    private Sucursal obj;
    private SucursalDao daoObj;
    private List<Sucursal> listObj;
    private List<Sucursal> listObjFiltro;
    private Integer idCiudad;
    private List<Ciudad> listCiudad;
    private CiudadDao daoCiudad;

    public void prepararUpdate(int id)
    {
        obj = daoObj.getOne(id);
        idCiudad = obj.getCiudad().getIdCiudad();
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
        Ciudad ciu = new Ciudad();
        ciu.setIdCiudad(idCiudad);
        obj.setCiudad(ciu);
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
        Ciudad ciu = new Ciudad();
        ciu.setIdCiudad(idCiudad);
        obj.setCiudad(ciu);

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
        daoCiudad = new CiudadDao();
        idCiudad = 0;
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
        listObj = daoObj.getAll();
        return listObj;
    }

    public void setListObj(List<Sucursal> listObj)
    {
        this.listObj = listObj;
    }

    public Integer getIdCiudad()
    {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad)
    {
        this.idCiudad = idCiudad;
    }

    public List<Ciudad> getListCiudad()
    {
        listCiudad = daoCiudad.getAll();
        return listCiudad;
    }

    public void setListCiudad(List<Ciudad> listCiudad)
    {
        this.listCiudad = listCiudad;
    }
}
