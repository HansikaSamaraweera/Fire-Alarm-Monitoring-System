package alarm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlarmSensorServer extends UnicastRemoteObject implements TemperatureSensor, Runnable {

	private volatile double CO2;
        private volatile double Smoke;
	private ArrayList<AlarmListener> list = new ArrayList<AlarmListener>();

	//Set CO2 and Smoke in the constructor
	public AlarmSensorServer() throws java.rmi.RemoteException {
		CO2 = 4.0;
                Smoke = 5.0;
	}
	
	//This method will return C02 level
	public double getCo2() throws java.rmi.RemoteException {
		return CO2;
	}
        
        //This method will return Smoke level
	public double getSmoke() throws java.rmi.RemoteException {
		return Smoke;
	}
        

	//This method is for Registering listners
	public void addAlarmListener(AlarmListener listener)
			throws java.rmi.RemoteException {
		System.out.println("adding listener -" + listener);
		list.add(listener);
	}

	//This method is for Removing Registered listners
	public void removeAlarmListener(AlarmListener listener)
			throws java.rmi.RemoteException {
		System.out.println("removing listener -" + listener);
		list.remove(listener);
	}

	//This method is use to Set the thread
	public void run() {
		Random r = new Random();
		for (;;) {
			try {
				// Sleep for a random amount of time
				int duration = r.nextInt() % 10000 + 200;
				// Check to see if negative, if so, reverse
				if (duration < 0) {
					duration = duration * -1;
					Thread.sleep(duration);
				}
			} catch (InterruptedException ie) {
			}

			// Get a number, to see if CO2 and Smoke goes up or down
			int num = r.nextInt();
			if (num < 0) {
				CO2 += 0.5;
                                Smoke += 0.5;
			} else {
				CO2 -= 0.5;
                                Smoke -= 0.5;
			}

			// Notify registered listeners
			try {
				notifyListeners();
                                updateSensor(Smoke, CO2);
                                if(Smoke > 5 || CO2 > 5){
//                                    sendEmail("2");
                                }
                                
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
                 
	}

	private void notifyListeners() throws RemoteException {
		// Notifing  
		 for(AlarmListener e : list){
			  e.Co2Changed(CO2);
                          e.SmokeChanged(Smoke);
		 }
	}

	public static void main(String[] args) {

	   System.setProperty("java.security.policy", "file:allowall.policy");
 

		System.out.println("Loading Alarm service");

		try {
			AlarmSensorServer sensor = new AlarmSensorServer();
			Registry reg=LocateRegistry.createRegistry(9998);
                        reg.rebind("hi server", sensor);

			Thread thread = new Thread(sensor);
			thread.start();
		} catch (RemoteException re) {
			System.err.println("Remote Error - " + re);
		} catch (Exception e) {
			System.err.println("Error - " + e);
		}

	}
        
        
        
        
        
        private void updateSensor(double smoke,double co2){
    
        try {
            
            URL myurl = new URL("http://localhost:8080/sensor/update");
            HttpURLConnection con = (HttpURLConnection)myurl.openConnection();
		con.setRequestMethod("POST");
		
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		
		con.setDoOutput(true);
                Sensor s = new Sensor();
                s.setSensorId(3);
                s.setFloorNo(10);
                s.setRoomNo(452);   
            
           String passingData = "{\"sensorId\": \""+s.getSensorId()+"\",\"floorNo\": \""+s.getFloorNo()+"\",\"roomNo\": \""+s.getRoomNo()+"\" ,\"smokeLevel\": \""+smoke+"\",\"coLevel\": \""+co2+"\" }";
           
            try(OutputStream os = con.getOutputStream()) {
            byte[] input = passingData.getBytes("utf-8");
            os.write(input, 0, input.length);           
            }
            
            int code = con.getResponseCode();
		System.out.println(code);
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))){
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
		}
          
            
            
        } catch (IOException ex) {
            Logger.getLogger(AlarmSensorServer.class.getName()).log(Level.SEVERE, null, ex);
        }
           

        }

        private void sendEmail(String id){
    
        try {
            
            URL myurl = new URL("http://localhost:8080/user/send");
            HttpURLConnection con12 = (HttpURLConnection)myurl.openConnection();
		con12.setRequestMethod("POST");
		
		con12.setRequestProperty("Content-Type", "application/json; utf-8");
		con12.setRequestProperty("Accept", "application/json");
		
		con12.setDoOutput(true);
            
            
           String passingData = "{\"id\": \""+id+"\"}";
           
            try(OutputStream os = con12.getOutputStream()) {
            byte[] input = passingData.getBytes("utf-8");
            os.write(input, 0, input.length);           
            }
            
            int code = con12.getResponseCode();
		System.out.println(code);
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(con12.getInputStream(), "utf-8"))){
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
                         
		}
          
//            checkStart=true;
            
        } catch (IOException ex) {
            Logger.getLogger(AlarmSensorServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}