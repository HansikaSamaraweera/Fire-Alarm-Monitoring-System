package com.example.rest.service;

import com.example.rest.model.Sensor;
import com.example.rest.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService{

    @Autowired
    private SensorRepository sensorRepository;

    public Sensor addSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public List<Sensor> getallSensor() {
        return sensorRepository.findAll();
    }

    public Sensor update(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public Sensor search(int id) {
        return sensorRepository.search( id);
    }


}
