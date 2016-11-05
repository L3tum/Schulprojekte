/**
 *
 * @author tom.pauly
 */
public class Bruchrechner {
  public Bruchrechner(){
    
  }
  public Bruch addiereBruch(Bruch bruch1, Bruch bruch2){
    Bruch bruch = new Bruch((bruch1.getZaehler() * bruch2.getNenner()) + (bruch2.getZaehler() * bruch1.getNenner()), (bruch1.getNenner() * bruch2.getNenner()));
    
    return bruch;
  }
  public Bruch subtrahiereBruch(Bruch bruch1, Bruch bruch2){
    Bruch bruch = new Bruch((bruch1.getZaehler() * bruch2.getNenner()) - (bruch2.getZaehler() * bruch1.getNenner()), (bruch1.getNenner() * bruch2.getNenner()));
    return bruch;
  }
  public Bruch multipliziereBruch(Bruch bruch1, Bruch bruch2){
    Bruch bruch = new Bruch(0,0);
    bruch.setZaehler(bruch1.getZaehler() * bruch2.getZaehler());
    bruch.setNenner(bruch1.getNenner() * bruch2.getNenner());
    return bruch;
  }
  public Bruch dividiereBruch(Bruch bruch1, Bruch bruch2){
    Bruch bruch = new Bruch(0,0);
    bruch.setZaehler(bruch1.getZaehler() * bruch2.getNenner());
    bruch.setNenner(bruch1.getNenner() * bruch2.getZaehler());
    return bruch;
  }
}
