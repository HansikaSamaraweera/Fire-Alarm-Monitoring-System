
import java.rmi.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hansi
 */
public interface LoginInterface extends Remote {
    public boolean getlogin(String user,String pass)throws RemoteException;
    
}
