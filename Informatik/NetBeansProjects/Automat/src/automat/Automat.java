/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

/**
 *
 * @author tom.pauly
 */
class Automat {
      //Attribute
      private int zustand = 0;
      private final int ENDZUSTAND = 10;
      //Konstruktor
      public Automat () {
      }
      //Methode zustandWechseln -> private! Kein Rückgabewert, erwartet ein Zeichen (char)
      private void zustandWechseln(char eingabe) {
          switch (zustand) {
             case 0: {
               switch (eingabe) {
                 case '#' : {zustand=11;} break;
                 case '-' : {zustand=0;} break;
                 case '.' : {zustand=0;} break;
               }
             } break;
             case 11: {
               switch (eingabe) {
                 case '#' : {zustand=11;} break;
                 case '-' : {zustand=0;} break;
                 case '.' : {zustand=1;} break;
               }
             } break;
             case 1: {
               switch (eingabe) {
                 case '#' : {zustand=11;} break;
                 case '-' : {zustand=0;} break;
                 case '.' : {zustand=2;} break;
               }
             } break;
                 case 2: {
               switch (eingabe) {
                 case '#' : {zustand=11;} break;
                 case '-' : {zustand=0;} break;
                 case '.' : {zustand=3;} break;
               }
             } break;
                     case 3: {
               switch (eingabe) {
                 case '#' : {zustand=11;} break;
                 case '-' : {zustand=4;} break;
                 case '.' : {zustand=0;} break;
               }
             } break;
                         case 4: {
               switch (eingabe) {
                 case '#' : {zustand=11;} break;
                 case '-' : {zustand=5;} break;
                 case '.' : {zustand=0;} break;
               }
             } break;
                             case 5: {
               switch (eingabe) {
                 case '#' : {zustand=11;} break;
                 case '-' : {zustand=6;} break;
                 case '.' : {zustand=0;} break;
               }
             } break;
                                 case 6: {
               switch (eingabe) {
                 case '#' : {zustand=11;} break;
                 case '-' : {zustand=0;} break;
                 case '.' : {zustand=7;} break;
               }
             } break;
                                     case 7: {
               switch (eingabe) {
                 case '#' : {zustand=11;} break;
                 case '-' : {zustand=0;} break;
                 case '.' : {zustand=8;} break;
               }
             } break;
                                         case 8: {
               switch (eingabe) {
                 case '#' : {zustand=11;} break;
                 case '-' : {zustand=0;} break;
                 case '.' : {zustand=9;} break;
               }
             } break;
                                             case 9: {
               switch (eingabe) {
                 case '#' : {zustand=10;} break;
                 case '-' : {zustand=0;} break;
                 case '.' : {zustand=0;} break;
               }
             } break;
          }
      }
      //Methode wortuntersuchen -> Rückgabewert boolean, erwartet einen String
      public String wortUntersuchen(String text) {
         for(int i=0; i< text.length(); i++) {
            zustandWechseln(text.charAt(i));
         }
         String back = "";
         if(zustand==ENDZUSTAND) {
           back = "ALARM ALARM";
         }
         zustand = 0;
         return back;
      }
}
