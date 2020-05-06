/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarm;

/**
 *
 * @author Hansi
 */
 

import javax.xml.bind.annotation.*;
 
@XmlRootElement(name = "sensor")
public class Sensor {

	 int sensorId;
	 int roomNo;
	 int floorNo;
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
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	@XmlElement
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
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
