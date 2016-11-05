/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebungsarray;

import java.util.Random;

/**
 *
 * @author tom.pauly
 */
public class UebungsArray {

    private static int[] array;
   //Aufgabe 1 - ArrayFuellen
   public static int[] arrayFuellen(int laenge) {
     array = new int[laenge];
     Random rand = new Random();
     for(int i = 0; i < laenge; i++){
         array[i] = rand.nextInt(1000000000);
     }
     
     return array; //Diese Zeile muss gel�scht werden, wenn die Mthode komplett ist!
   }
   
   //Aufgabe 2 - ArrayAusgeben
   public static void arrayAusgeben(int[] tmp) {
       for(int i = 0; i < tmp.length; i++){
           System.out.println(tmp[i] + ",");
       }
       System.out.println();
   }
   
   //Aufgabe 3 - bestimmeMittelwert
   public static double bestimmeMittelwert(int[] tmp) {
     double summe = 0;
     for(int i = 0; i < tmp.length; i++){
         summe += tmp[i];
     }
     summe = summe / tmp.length;
     
     return summe; //Diese Zeile muss gel�scht werden, wenn die Mthode komplett ist!
   }
   
   //Aufgabe 4 - bestimmeMaximum
   public static int bestimmeMaximum(int[] tmp)  {
       int hilfe = 0;
       for(int i = 0; i < tmp.length; i++){
           if(tmp[i] > hilfe){
               hilfe = tmp[i];
           }
       }
     return hilfe; //Diese Zeile muss gel�scht werden, wenn die Mthode komplett ist!
   }
   
   //Aufgabe 4 - bestimmeMinimum
   public static int bestimmeMinimum(int[] tmp) {
     int hilfe = 0;
       for(int i = 0; i < tmp.length; i++){
           if(tmp[i] < hilfe){
               hilfe = tmp[i];
           }
       }
     return hilfe; //Diese Zeile muss gel�scht werden, wenn die Mthode komplett ist!
   }
   

    
   
   
   
   
   //Das Hauptprogramm
   public static void main(String[] args) {
     //Fuelle ein Array der L�nge 15 und speichere es in meinArray
     int[] meinArray = arrayFuellen(50000000);
     //Fuelle ein Array der L�nge 5 und speichere es in meinArray2
     int[] meinArray2 = arrayFuellen(5000000);
     
     //Ausgeben von Array meinArray und meinArray2
     arrayAusgeben(meinArray);
     arrayAusgeben(meinArray2);
     
     //Mittelwert von meinArray bestimmen, zwischenspeichern und ausgeben
     double speichern = bestimmeMittelwert(meinArray);
     System.out.println("Der Mittelwert lautet: "+speichern);
     
     //Maximum, Minimum von meinArray bestimmen und direkt ausgeben
     System.out.println("Der Maximum lautet: "+bestimmeMaximum(meinArray));
     System.out.println("Der Minimum lautet: "+bestimmeMinimum(meinArray));
     
     //Maximum, Minimum von meinArray2 bestimmen und direkt ausgeben
     System.out.println("Der Maximum lautet: "+bestimmeMaximum(meinArray2));
     System.out.println("Der Minimum lautet: "+bestimmeMinimum(meinArray2));
   }
}
