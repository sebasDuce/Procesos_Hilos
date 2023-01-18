import java.util.Scanner;

public class cFilPrincipal {
  public static void main (String [] pArguments) {
	  
    System . out . println ("Fil principal iniciat.");
    System . out . println ("Fil secundari iniciat.");
    
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Introduce una cantidad de hilos:");
    
    int quantFils = scan.nextInt();
    
    while (quantFils>5)
    {
    	System.out.println("Demasiados hilos");
        quantFils = scan.nextInt();
    }
  
    Thread[] vFils = new Thread[quantFils];
    
    for(int i = 0; i < quantFils; i++ ) {
    	
    	System.out.println("Introduce el numero que quieres factorizar");
    	int numero = scan.nextInt();
    	
    	cFil c = new cFil("#"+(i+1), numero);
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