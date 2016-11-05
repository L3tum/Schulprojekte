import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
  public static int nummern;
  public static int pass[];
  public static int guthaben[];
  public static int nummer[];
  public static int adminpass;
  
  
  public void loadConfig(){
    try {
      int b,c,y;
      c = 0;
      b = 1;
      y = 0;
      File file = new File("zahlen.txt");
      file.getAbsolutePath();
      if(!file.exists()){
        file.createNewFile();
      }
      Scanner sc = new Scanner(file);
      String[] details;
      details = new String[1];
      String line = sc.nextLine();
      details = line.split(";");
      //System.out.println("Details[0] = "+details[0]);
      nummern = Integer.parseInt(details[0]);
      String[] detail;
      detail = new String[nummern*3+1];
      int i;
      pass = new int[nummern];
      guthaben = new int[nummern];
      nummer = new int[nummern];
      for (i = 0;i < nummern ;i++ ) {
        detail = line.split(";");
      } // end of for
      int x;
      x = 0;
      System.out.println("Detail = "+detail[0]);
      adminpass = Integer.parseInt(detail[0]);
      for(i = 0; i < nummern; i++){
        if(detail[b] != null){
          //System.out.println("Detail["+b+"] = "+detail[b]);
          nummer[x] = Integer.parseInt(detail[b]);
          b++;
        }
        if(detail[b] != null){
          //System.out.println("Detail["+b+"] = "+detail[b]);
          pass[x] = Integer.parseInt(detail[b]);
          b++;
        }
        if(detail[b] != null){
          //System.out.println("Detail["+b+"] = "+detail[b]);
          guthaben[x] = Integer.parseInt(detail[b]);
          b++;
          x++;
        }
      }
      
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (NullPointerException e){
      e.printStackTrace();
    }
  }
  
  public int getNummern(){
    FileHandler handler = new FileHandler();
    handler.loadConfig();
    return nummern;
  }
  
  public int getPass(int n) {
    FileHandler handler = new FileHandler();
    handler.loadConfig();
    //int a;
    //a = pass.length;
    //System.out.println("Länge = "+a);
    //System.out.println("Passwort = "+pass[n]);
    return pass[n];
  }
  
  public int getGuthaben(int n) {
    FileHandler handler = new FileHandler();
    handler.loadConfig();
    return guthaben[n];
  }
  
  public int getNummer(int n) {
    FileHandler handler = new FileHandler();
    handler.loadConfig();
    return nummer[n];
  }
  
  public int getAdminPass(){
    FileHandler handler = new FileHandler();
    handler.loadConfig();
    return adminpass;
  }
}
