/**
 * @author David Valenzuela 171001
 * @author Fernando Hegnstenberg 17699
 *
 */

public class RedBlackTree<K extends Comparable<K>, V> extends BinaryTree<K, V> {

	/**
	 * Class constructor
	 */
	public RedBlackTree() {
		super();
		
	}
	
	/* (non-Javadoc)
	 * @see BinaryTree#insertar(java.lang.Comparable, java.lang.Object)
	 * Obtenido de https://algs4.cs.princeton.edu/33balanced/RedBlackBST.java.html
	 */
	@Override
	public void insertar(K key, V valor) {
		
		NodoRB<K, V > nodo = put((RedBlackTree<K, V>.NodoRB<K, V>) raiz, key, valor);
		nodo.setColor(false);
		raiz = nodo;
		size++;
		
	}
	
	/**
	 * Obtenido de https://algs4.cs.princeton.edu/33balanced/RedBlackBST.java.html
	 * @param n
	 * @param key
	 * @param valor
	 * @return
	 */
	private NodoRB<K, V> put(NodoRB<K, V> n, K key, V valor) {
		if(n == null) return new NodoRB<K, V>(key, valor, true);
		
		int cmp = key.compareTo(n.getValor().getTheKey());
		if (cmp < 0) n.setIzquierdo(put((NodoRB<K, V>)n.getIzquierdo(), key, valor));
		else if(cmp > 0) n.setDerecho(put((NodoRB<K, V>)n.getDerecho(), key, valor));
		else n.setValor(new Association<K, V>(key, valor));
		
		NodoRB<K ,V> der = (NodoRB<K, V>) n.getDerecho();
		if(der == null) der = new NodoRB<K, V>(null, null, false);
		NodoRB<K, V> izq = (NodoRB<K, V>) n.getIzquierdo();
		if(izq == null) izq = new NodoRB<K, V>(null, null, false);
		NodoRB<K, V> izqizq = (NodoRB<K, V>) izq.getIzquierdo();	
		if(izqizq == null) izqizq = new NodoRB<K, V>(null, null, false);
		
		
		if(der.getColor() && !izq.getColor()) n = rotateLeft(n);
		if(izq.getColor() && izqizq.getColor()) n = rotateRight(n);
		if(izq.getColor() && der.getColor()) flipColors(n);
		
		return n;
	}
	
	/**
	 * ROtacion a la derecha, codigo obetenido de https://algs4.cs.princeton.edu/33balanced/SplayBST.java.html
	 * @param n nodo a realizar la rotacion
	 * @return Nodo raiz
	 */
	private NodoRB<K, V> rotateRight(NodoRB<K,V> n){
		Nodo<K, V> x = n.getIzquierdo();
		n.setIzquierdo(n.getDerecho());
		x.setDerecho(n);
		return (RedBlackTree<K, V>.NodoRB<K, V>) x;
		}
	
	/**
	 * Realizar una rotacion a la izquierda, codigo obetenido de https://algs4.cs.princeton.edu/33balanced/SplayBST.java.html
	 * @param n nodo 
	 * @return
	 */
	private NodoRB<K, V> rotateLeft(NodoRB<K, V> n){
		Nodo<K, V> x = n.getDerecho();
		n.setDerecho(x.getIzquierdo());
		x.setIzquierdo(n);
		return (RedBlackTree<K, V>.NodoRB<K, V>) x;
	}
	
	/**
	 * Obtenido de https://algs4.cs.princeton.edu/33balanced/RedBlackBST.java.html
	 * @param n
	 */
	private NodoRB<K, V> flipColors(NodoRB<K, V> n) {
		n.setColor(!n.getColor());
		NodoRB<K, V> der = (NodoRB<K, V>) n.getDerecho();
		der.setColor(!der.getColor());
		n.setDerecho(der);
		NodoRB<K, V> izq = (NodoRB<K, V>) n.getIzquierdo();
		izq.setColor(!izq.getColor());
		n.setIzquierdo(izq);
		return n;
	}

	/**
	 * @author David Valenzuela 171001
	 *
	 * @param <K>
	 * @param <V>
	 */
	protected class NodoRB<L extends Comparable<L>, C> extends Nodo<L, C> {
		
		/**
		 * Color del nodo, true = rojo, false = negro
		 */
		protected Boolean color;
			
		/**
		 * Contructor de la clae
		 * @param llave
		 * @param valor
		 * @param color
		 */
		public NodoRB(L llave, C valor, Boolean color) {
			super(llave, valor);
			this.setColor(color);
		}

		/**
		 * @return the color
		 */
		private Boolean getColor() {
			if(color == null || this == null) return false;
			return color;
		}

		/**
		 * @param color the color to set
		 */
		private void setColor(Boolean color) {
			this.color = color;
		}	
	}
	
}
