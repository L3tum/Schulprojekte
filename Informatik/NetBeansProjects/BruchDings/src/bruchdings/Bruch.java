/**
 *
 * @author tom.pauly
 */
public class Bruch {
  private int nenner;
  private int zaehler;
  
  public Bruch(int zaehler, int nenner){
    this.nenner = nenner;
    this.zaehler = zaehler;
  }
  public int getNenner(){
    return this.nenner;
  }
  
  public int getZaehler(){
    return this.zaehler;
  }
  
  public void setZaehler(int nz){
    zaehler = nz;
  }
  public void setNenner(int nn){
    nenner = nn;
  }
  public double gibDezimalzahl(){
    return zaehler/nenner;
  }
  public String gibTextausgabe(){
    return zaehler+"|"+nenner;
  }
  public void erweitern(int zahl){
    zaehler *= zahl;
    nenner *= zahl;
  }
  public void kuerzen(){
    int a = gGT(nenner, zaehler);
    zaehler /= a;
    nenner /= a;
  }
  public int gGT(int x, int y) {
    //Use absolute values to correctly compute negative values
    int a = java.lang.Math.abs(x);
    int b = java.lang.Math.abs(y);
    int r;
    while (b != 0) {
      r = a % b;
      a = b;
      b = r;
    }
    return a;
  }
}