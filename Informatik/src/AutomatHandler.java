import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutomatHandler {
    Scanner sc = new Scanner(System.in);
    List<Konto> bank = new ArrayList<Konto>();
    FileHandler fileHandler = new FileHandler();
    int pass = 123;
    public int nummern = fileHandler.getNummern();

    public void init(){
        FileHandler handler = new FileHandler();
        handler.loadConfig();
        int i,b;
        i = 0;
        b = 0;
        int pass;
        int haben;
        int nummer;
        int n;
        System.out.println(nummern);
        if(i < nummern) {
            for (i = 0; i < nummern; i++) {
                pass = fileHandler.getPass(b);
                haben = fileHandler.getGuthaben(b);
                nummer = fileHandler.getNummer(b);
                bank.add(nummer, new Konto());
                bank.get(b).setPass(pass);
                bank.get(b).setHaben(haben);
                b++;
            }
        }
    }

    public void erstellen(){
        init();
        int a,b;
        int opNummer = 0;
        double haben= 0.0;
        bank.add(nummern, new Konto());
        bank.get(nummern).setPass(pass);
        bank.get(nummern).setHaben(haben);
        System.out.println("Deine Kontonummer ist: " + nummern + ", merke sie dir gut!");
        System.out.println("Deine Kundennummer ist: "+opNummer+". Sie ist nicht so wichtig, " +
                "merke sie dir trotzdem, sie könnte hilfreich sein!");
        System.out.println("Bitte gebe ein Passwort ein!");
        a = sc.nextInt();
        System.out.println("A = "+a);
        System.out.println("Bitte bestätige das Passwort durch eine erneute Eingabe!");
        b = sc.nextInt();
        System.out.println("B = "+b);
        if(a == b){
            bank.get(nummern).setPass(a);
            System.out.println("Passwort erfolgreich gesetzt!");
            System.out.println("Bitte Kundennummer eingeben!");
            opNummer = sc.nextInt();
            bank.get(nummern).setOpNummer(opNummer);
            System.out.println("Nummer erstellen = "+opNummer);
            nummern++;
            speichern();
        }
        else{
            System.out.println("Passwort falsch!");
            bank.remove(nummern);
            String[] args = null;
            Bankautomat.main(args);
        }
    }

    public void einzahlen(){
        init();
        int a,i;
        double b,d;
        System.out.println("Bitte geben Sie ihre Kontonummer ein!");
        i = sc.nextInt();
        System.out.println("Bitte geben Sie den Betrag ein!");
        d = sc.nextDouble();
        b = bank.get(i).getHaben();
        b = b+d;
        bank.get(i).setHaben(b);
        System.out.println("Guthaben eingezahlt!");
        speichern();
    }

    public void auszahlen(){
        init();
        int a,b,c,i;
        double d,e;
        System.out.println("Bitte geben Sie ihre Kontonummer ein!");
        a = sc.nextInt();
        d = bank.get(a).getHaben();
        i = bank.get(a).getPass();
        System.out.println("Bitte geben Sie ihr Passwort ein!");
        b = sc.nextInt();
        if(b == i){
            System.out.println("Sie haben noch: "+d+"€ Guthaben!");
            System.out.println("Bitte geben Sie den gewünschten Betrag ein!");
            e = sc.nextDouble();
            if(e <= d){
                d = d-e;
                bank.get(a).setHaben(d);
                System.out.println("Sie haben nun noch: "+d+"€ Guthaben!");
                speichern();
            }
            else{
                System.out.println("Sie haben zu wenig Guthaben!");
                String[] args = null;
                Bankautomat.main(args);
            }
        }
        else{
            System.out.println("PASSWORT FALSCH!");
            String[] args = null;
            Bankautomat.main(args);
        }
    }

    public void ueberweisen(){
        init();
        int a,b,c,i;
        double d,e,f,g;
        System.out.println("Bitte geben Sie ihre Kontonummer ein!");
        a = sc.nextInt();
        System.out.println("Bitte geben Sie ihr Passwort ein!");
        c = sc.nextInt();
        i = bank.get(a).getPass();
        if(c == i) {
            System.out.println("Bitte gebe Sie dir Kontonummer des Empfängers ein!");
            b = sc.nextInt();
            d = bank.get(a).getHaben();
            System.out.println("Bitte geben Sie den Betrage ein! Sie haben noch: " + d + "€ Guthaben!");
            e = sc.nextDouble();
            if(e <= d){
                f = bank.get(b).getHaben();
                f = f+e;
                bank.get(b).setHaben(f);
                d = d-e;
                bank.get(a).setHaben(d);
                System.out.println("Tranksaktion geglückt!");
                speichern();
            }
            else{
                System.out.println("Sie haben zu wenig Guthaben!");
                String[] args = null;
                Bankautomat.main(args);
            }
        }
        else{
            System.out.println("PASSWORT FALSCH!");
            String[] args = null;
            Bankautomat.main(args);
        }
    }

    public void hacken(){
        init();
        int a,b,c,i;
        double d,e,f;
        System.out.println("Bitte geben Sie ihre Kontonummer ein!");
        a = sc.nextInt();
        System.out.println("Bitte geben Sie das Adminpasswort ein!");
        b = sc.nextInt();
        c = fileHandler.getAdminPass();
        //System.out.println("Nummer = "+c);
        if( c == b) {
            for (i = 0; i < nummern; i++) {
                if (a != i) {
                    e = bank.get(i).getHaben();
                    bank.get(i).setHaben(0);
                    d = bank.get(a).getHaben();
                    f = d + e;
                    bank.get(a).setHaben(f);
                }
            }
        }
        else{
            System.out.println("FALSCH!");
            String[] args = null;
            Bankautomat.main(args);
        }
        speichern();
    }

    public void speichern(){
        File file = new File("zahlen.txt");
        File file2 = new File("backup.txt");
        file.getAbsolutePath();
        file2.getAbsolutePath();
        file.delete();
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            int i,c;
            String g;
            c = 1;
            String[] details;
            details = new String[nummern*4+2];
            details[0] = String.valueOf(nummern);
            //System.out.println("Nummern = "+nummern);
            for(i = 0; i < nummern;i++){
                g = String.valueOf(i);
                details[c] = g;
                c++;
                g = String.valueOf(bank.get(i).getPass());
                details[c] = g;
                c++;
                g = String.valueOf(bank.get(i).getHaben());
                details[c] = g;
                c++;
            }
            BufferedWriter wr = new BufferedWriter(new FileWriter(file));
            for(i = 0; i < nummern*4+1;i++){
                //System.out.println("Detail["+i+"] = "+details[i]);
                wr.write(details[i]);
                wr.write(";");
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
            for(i = 0;i < nummern*3+1;i++){
                writer.write(details[i]);
                writer.write(";");
            }
            wr.close();
            writer.close();
            String[] args = null;
            Bankautomat.main(args);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}