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
public class LoginBean
{

    Tercero loginTer;
    String rolRequired;
    boolean admin, usuario, cliente;

    boolean isLogin;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean()
    {
        isLogin=false;
    }

    public String login()
    {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean loggedIn = false;

        TerceroDao daoTer = new TerceroDao();
        loginTer = daoTer.buscarPorTercero(loginTer);

        if (loginTer != null)
        {
            loggedIn = true;
            //msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", loginTer.getTerDocumento() + "");
            isLogin=true;
            checkRol();
            return "index.xhtml?faces-redirect=true";
        } else
        {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials ");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
        return "";
    }

    public void checkRol()
    {

        System.out.println(rolRequired);
        // Iterator<Roles> iterator = loginTer.getRoleses().iterator();

        System.out.println("el tamnanio " + loginTer.getRoleses().size());

        for (Roles rol : loginTer.getRoleses())
        {
            int num = rol.getRolId();
            System.out.println("el numero: "+num);
            if (num == 1)
            {
                this.admin = true;
            } else if (num == 2)
            {
                this.usuario = true;
            } else if (num == 3)
            {
                this.cliente = true;
            }
        }
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml?faces-redirect=true";
    }

    public String getRolRequired()
    {
        return rolRequired;
    }

    public void setRolRequired(String rolRequired)
    {
        this.rolRequired = rolRequired;
    }

    public Tercero getLoginTer()
    {
        if (loginTer == null)
        {
            loginTer = new Tercero();
        }
        return loginTer;
    }

    public void setLoginTer(Tercero loginTer)
    {
        this.loginTer = loginTer;
    }

    public boolean isAdmin()
    {
        return admin;
    }

    public void setAdmin(boolean admin)
    {
        this.admin = admin;
    }

    public boolean isUsuario()
    {
        return usuario;
    }

    public void setUsuario(boolean usuario)
    {
        this.usuario = usuario;
    }

    public boolean isCliente()
    {
        return cliente;
    }

    public void setCliente(boolean cliente)
    {
        this.cliente = cliente;
    }
    
    
}
