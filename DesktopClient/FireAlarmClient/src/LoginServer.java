/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hansi
 */
public class LoginServer {
    
    public static void main(String[] args){
        
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            LoginImplement lp = new LoginImplement();
            reg.rebind("login", lp);
            System.out.println("Sever is ready");
            
        } catch (RemoteException ex) {
            Logger.getLogger(LoginServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
