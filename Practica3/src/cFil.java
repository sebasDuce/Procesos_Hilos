public class cFil implements Runnable {
  
	String nombre;
	int[][] matrizOne;
	int[][] matrizTwo;
	int[][] matrizRes;
	int fila;
	int columna;
	
	
  public cFil (String nombre, int[][] matrizOne, int[][] matrizTwo, int[][] matrizRes, int fila, int columna) {
	 
	 this.nombre = nombre;
	 this.matrizOne = matrizOne;
	 this.matrizTwo = matrizTwo;
	 this.matrizRes = matrizRes;
	 this.fila = fila;
	 this.columna = columna;
    
  }
  
  public void run () {
	  
    System . out . println ("Iniciant execució procés "+nombre);
    
    matrizRes[fila][columna]=0;
	for (int i=0;i<matrizTwo.length;i++) {
		matrizRes[fila][columna] += matrizOne[fila][i] * matrizTwo[i][columna];
	}
    System . out . println ("Acabant execució procès "+nombre);
  }
}