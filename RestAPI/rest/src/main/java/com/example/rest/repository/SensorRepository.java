package com.example.rest.repository;

import com.example.rest.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SensorRepository extends JpaRepository<Sensor,String> {


    @Query(value = "from Sensor where sensorId=?1")
    Sensor search(int id);


}
