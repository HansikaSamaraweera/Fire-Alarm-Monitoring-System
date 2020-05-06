
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hansi
 */
public class LoginImplement extends UnicastRemoteObject implements LoginInterface{

    public LoginImplement()throws RemoteException{
        
    }
    
    @Override
    public boolean getlogin(String user, String pass) throws RemoteException {
       boolean match = false;
       
       try{
           if(user.equals("admin")&& pass.equals("admin")){
               return match = true;
           }else{
               return match = false;
           }
           
       }catch(Exception e){
           e.printStackTrace();
       }
       return match;
       
    }

    
    
}
