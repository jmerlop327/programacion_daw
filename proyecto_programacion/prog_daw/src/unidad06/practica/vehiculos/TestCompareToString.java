package unidad06.practica.vehiculos;

public class TestCompareToString {
	public static void main(String[] args) {
		String s1 = "aab";
		String s2 = "aab";
		String s3 = "bbb";
		String s4 = "aaa";
		String mat1 = "1234DFH";
		String mat2 = "0234FYS";
		
		System.out.println(s1.compareTo(s2));//0
		System.out.println(s1.compareTo(s3));//-1 o valor negativo
		System.out.println(s1.compareTo(s4));//+1 o valor positivo
		System.out.println(mat1.compareTo(mat2));//-1 o valor negativo
		
	}
}
