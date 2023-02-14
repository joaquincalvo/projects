//Martin Rilo - 236209
//Joaquin Calvo - 203832
package sumas;

import java.io.Serializable;

public class Ficha implements Comparable<Ficha>, Serializable {

    private int numero;
    private String color;
    private int posicionFila;
    private int posicionColumna;

    public Ficha() {
        this.numero = 0;
        this.color = "NEUTRO";
        this.posicionFila = 0;
        this.posicionColumna = 0;
    }

    public Ficha(int numero, String color, int posicionFila, int posicionColumna) {
        this.numero = numero;
        this.color = color;
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPosicionFila() {
        return posicionFila;
    }

    public void setPosicionFila(int posicionFila) {
        this.posicionFila = posicionFila;
    }

    public int getPosicionColumna() {
        return posicionColumna;
    }

    public void setPosicionColumna(int posicionColumna) {
        this.posicionColumna = posicionColumna;
    }

    @Override

    public int compareTo(Ficha f) {
        return this.getNumero() - f.getNumero();
    }

    @Override
    public String toString() {
        String retorno;
        retorno = "" + getNumero();
        return retorno;
    }

    public boolean equalsFicha(Object obj) {

        Ficha otraF = (Ficha) obj;
        return this.getNumero() == otraF.getNumero();
    }

}
