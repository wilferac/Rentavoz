/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import dao.TerceroDao;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Tercero;
import org.primefaces.context.RequestContext;

/**
 *
 * @author inovate
 */
@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean {

    Tercero loginTer;

    public Tercero getLoginTer() {
        if(loginTer!=null)
        {
            return loginTer;
        }
        return new Tercero();
    }

    public void setLoginTer(Tercero loginTer) {
        this.loginTer = loginTer;
    }

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public void login() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean loggedIn = false;
        
        TerceroDao daoTer = new TerceroDao();
        loginTer=daoTer.buscarPorTercero(loginTer);

        if (loginTer != null) {
            loggedIn = true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", loginTer.getTerDocumento() + "");
        } else {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
    }
}
