import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreeTest {

	@Test
	void SplayTreetest() {
		// Creamos el arbol
		SplayTree<Integer, String> arbol = new SplayTree<Integer, String>();
		
		// Insertamos Valores de prueba en el arbol
		arbol.insertar(1, "1");
		arbol.insertar(2, "2");
		
		// Verificamos que sea del tamaño correcto
		assertEquals(arbol.getSize(), 2);
		
		
		
	}

}
