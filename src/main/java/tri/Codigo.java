package tri;

import java.util.ArrayList;
import java.util.List;

public class Codigo {

	public static void main(String[] args) {

		int tam = 4;
		int[][] triangulo = { { 6 }, { 3, 5 }, { 9, 7, 1 }, { 4, 6, 8, 4 }};

		List<Valor> listaValor = new ArrayList<Valor>();

		if (verificarTriangulo(triangulo, tam)) {
			montarTriangulo(triangulo);

			for (int i = 0; i < triangulo.length; i++) {
				for (int j = 0; j <= i; j++) {
					if (i == 0) {
						Valor v = new Valor(triangulo[i][j], 0);
						listaValor.add(v);
					} else {
						listaValor.add(verificarMaiorValor(triangulo[i], listaValor));
						break;
					}
				}
			}

			System.out.print(total(listaValor));

		} else {
			System.out.println("Erro!!!! - Tamanho não corresponde aos níves do triângulo");
		}

	}

	public static boolean verificarTriangulo(int[][] colunas, int tam) {

		int ordem[] = new int[tam];
		boolean ok = true;

		for (int i = 0; i < colunas.length; i++) {
			for (int j = 0; j <= i; j++) {
				ordem[i] = colunas[i].length;
				// break;
			}
		}

		for (int i = 0; i < ordem.length - 1; i++) {
			if (ordem[i] >= ordem[i + 1]) {
				ok = false;
			}
		}

		return ok;
	}

	public static void montarTriangulo(int t[][]) {

		for (int i = 0; i < t.length; i++) {

			for (int j = 0; j <= i; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------");
	}

	public static Valor verificarMaiorValor(int[] linha, List<Valor> lista) {

		int aux = 0, index = 0;
		Valor v;
		int indexLinha = lista.get(lista.size() - 1).getIndex();

		if (indexLinha == 0) {
			if (linha[indexLinha] > linha[indexLinha + 1]) {
				aux = linha[indexLinha];
			} else {
				aux = linha[indexLinha + 1];
			}
		} else {
			if (linha[indexLinha] > linha[indexLinha + 1]) {
				aux = linha[indexLinha];
			} else {
				aux = linha[indexLinha + 1];
			}
		}

		for (int i = 0; i < linha.length; i++) {
			if (aux == linha[i]) {
				index = i;
				break;
			}
		}

		v = new Valor(aux, index);
		return v;
	}
	
	public static int total(List<Valor> listaValor){
		int resultado =0;

		for (int i = 0; i < listaValor.size(); i++) {
			if (i == listaValor.size() - 1) {
				System.out.print(listaValor.get(i).getMaior() + "=");
			} else {
				System.out.print(listaValor.get(i).getMaior() + "+");
			}
			resultado += listaValor.get(i).getMaior();
		}

		return resultado;
	}

}
