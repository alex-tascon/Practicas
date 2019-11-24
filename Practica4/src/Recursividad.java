import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Recursividad {

	/**
	 * Método invertirFrase, que recibe un String y lo devuelve invertido letra a letra, de forma recursiva
	 * @param palabra String a invertir
	 * @return String invertido
	 */
	private static String invertirFrase(String frase) { 
		if (frase.length() == 1) {
			return frase;
		} else {
			return invertirFrase(frase.substring(1)) + frase.charAt(0);
		}
	}
	
	/**
	 * Método invertirPalabras, que recibe un String y lo devuelve invertido palabra a palabra (considerando los separadores
	 * habituales espacio, tabulador, salto de línea, símbolos de puntuación), de forma recursiva
	 * @param frase String a invertir
	 * @return String invertido
	 */
	private static String invertirPalabras(String frase) {
		if (frase == null | frase.length() == 0) return frase;
		int pos = frase.indexOf(" ");
		if (pos > -1) {
			return invertirPalabras(frase.substring(pos+1)) + " " + frase.substring(0, pos);
		} else {
			return frase;
		}
	}
	
	/**
	 * Método longAHexa, que recibe un long y devuelve la conversión de ese long a hexadecimal, de forma recursiva
	 * @param numero long recibido
	 * @return String del long en hexadecimal
	 */
	private static String longAHexa(long numero) {
		if (numero == 0) {
			return "";
		} else {
			long num2 = numero % 16;
			if (num2 == 10) return longAHexa(numero / 16) + "A"; else if (num2 == 11) return longAHexa(numero / 16) + "B";
			else if (num2 == 12) return longAHexa(numero / 16) + "C"; else if (num2 == 13) return longAHexa(numero / 16) + "D";
			else if (num2 == 14) return longAHexa(numero / 16) + "E"; else if (num2 == 15) return longAHexa(numero / 16) + "F";
			else return longAHexa(numero / 16) + Long.toString(num2);
		}
	}
	
	/**
	 * Método sacaPalabras, que recibe un fichero de texto y devuelve un ArrayList de Strings con todas las palabras del fichero
	 * de texto en orden inverso a como aparecen, de forma recursiva
	 * @throws Exception 
	 */
	private static ArrayList<String> sacaPalabras(File fichero) {
		return null;
	}
	
	/**
	 * Método ordenaQuick, que recibe un arraylist de Strings (por ejemplo las palabras del 4.4.) y devuelve ese arraylist ordenado
	 * alfabéticamente por el método quicksort, de forma recursiva (observa que puede haber palabras repetidas)
	 * @param listaStrings String a ordenar
	 * @param i Límite inferior
	 * @param d Límite superior
	 */
	private static void ordenaQuick(ArrayList<String> listaStrings, int i, int d) {
		int izda = i; int dcha = d; int pivote = (izda + dcha) / 2;
		do {
			while (listaStrings.get(izda).compareToIgnoreCase(listaStrings.get(pivote)) < 0) { izda++; }
			while (listaStrings.get(izda).compareToIgnoreCase(listaStrings.get(pivote)) > 0) { dcha--; }
			if (izda <= dcha) {
				String aux = listaStrings.get(izda); listaStrings.set(izda, listaStrings.get(dcha));
				listaStrings.set(dcha, aux); izda++; dcha--;
			}
		} while (izda <= dcha);
		if (i < dcha) { ordenaQuick(listaStrings, i, dcha); }
		if (izda < d) { ordenaQuick(listaStrings, izda, d); }
	}
	
	private static void ordenaQuick(ArrayList<String> listaStrings) {
		ordenaQuick(listaStrings, 0, listaStrings.size() - 1);
	}
	
	/**
	 * Método buscaPalabra, que recibe un arraylist de Strings ordenado y una palabra, y devuelve la posición en la que se encuentra
	 * esa palabra (si está repetida, la posición de la última ocurrencia). De forma recursiva y utilizando un proceso de coste
	 * logarítmico
	 * @param lista Lista donde buscar
	 * @param palabra Palabra que buscar
	 * @return Posición del elemento
	 */
	private static int buscaPalabra(ArrayList<String> lista, String palabra, int indice) {
		if (indice == lista.size() || lista.get(indice).equals(palabra)) {
			if (indice == lista.size()) {
				return -1;
			} else {
				return indice;
			}
		} else {
			return buscaPalabra(lista, palabra, indice + 1);
		}
	}
	
	private static int buscaPalabra(ArrayList<String> lista, String palabra) {
		return buscaPalabra(lista, palabra, 0);
	}
	
	public static void main(String[] args) {
		// 1
		System.out.println(invertirFrase("Recursividad"));
		
		// 2
		System.out.println(invertirPalabras("No temo al examen"));
		
		// 3
		System.out.println(longAHexa(125));
		
		// 4
		
		
		// 5
		ArrayList<String> lista = new ArrayList<String>(Arrays.asList("Suspenso", "Aprobado", "Notable", "Sobresaliente"));
		//ordenaQuick(lista);
		//System.out.println(lista);
		
		// 6
		System.out.println(buscaPalabra(lista, "Notable"));
	}
}
