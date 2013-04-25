/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.TerceroDao;
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
public class TerceroBean
{
    private Tercero objTercero;
    private TerceroDao daoTercero;
    
    
    
    public Tercero getObjTercero()
    {
        if(objTercero==null)
        {
            objTercero= new Tercero();
        }
        return objTercero;
    }

    public void setObjTercero(Tercero objTercero)
    {
        this.objTercero = objTercero;
    }
    
    public TerceroBean()
    {
        objTercero= new Tercero();
        daoTercero= new TerceroDao();
    }
    
    public void guardar()
    {
        FacesMessage message;
        //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
        try
        {
            daoTercero.insertar(objTercero);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tercero Creado", null);
            objTercero=new Tercero();
        }
        catch(Exception e)
        {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
        }
        
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
}
