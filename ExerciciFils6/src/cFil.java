public class cFil implements Runnable {
  
	String nombre;
	int numCalc;
  
  public cFil (String nombre, int numCalc) {
	 
	 this.nombre = nombre;
     this.numCalc = numCalc;
    
  }
  
  public void run () {
	  
    System . out . println ("Iniciant execuci� proc�s "+nombre);
    
    int res = 1;
    for(int i=1; i<=numCalc; i++){
    	
    	res = res * 2;    
    	
    } System.out.println("2 elevado a "+numCalc+" �s = " + res);
    
    System . out . println ("Acabant execuci� proc�s "+nombre);
  }
  
}