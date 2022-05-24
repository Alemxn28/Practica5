
package practica5;


public class Huffmannode {
  private  int pixel;
    private int frecuencia;
    private String codificacion;   

Huffmannode izquierda,derecha;

public Huffmannode(int pixel, int frecuencia){
  this.pixel=pixel;
  this.frecuencia=frecuencia; 
  
  }

    public int getPixel() {
        return pixel;
    }

    public void setPixel(int pixel) {
        this.pixel = pixel;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getCodificacion() {
        return codificacion;
    }

    public void setCodificacion(String codificacion) {
        this.codificacion = codificacion;
    }

    public Huffmannode getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Huffmannode izquierda) {
        this.izquierda = izquierda;
    }

    public Huffmannode getDerecha() {
        return derecha;
    }

    public void setDerecha(Huffmannode derecha) {
        this.derecha = derecha;
    }
}
