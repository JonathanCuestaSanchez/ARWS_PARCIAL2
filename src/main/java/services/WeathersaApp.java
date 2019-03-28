/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author 2118270
 */
public interface WeathersaApp {
     String getCityWeather(String city) throws  WeatherException;
}
