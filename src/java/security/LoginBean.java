/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import dao.TerceroDao;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Roles;
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
    String rolRequired;

    public String getRolRequired() {
        return rolRequired;
    }

    public void setRolRequired(String rolRequired) {
        this.rolRequired = rolRequired;
    }
    
    

    public Tercero getLoginTer() {
        if (loginTer == null) {
            loginTer = new Tercero();
        }
        return loginTer;
    }

    public void setLoginTer(Tercero loginTer) {
        this.loginTer = loginTer;
    }

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String login() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean loggedIn = false;

        TerceroDao daoTer = new TerceroDao();
        loginTer = daoTer.buscarPorTercero(loginTer);

        if (loginTer != null) {
            loggedIn = true;
            //msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", loginTer.getTerDocumento() + "");
            return "index";
        } else {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials ");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
        return "";
    }

    public boolean checkRol() {
        
        System.out.println(rolRequired);
       // Iterator<Roles> iterator = loginTer.getRoleses().iterator();
        
        System.out.println("el tamnanio "+loginTer.getRoleses().size());
        
        for(Roles rol :loginTer.getRoleses() )
        {
            //System.out.println(rol.getRol().getRolNombre());
            if (rol.getRol().getRolNombre().compareTo(rolRequired) == 0) {
                return true;
            }
        }
        
//        while (iterator.hasNext()) {
//            Roles setElement = iterator.next();
//            System.out.println(setElement.getRol().getRolNombre());
//            if (setElement.getRol().getRolNombre().compareTo(value) == 0) {
//                return true;
//            }
//        }

        return false;
    }
}
