package alarm;


public interface TemperatureSensor extends java.rmi.Remote
{
	public double getCo2() throws
		java.rmi.RemoteException;
        public double getSmoke() throws
		java.rmi.RemoteException;
	public void addAlarmListener
		(AlarmListener listener )
		throws java.rmi.RemoteException;
	public void removeAlarmListener
		(AlarmListener listener )
		throws java.rmi.RemoteException;
                
}
