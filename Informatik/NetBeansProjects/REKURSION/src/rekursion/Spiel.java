/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekursion;

/**
 *
 * @author tom.pauly
 */
public class Spiel {

    private Würfel würfel;
    public Spiel(Würfel würfel){
        this.würfel = würfel;
    }
    public Würfel getWürfel(){
        return this.würfel;
    }
    public int addiereXIter(int x){
        int all = 0;
        for(int i = 0; i < x; i++){
            all += würfel.wuerfel();
        }
        return all;
    }
    public int addiereXRek(int x){
        if(x == 0){
            return 0;
        }
        int zahl = würfel.wuerfel();
        return zahl + addiereXRek(x-1);
    }
    public int maxFindenIter(int x){
        int max = 0;
        for(int i = 0; i < x; i++){
            int temp = würfel.wuerfel();
            if(temp > max){
                max = temp;
            }
        }
        return max;
    }
    public int maxFindenRek(int x){
        if(x == 0){
            return 0;
        }
        else{
            int zahl = würfel.wuerfel();
            int andereZahl = maxFindenRek(x - 1);
            if(zahl > andereZahl){
                return zahl;
            }
            else{
                return andereZahl;
            }
        }
    }
    public int gibXErgebnisseIter(int x){
        int finale = würfel.wuerfel();
        for(int i = 0; i < x - 1; i++){
            finale += würfel.wuerfel();
        }
        return finale;
    }
    public int gibXErgebnisseRek(int x){
        if(x == 0){
            return 0;
        }
        else{
            return Integer.parseInt(Integer.toString(x) + Integer.toString(x - 1));
        }
    }
}
