
public class SplayTree<K extends Comparable<K>, V> extends BinaryTree<K,V>{

	public SplayTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private Nodo<K, V>  splay(Nodo<K, V> n, K key) {
		if(n == null) return null;
		int comp1 = key.compareTo(n.getValor().getTheKey());
		
		if(comp1 <  0){
			if(n.getIzquierdo() == null) return n;
			int comp2 = key.compareTo(n.getIzquierdo().getValor().getTheKey());
			if(comp2 < 0) {
				n.getIzquierdo().setIzquierdo(splay(n.getIzquierdo().getIzquierdo(), key));
				n = rotateRight(n);
			} else if(comp2 > 0) {
				n.getIzquierdo().setDerecho(splay(n.getIzquierdo()), key);
				if(n.getIzquierdo().getDerecho() != null) 
			}
		}
		
	}
	
	/**
	 * @param n
	 * @return
	 */
	private Nodo<K, V> rotateRight(Nodo<K,V> n){
		Nodo<K, V> x = n.getIzquierdo();
		n.setIzquierdo(n.getDerecho());
		x.setDerecho(n);
		return x;
		}
	
	private Nodo<K, V> rotateLeft(Nodo<K, V> n){
		
	}
	
	

}
