public class Buch{
  String titel, autor, ISBN;
  int anzahl, preis;
  
  public Buch(String titel, String autor, String ISBN){
    this.titel = titel;
    this.autor = autor;
    this.ISBN = ISBN;
    this.anzahl = 1;
    this.preis = 1;

  }
  
  public int getAnzahl(){
    return this.anzahl;
  }
  public int getPreis(){
    return this.preis;
  }
    public String getTitel(){
    return this.titel;
  }
    public String getAutor(){
    return this.autor;
  }
  public String getISBN(){
    return this.ISBN;
  }
  
    public void setPreis(int preis){
    this.preis = preis;
  }
  
  public void setAnzahl(int anz){
    this.anzahl = anz;
  }

}