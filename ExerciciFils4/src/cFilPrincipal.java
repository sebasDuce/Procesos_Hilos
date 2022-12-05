import java.util.Scanner;

public class cFilPrincipal {
  public static void main (String [] pArguments) {
    System . out . println ("Fil principal iniciat.");
    System . out . println ("Fil secundari iniciat.");
    
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Introduce una cantidad:");
    
    int quantFils = scan.nextInt();
    
    while (quantFils>5)
    {
    	System.out.println("Demasiado grande");
        quantFils = scan.nextInt();
    }
  
    Thread[] vFils = new Thread[quantFils];
    
    for(int i = 0; i < quantFils; i++ ) {
    	
    	cFil c = new cFil("#"+(i+1));
    	c.sTemporitzacio(1*i);
    	vFils[i] =  new Thread (c);
    }
    
    for(int i = 0; i < vFils.length; i++) {
    	vFils[i].start();
    }
    
    System . out . println ("Iniciant execució procés principal");
    try {

      for(int i = 0; i < vFils.length; i++) {
    	  vFils[i].join();
      }
      
      for (int vComptador = 0; vComptador < 10; vComptador ++) {
        Thread . sleep (500);
        System . out . println ("Despertant aturada " + vComptador + " procès principal");
      }
    }
    catch (InterruptedException pExcepcio) {
      System . out . println ("Interrompent execució procès principal");
    }
    
    System . out . println ("Acabant execució procès principal");
  }
}