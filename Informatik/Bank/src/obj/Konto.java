package obj;

public class Konto {
    private String iban;
    private int guthaben;
    private int zinsen;
    private int kontoNummer;
    Konto(String iban, int zinsen, int guthaben, int kontoNummer){
        this.iban = iban;
        this.zinsen = zinsen;
        this.guthaben = guthaben;
        this.kontoNummer = kontoNummer;
    }
    public void einzahlen(int betrag){
        this.guthaben = this.guthaben + betrag;
        System.out.println("Einzahlung erfolgreich!\n Ihr Guthaben beträgt nun " + this.guthaben + " Euro");
    }
    public void auszahlen(int betrag){
        if((this.guthaben - betrag) < 0 ){
            System.out.println("Sie haben nicht genug Geld auf ihrem Konto!");
        } else {
            this.guthaben = this.guthaben - betrag;
            System.out.println("Auszahlung erfolgreich!\n Ihr Guthaben beträgt nun " + this.guthaben + " Euro");
        }
    }

    //Setters
    public void setZinsen(int zinsen){
        this.zinsen = zinsen;
    }
    public void zinsenBerechnen(){
        this.guthaben = this.guthaben * (this.zinsen / 100);
        System.out.println("Zinsen wurden addiert!\n Ihr Guthaben beträgt nun " + this.guthaben + " Euro");
    }

    //Getters
    public String getIban(){
        return this.iban;
    }
    public int getGuthaben(){
        return this.guthaben;
    }
    public int getZinsen(){
        return this.zinsen;
    }
    public int getKontoNummer() {
        return kontoNummer;
    }
}
