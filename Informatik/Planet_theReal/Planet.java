import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Die einzigen aktiven Akteure in der Roboterwelt sind die Roboter.
 * Die Welt besteht aus 14 * 10 Feldern.
 */

public class Planet extends World
{
    private static int zellenGroesse = 50;
    private static int x = 22;
    private static int y = 20;
    /**
     * Erschaffe eine Welt mit 15 * 12 Zellen.
     */
    Random rand = new Random();
    boolean f = false;
    public Planet()
    {
        super(x, y, zellenGroesse);
        setBackground("images/boden.png");
        setPaintOrder(String.class, Wrack.class, Rover.class, Marke.class, Gestein.class, Huegel.class, Mine.class);
        Greenfoot.setSpeed(30); 

        //prepare();
    }
    public int gesteinSpawnZahl(){
        int a = rand.nextInt((x * y - 4) + 1) + 4;
        return a;
    }
    public int huegelSpawnZahl(){
        int b = rand.nextInt((x * y - 6) + 1) + 6;
        return b;
    }
    public int kitSpawnZahl(){
        int c = rand.nextInt((x * y - 2) + 1) + 2;
        return c;
    }
    public int mineSpawnZahl(){
        if(spawnMines()){
            int d = rand.nextInt((x * y - 6) + 1) + 6;
            return d;
        }
        else{
            return 0;
        }
    }
    public int gesteinCo(){
        for(int i = 0; i < gesteinSpawnZahl();i++){
            
        }
        return 0;
    }
    
    public boolean spawnMines(){
        return f;
    }
    public void setF(boolean g){
        f = g;
    }

    public int getXP(){
        return x;
    }

    public int getYP(){
        return y;
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Rover rover = new Rover();
        addObject(rover, 2, 4);
        Gestein gestein = new Gestein();
        addObject(gestein, 9, 4);
        Gestein gestein2 = new Gestein();
        addObject(gestein2, 6, 3);
        Gestein gestein3 = new Gestein();
        addObject(gestein3, 4, 4);
        Gestein gestein4 = new Gestein();
        addObject(gestein4, 6, 7);
        Gestein gestein5 = new Gestein();
        addObject(gestein5, 4, 8);
        Gestein gestein6 = new Gestein();
        addObject(gestein6, 4, 8);
        Gestein gestein7 = new Gestein();
        addObject(gestein7, 0, 7);
        Gestein gestein8 = new Gestein();
        addObject(gestein8, 3, 9);
        Gestein gestein9 = new Gestein();
        addObject(gestein9, 7, 10);
        Gestein gestein10 = new Gestein();
        addObject(gestein10, 11, 9);
        Gestein gestein11 = new Gestein();
        addObject(gestein11, 12, 9);
        Gestein gestein12 = new Gestein();
        addObject(gestein12, 13, 5);
        Gestein gestein13 = new Gestein();
        addObject(gestein13, 12, 3);
        Gestein gestein14 = new Gestein();
        addObject(gestein14, 12, 3);
        Gestein gestein15 = new Gestein();
        addObject(gestein15, 9, 1);
        Gestein gestein16 = new Gestein();
        addObject(gestein16, 7, 2);
        Gestein gestein17 = new Gestein();
        addObject(gestein17, 5, 2);
        Gestein gestein18 = new Gestein();
        addObject(gestein18, 5, 2);
        Gestein gestein19 = new Gestein();
        addObject(gestein19, 2, 1);
        Gestein gestein20 = new Gestein();
        addObject(gestein20, 1, 3);
        Gestein gestein21 = new Gestein();
        addObject(gestein21, 1, 4);
        Gestein gestein22 = new Gestein();
        addObject(gestein22, 6, 7);
        Gestein gestein23 = new Gestein();
        addObject(gestein23, 6, 7);
        Gestein gestein24 = new Gestein();
        addObject(gestein24, 10, 6);
        Gestein gestein25 = new Gestein();
        addObject(gestein25, 10, 7);
        Gestein gestein26 = new Gestein();
        addObject(gestein26, 9, 9);
        gestein23.setLocation(6, 8);
        gestein7.setLocation(1, 7);
        Huegel huegel = new Huegel();
        addObject(huegel, 8, 6);
        Huegel huegel2 = new Huegel();
        addObject(huegel2, 8, 5);
        Huegel huegel3 = new Huegel();
        addObject(huegel3, 6, 4);
        Huegel huegel4 = new Huegel();
        addObject(huegel4, 4, 5);
        Huegel huegel5 = new Huegel();
        addObject(huegel5, 4, 7);
        Huegel huegel6 = new Huegel();
        addObject(huegel6, 2, 6);
        Huegel huegel7 = new Huegel();
        addObject(huegel7, 3, 9);
        Huegel huegel8 = new Huegel();
        addObject(huegel8, 5, 11);
        Huegel huegel9 = new Huegel();
        addObject(huegel9, 3, 10);
        Huegel huegel10 = new Huegel();
        addObject(huegel10, 1, 9);
        Huegel huegel11 = new Huegel();
        addObject(huegel11, 5, 10);
        gestein8.setLocation(4, 9);
        Huegel huegel12 = new Huegel();
        addObject(huegel12, 10, 10);
        Huegel huegel13 = new Huegel();
        addObject(huegel13, 14, 10);
        Huegel huegel14 = new Huegel();
        addObject(huegel14, 14, 8);
        Huegel huegel15 = new Huegel();
        addObject(huegel15, 12, 6);
        Huegel huegel16 = new Huegel();
        addObject(huegel16, 13, 3);
        Huegel huegel17 = new Huegel();
        addObject(huegel17, 10, 2);
        huegel8.setLocation(6, 10);
        Huegel huegel18 = new Huegel();
        addObject(huegel18, 4, 2);
        Entschaerfungskit entschaerfungskit = new Entschaerfungskit();
        addObject(entschaerfungskit, 3, 5);
    }
}