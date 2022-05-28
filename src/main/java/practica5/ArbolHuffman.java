package practica5;

import java.util.PriorityQueue;

public class ArbolHuffman {

    private Huffmannode raiz;

    public Huffmannode getRaiz() {
        return raiz;
    }

    public void setRaiz(Huffmannode raiz) {
        this.raiz = raiz;
    }

    public ArbolHuffman(int[] ArregloFrecuencias) {
        PriorityQueue coladeprioridad = new PriorityQueue<Huffmannode>(new Comparador());
        for (int i = 0; i < ArregloFrecuencias.length; i++) {
            Huffmannode temporal = new Huffmannode(i, ArregloFrecuencias[i]);
            coladeprioridad.add(temporal);

        }

        while (coladeprioridad.size() > 1) {
            Huffmannode izquierdo = (Huffmannode) coladeprioridad.poll();
            Huffmannode derecho = (Huffmannode) coladeprioridad.poll();
            Huffmannode papa = new Huffmannode(-4, izquierdo.getFrecuencia() + derecho.getFrecuencia());
            papa.setIzquierda(izquierdo);
            papa.setDerecha(derecho);
            coladeprioridad.add(papa);
        }
        this.raiz = (Huffmannode) coladeprioridad.poll();

    }

    public void enorden(Huffmannode nodo) {
        if (nodo == null) {

            return;

        }

        enorden(nodo.getIzquierda());
        System.out.println("frecuencia:" + nodo.getFrecuencia());
        System.out.println("Pixel:" + nodo.getPixel());
        System.out.println("Codificacion: " + nodo.getCodificacion());
        enorden(nodo.getDerecha());
    }

    public void codificararbol(Huffmannode nodo, String recur) {
        nodo.setCodificacion(recur);
        if (nodo.getIzquierda() != null) {

            codificararbol(nodo.getIzquierda(), recur + "0");
        }
        if (nodo.getDerecha() != null) {

            codificararbol(nodo.getDerecha(), recur + "1");
        }

    }

    public String obtenercodificacionpixel(int pixel, Huffmannode nodo) {
        if (nodo.getPixel() == pixel) {

            return nodo.getCodificacion();
        }
        String aux;
        if (nodo.getIzquierda() != null) {
            aux = obtenercodificacionpixel(pixel, nodo.getIzquierda());
            if (aux != null) {
                return aux;
            }
        }
        if (nodo.getDerecha() != null) {
            aux = obtenercodificacionpixel(pixel, nodo.getDerecha());
            if (aux != null) {
                return aux;
            }
        }
        return null;
    }

    public int deCadenaAPixel(String cadena, Huffmannode nodo) {
        if (nodo.getCodificacion().equals(cadena)) {
            return nodo.getPixel();
        }
        int aux;
        if (nodo.getIzquierda() != null) {
            aux = deCadenaAPixel(cadena, nodo.getIzquierda());
            if (aux != -1) {
                return aux;
            }
        }
        if (nodo.getDerecha() != null) {
            aux = deCadenaAPixel(cadena, nodo.getDerecha());
            if (aux != -1) {
                return aux;
            }
        }
        return -1;
    }

}
