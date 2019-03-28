/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author 2118270
 */
class Weather {
     private static final String USER_AGENT = "Mozilla/5.0";    
    public static String getCityWeather(String city) throws IOException {
        
        return HttpRequert("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=121f0956f479fc5a1895208ed234589b");

    }
  
    private static String HttpRequert(String request) throws IOException{
        String GET_URL = request;
        String value;
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            value=response.toString();
            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
            value="Error no se puedo";
        }
        return value;

    }
}
