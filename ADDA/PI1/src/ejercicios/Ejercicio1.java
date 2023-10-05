package ejercicios;

import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ejercicio1 (32, 55));
		System.out.println(ejercicio1It(32, 55));
		System.out.println(ejercicio1RF(32, 55));
	}
	public record EnteroCadena(Integer a, String s) {

		public static EnteroCadena of(Integer i, String s) {
			// TODO Auto-generated method stub
			return new EnteroCadena(i, s);
		}}

	public static String ejercicio1 (Integer varA, Integer varB) {
		UnaryOperator<EnteroCadena> nx = elem ->
		{
				return EnteroCadena.of(elem.a() + 3,
						elem.a()%2 == 0?
						elem.a() + "*":
						elem.a() + "!");
		};
		
		return Stream.iterate(EnteroCadena.of(varA, "A"), elem -> elem.a() < varB, nx)
				.filter(elem -> elem.a()%10 != 0)
				.map(elem -> elem.s())
				.collect(Collectors.joining("-"));
	}
	
	public static String ejercicio1It(Integer varA, Integer varB) {
		
		String r = "";
		EnteroCadena x = EnteroCadena.of(varA, "A");

		while(x.a() < varB) {
			
			if (x.a() == varA) {
				r = x.s();
			}
			
			else if (x.a() %10 != 0 ) {
				r = r + "-"+  x.s();
				
			}
			x = 	x.of(x.a() + 3, x.a()%2== 0? x.a() + "*": x.a() + "!");
			r = r.join("-", r);
		}
		
		
		
		return r;
	}
	
	public static String ejercicio1RF (Integer varA, Integer varB) {
		return ejercicio1RF(varA, varB, "", EnteroCadena.of(varA, "A"));
	}
	
	private static String ejercicio1RF(Integer a, Integer b, String ac, EnteroCadena x) {
		if(x.a() < b) {
			
			if (x.a() == a) {
				ac = x.s();
			}
			
			else if (x.a() %10 != 0 ) {
				ac = ac+ "-"+  x.s();
				
			}
			x = 	x.of(x.a() + 3, x.a()%2== 0? x.a() + "*": x.a() + "!");
			ac = ejercicio1RF(a,b, ac, x);
		}
		return ac;
	}
	
	
}