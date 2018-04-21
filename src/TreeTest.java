import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class TreeTest {

	/**
	 * Prueba de insercion de datos del SplayTree
	 */
	@Test
	void SplayInsertarTest() {
		// Creamos el arbol
		SplayTree<Integer, String> arbol = new SplayTree<Integer, String>();
		
		// Insertamos Valores de prueba en el arbol
		arbol.insertar(1, "1");
		arbol.insertar(2, "2");
		
		// Verificamos que sea del tamaño correcto
		assertEquals(arbol.getSize(), 2);	
	}
	
	/**
	 * Prueba de busqueda de datos por medio de la llave en el SplayTree
	 */
	@Test
	void SplayBuscarTest() {
		// Creamos el arbol
		SplayTree<Integer, String> arbol = new SplayTree<Integer, String>();
				
		// Insertamos Valores de prueba en el arbol
		arbol.insertar(1, "1");
		arbol.insertar(2, "2");
		
		// Verificamos que los valores retornados por la busqueda sean lo correctos
		assertEquals(arbol.buscar(2), "2");
		assertEquals(arbol.buscar(1), "1");
	}
	
	/**
	 * Prueba de insercion de datos para el RedBlackTree
	 */
	@Test
	void RBInsertarTest() {
		// Creamos el arbol
		RedBlackTree<Integer, String> arbol = new RedBlackTree<Integer, String>();
		
		// Insertamos Valores de prueba en el arbol
		arbol.insertar(1, "1");
		arbol.insertar(2, "2");
				
		// Verificamos que sea del tamaño correcto
		assertEquals(arbol.getSize(), 2);		
	}
	
	/**
	 * Prueba de busqueda de datos por medio de la llave por medio de la llave para el RedBlackTree	
	 */
	void RBBuscarTest() {
		// Creamos el arbol
		RedBlackTree<Integer, String> arbol = new RedBlackTree<Integer, String>();
		
		// Insertamos Valores de prueba en el arbol
		arbol.insertar(1, "1");
		arbol.insertar(2, "2");
			
		// Verificamos que los valores retornados por la busqueda sean lo correctos
		assertEquals(arbol.buscar(2), "2");
		assertEquals(arbol.buscar(1), "1");
		
	}

}
