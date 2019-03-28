/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;
import services.WeatherException;

/**
 *
 * @author 2118270
 */
public class InMemoryPersistence implements Persistence {
    private ConcurrentHashMap<String,String> requests=new ConcurrentHashMap<>();

    public InMemoryPersistence(){
    }

    @Override
    public String getCityWeather(String city) throws WeatherException {
        if(!requests.containsKey(city)){
            try {
                requests.put(city,Weather.getCityWeather(city));
            } catch (IOException e) {
                throw new WeatherException("no found");
            }
        }
        return requests.get(city);
    }
    public void manejadorCache(){
        //se necesita de un hilo no lo implemento por cuestiones de tiempo
        Calendar fecha = Calendar.getInstance();
        int minuto = fecha.get(Calendar.MINUTE);
        int cont=0;
        boolean br=true;
        while (br){
            if(minuto!=fecha.get(Calendar.MINUTE)){
                cont++;
                if(cont>5){
                    requests=new ConcurrentHashMap<>();
                    br=false;
                }

            }
        }
        manejadorCache();
    }
}
