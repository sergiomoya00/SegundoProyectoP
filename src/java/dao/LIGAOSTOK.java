/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.login;

/**
 *
 * @author jabre
 */
public class LIGAOSTOK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CenterDAO u=new CenterDAO();
        login log=new login();
        
        log.setEmail("administrador");
        log.setPassword("administrador");
        
        
        System.out.print(u.getAllCenters().get(0));
        
        
        
        
    }
    
}
