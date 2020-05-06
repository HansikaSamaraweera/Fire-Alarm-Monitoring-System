package alarm;

interface AlarmListener extends java.rmi.Remote
{
	//Remort methods
	public void Co2Changed(double CO2) throws java.rmi.RemoteException;
	public void SmokeChanged(double Smoke) throws java.rmi.RemoteException;
}
