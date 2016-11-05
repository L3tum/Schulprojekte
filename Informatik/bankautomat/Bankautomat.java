/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankautomat;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

import java.util.Scanner;

/**
 *
 * @author Letum
 */
public class Bankautomat {
    
    Scanner sc = new Scanner(System.in);
    Zaehler za = new Zaehler();
    List<Kunde> kunden = new ArrayList<>();
    public static void main(String[] args) {

    }
    public void create(){
        String name;
        String vorname;
        String geb;
        System.out.println("Bitte Nachnamen eingeben!");
        name = sc.next();
        System.out.println("Bitte Vornamen eingeben!");
        vorname = sc.next();
        System.out.println("Bitte Geburtsdatum in dd.mm.yyyy eingeben!");
        geb = sc.next();
        String kn = za.getAm();
        int k = Integer.getInteger(kn);
        kunden.add(k, new Kunde(vorname, name, geb, kn));
     }
    public void anmelden(){
        System.out.println("Bitte geben Sie ihre Kundennummer ein!");
        int tmp = sc.nextInt();
        int ub = Integer.getInteger(kunden.get(tmp).getKN());
        if(ub == tmp){
            System.out.println("Sie haben sich angemeldet!");
        }
        else{
            System.out.println("Falsche Kundennummer!");
            anmelden();
        }
        
    }
}
