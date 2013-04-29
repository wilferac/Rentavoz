/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.LineaDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Linea;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "LineaBean")
@SessionScoped
public class LineaBean
{

    private Linea objLinea;
    private LineaDao daoLinea;
    private List<Linea> listLineaFiltro;
    private List<Linea> listLinea;

    public void prepararUpdate(int id)
    {
        objLinea = daoLinea.getOne(id);
        if (objLinea == null)
        {
            System.out.println("esta mierda es null");
        }

        System.out.println("seteando Linea " + id);
    }

    public void update()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoLinea.update(objLinea);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa Actualizada", null);
            objLinea = new Linea();
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void save()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoLinea.insert(objLinea);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa Creada", null);
            objLinea = new Linea();
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Linea> getListTerceroFiltro()
    {
        return listLineaFiltro;
    }

    public LineaBean()
    {
        objLinea = new Linea();
        daoLinea = new LineaDao();
    }

    public Linea getObjLinea()
    {
        return objLinea;
    }

    public void setObjLinea(Linea objLinea)
    {
        this.objLinea = objLinea;
    }

    public List<Linea> getListLineaFiltro()
    {
        return listLineaFiltro;
    }

    public void setListLineaFiltro(List<Linea> listLineaFiltro)
    {
        this.listLineaFiltro = listLineaFiltro;
    }

    public List<Linea> getListLinea()
    {
        return listLinea;
    }

    public void setListLinea(List<Linea> listLinea)
    {
        this.listLinea = listLinea;
    }

    
}
