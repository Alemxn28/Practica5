package practica5;

import java.util.BitSet;
import java.util.Collections;

public class CodificarHuffman {

    public int[][] codificarmatriz(ArbolHuffman arbol, int[][] matriz) {
        String[] matrixcodificada = new String[matriz.length];
        int maximalong = 0, maximaposicion = 0;
        for (int i = 0; i < matrixcodificada.length; i++) {

            matrixcodificada[i] = "";

        }    
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
            matrixcodificada[maximaposicion] += GenerarCadenaR(faltante, '0');

            maximalong += faltante;
        }
        
        for (int i = 0; i < matrixcodificada.length; i++) {

            matrixcodificada[i] += GenerarCadenaR(maximalong - matrixcodificada[i].length(), '0');

        }
        int matrizcodificada[][] = new int[matrixcodificada.length][matrixcodificada[0].length() / 8];
        for (int i = 0; i < matrixcodificada.length; i++) {
            int jAux = 0;
            for (int j = 0; j < matrixcodificada[i].length(); j += 8) {

                matrizcodificada[i][jAux] = deStringAentero(matrixcodificada[i].substring(j, j + 8));
                System.out.println(matrixcodificada[i].substring(j, j + 8));
                System.out.println("Valor de j: "+j);
                 System.out.println("Valor de j+8: "+j+8);
               
 jAux++;
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

    public String GenerarCadenaR(int repeticiones, char caracterArepe) {
        String cadena = "";
        for (int i = 0; i < repeticiones; i++) {
            cadena += caracterArepe;
        }
        return cadena;

    }

    public String deEnteroaString(int entero) {
        byte[] aux = {(byte) entero};
     BitSet bit = new BitSet(8);
     bit = BitSet.valueOf(aux);
     
     String codificacion = "";
     for(int i = 0; i<8; i++){
   
         if(bit.get(7-i) == true){
            codificacion += '1';
         } else {
            codificacion += '0';
         }
     }
    return codificacion;
    }

    public int[][] decodificarMatriz(ArbolHuffman arbol, int[][] matriz, int n) {
        String[] matrixcodificada = new String[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
              matrixcodificada[i]="";
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("valor de entero: "+deEnteroaString(matriz[i][j]));
                matrixcodificada[i] += deEnteroaString(matriz[i][j]);
            }
        }
        int[][] mat = new int[matriz.length][n];
        for (int i = 0; i < matrixcodificada.length; i++) {
            int jAux = 0, end = 1, begin = 0;
            for (int j = 0; j < matrixcodificada[i].length(); j++) {
                String aux = matrixcodificada[i].substring(begin, end);
                System.out.println(aux);
                int pixel = arbol.deCadenaAPixel(aux, arbol.getRaiz());
                System.out.println("valor fila:"+i);
                System.out.println("valor pixel: "+pixel);
                end++;
                if (pixel != -4 && pixel != 256) {
                    begin = j + 1;
                    //end += 1;
                    mat[i][jAux] = pixel;
                    jAux++;

                }
                if (pixel == 256) {
                    break;
                }
            }
        }
        return mat;
    }
}
