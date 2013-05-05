/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "MenuBean")
@SessionScoped
public class MenuBean
{

    public void goIndex()
    {
        try
        {

            FacesContext.getCurrentInstance().getExternalContext().redirect("/Minutos/faces/index.xhtml");
        } catch (IOException ex)
        {
            Logger.getLogger(MenuBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goCrud(String location)
    {
        try
        {

            FacesContext.getCurrentInstance().getExternalContext().redirect("/Minutos/faces/crud/"+location+".xhtml");
        } catch (IOException ex)
        {
            Logger.getLogger(MenuBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates a new instance of MenuBean
     */
    public MenuBean()
    {
    }

    public void save()
    {
        addMessage("Data saved");
    }

    public void update()
    {
        addMessage("Data updated");
    }

    public void delete()
    {
        addMessage("Data deleted");
    }

    public void addMessage(String summary)
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
