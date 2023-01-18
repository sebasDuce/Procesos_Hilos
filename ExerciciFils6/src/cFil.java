public class cFil implements Runnable {
  
	String nombre;
	int numCalc;
  
  public cFil (String nombre, int numCalc) {
	 
	 this.nombre = nombre;
     this.numCalc = numCalc;
    
  }
  
  public void run () {
	  
    System . out . println ("Iniciant execució procés "+nombre);
    
    int res = 1;
    for(int i=1; i<=numCalc; i++){
    	
    	res = res * 2;    
    	
    } System.out.println("2 elevado a "+numCalc+" és = " + res);
    
    System . out . println ("Acabant execució procès "+nombre);
  }
  
}