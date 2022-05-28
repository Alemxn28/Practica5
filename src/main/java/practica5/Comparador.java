
package practica5;

import java.util.Comparator;


public class Comparador implements Comparator<Huffmannode>{
    public int compare(Huffmannode a,Huffmannode b){
     if(a.getFrecuencia()>b.getFrecuencia()){
    return 1;       
        }
     return -1;
    }
  
}
