/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.EmpresaDao;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Empresa;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "EmpresaBean")
@SessionScoped
public class EmpresaBean
{

    private Empresa objEmpresa;
    private EmpresaDao daoEmpresa;
    

    public void update()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoEmpresa.actualizar(objEmpresa);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa Actualizada", null);
            objEmpresa = new Empresa();
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
            daoEmpresa.insertar(objEmpresa);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa Creado", null);
            objEmpresa = new Empresa();
        } catch (Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public List<Empresa> getListTerceroFiltro()
    {
        return listTerceroFiltro;
    }
    

    public EmpresaBean()
    {
        objEmpresa = new Empresa();
        daoEmpresa = new EmpresaDao();
    }

    public Empresa getObjEmpresa()
    {
        return objEmpresa;
    }

    public void setObjEmpresa(Empresa objEmpresa)
    {
        this.objEmpresa = objEmpresa;
    }
}
