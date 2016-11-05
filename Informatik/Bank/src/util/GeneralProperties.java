package util;

import java.io.*;
import java.util.Properties;

public class GeneralProperties {
    private int kn;
    private String names[];
    private int am;

    public void outputStream(int kundennummer, String bankname) throws IOException{
        File knFile = new File(bankname + "kn.properties");
        if(!knFile.exists()){
            knFile.createNewFile();
        }
        Properties prop = new Properties();
        OutputStream out = new FileOutputStream(knFile);
        prop.setProperty("firstkn", String.valueOf(kundennummer));
        prop.store(out, "First KN of " + bankname);
        out.close();
    }
    public void inputStream(String bankname) throws IOException{
        File knFile = new File(bankname + "kn.properties");
        Properties prop = new Properties();
        InputStream in = new FileInputStream(knFile);
        if(in != null){
            prop.load(in);
        } else{
            throw new FileNotFoundException("File '" + knFile + "' not found!");
        }
        this.kn = Integer.valueOf(prop.getProperty("firstkn"));
        in.close();
    }
    public void nameInputStream() throws IOException{
        File nameFile = new File("banken.properties");
        Properties prop = new Properties();
        InputStream in = new FileInputStream(nameFile);
        if(in != null){
            prop.load(in);
        } else{
            throw new FileNotFoundException("File '" + nameFile + "' not found!");
        }
        am = Integer.valueOf(prop.getProperty("bankenanzahl"));
        names = new String[am];
        for(int i = 0; i < am; i++){
            names[i] = prop.getProperty("bankname"+ i);
        }
        in.close();
    }
    public void nameOutputStream(String names[], int am) throws IOException{
        File nameFile = new File("banken.properties");
        if(!nameFile.exists()){
            nameFile.createNewFile();
        }
        Properties prop = new Properties();
        OutputStream out = new FileOutputStream(nameFile);
        prop.setProperty("bankenanzahl", String.valueOf(am));
        for(int i = 0; i < am; i++){
            prop.setProperty("bankname"+ i, names[i]);
        }
        prop.store(out, "Banknamen");
        out.close();
    }

    //Getters
    public int getAm() {
        return am;
    }
    public String getNames(int stelle) {
        return names[stelle];
    }

    public int getKn(){
        return this.kn;
    }
}
