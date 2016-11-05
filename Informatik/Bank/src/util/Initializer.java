package util;

import java.io.IOException;

public class Initializer {
    private String names[];
    public void initialize(){
        GeneralProperties gen = new GeneralProperties();
        try{
            gen.nameInputStream();
            names = new String[gen.getAm()];
            for(int i = 0; i < gen.getAm(); i++){
                names[i] = gen.getNames(i);
            }
            for (int i = 0;i < gen.getAm(); i++) {
                gen.inputStream(names[i]);
            } // end of for
        } catch(IOException i) {
            i.printStackTrace();
        }
    }
}
