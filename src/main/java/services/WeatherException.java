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
public class WeatherException extends Exception {
     public WeatherException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherException(String message) {
        super(message);
    }
}
