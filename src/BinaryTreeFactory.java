/**
 * @author David Valenzuela 171001
 * @author Fernando Hegnstenberg 17699
 *
 */
public class BinaryTreeFactory {

	/**
	 * Fabrica de BinaryTress
	 * @param type tipo de arbol a implementar, 1 = SplayTree, 2 = RedBlack Tree, por defecto se crea SPlay tree
	 * @return instancia del arbol seleccionado;
	 */
	public static <K extends Comparable<K>, V> BinaryTree<K, V> getTree(int type){
		switch(type) {
		case 1:
			return new SplayTree<K, V>();
		case 2:
			return new RedBlackTree<K, V>();
		default:
			return new SplayTree<K, V>();
		}
	}
	
}
