/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import services.WeatherException;
import services.WeathersaApp;

/**
 *
 * @author 2118270
 */

@RestController
public class WeatherControl {
    @Autowired
    WeathersaApp service;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/weather/{city}")
    @ResponseBody
    public ResponseEntity<?> getCityWeather (@PathVariable("city") String city) {
        try {
            String values=service.getCityWeather(city);

            return new ResponseEntity<>(values, HttpStatus.ACCEPTED);

        }catch (WeatherException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
}
