public class Fachbuch extends Buch{
  private String kategorie;
  
  public Fachbuch(String titel, String autor, String ISBN, String kategorie){
    super(String titel, String autor, String ISBN);
    this.kategorie = kategorie;
    }
  public String getKategorie(){
    return kategorie;
    }
  }