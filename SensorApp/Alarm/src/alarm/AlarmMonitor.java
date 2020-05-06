package alarm;

import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AlarmMonitor extends UnicastRemoteObject implements
		AlarmListener, Runnable {

	private int count = 0;
        private int count1 =0;

	//This method isfor monitoring CO2 and Smoke
	public AlarmMonitor() throws RemoteException {
	}

	public static void main(String[] args) {

	   System.setProperty("java.security.policy", "file:allowall.policy");
 

		try {
			Registry reg=LocateRegistry.getRegistry(9998);

			Remote remoteService = reg.lookup("hi server");
			TemperatureSensor sensor = (TemperatureSensor) remoteService;
			double reading1 = sensor.getCo2();
			System.out.println("Original CO2 : " + reading1);
                        double reading2 = sensor.getSmoke();
			System.out.println("Original Smoke : " + reading2);
			AlarmMonitor monitor = new AlarmMonitor();

			//Adding the method call to register the listener in the server object
			sensor.addAlarmListener(monitor);

			monitor.run();
		} catch (RemoteException re) {
		} catch (NotBoundException nbe) {
		}
	}

	//get a system output when the CO2 changes
	public void Co2Changed(double Co2)
			throws java.rmi.RemoteException {
		System.out.println("\nCo2 change event : " + Co2);
		count = 0;
	}
        
        public void SmokeChanged(double Smoke)
			throws java.rmi.RemoteException {
		System.out.println("\nSmoke change event : " + Smoke);
		count1 = 0;
	}

	public void run() {
		for (;;) {
			count++;
                        count1++;

		// note that this might only work on windows console
			//System.out.print("\r" + count);
                        //System.out.print("\r" + count1);
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
			}

		}

	}
}