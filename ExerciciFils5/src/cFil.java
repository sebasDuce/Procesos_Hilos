public class cFil implements Runnable {
  
	String nombre;
	int numCalc;
  
  public cFil (String nombre, int numCalc) {
	 
	 this.nombre = nombre;
     this.numCalc = numCalc;
    
  }
  
  public void run () {
	  
    System . out . println ("Iniciant execuci� proc�s "+nombre);
    
    int factorial = numCalc;
    for(int i=factorial; i>1; i--){
    	
    	numCalc*=(i-1);    
    	
    } System.out.println("Factorial de "+factorial+" �s = " +numCalc);
    
    System . out . println ("Acabant execuci� proc�s "+nombre);
  }
  
}