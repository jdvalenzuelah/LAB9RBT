/**
 * @author David Valenzuela 171001
 * @author Fernando Hegnstenberg 17699
 * @author 2001 duane a. bailey
 *
 * @param <K>
 * @param <V>
 */
public class BinaryTree<K extends Comparable<K>, V> {
	/**
	 * Nodo raiz del arbol
	 */
	protected Nodo<K,V> raiz;
	
	/**
	 * size del arbol
	 */
	protected int size;
	
	
	
	
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Constructorde la clase
	 */
	public BinaryTree(){
		raiz = null;
		size = 0;
	}
	
	/**
	 * Insertar un nuevo valor al arbol
	 * @param key llave
	 * @param valor Valor
	 */
	public void insertar(K key, V valor) {
		Nodo<K,V> n = new Nodo<K,V>(key, valor);
		if (raiz==null) {
			raiz=n;
		}	
		else {
			 Nodo<K, V> actual = raiz;
			 Nodo<K, V> padre;
			 boolean flag = true;
			 while(flag) {
				 padre = actual;
				 int comparacion = actual.valor.compareTo(key);
				 if(comparacion > 0) {
					 actual = actual.izq;
					 if(actual == null) {
						 padre.izq = n;
						 flag = false;
					 }
				 }else {
					 actual = actual.der;
					 if(actual == null) {
						 padre.der = n;
						 flag = false;
					 }
				 }
			 }
		}
		size++;
	}
	
	/**
	 * Insertar un nuevo nodo al arbol
	 * @param n nuevo nodo a insertar
	 */
	public void insertar(Nodo<K,V> n) {
		if (raiz==null) {
			raiz=n;
		}	
		else {
			 Nodo<K, V> actual = raiz;
			 Nodo<K, V> padre;
			 boolean flag = true;
			 while(flag) {
				 padre = actual;
				 int comparacion = actual.valor.compareTo(n.getValor().getTheKey());
				 if(comparacion > 0) {
					 actual = actual.izq;
					 if(actual == null) {
						 padre.izq = n;
						 flag = false;
					 }
				 }else {
					 actual = actual.der;
					 if(actual == null) {
						 padre.der = n;
						 flag = false;
					 }
				 }
			 }
		}
		size++;
	}
	
	/**
	 * Buscar un valor en el arboSl a partir de la llave
	 * @param llave
	 * @return
	 */
	public V buscar(K llave) {
		Nodo<K, V> actual = raiz;
		while(actual != null) {
			int comparacion = actual.valor.compareTo(llave);
			if(comparacion == 0) {
				return actual.valor.theValue;
			}else if(comparacion > 0) {
				actual = actual.izq;
			}else {
				actual = actual.der;
			}
		}
		return null;
	}
	
	/**
	 * Recorrer
	 * @param raiz
	 */
	public void inOrder(Nodo<K, V> raiz) {
		if(raiz != null) {
			inOrder(raiz.izq);
			System.out.println(raiz.valor);
			inOrder(raiz.der);
		}
	}
	
	/**
	 * Obtener el padre del nodo
	 * @return padre del nodo
	 */
	public Nodo<K, V> getPadre(){
		return this.raiz;
	}
	
	/**
	 * @author David Valenzuela 171001
	 * @author Fernando Hegnstenberg 17699
	 *
	 * @param <L>
	 * @param <C>
	 */
	 protected class Nodo<L extends Comparable<L>,C>{
		Association<L,C> valor;
		Nodo<L,C> der;
		Nodo<L,C> izq;
		
		/**
		 * Constructor de la clase
		 * @param llave
		 * @param valor
		 */
		public Nodo(L llave, C valor) {
			this.valor = new Association<L, C>(llave, valor);
			der = null;
			izq = null;
		}
		
		/**
		 * @return
		 */
		public Nodo<L, C> getIzquierdo() {
			return izq;
		}
		
		/**
		 * @return
		 */
		public Nodo<L,C> getDerecho(){
			return der;
		}
		
		/**
		 * @param nIz
		 */
		public void setIzquierdo(Nodo<L, C> nIz){
			this.izq = nIz;
		}
		
		/**
		 * @param nDer
		 */
		public void setDerecho(Nodo<L, C> nDer) {
			this.der = nDer;
		}
		
		/**
		 * @return
		 */
		public Association<L, C> getValor(){
			return this.valor;
		}

		/**
		 * @param valor the valor to set
		 */
		public void setValor(Association<L, C> valor) {
			this.valor = valor;
		}
		
		
	}

}