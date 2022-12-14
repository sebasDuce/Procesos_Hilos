
public class cFilPrincipal {
  public static void main (String [] pArguments) {
    System . out . println ("Fil principal iniciat.");
    System . out . println ("Fil secundari iniciat.");
    cFil vObjecteFil = new cFil ("#1");
    
    vObjecteFil.sTemporitzacio(600);
    
    //alternativa: innecessari
    Thread vFil = new Thread (vObjecteFil);
    //alternativa: vObjecteFil
    
    vFil . start ();
    
    
    
    System . out . println ("Iniciant execució procés principal");
    try {

      
      for (int vComptador = 0; vComptador < 10; vComptador ++) {
        Thread . sleep (500);
        System . out . println ("Despertant aturada " + vComptador + " procès principal");
      }
      vFil.join();
    }
    catch (InterruptedException pExcepcio) {
      System . out . println ("Interrompent execució procès principal");
    }
    
    System . out . println ("Acabant execució procès principal");
  }
}