//Martin Rilo - 236209
//Joaquin Calvo - 203832
package sumas;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Partida implements Comparable<Partida>, Serializable {

    private Jugador jugadorRojo;
    private Jugador jugadorAzul;
    private int formaTerminacion;
    //1 - Cantidad de movimientos totales.
    //2 - Primero en llegar al otro lado.
    //3 - Primero en llegar con todas las piezas al otro lado.
    private int hora;
    private int minutos;
    private ArrayList<Jugada> jugadas;

    public Partida(Jugador jugadorRojo, Jugador jugadorAzul, int formaTerminacion) {
        this.jugadorRojo = jugadorRojo;
        this.jugadorAzul = jugadorAzul;
        this.formaTerminacion = formaTerminacion;
        this.hora = LocalDateTime.now().getHour();
        this.minutos = LocalDateTime.now().getMinute();
        this.jugadas = new ArrayList<>();
    }

    public Jugador getJugadorRojo() {
        return jugadorRojo;
    }

    public void setJugadorRojo(Jugador jugadorRojo) {
        this.jugadorRojo = jugadorRojo;
    }

    public Jugador getJugadorAzul() {
        return jugadorAzul;
    }

    public void setJugadorAzul(Jugador jugadorAzul) {
        this.jugadorAzul = jugadorAzul;
    }

    public int getFormaTerminacion() {
        return formaTerminacion;
    }

    public void setFormaTerminacion(int formaTerminacion) {
        this.formaTerminacion = formaTerminacion;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public ArrayList<Jugada> getJugadas() {
        return jugadas;
    }

    public void agregarJugada(Jugada jugada) {
        this.getJugadas().add(jugada);
    }

    @Override
    public int compareTo(Partida p) {
        int resultado = this.getHora() - p.getHora();
        if (resultado == 0) {
            resultado = this.getMinutos() - p.getMinutos();

        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Jugador Rojo: " + getJugadorRojo() + " - Jugador Azul: " + getJugadorAzul() + " - Forma Terminacion: " + getFormaTerminacion() + " - Hora: " + getHora() + ":" + getMinutos();
    }
}
