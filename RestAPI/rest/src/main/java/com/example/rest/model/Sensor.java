package com.example.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sensorId;
    String roomNo;
    String floorNo;
    double coLevel;
    double smokeLevel;

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public Sensor() {
    }

    public double getCoLevel() {
        return coLevel;
    }

    public void setCoLevel(double coLevel) {
        this.coLevel = coLevel;
    }

    public double getSmokeLevel() {
        return smokeLevel;
    }

    public void setSmokeLevel(double smokeLevel) {
        this.smokeLevel = smokeLevel;
    }


}
