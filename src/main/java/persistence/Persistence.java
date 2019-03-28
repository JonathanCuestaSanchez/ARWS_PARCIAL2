/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import services.WeatherException;

/**
 *
 * @author 2118270
 */
public interface Persistence {
    String getCityWeather(String City) throws  WeatherException;
    void manejadorCache();
}
