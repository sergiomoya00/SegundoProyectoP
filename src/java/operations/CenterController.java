/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import bean.center;
import bean.login;
import com.opensymphony.xwork2.ActionSupport;
import dao.CenterDAO;
import dao.UserDAO;
import java.util.List;


/**
 *
 * @author jabre
 */
public class CenterController extends ActionSupport {

    
    private center center=new center();
    private List<center> list;
    
    @Override
    public String execute(){
    CenterDAO usuario=new CenterDAO();
    usuario.centerRegister(center);
    
    return SUCCESS;
    }
    
    public String getAllCenters(){
    CenterDAO usuario=new CenterDAO();
    this.list=usuario.getAllCenters();
    return SUCCESS;
    }
    
    public center getCenter() {
        return center;
    }

    public void setCenter(center center) {
        this.center = center;
    }
    public List<center> getList() {
        return list;
    }

    public void setList(List<center> list) {
        this.list = list;
    }
    
    
}
