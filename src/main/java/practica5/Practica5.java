
package practica5;


public class Practica5 {

   
    public static void main(String[] args) {
     int arreglo[]=new int[257];
     for(int i=0;i<257;i++){
       arreglo[i]=0;
       }
     int matriz[][]={{33,21,23,4,67,6},
      {32,2,54,23,43,21}};

     ArbolHuffman ArbolHuff = new ArbolHuffman(arreglo);
     Huffmannode arbol = ArbolHuff.getRaiz();
     ArbolHuff.codificararbol(arbol, "");
     String codifica = ArbolHuff.obtenercodificacionpixel(2, arbol);
     System.out.println(codifica);
     CodificarHuffman huff = new CodificarHuffman();
    int matrizcodificada[][]=huff.codificarmatriz(ArbolHuff, matriz);
    //System.out.println(huff.deStringAentero("111"));
    // ArbolHuff.enorden(arbol);
    }
    
}
