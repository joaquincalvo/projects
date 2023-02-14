//Martin Rilo - 236209
//Joaquin Calvo - 203832
package sumas;

import java.io.Serializable;

public class Jugada implements Serializable{

    private Ficha ficha;
    private char direccionFicha;

    public Jugada(Ficha ficha, char direccionFicha) {
        this.ficha = ficha;
        this.direccionFicha = direccionFicha;
    }

    public Jugada() {
        this.ficha = null;
        this.direccionFicha = 'A';
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public char getDireccionFicha() {
        return direccionFicha;
    }

    public void setDireccionFicha(char direccionFicha) {
        this.direccionFicha = direccionFicha;
    }

    @Override
    public String toString() {
        return "Ficha: " + getFicha() + " Direccion: " + getDireccionFicha();
    }
}
