package com.kafka.driver.controller;

import com.kafka.driver.service.CabLocationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {
    @Autowired
    private CabLocationService cabLocationService;


    @PutMapping
    public ResponseEntity<Object> updateLocation(){
        int range=100;
        while(range > 0){
//            System.out.println(Math.random() + " , "+ Math.random());
            cabLocationService.updateLocation(Math.random() + " , "+ Math.random());
            range--;

        }
        return new ResponseEntity<>(Map.of("message", "Location updated"),HttpStatus.OK);
    }

}
