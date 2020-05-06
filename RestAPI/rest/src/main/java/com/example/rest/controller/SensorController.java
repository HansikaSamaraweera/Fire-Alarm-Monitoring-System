package com.example.rest.controller;

import com.example.rest.model.Sensor;
import com.example.rest.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/sensor")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping(value = "/addsensor")
    public Sensor addSensor(@RequestBody Sensor sensor){
        return sensorService.addSensor(sensor);
    }

    @GetMapping(value = "/getsensor")
    public List<Sensor> getallSensor(){
        return sensorService.getallSensor();
    }

    @PostMapping(value = "/update")
    public Sensor update(@RequestBody Sensor sensor){
        return  sensorService.update(sensor);
    }
    @GetMapping(value ="/search/{id}")
    public Sensor search(@PathVariable int id){
        return sensorService.search(id);
    }


}
