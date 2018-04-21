import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * @author David Valenzuela 171001
 * @author Fernando Hegnstenberg 17699
 *
 */

public class Main {
	
	public static void main(String args[]) {
		BinaryTree<String, String> arbol;
		
		/* Variables */
		String filePath = "";
		String line = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese una opcion para implementacion: \n1. SplayTree \n2. RedBlack Tree");
		switch(sc.nextLine()) {
		case "1":
			arbol = BinaryTreeFactory.getTree(1);
			break;
		case "2":
			arbol = BinaryTreeFactory.getTree(2);
			break;
		default:
			System.out.println("Opcion incorrecta, arbol creado con Splay tree");
			arbol = BinaryTreeFactory.getTree(1);
			break;
		}
		
		System.out.println("Ingrese ruta del diccionario: ");
		filePath = sc.nextLine();
		
		/* Abrir el diccionario y agregar valores al arbol */
		try {
			// Leer el archivo con diccionario
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			reader.readLine(); // Omitimos la primera linea del archivo
			while((line = reader.readLine()) != null) {
				line = line.toLowerCase(); // All lowercase
				if(line.indexOf(";") > -1) line = line.substring(0, line.indexOf(";")); // Omitinos multiples traducciones
				if(line.indexOf(",") > -1) line = line.substring(0, line.indexOf(","));
				String[] kv = line.split("	"); // Separar los valores
				arbol.insertar(kv[0], kv[1]); //agregar los valores al arbol
			}
			reader.close(); // Cerramos el archivo
		} catch (Exception e) {
			System.out.println("Error");
			System.out.println(e.getMessage());
		}
		
		System.out.println("Ingrese ruta del texto a traducir: ");
		filePath = sc.nextLine();
		//sc.close();
		
		/* Abrir el textoa traducir */
		try {
			// Leer el archivo con el texto
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			line = reader.readLine().toLowerCase(); // Leer la primera linea
			line = line.substring(0, line.length() -1); // Removemos el punto
			reader.close(); // Cerramos el archivo
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		

		/* Mostrar texto Traducido */
		System.out.println("Texto traducido: \n");
		System.out.println(traducirTexto(line, arbol));
		
		sc.nextLine();
		sc.close();
		
	}
	
	/**
	 * @param textoIngles
	 * @param traducciones
	 * @return
	 */
	public static String traducirTexto(String textoIngles, BinaryTree<String, String> traducciones) {
		String palabraIngles, palabraEspa;
		String textoEspa = "";
		
		StringTokenizer listaP = new StringTokenizer(textoIngles);
		while(listaP.hasMoreTokens()) {
			palabraEspa = traducciones.buscar(palabraIngles = listaP.nextToken());
			if(palabraEspa != null) {
				textoEspa += " " + palabraEspa;
			}else {
				textoEspa += " *" + palabraIngles + "*";
			}
		}
		return textoEspa;
	}
	

}
