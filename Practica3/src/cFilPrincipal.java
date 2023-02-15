import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
public class cFilPrincipal {
  public static void main (String [] pArguments) {
	
	Scanner scan = new Scanner(System.in);
	String frase = "Intodueixi un numero entre 1 y 20";
	
	System.out.println("Iniciant Programa...");
	System.out.println("Introdueixi els seguents valors:");
	
	System.out.println("Files de Primer Vector : ");
	int filaOne = scan.nextInt();
	while (filaOne > 20 || filaOne < 1) {
		System.out.println(frase);
		filaOne = scan.nextInt();
	}
    System.out.println("Columnes de Primer Vector : ");
    int coluOne = scan.nextInt();
    while (coluOne > 20 || coluOne < 1) {
		System.out.println(frase);
		coluOne = scan.nextInt();
	}
    System.out.println("Files de Segon Vector : ");
    int filaTwo = scan.nextInt();
	while (filaTwo > 20 || filaTwo < 1) {
		System.out.println(frase);
		filaTwo = scan.nextInt();
	}
    System.out.println("Columnes de Segon Vector : ");
    int coluTwo = scan.nextInt();
    while (coluTwo > 20 || coluTwo < 1) {
		System.out.println(frase);
		coluTwo = scan.nextInt();
	}
    
    if(filaOne != coluTwo) {
    	System.out.println("ERROR : N FILA A != N COLUMNA B");
    	return;
    }
    
    System.out.println("Generant Matrius...");
    
    int[][] matrizOne = new int [filaOne][coluOne];
    int[][] matrizTwo = new int [filaTwo][coluTwo];
    
	int[][] matrizRes = new int [filaOne][coluTwo];
	
	LinkedList<Thread> vFils = new LinkedList<Thread>();
	
	boolean menu = true;
	
	while (menu)
	{
		System.out.println("Indiqui la seguent acció : ");
		System.out.println("[1] Calcular nova matriu");
		System.out.println("[2] Sortir");
		
		int select = scan.nextInt();
		if (select == 1) {
			Llenar(matrizOne, filaOne, coluOne);
			Llenar(matrizTwo, filaTwo, coluTwo);
			
			Printar(matrizOne, filaOne, coluOne);
			System.out.println();
			Printar(matrizTwo, filaTwo, coluTwo);
		}
		if (select == 2){
			System.out.println("Heu tancat el programa.");
			return;
		}
		
		System.out.println("Calculant...");
		
	    for(int i = 0; i < filaOne ; i++ ) {
	    	for (int j = 0; j < coluTwo; j++) {
	        	cFil c = new cFil((i+1)+"#"+(j+1), matrizOne, matrizTwo, matrizRes, i, j);
	        	vFils.add(new Thread (c));
			}
	    }
	    
	    System . out . println ("Iniciant execució procés principal");
	    try {
	    	for(Thread t : vFils) {
	    		t.start();
	        	t.join();
	    	}
	    	System.out.println();
	    	System.out.println("Matriu Resultant : ");
	    	Printar(matrizRes, filaOne, coluTwo);
	    	System.out.println();
	    	
	      for (int vComptador = 0; vComptador < 3; vComptador ++) {
	        Thread . sleep (500);
	        System . out . println ("Despertant aturada " + (vComptador+1) + " procès principal");
	      }
	      System . out . println ("Acabant execució procès principal");
	      vFils.removeAll(vFils);
	    }
	    catch (InterruptedException pExcepcio) {
	      System . out . println ("Interrompent execució procès principal");
	    }
	}
  }
  
  	private static void Llenar(int[][] matrix, int fila, int colu)
	{	
		Random rand = new Random();
		
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < colu; j++) {
				int randomNum = rand.nextInt(5 - 0) + 1;
				matrix[i][j] = randomNum;
			}
		}
	}
  	
  	private static void Printar(int[][] matrix, int fila, int colu)
	{
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < colu; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
  
}