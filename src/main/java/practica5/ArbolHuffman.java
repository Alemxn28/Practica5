
package practica5;

import java.util.PriorityQueue;


public class ArbolHuffman {
    Huffmannode raiz;
    public ArbolHuffman(int[] ArregloFrecuencias){
    PriorityQueue coladeprioridad = new PriorityQueue<Huffmannode>(new Comparador());
        for (int i = 0; i < ArregloFrecuencias.length; i++)
        {
          Huffmannode temporal = new Huffmannode(i,ArregloFrecuencias[i]);
          coladeprioridad.add(temporal);

        }
        Huffmannode temporal = (Huffmannode) coladeprioridad.peek();
       System.out.println(temporal.getFrecuencia());
    }
}
