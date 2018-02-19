package ht;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import tri.Codigo;
import tri.Valor;

public class CodigoTest extends TestCase {

	public void testTrianguloTamanhoQuantidade() {

		int tam = 7;
		int tri[][] = { { 6 }, { 3, 5 }, { 9, 7, 1 }, { 4, 6, 8, 4 }, { 2, 5, 9, 0, 7 }, { 6, 8, 0, 1, 2, 4 },
				{ 6, 8, 0, 1, 7, 9, 3 } };

		boolean trianguloOk = Codigo.verificarTriangulo(tri, tam);

		assertEquals(trianguloOk, true);

	}

	public void testeTrianguloVerificaNiveis() {

		int tam = 7;
		int tri[][] = { { 6 }, { 3, 5 }, { 9, 7, 1 }, { 4, 6, 8, 4 }, { 2, 5, 9, 0, 7 }, { 6, 8, 0, 1, 2, 4 },
				{ 6, 8, 3 } };

		boolean trianguloOk = Codigo.verificarTriangulo(tri, tam);

		assertEquals(trianguloOk, true);
	}

	public void testeTrianguloVerificaTotal() {

		int tam = 4;
		int tri[][] = { { 6 }, { 3, 5 }, { 9, 7, 1 }, { 4, 6, 8, 4 } };

		boolean ok = Codigo.verificarTriangulo(tri, tam);
		List<Valor> listaValor = new ArrayList<Valor>();

		if (ok) {
			for (int i = 0; i < tri.length; i++) {
				for (int j = 0; j <= i; j++) {
					if (i == 0) {
						Valor v = new Valor(tri[i][j], 0);
						listaValor.add(v);
					} else {
						listaValor.add(Codigo.verificarMaiorValor(tri[i], listaValor));
						break;
					}
				}
			}
		}

		assertEquals(26, Codigo.total(listaValor));

	}

}
