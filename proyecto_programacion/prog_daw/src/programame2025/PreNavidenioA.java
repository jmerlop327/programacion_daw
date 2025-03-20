package programame2025;
//https://programame.com/documents/ProblemsSets/2025/ProgramaMe-2025-Navidad.pdf
//https://aceptaelreto.com/problem/statement.php?id=763&cat=172
public class PreNavidenioA {
	// Asume fichero llamado solution.java

    static java.util.Scanner in;

    public static void casoDePrueba() {
      
        // TU CÓDIGO AQUÍ
    	if("colgadas".equalsIgnoreCase(in.next())) {
    		System.out.println("Bien");
    	} else {
    		System.out.println("Mal");
    	}
    } // casoDePrueba

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    } // main
}
