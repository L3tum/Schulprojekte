package obj;

import java.util.ArrayList;
import java.util.List;

public class BankenGewerkschaft {
    private List<Bank> myList = new ArrayList<Bank>();
    private int bankenanzahl;

    public void bankErstellen(int blz, int geld, String fueher, String name){
        myList.add(blz, new Bank(blz, geld, fueher, name));
        bankenanzahl++;
    }

    //Getters
    public List<Bank> getMyList() {
        return myList;
    }

    public int getBankenanzahl() {
        return bankenanzahl;
    }
}
