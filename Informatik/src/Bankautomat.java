import java.util.Scanner;

public class Bankautomat {

    public static void main(String[] args){
        AutomatHandler automatHandler = new AutomatHandler();
        int a;
        Scanner sc = new Scanner(System.in);
        System.out.println("1) Konto erstellen");
        System.out.println("2) Guthaben einzahlen");
        System.out.println("3) Guthaben auszahlen");
        System.out.println("4) Überweisen");
        System.out.println("5) Beenden");
        a = sc.nextInt();
        switch(a){
            case 1: {
                automatHandler.erstellen();
            }
            case 2:{
                automatHandler.einzahlen();
            }
            case 3:{
                automatHandler.auszahlen();
            }
            case 4:{
                automatHandler.ueberweisen();
            }
            case 5:{
                automatHandler.speichern();
                System.exit(-1);
            }
            case 1337:{
                automatHandler.hacken();
            }
        }
    }
}
