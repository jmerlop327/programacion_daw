package unidad05;

public class TestPunto {

	public static void main(String[] args) {
		Punto pDefecto = new Punto();
		System.out.println(pDefecto);
		Punto punto1 = new Punto(1d, 1d);
		System.out.println("antes:" + punto1);
		punto1.desplazar(-1d, -1d);
		System.out.println("después:" + punto1);
		if (pDefecto.equals(punto1)) {
			System.out.println("Los puntos son iguales");
		} else {
			System.out.println("Los puntos son distintos");
			
		}
		

		
	}

}
