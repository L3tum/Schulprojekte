/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tom.pauly
 */
public class Buchhaendler {
    public List<BUCH> buecher = new ArrayList<BUCH>();


    public Buchhaendler(){
        for(int i = 0; i < 50; i++){
            this.buecher.add(new BUCH(Util.sendGet(), Util.sendGet(), Util.sendGet()));
        }
    }

}
