/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import bean.center;
import bean.login;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.CenterDAO;
import dao.UserDAO;

/**
 *
 * @author jabre
 */
public class LoginController extends ActionSupport {

    private login login = new login();

    @Override
    public String execute() {
        UserDAO usuario = new UserDAO();
        
        return usuario.logIn(login);
    }
    
    public login getLogin() {
        return login;
    }

    public void setLogin(login login) {
        this.login = login;
    }



}
