package ejemplo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import us.lsi.geometria.Cuadrante;
import us.lsi.geometria.Punto2D;

public class Ejemplo {

	
	public static Map<Cuadrante, Double> solucionIterativa(List<Punto2D> ls){
		Map<Cuadrante, Double> ac = new HashMap<>();
		Integer e = 0;
		while(e < ls.size()) {
			Punto2D p = ls.get(e);
			Cuadrante key = p.cuadrante();
			if (ac.containsKey(key)) {
				ac.put(key, ac.get(key) + p.x());
			}else {
				ac.put(key, p.x());
			}
			e++;	
		}
		return ac;
	
	}
	
	
	public static Map<Cuadrante, Double> solucionRecursiva(List<Punto2D>  ls){
		return solucionRecursiva(0, new HashMap<> (), ls);
	}
	
	public static Map<Cuadrante, Double> solucionRecursiva(Integer e, Map<Cuadrante, Double> ac, List <Punto2D> ls){
		Map<Cuadrante, Double> r = ac;
		Punto2D p = ls.get(e);
		if (e < ls.size()) {
		Cuadrante key = p.cuadrante();
		if (ac.containsKey(key)) {
			ac.put(key, ac.get(key) + p.x());
		}else {
			ac.put(key, p.x());
		}
		e = e +1;
		r = solucionRecursiva(e, ac, ls);
	}
	return r;
	}
}

