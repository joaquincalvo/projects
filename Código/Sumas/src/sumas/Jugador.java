//Martin Rilo - 236209
//Joaquin Calvo - 203832
package sumas;
import java.io.Serializable;
import java.util.Observable;
public class Jugador extends Observable implements Comparable<Jugador>, Serializable {

    private String nombreJugador;
    private String apodoJugador;
    private int edadJugador;
    private int partidasGanadas;

    public Jugador() {

        nombreJugador = "";
        apodoJugador = "";
        edadJugador = 0;
        partidasGanadas = 0;
    }

    public Jugador(String nombreJugador, String apodoJugador, int edadJugador) {

        this.nombreJugador = nombreJugador;
        this.apodoJugador = apodoJugador;
        this.edadJugador = edadJugador;
        this.partidasGanadas = 0;

    }

    public String getNombreJugador() {
        return nombreJugador;
        
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.setChanged();
        this.notifyObservers();
    }

    public String getApodoJugador() {
        return apodoJugador;
    }

    public void setApodoJugador(String apodoJugador) {
        this.apodoJugador = apodoJugador;
        this.setChanged();
        this.notifyObservers();
    }

    public int getEdadJugador() {
        return edadJugador;
    }

    public void setEdadJugador(int edadJugador) {
        this.edadJugador = edadJugador;
        this.setChanged();
        this.notifyObservers();
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public int compareTo(Jugador j) {
        return j.getPartidasGanadas() - this.getPartidasGanadas();
    }

    public boolean equalsJugador(Object obj) {

        Jugador otroJ = (Jugador) obj;
        if (this.getApodoJugador().equals(otroJ.getApodoJugador())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return getApodoJugador();
    }

}
