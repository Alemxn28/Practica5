package practica5;

public class Practica5 {

    public static void main(String[] args) {
        int arreglo[] = new int[257];
        for (int i = 0; i < 257; i++) {
            arreglo[i] = 0;
        }
        arreglo[33]++;
        arreglo[21]++;
        arreglo[23]++;
        arreglo[4]++;
        arreglo[67]++;
        arreglo[6]++;
        int matriz[][] = {{33, 21, 23, 4, 67, 6},
        {33, 21, 23, 4, 67, 6}};

        ArbolHuffman ArbolHuff = new ArbolHuffman(arreglo);
        Huffmannode arbol = ArbolHuff.getRaiz();
        ArbolHuff.codificararbol(arbol, "");
        String codifica = ArbolHuff.obtenercodificacionpixel(2, arbol);
        System.out.println(codifica);
        CodificarHuffman huff = new CodificarHuffman();
      ArbolHuff.enorden(arbol);  
      int matrizcodificada[][] = huff.codificarmatriz(ArbolHuff, matriz);
      int matrizdecodificada[][]=huff.decodificarMatriz(ArbolHuff, matrizcodificada, 6);
    
      for (int i = 0; i < matrizdecodificada.length; i++) {
            for (int j = 0; j < matrizdecodificada[i].length; j++) {
                System.out.print(matrizdecodificada[i][j] + " ");
            }
            System.out.println();
        }
        //System.out.println(huff.deStringAentero("111"));
         
    }

}
