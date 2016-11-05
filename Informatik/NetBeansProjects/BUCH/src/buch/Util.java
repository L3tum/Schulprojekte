/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author tom.pauly
 */
public class Util {
    
    private static final String USER_AGENT = "Java Application";
    
    public static String sendGet() {

                try{
		String url = "http://pleaseinsult.me/api?severity=extreme";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
                

		//print result
		return response.substring(12).replaceAll("severity", "").replaceAll("extreme", "").replaceAll(":", "").replaceAll("}", "").replace('"', ' ').replace(',', ' ');

                }
                catch(Exception e){
                    return e.toString();
                }
	}
}
