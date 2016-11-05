/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoprojekt;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author tim.goeller
 */
public class AutoProjekt {

    private static GUI gui;
    static Autohaendler ah;
    static int carsInMarketCount = 30;
    static List<Auto> carsMarket = new ArrayList<Auto>();
    private static final String USER_AGENT = "Java Application";

    public static void main(String[] args) throws Exception {
        ah = new Autohaendler(new ArrayList<Auto>(), 900000, sendGet() + " Autohandel's GmbH");
        for(int i = carsInMarketCount; i != 0; i--) {
            carsMarket.add(new Auto(sendGet(), (int)(Math.random() * 10), (int)(Math.random() * 1000), (int)(Math.random() * 100), sendGet(), (int)(Math.random() * 100000), sendGet()));
        }
        gui = new GUI(ah);
        gui.setVisible(true);
        
        
    }
    
    private static String sendGet() throws Exception {

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
}
