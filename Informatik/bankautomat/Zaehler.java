/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankautomat;

/**
 *
 * @author tom.pauly
 */
public class Zaehler {
    String am = "10000";
    
    public String getAm(){
       int a = Integer.getInteger(am);
       a++;
       am = String.valueOf(a);
       return am;
    }
}
