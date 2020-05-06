 

import javax.xml.bind.annotation.*;
 
@XmlRootElement(name = "sensor")
public class Sensor {

	 int sensorId;
	String roomNo;
	 String floorNo;
	 double coLevel;
	 double smokeLevel;
	 
	 @XmlElement
	public int getSensorId() {
		return sensorId;
	}
	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}
	
	@XmlElement
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	@XmlElement
	public String getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}
	@XmlElement
	public double getCoLevel() {
		return coLevel;
	}
	public void setCoLevel(double coLevel) {
		this.coLevel = coLevel;
	}
	@XmlElement
	public double getSmokeLevel() {
		return smokeLevel;
	}
	public void setSmokeLevel(double smokeLevel) {
		this.smokeLevel = smokeLevel;
	}
	 
	 
	 
}
