package practica5;

import java.util.BitSet;
import java.util.Collections;

public class CodificarHuffman {

    public int[][] codificarmatriz(ArbolHuffman arbol, int[][] matriz) {
        String[] matrixcodificada = new String[matriz.length];
        int maximalong = 0, maximaposicion = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matrixcodificada[i] += arbol.obtenercodificacionpixel(matriz[i][j], arbol.getRaiz());
            }
            matrixcodificada[i] += arbol.obtenercodificacionpixel(256, arbol.getRaiz());
            maximalong = Math.max(maximalong, matrixcodificada[i].length());
            if (maximalong == matrixcodificada[i].length()) {

                maximaposicion = i;
            }
        }
        if (maximalong % 8 != 0) {
            int faltante = 8 - (maximalong % 8);
            matrixcodificada[maximaposicion] = String.join(matrixcodificada[maximaposicion], Collections.nCopies(faltante, "0"));
            maximalong += faltante;
        }
        for (String cadena : matrixcodificada) {
            cadena = String.join(cadena, Collections.nCopies(maximalong - cadena.length(), "0"));
        }
        int matrizcodificada[][] = new int[matrixcodificada.length][matrixcodificada[0].length() / 8];
        for (int i = 0; i < matrixcodificada.length; i++) {
            int jAux = 0;
            for (int j = 0; j < matrixcodificada[i].length(); j += 8) {
                matrizcodificada[i][jAux] = deStringAentero(matrixcodificada[i].substring(j, j + 8));

            }

        }
        return matrizcodificada;
    }

    public int deStringAentero(String numerocodificado) {
        BitSet bit = new BitSet(numerocodificado.length());
        for (int i = 0; i < numerocodificado.length(); i++) {
            if (numerocodificado.charAt(i) == '1') {
                bit.set(i, true);
            }

        }
        int numero = 0;
        for (int i = 0; i < bit.size(); i++) {
            if (bit.get(i) == true) {
                numero += (Math.pow(2, i));
            }

        }
        return numero;
    }
}
