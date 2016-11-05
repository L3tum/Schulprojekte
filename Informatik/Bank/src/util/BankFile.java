package util;

import obj.Bank;
import obj.Kunde;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BankFile {
    GeneralProperties gen = new GeneralProperties();

    //Kunden fuer inputStream
    private int kns[];
    private String bday[];
    private String geschlecht[];
    private String land[];
    private String iban[][];
    private int zinsen[][];
    private int guthaben[][];
    private int kontenAnzahl[];
    private int kontoNummer[][];

    //Bank fuer inputStream
    private int size;
    private int blz;
    private double geld;
    private String fueher;
    private String name;
    private List<Kunde> myList = new ArrayList<Kunde>();

    public void outputStream(Bank bank) throws IOException{
        Properties prop = new Properties();
        File fileName = new File(bank.getName() + ".properties");
        if(!fileName.exists()){
            fileName.createNewFile();
        }
        OutputStream out = new FileOutputStream("/cfg/" +fileName);
        prop.setProperty("bankname", bank.getName());
        prop.setProperty("blz", String.valueOf(bank.getBankleitzahl()));
        prop.setProperty("kundenAnzahl", String.valueOf(bank.getKundenAnzahl()));
        prop.setProperty("geld", String.valueOf(bank.getGeld()));
        prop.setProperty("fueher", bank.getFuehrer());

        for(int i = gen.getKn(); i < bank.getKundenAnzahl(); i++){
            prop.setProperty("kundennummer" + i, String.valueOf(bank.getMyList().get(i).getKn()));
            prop.setProperty("bday" + i, String.valueOf(bank.getMyList().get(i).getBday()));
            prop.setProperty("geschlecht" + i, bank.getMyList().get(i).getGeschlecht());
            prop.setProperty("land" + i, bank.getMyList().get(i).getLand());
            prop.setProperty("kontenAnzahl" + i, String.valueOf(bank.getMyList().get(i).getKontenAnzahl()));
            for(int o = 0; o < bank.getMyList().get(i).getKontenAnzahl(); o++) {
                prop.setProperty("kontoNummer" + i + o, String.valueOf(bank.getMyList().get(i).getMyList().get(o).getKontoNummer()));
                prop.setProperty("iban" + i + o, bank.getMyList().get(i).getMyList().get(o).getIban());
                prop.setProperty("zinsen" + i + o, String.valueOf(bank.getMyList().get(i).getMyList().get(o).getZinsen()));
                prop.setProperty("guthaben" + i + o, String.valueOf(bank.getMyList().get(i).getMyList().get(o).getGuthaben()));
            }
        }
        prop.store(out, "Propertyfile der Bank " + bank.getName());
        out.close();
    }

    public void inputStream(String bankname) throws IOException{
        Properties prop = new Properties();
        File fileName = new File(bankname + ".properties");
        InputStream in = getClass().getClassLoader().getResourceAsStream("/cfg/" + fileName);
        if(in != null){
            prop.load(in);
        } else{
            throw new FileNotFoundException("File '" + fileName + "' not found!");
        }

        this.blz = Integer.valueOf(prop.getProperty("blz"));
        this.size = Integer.valueOf(prop.getProperty("kundenAnzahl"));
        this.geld = Double.parseDouble(prop.getProperty("geld"));
        this.fueher = prop.getProperty("fueher");
        this.name = prop.getProperty("bankname");

        this.kns = new int[size];
        this.bday = new String[size];
        this.geschlecht = new String[size];
        this.land = new String[size];
        this.iban = new String[size][100];
        this.zinsen = new int[size][100];
        this.guthaben = new int[size][100];
        this.kontenAnzahl = new int[size];
        this.kontoNummer = new int[size][100];

        for(int i = 0; i < this.size; i++){
            kontenAnzahl[i] = Integer.valueOf(prop.getProperty("kontenAnzahl" + i));
        }

        for(int i = 0; i < this.size; i++){
            this.kns[i] = Integer.valueOf(prop.getProperty("kundennummer" + i));
            this.bday[i] = prop.getProperty("bday" + i);
            this.geschlecht[i] = prop.getProperty("geschlecht" + i);
            this.land[i] = prop.getProperty("land" + i);
            for(int o = 0; o < kontenAnzahl[i]; o++){
                this.iban[i][o] = prop.getProperty("iban" + i + o);
                this.zinsen[i][o] = Integer.valueOf(prop.getProperty("zinsen" + i + o));
                this.guthaben[i][o] = Integer.valueOf(prop.getProperty("guthaben" + i + o));
                this.kontoNummer[i][o] = Integer.valueOf(prop.getProperty("kontoNummer" + i + o));
            }
        }
        in.close();

        for(int i = 0; i < size; i++){
            this.myList.add(kns[i], new Kunde(bday[i], kns[i], geschlecht[i], land[i], iban[i][0], zinsen[i][0], guthaben[i][0], kontoNummer[i][0]));
            if(iban[i].length > 1){
                for(int o = 0; o < iban[i].length; o++) {
                    this.myList.get(i).addKonto(iban[i][o], zinsen[i][o], guthaben[i][o], kontoNummer[i][o]);
                }
            }
        }
    }

    //Getters
    public List<Kunde> getList(){
        return this.myList;
    }

    public double getGeld() {
        return this.geld;
    }

    public int getBlz() {
        return this.blz;
    }

    public int getSize() {
        return this.size;
    }

    public String getFueher() {
        return this.fueher;
    }

    public String getName() {
        return this.name;
    }
}
