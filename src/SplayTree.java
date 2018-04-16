/**
 * @author David Valenzuela 171001
 * @author Fernando Hegnstenberg 17699
 *
 */
public class SplayTree<K extends Comparable<K>, V> extends BinaryTree<K,V>{

	public SplayTree() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see BinaryTree#insertar(java.lang.Comparable, java.lang.Object)
	 */
	@Override
	public void insertar(K key, V valor) {
		Nodo<K , V> n = new Nodo<K, V>(key, valor);
		super.insertar(n);
		splay(n, key);
			
	}
	
	/* (non-Javadoc)
	 * @see BinaryTree#insertar(BinaryTree.Nodo)
	 */
	@Override
	public void insertar(Nodo<K, V> n) {
		super.insertar(n);
		splay(n, n.getValor().getTheKey());
	}
	
	/* (non-Javadoc)
	 * @see BinaryTree#buscar(java.lang.Comparable)
	 */
	@Override
	public V buscar(K llave) {
		return splay(new Nodo<K, V>(llave, super.buscar(llave)), llave).getValor().getTheValue();
	}
	
	/**
	 * Realizar splay del arbol sobre un nodo, codigo obetenido de https://algs4.cs.princeton.edu/33balanced/SplayBST.java.html
	 * @param n nodo sobre el cual se realizara el splay
	 * @param key llave del nodo
	 * @return Nodo raiz;
	 */
	private Nodo<K, V> splay(Nodo<K, V> n, K key) {
		if(n == null) return null;
		int comp1 = key.compareTo(n.getValor().getTheKey());
		
		if(comp1 <  0){
			if(n.getIzquierdo() == null) return n;
			int comp2 = key.compareTo(n.getIzquierdo().getValor().getTheKey());
			if(comp2 < 0) {
				n.getIzquierdo().setIzquierdo(splay(n.getIzquierdo().getIzquierdo(), key));
				n = rotateRight(n);
			} else if(comp2 > 0) {
				n.getIzquierdo().setDerecho(splay(n.getIzquierdo(), key));
				if(n.getIzquierdo().getDerecho() != null) n.setIzquierdo(rotateLeft(n.getIzquierdo()));
			}
			if(n.getIzquierdo() == null) {
				return n;
			} else {
				return rotateRight(n);
			}				
		} else if(comp1 > 0) {
			if(n.getDerecho() == null) {
				return n;
			}
			
			int comp2 = key.compareTo(n.getDerecho().getValor().getTheKey());
			if(comp2 < 0) {
				n.getDerecho().setIzquierdo(splay(n.getDerecho().getIzquierdo(), key));
				if(n.getDerecho().getIzquierdo() != null) n.setDerecho(rotateRight(n.getDerecho()));	
			}else if(comp2 > 0) {
				n.getDerecho().setDerecho(splay(n.getDerecho().getDerecho(), key));
			}
			
			if(n.getDerecho() == null) return n;
			else return rotateLeft(n);
		} else return n;	
	}
	
	/**
	 * ROtacion a la derecha, codigo obetenido de https://algs4.cs.princeton.edu/33balanced/SplayBST.java.html
	 * @param n nodo a realizar la rotacion
	 * @return Nodo raiz
	 */
	private Nodo<K, V> rotateRight(Nodo<K,V> n){
		Nodo<K, V> x = n.getIzquierdo();
		n.setIzquierdo(n.getDerecho());
		x.setDerecho(n);
		return x;
		}
	
	/**
	 * Realizar una rotacion a la izquierda, codigo obetenido de https://algs4.cs.princeton.edu/33balanced/SplayBST.java.html
	 * @param n nodo 
	 * @return
	 */
	private Nodo<K, V> rotateLeft(Nodo<K, V> n){
		Nodo<K, V> x = n.getDerecho();
		n.setDerecho(x.getIzquierdo());
		x.setIzquierdo(n);
		return x;
	}
	
	

}
