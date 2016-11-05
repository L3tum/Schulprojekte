import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Rover extends Actor
{
    private Display anzeige;
    int times = 0;
    int times1 = 0;
    int times2 = 0;
    int times3 = 0;
    int timmes = 0;
    int savve[][];
    int stelle = 0;
    boolean fahren = true;
    boolean kit = false;
    public void act() 
    {
        try{
            World world = getWorld();
            steppedOn(world);
            Planet planet = new Planet();
            savve = new int[planet.getXP() * planet.getYP()][planet.getXP() * planet.getYP() * 2];
            boolean x = true;
            int numbers = 0;
            while(x && getFahren())
            {
                Actor kits = getOneIntersectingObject(Entschaerfungskit.class);
                if(getOneIntersectingObject(Entschaerfungskit.class)!=null){
                    anzeige.anzeigen("Entschärfungskit gefunden!");
                    Greenfoot.delay(1);
                    anzeige.anzeigen("Koordinaten: "+getX()+", "+getY());
                    world.removeObject(kits);
                    kit = true;
                }
                while(huegelVorhanden("vorne") && getFahren() && numbers <= 4)
                {
                    drehe("links");
                    numbers++;
                }
                if(numbers > 4){
                    dreheRechts(2);
                }
                if(gesteinVorhanden() && getFahren()){
                    savve[stelle][0] = ((Gestein)getOneIntersectingObject(Gestein.class)).getWassergehalt();
                    stelle++;
                    savve[stelle][1] = getX();
                    savve[stelle][2] = getY();
                    analysiereGestein();
                    setzeMarke();
                }
                try{
                    fahre();
                }
                catch( IllegalStateException e){
                    System.err.println("Rover has left the world.");
                }
            }
        }
        catch( IllegalStateException e ) {
            
        }
    }
    public void schlangenlinie(int anzahl, int laenge){
        for(int i = 0;i < anzahl;i++){
            dreheLinks(1);
            fahren(laenge);
            dreheRechts(1);
            fahre();
            dreheRechts(1);
            fahren(laenge);
            dreheLinks(1);
            fahre();
        }
    }   
    public void S69A3a(){
        setzeMarke();
        fahre();
        boolean x = true;
        while(x == true){
            while(huegelVorhanden("rechts")){
                fahre();
            }
            drehe("rechts");
            fahre();
            if(markeVorhanden() && huegelVorhanden("links")){
                entferneMarke();
                umdrehen();
            }
            if(markeVorhanden() && !huegelVorhanden("links")){
                Greenfoot.stop();
            }
        }
    }
    public boolean getKit(){
        return kit;
    }
    public int listlength(){
        anzeige.anzeigen("Sie haben bisher "+String.valueOf(stelle - 1)+" Gesteine analysiert!");
        return stelle-1;
    }
    public int listNum(int xy){
        if(stelle <= xy){
            anzeige.anzeigen("So viele Gesteine wurden nicht analysiert!");
            return 0;
        }
        else{
            anzeige.anzeigen("Der Wassergehalt des Gesteins Nummer "+xy+", beträgt: "+String.valueOf(savve[xy][0]));
            Greenfoot.delay(1);
            anzeige.anzeigen("Die Koodinaten waren: "+savve[xy][1]+", "+savve[xy][2]);
            return savve[xy][0];
        }
    }
    public void hide()
    {
        setImage("images/smoke_little.png");
    }
    public void unhide(){
        setImage("images/rover.png");
    }
    public void dreheLinks(int a){
        for(int i = 0; i < a;i++){
           drehe("links");
        }
    }
    public void dreheRechts(int a){
        for(int i = 0; i < a;i++){
           drehe("rechts");
        }
    }
    public void umdrehen(){
        drehe("rechts");
        drehe("rechts");
    }
    public void fahren(int a){
        for(int i = 0; i < a;i++){
            fahre();
        }
    }
    public void fahre()
    {
        try{
            Planet world = new Planet();
            int XP = world.getXP();
            int YP = world.getYP();
            steppedOn(world);
            int posX = getX();
            int posY = getY();
            if(huegelVorhanden("vorne")&& getFahren())
            {
                steppedOn(world);
                nachricht("Zu steil!");
            }
            else if(getRotation()==0 && getX()==XP && getY()==YP && times1 != 4&& getFahren()){
                steppedOn(world);
                drehe("links");
                times1++;
            }
            else if(getRotation()== 0 && getX()==XP && getY()==1 && times1 != 4 && getFahren()){
                steppedOn(world);
                drehe("rechts");
                times1++;
            }
            else if(getRotation()==0 && getX()==XP && times1 != 4 && getFahren()){
                steppedOn(world);
                drehe("links");
                times1++;
            }
            else if(getRotation()==90 && getY()==YP && getX()== 1 && times2 != 4 && getFahren()){
                steppedOn(world);
                drehe("links");
                times2++;
            }
            else if(getRotation()==90 && getY()==YP && getX()== 15 && times2 != 4 && getFahren()){
                steppedOn(world);
                drehe("rechts");
                times2++;
            }
            else if(getRotation()==90 && getY()==YP && times2 != 4 && getFahren()){
                steppedOn(world);
                drehe("rechts");
                times2++;
            }
            else if(getRotation()==180 && getX()==1 && getY()==YP && times3 != 4 && getFahren()){
                steppedOn(world);
                drehe("rechts");
                times3++;
            }
            else if(getRotation()==180 && getX()==1 && getY()==1 && times3 != 4 && getFahren()){
                steppedOn(world);
                drehe("links");
                times3++;
            }
            else if(getRotation()==180 && getX()==1 && times3 != 4 && getFahren()){
                steppedOn(world);
                drehe("rechts");
                times3++;
            }
            else if(getRotation()==270 && getY()==1 && getX()==1 && times != 4 && getFahren()){
                steppedOn(world);
                drehe("rechts");
                times++;
            }
            else if(getRotation()==270 && getY()==1 && getX()==XP && times != 4 && getFahren()){
                steppedOn(world);
                drehe("links");
                times++;
            }
            else if(getRotation()==270 && getY()==1 && times != 4 && getFahren()){
                steppedOn(world);
                drehe("rechts");
                times++;
            }
            else if(getRotation()==0 && getX()==XP && times1 == 4 && timmes != 2 && getFahren()){
                steppedOn(world);
                drehe("links");
                fahre();
                drehe("links");
                times1 = 0;
                timmes++;
            }
            else if(getRotation()==90 && getY()==YP && times2 == 4 && timmes != 2 && getFahren()){
                steppedOn(world);
                drehe("rechts");
                fahre();
                drehe("rechts");
                times2 = 0;
                timmes++;
            }
            else if(getRotation()==180 && getX()==1 && times3 == 4 && timmes != 2 && getFahren()){
                steppedOn(world);
                drehe("rechts");
                fahre();
                drehe("rechts");
                times3 = 0;
                timmes++;
            }
            else if(getRotation()==270 && getY()==1 && times == 4 && timmes != 2 && getFahren()){
                steppedOn(world);
                drehe("links");
                fahre();
                drehe("links");
                times = 0;
                timmes++;
            }
            else if(timmes == 2 && getFahren()){
                steppedOn(world);
                dreheLinks(2);
                fahre();
                dreheRechts(2);
                fahre();
                timmes = 0;
            }
            else
            {
                move(1);
                Greenfoot.delay(1);
                steppedOn(world);
            }
            steppedOn(world);
        }
        catch( IllegalStateException e){
                    
        }
    }
    public void drehe(String richtung)
    {
        if(richtung=="rechts")
        {
            setRotation(getRotation()+90);
        }
        else if (richtung=="links")
        {
            setRotation(getRotation()-90);
        }
        else
        {
            nachricht("Befehl nicht korrekt!");
        }
    }
    public boolean gesteinVorhanden()
    {
        if(getOneIntersectingObject(Gestein.class)!=null)
        {
            nachricht("Gestein gefunden!");
            return true;

        }

        return false;
    }

    /**
     * Der Rover überprüft, ob sich in richtung ("rechts", "links", oder "vorne") ein Objekt der Klasse Huegel befindet.
     * Das Ergebnis wird auf dem Display angezeigt.
     * Sollte ein anderer Text (String) als "rechts", "links" oder "vorne" übergeben werden, dann erscheint eine entsprechende Meldung auf dem Display.
     */
    public boolean huegelVorhanden(String richtung)
    {
        int rot = getRotation();

        if (richtung=="vorne" && rot==0 || richtung=="rechts" && rot==270 || richtung=="links" && rot==90)
        {
            if(getOneObjectAtOffset(1,0,Huegel.class)!=null && ((Huegel)getOneObjectAtOffset(1,0,Huegel.class)).getSteigung() >30)
            {
                return true;
            }
        }

        if (richtung=="vorne" && rot==180 || richtung=="rechts" && rot==90 || richtung=="links" && rot==270)
        {
            if(getOneObjectAtOffset(-1,0,Huegel.class)!=null && ((Huegel)getOneObjectAtOffset(-1,0,Huegel.class)).getSteigung() >30)
            {
                return true;
            }
        }

        if (richtung=="vorne" && rot==90 || richtung=="rechts" && rot==0 || richtung=="links" && rot==180)
        {
            if(getOneObjectAtOffset(0,1,Huegel.class)!=null && ((Huegel)getOneObjectAtOffset(0,1,Huegel.class)).getSteigung() >30)
            {
                return true;
            }

        }

        if (richtung=="vorne" && rot==270 || richtung=="rechts" && rot==180 || richtung=="links" && rot==0)
        {
            if(getOneObjectAtOffset(0,-1,Huegel.class)!=null && ((Huegel)getOneObjectAtOffset(0,-1,Huegel.class)).getSteigung() >30)
            {
                return true;
            }

        }

        if(richtung!="vorne" && richtung!="links" && richtung!="rechts")
        {
            nachricht("Befehl nicht korrekt!");
        }

        return false;
    }

    /**
     * Der Rover ermittelt den Wassergehalt des Gesteins auf seiner Position und gibt diesen auf dem Display aus.
     * Sollte kein Objekt der Klasse Gestein vorhanden sein, dann erscheint eine entsprechende Meldung auf dem Display.
     */
    public void analysiereGestein()
    {
        if(gesteinVorhanden())
        {
            nachricht("Gestein untersucht! Wassergehalt ist "+((Gestein)getOneIntersectingObject(Gestein.class)).getWassergehalt()+"%.");
            Greenfoot.delay(1);
            removeTouching(Gestein.class);
        }
        else 
        {
            nachricht("Hier ist kein Gestein");
        }
    }

    /**
     * Der Rover erzeugt ein Objekt der Klasse „Markierung“ auf seiner Position.
     */
    public void setzeMarke()
    {
        getWorld().addObject(new Marke(), getX(), getY());
    }

    /**
     * *Der Rover gibt durch einen Wahrheitswert (true oder false )zurück, ob sich auf seiner Position ein Objekt der Marke befindet.
     * Eine entsprechende Meldung erscheint auch auf dem Display.
     */
    public boolean markeVorhanden()
    {
        if(getOneIntersectingObject(Marke.class)!=null)
        {
            return true;
        }

        return false;
    }

    public void entferneMarke()
    {
        if(markeVorhanden())
        {
            removeTouching(Marke.class);
        }
    }

    private void nachricht(String pText)
    {
        if(anzeige!=null)
        {
            anzeige.anzeigen(pText);
            Greenfoot.delay(1);
            anzeige.loeschen();
        }
    }

    private void displayAusschalten()
    {
        getWorld().removeObject(anzeige);

    }
    protected void addedToWorld(World world)
    {
        setImage("images/rover.png");
        world = getWorld();
        anzeige = new Display();
        world.addObject(anzeige, 7, 0);
        if(getY()==0)
        {
            setLocation(getX(),1);
        }
        anzeige.anzeigen("Je suis Adolf!");

    }
    public void steppedOn(World world){
        Planet planet = (Planet) getWorld();
        Actor mine;
        world = getWorld();
        Wrack wrack = new Wrack();
        mine = getOneIntersectingObject(Mine.class);
        if(getOneIntersectingObject(Mine.class) != null && getKit() == false){
           world.addObject(wrack, getX(), getY());
           //world.removeObjects(world.getObjects(Huegel.class));
           //world.removeObjects(world.getObjects(Gestein.class));
           anzeige.anzeigen("FRIENDSHIP IS MAGIC!");
           //world.setBackground("images/heartss.jpg");
           //if (!world.getObjects(Mine.class).isEmpty())
           //{
              //for (Object mine1 : world.getObjects(Mine.class))
              //{
                  //((Mine) mine1).setImage("images/crazy.png");
              //}
           //}
           //fahren = false;
           world.removeObject(this);
        }
        else if(getOneIntersectingObject(Mine.class) != null && getKit()){
            Greenfoot.delay(1);
            world.removeObject(mine);
            kit = false;
            anzeige.anzeigen("Mine entschärft!");
        }
    }
    public boolean getFahren(){
        return fahren;
    }
    class Display extends Actor
    {
        GreenfootImage bild; 

        public Display()
        {
            bild = getImage();
        }

        public void act() 
        {

        }  

        public void anzeigen(String pText)
        {
            loeschen();
            bild = new GreenfootImage(pText, 30, null, null); 
            getImage().drawImage(bild, 8,0);

        }
        public void loeschen()
        {
            getImage().clear();
            setImage("images/nachricht.png");
        }
    }
}
