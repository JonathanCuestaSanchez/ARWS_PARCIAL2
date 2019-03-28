/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.Persistence;

/**
 *
 * @author 2118270
 */

@Service
public class WeatherAppP implements WeathersaApp{
     @Autowired
    Persistence persistence;
     
    @Override
    public String getCityWeather(String city) throws  WeatherException {
        return persistence.getCityWeather(city);
    }
}
