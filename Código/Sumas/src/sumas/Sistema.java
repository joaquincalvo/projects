//Martin Rilo - 236209
//Joaquin Calvo - 203832
package sumas;

import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Observable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;

public class Sistema extends Observable {

    public ArrayList<Jugador> jugadores = new ArrayList<>();
    public ArrayList<Partida> partidas = new ArrayList<>();
    public ArrayList<Ficha> fichas = new ArrayList<>();
    public Tablero tablero = new Tablero();

    public Sistema() {
        this.jugadores = cargarJugadores();
        this.partidas = cargarPartidas();
    }

    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Grabar() {

        try {

            ObjectOutputStream escribirJugadores = new ObjectOutputStream(new FileOutputStream("archivos/jugadores.dat"));
            escribirJugadores.writeObject(jugadores);
            escribirJugadores.close();

            ObjectOutputStream escribirPartidas = new ObjectOutputStream(new FileOutputStream("archivos/partidas.dat"));
            escribirPartidas.writeObject(partidas);
            escribirPartidas.close();

        } catch (Exception e) {

        }

    }

    public ArrayList<Jugador> cargarJugadores() {
        try {
            ObjectInputStream recuperarJugadores = new ObjectInputStream(new FileInputStream("archivos/jugadores.dat"));
            ArrayList<Jugador> jugadoresViejos = new ArrayList<>();
            jugadores = (ArrayList<Jugador>) recuperarJugadores.readObject();
            recuperarJugadores.close();
        } catch (Exception e) {

        }

        return jugadores;

    }

    public ArrayList<Partida> cargarPartidas() {

        try {
            ObjectInputStream recuperarJugadas = new ObjectInputStream(new FileInputStream("archivos/partidas.dat"));
            ArrayList<Partida> jugadasViejos = new ArrayList<>();
            partidas = (ArrayList<Partida>) recuperarJugadas.readObject();
            recuperarJugadas.close();
        } catch (Exception e) {

        }

        return partidas;
    }

//Para pedir una palabra entre un rango de valores    
    public boolean stringRango(String palabra, int desde, int hasta) {
        boolean valido = false;
        try {
            valido = palabra.length() >= desde && palabra.length() <= hasta;
            if (!valido) {
            }
        } catch (InputMismatchException ex) {
        }
        return valido;
    }

    //Para pedir un valor entre un rango de valores
    public boolean intRango(int numero, int desde, int hasta) {
        boolean valido = false;

        try {
            valido = numero >= desde && numero <= hasta;
            if (!valido) {
            }
        } catch (InputMismatchException ex) {
        }

        return valido;
    }

    //Agrega un jugador
    public boolean agregarJugador(Jugador j) {
        boolean existe = false;
        if (!jugadores.isEmpty()) {
            for (int i = 0; i < jugadores.size(); i++) {
                if (jugadores.get(i).equalsJugador(j)) {
                    existe = true;
                }
            }

        }
        if (!existe) {
            jugadores.add(j);
        }

        return existe;

    }

    public ArrayList<Jugador> getListaJugadores() {
        return jugadores;
    }

    //Ordena la lista de jugadores por cantidad de partidas ganadas
    public boolean ranking() {
        boolean ordena = false;
        if (!jugadores.isEmpty()) {
            Collections.sort(jugadores);
            ordena = true;
        }
        return ordena;
    }

    //Define si ambos jugadores no tienen movimientos
    public boolean sinMovimientos() {
        boolean termina = false;
        ArrayList<Ficha> movimientosPosibles = verMovimientos();
        String turno = tablero.getColorTurno();
        if (movimientosPosibles.isEmpty()) {
            if (tablero.getColorTurno().equals("ROJO")) {
                tablero.setColorTurno("AZUL");
            } else {
                tablero.setColorTurno("ROJO");
            }
            if (movimientosPosibles.isEmpty()) {
                termina = true;
            }
        }
        tablero.setColorTurno(turno);
        return termina;
    }

    //Carga cada ficha en su respectiva posicion X e Y
    public void cargaFichas() {
        tablero.reiniciarMatriz();
        for (int i = 0; i < fichas.size(); i++) {
            Ficha ficha = fichas.get(i);
            tablero.setMatriz(ficha.getPosicionFila(), ficha.getPosicionColumna(), ficha);
        }
    }

    //Inicializa cada ficha con color, numero y posicio X e Y
    public void inicializarFicha() {
        fichas.clear();
        Ficha a1 = new Ficha(1, "AZUL", 0, 1);
        fichas.add(a1);
        Ficha a2 = new Ficha(2, "AZUL", 0, 2);
        fichas.add(a2);
        Ficha a3 = new Ficha(3, "AZUL", 0, 3);
        fichas.add(a3);
        Ficha a4 = new Ficha(4, "AZUL", 0, 4);
        fichas.add(a4);
        Ficha a5 = new Ficha(5, "AZUL", 0, 5);
        fichas.add(a5);
        Ficha a6 = new Ficha(6, "AZUL", 0, 6);
        fichas.add(a6);
        Ficha a7 = new Ficha(7, "AZUL", 0, 7);
        fichas.add(a7);
        Ficha a8 = new Ficha(8, "AZUL", 0, 8);
        fichas.add(a8);

        Ficha r1 = new Ficha(1, "ROJO", 7, 7);
        fichas.add(r1);
        Ficha r2 = new Ficha(2, "ROJO", 7, 6);
        fichas.add(r2);
        Ficha r3 = new Ficha(3, "ROJO", 7, 5);
        fichas.add(r3);
        Ficha r4 = new Ficha(4, "ROJO", 7, 4);
        fichas.add(r4);
        Ficha r5 = new Ficha(5, "ROJO", 7, 3);
        fichas.add(r5);
        Ficha r6 = new Ficha(6, "ROJO", 7, 2);
        fichas.add(r6);
        Ficha r7 = new Ficha(7, "ROJO", 7, 1);
        fichas.add(r7);
        Ficha r8 = new Ficha(8, "ROJO", 7, 0);
        fichas.add(r8);
        
    }

    //Genera una lista con las fichas que tienen posibles movimientos
    public ArrayList<Ficha> verMovimientos() {
        ArrayList<Ficha> movimientos = new ArrayList<>();
        boolean aux = false;
        if (tablero.getColorTurno().equals("ROJO")) {
            for (int i = 0; i < fichas.size(); i++) {
                if (fichas.get(i).getColor().equals("ROJO")) {
                    //VERTICAL
                    if ((fichas.get(i).getPosicionFila() - 1) < 0) {
                        aux = true;
                    } else if (tablero.getMatriz()[(fichas.get(i).getPosicionFila()) - 1][fichas.get(i).getPosicionColumna()] == null) {
                        movimientos.add(fichas.get(i));
                    }
                    //IZQUIERDA
                    if ((fichas.get(i).getPosicionFila() - 1) < 0 || fichas.get(i).getPosicionColumna() - 1 < 0) {
                        aux = true;
                    } else if (tablero.getMatriz()[(fichas.get(i).getPosicionFila()) - 1][fichas.get(i).getPosicionColumna() - 1] == null) {

                        movimientos.add(fichas.get(i));

                    }
                    //DERECHA
                    if ((fichas.get(i).getPosicionFila() - 1) < 0 || (fichas.get(i).getPosicionColumna() + 1) > 8) {
                        aux = true;
                    } else if (tablero.getMatriz()[(fichas.get(i).getPosicionFila()) - 1][fichas.get(i).getPosicionColumna() + 1] == null) {

                        movimientos.add(fichas.get(i));

                    }
                }
            }
        } else if (tablero.getColorTurno().equals("AZUL")) {
            for (int i = 0; i < fichas.size(); i++) {
                if (fichas.get(i).getColor().equals("AZUL")) {
                    //VERTICAL
                    if ((fichas.get(i).getPosicionFila() + 1) > 7) {
                        aux = true;
                    } else if (tablero.getMatriz()[(fichas.get(i).getPosicionFila()) + 1][fichas.get(i).getPosicionColumna()] == null) {

                        movimientos.add(fichas.get(i));
                    }
                    //IZQUIERDA
                    if ((fichas.get(i).getPosicionFila() + 1) > 7 || fichas.get(i).getPosicionColumna() - 1 < 0) {
                        aux = true;
                    } else if (tablero.getMatriz()[(fichas.get(i).getPosicionFila()) + 1][fichas.get(i).getPosicionColumna() - 1] == null) {

                        movimientos.add(fichas.get(i));

                    }
                    //DERECHA
                    if ((fichas.get(i).getPosicionFila() + 1) > 7 || (fichas.get(i).getPosicionColumna() + 1) > 8) {
                        aux = true;
                    } else if (tablero.getMatriz()[(fichas.get(i).getPosicionFila()) + 1][fichas.get(i).getPosicionColumna() + 1] == null) {

                        movimientos.add(fichas.get(i));

                    }
                }
            }
        }
        ArrayList<Ficha> movimientosRetorno = new ArrayList<>();
        for (int i = 0; i < movimientos.size(); i++) {
            if (!(movimientosRetorno.contains(movimientos.get(i)))) {
                movimientosRetorno.add(movimientos.get(i));
            }

        }
        return movimientosRetorno;
    }

    
    //Mueve ficha
    public boolean moverFicha(String movida, Partida partida, int tipoMov) {
        boolean valido = false;
        int numeroFicha = 0;
        if (movida.length() == 2) {
            try {
                numeroFicha = Integer.parseInt(movida.substring(0, 1));
            } catch (NumberFormatException ex) {
            }
            char direccionMovida = movida.charAt(1);
            if (numeroFicha > 0 && numeroFicha < 9) {
                for (int i = 0; i < fichas.size(); i++) {
                    if (fichas.get(i).getNumero() == numeroFicha && fichas.get(i).getColor().equals(tablero.getColorTurno()) && tablero.getColorTurno().equals("ROJO")) {
                        if (direccionMovida == 'D') {
                            if (fichas.get(i).getPosicionFila() - 1 >= 0 && fichas.get(i).getPosicionColumna() + 1 < 9) {
                                if (tablero.getMatriz()[fichas.get(i).getPosicionFila() - 1][fichas.get(i).getPosicionColumna() + 1] == null) {
                                    fichas.get(i).setPosicionFila(fichas.get(i).getPosicionFila() - 1);
                                    fichas.get(i).setPosicionColumna(fichas.get(i).getPosicionColumna() + 1);
                                    valido = true;
                                }
                            }
                        } else if (direccionMovida == 'I') {
                            if (fichas.get(i).getPosicionFila() - 1 >= 0 && fichas.get(i).getPosicionColumna() - 1 >= 0) {
                                if (tablero.getMatriz()[fichas.get(i).getPosicionFila() - 1][fichas.get(i).getPosicionColumna() - 1] == null) {
                                    fichas.get(i).setPosicionFila(fichas.get(i).getPosicionFila() - 1);
                                    fichas.get(i).setPosicionColumna(fichas.get(i).getPosicionColumna() - 1);
                                    valido = true;
                                }
                            }
                        } else if (direccionMovida == 'A') {
                            if (fichas.get(i).getPosicionFila() - 1 >= 0) {
                                if (tablero.getMatriz()[fichas.get(i).getPosicionFila() - 1][fichas.get(i).getPosicionColumna()] == null) {
                                    fichas.get(i).setPosicionFila(fichas.get(i).getPosicionFila() - 1);
                                    valido = true;
                                }
                            }
                        }
                        if (valido && tipoMov == 1) {
                            tablero.getMatriz()[fichas.get(i).getPosicionFila()][fichas.get(i).getPosicionColumna()] = null;
                            Jugada jugada = new Jugada(fichas.get(i), direccionMovida);
                            partida.agregarJugada(jugada);
                            cargaFichas();
                        } else if (tipoMov == 2) {
                            tablero.getMatriz()[fichas.get(i).getPosicionFila()][fichas.get(i).getPosicionColumna()] = null;
                            cargaFichas();
                        }
                    }
                    if (fichas.get(i).getNumero() == numeroFicha && fichas.get(i).getColor().equals(tablero.getColorTurno()) && tablero.getColorTurno().equals("AZUL")) {
                        if (direccionMovida == 'D') {
                            if (fichas.get(i).getPosicionFila() + 1 < 8 && fichas.get(i).getPosicionColumna() + 1 < 9) {
                                if (tablero.getMatriz()[fichas.get(i).getPosicionFila() + 1][fichas.get(i).getPosicionColumna() + 1] == null) {
                                    fichas.get(i).setPosicionFila(fichas.get(i).getPosicionFila() + 1);
                                    fichas.get(i).setPosicionColumna(fichas.get(i).getPosicionColumna() + 1);
                                    valido = true;
                                }
                            }
                        } else if (direccionMovida == 'I') {
                            if (fichas.get(i).getPosicionFila() + 1 < 8 && fichas.get(i).getPosicionColumna() - 1 >= 0) {
                                if (tablero.getMatriz()[fichas.get(i).getPosicionFila() + 1][fichas.get(i).getPosicionColumna() - 1] == null) {
                                    fichas.get(i).setPosicionFila(fichas.get(i).getPosicionFila() + 1);
                                    fichas.get(i).setPosicionColumna(fichas.get(i).getPosicionColumna() - 1);
                                    valido = true;
                                }
                            }
                        } else if (direccionMovida == 'A') {
                            if (fichas.get(i).getPosicionFila() + 1 < 8) {
                                if (tablero.getMatriz()[fichas.get(i).getPosicionFila() + 1][fichas.get(i).getPosicionColumna()] == null) {
                                    fichas.get(i).setPosicionFila(fichas.get(i).getPosicionFila() + 1);
                                    valido = true;
                                }
                            }
                        }
                        if (valido && tipoMov == 1) {
                            tablero.getMatriz()[fichas.get(i).getPosicionFila()][fichas.get(i).getPosicionColumna()] = null;
                            Jugada jugada = new Jugada(fichas.get(i), direccionMovida);
                            partida.agregarJugada(jugada);
                            cargaFichas();
                        } else if (tipoMov == 2) {
                            tablero.getMatriz()[fichas.get(i).getPosicionFila()][fichas.get(i).getPosicionColumna()] = null;
                            cargaFichas();
                        }
                    }
                }
            }
        }
        return valido;
    }

    //Una vez hecho un movimiento, genera nuevos movimientos posibles
    public ArrayList<String> verMovimientosExtra(String entrada, Partida partida) {
        ArrayList<String> movimientosExtra = new ArrayList<>();
        cargaFichas();
        boolean valido = false;
        Ficha ficha = null;
        if (entrada.length() == 2) {
            int numeroFicha = Integer.parseInt(entrada.substring(0, 1));
            for (int i = 0; i < fichas.size(); i++) {
                if (tablero.getColorTurno().equals("ROJO")) {
                    if (fichas.get(i).getColor().equals("ROJO") && fichas.get(i).getNumero() == numeroFicha) {
                        ficha = new Ficha(fichas.get(i).getNumero(), fichas.get(i).getColor(), fichas.get(i).getPosicionFila(), fichas.get(i).getPosicionColumna());
                    }
                }
                if (tablero.getColorTurno().equals("AZUL")) {
                    if (fichas.get(i).getColor().equals("AZUL") && fichas.get(i).getNumero() == numeroFicha) {
                        ficha = new Ficha(fichas.get(i).getNumero(), fichas.get(i).getColor(), fichas.get(i).getPosicionFila(), fichas.get(i).getPosicionColumna());
                    }
                }
            }
            int contadorDD = ficha.getNumero();
            int contadorDI = ficha.getNumero();
            int contadorH = ficha.getNumero();
            int contadorV = ficha.getNumero();

            //DIAGONAL DERECHA
            int filaAux = ficha.getPosicionFila() - 1;
            int coluAux = ficha.getPosicionColumna() + 1;
            while (filaAux > -1 && coluAux < 9) {
                if (tablero.getMatriz()[filaAux][coluAux] != null) {
                    contadorDD = tablero.getMatriz()[filaAux][coluAux].getNumero() + contadorDD;
                }
                filaAux = filaAux - 1;
                coluAux = coluAux + 1;
            }
            filaAux = ficha.getPosicionFila() + 1;
            coluAux = ficha.getPosicionColumna() - 1;
            while (filaAux < 8 && coluAux > -1) {
                if (tablero.getMatriz()[filaAux][coluAux] != null) {
                    contadorDD = tablero.getMatriz()[filaAux][coluAux].getNumero() + contadorDD;
                }
                filaAux = filaAux + 1;
                coluAux = coluAux - 1;
            }

            //DIAGONAL IZQUIERDA
            filaAux = ficha.getPosicionFila() - 1;
            coluAux = ficha.getPosicionColumna() - 1;
            while (filaAux > -1 && coluAux > -1) {
                if (tablero.getMatriz()[filaAux][coluAux] != null) {
                    contadorDI = tablero.getMatriz()[filaAux][coluAux].getNumero() + contadorDI;
                }
                filaAux = filaAux - 1;
                coluAux = coluAux - 1;
            }
            filaAux = ficha.getPosicionFila() + 1;
            coluAux = ficha.getPosicionColumna() + 1;
            while (filaAux < 8 && coluAux < 9) {
                if (tablero.getMatriz()[filaAux][coluAux] != null) {
                    contadorDI = tablero.getMatriz()[filaAux][coluAux].getNumero() + contadorDI;
                }
                filaAux = filaAux + 1;
                coluAux = coluAux + 1;
            }

            //HORIZONTAL
            filaAux = ficha.getPosicionFila();
            coluAux = ficha.getPosicionColumna() + 1;
            while (coluAux < 9) {
                if (tablero.getMatriz()[filaAux][coluAux] != null) {
                    contadorH = tablero.getMatriz()[filaAux][coluAux].getNumero() + contadorH;
                }
                coluAux = coluAux + 1;
            }
            filaAux = ficha.getPosicionFila();
            coluAux = ficha.getPosicionColumna() - 1;
            while (coluAux > -1) {
                if (tablero.getMatriz()[filaAux][coluAux] != null) {
                    contadorH = tablero.getMatriz()[filaAux][coluAux].getNumero() + contadorH;
                }
                coluAux = coluAux - 1;
            }

            //VERTICAL
            filaAux = ficha.getPosicionFila() + 1;
            coluAux = ficha.getPosicionColumna();
            while (filaAux < 8) {
                if (tablero.getMatriz()[filaAux][coluAux] != null) {
                    contadorV = tablero.getMatriz()[filaAux][coluAux].getNumero() + contadorV;
                }
                filaAux = filaAux + 1;
            }
            filaAux = ficha.getPosicionFila() - 1;
            coluAux = ficha.getPosicionColumna();
            while (filaAux > -1) {
                if (tablero.getMatriz()[filaAux][coluAux] != null) {
                    contadorV = tablero.getMatriz()[filaAux][coluAux].getNumero() + contadorV;
                }
                filaAux = filaAux - 1;
            }
            String movimiento = "";
            if (contadorDI > 0 && contadorDI < 9) {
                for (int i = 0; i < fichas.size(); i++) {
                    if (fichas.get(i).getNumero() == contadorDI && contadorDI != ficha.getNumero()) {
                        movimiento = fichas.get(i).getNumero() + "";
                        if (ficha.getColor().equals("ROJO")) {
                            movimiento = movimiento + "I";
                        } else {
                            movimiento = movimiento + "D";
                        }
                        movimientosExtra.add(movimiento);

                    }
                }
            }
            movimiento = "";
            if (contadorDD > 0 && contadorDD < 9) {
                for (int i = 0; i < fichas.size(); i++) {
                    if (fichas.get(i).getNumero() == contadorDD && contadorDD != ficha.getNumero()) {
                        movimiento = fichas.get(i).getNumero() + "";
                        if (ficha.getColor().equals("ROJO")) {
                            movimiento = movimiento + "D";
                        } else {
                            movimiento = movimiento + "I";
                        }
                        movimientosExtra.add(movimiento);
                    }
                }
            }
            movimiento = "";
            if (contadorH > 0 && contadorH < 9) {
                for (int i = 0; i < fichas.size(); i++) {
                    if (fichas.get(i).getNumero() == contadorH && contadorH != ficha.getNumero()) {
                        movimiento = fichas.get(i).getNumero() + "";
                        movimiento = movimiento + "A";
                        movimientosExtra.add(movimiento);
                    }
                }
            }
            movimiento = "";
            if (contadorV > 0 && contadorV < 9) {
                for (int i = 0; i < fichas.size(); i++) {
                    if (fichas.get(i).getNumero() == contadorV && contadorV != ficha.getNumero()) {
                        movimiento = fichas.get(i).getNumero() + "";
                        movimiento = movimiento + "A";
                        movimientosExtra.add(movimiento);
                    }
                }
            }
        }
        ArrayList<String> movimientosExtraRetorno = new ArrayList<>();
        for (int i = 0; i < movimientosExtra.size(); i++) {
            if (!(movimientosExtraRetorno.contains(movimientosExtra.get(i)))) {
                movimientosExtraRetorno.add(movimientosExtra.get(i));
            }
        }
        return movimientosExtraRetorno;
    }

      //Define quien es el ganador dependiendo de la forma de terminacion
    public Jugador definirGanador(int formaTerminacion, int movimientosTotales, int movimientosActuales, Partida partida) {
        Jugador ganador = null;
        int contadorRojo = 0;
        int contadorAzul = 0;
        if (formaTerminacion == 1) {
            if (movimientosTotales == movimientosActuales) {
                for (int i = 0; i < 8; i++) {
                    if (tablero.getMatriz()[0][i] != null) {
                        Ficha ficha = tablero.getMatriz()[0][i];
                        if (ficha.getColor().equals("ROJO")) {
                            contadorRojo = contadorRojo + ficha.getNumero();
                        }
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (tablero.getMatriz()[7][i] != null) {
                        Ficha ficha = tablero.getMatriz()[7][i];
                        if (ficha.getColor().equals("AZUL")) {
                            contadorAzul = contadorAzul + ficha.getNumero();
                        }
                    }
                }
                if (contadorRojo > contadorAzul) {
                    ganador = partida.getJugadorRojo();
                } else if (contadorRojo < contadorAzul) {
                    ganador = partida.getJugadorAzul();
                } else {
                    ganador = null;
                }
            }
        } else if (formaTerminacion == 2) {
            for (int i = 0; i < fichas.size(); i++) {
                if (fichas.get(i).getColor().equals("ROJO") && fichas.get(i).getPosicionFila() == 0) {
                    ganador = partida.getJugadorRojo();
                }
                if (fichas.get(i).getColor().equals("AZUL") && fichas.get(i).getPosicionFila() == 7) {
                    ganador = partida.getJugadorAzul();
                }
            }
        } else if (formaTerminacion == 3) {
            for (int i = 0; i < fichas.size(); i++) {
                if (fichas.get(i).getColor().equals("ROJO") && fichas.get(i).getPosicionFila() == 0) {
                    contadorRojo = contadorRojo + 1;
                }
                if (fichas.get(i).getColor().equals("AZUL") && fichas.get(i).getPosicionFila() == 7) {
                    contadorAzul = contadorAzul + 1;
                }
            }
            if (contadorRojo == 8) {
                ganador = partida.getJugadorRojo();
            } else if (contadorAzul == 8) {
                ganador = partida.getJugadorAzul();
            }
        }
        //("1 - Cantidad de movimientos totales.");
        //("2 - Primero en llegar al otro lado.");
        //("3 - Primero en llegar con todas las piezas al otro lado.");
        if (ganador != null) {
            for (int i = 0; i < jugadores.size(); i++) {
                if (jugadores.get(i).equalsJugador(ganador)) {
                    jugadores.get(i).setPartidasGanadas(jugadores.get(i).getPartidasGanadas() + 1);
                }
            }
        }
        return ganador;
    }

    //Define si en la partida ya hay un ganador y realiza los calculos
    public boolean finalizacion(int formaTerminacion, int movimientosTotales, int movimientosActuales) {
        boolean termina = false;
        int contadorRojo = 0;
        int contadorAzul = 0;
        if (formaTerminacion == 1) {
            if (movimientosTotales == movimientosActuales) {
                termina = true;
            }
        } else if (formaTerminacion == 2) {
            for (int i = 0; i < fichas.size(); i++) {
                if (fichas.get(i).getColor().equals("ROJO") && fichas.get(i).getPosicionFila() == 0) {
                    termina = true;
                }
                if (fichas.get(i).getColor().equals("AZUL") && fichas.get(i).getPosicionFila() == 7) {
                    termina = true;
                }
            }
        } else if (formaTerminacion == 3) {
            for (int i = 0; i < fichas.size(); i++) {
                if (fichas.get(i).getColor().equals("ROJO") && fichas.get(i).getPosicionFila() == 0) {
                    contadorRojo = contadorRojo + 1;
                }
                if (fichas.get(i).getColor().equals("AZUL") && fichas.get(i).getPosicionFila() == 7) {
                    contadorAzul = contadorAzul + 1;
                }
            }
            if (contadorRojo == 8 || contadorAzul == 8) {
                termina = true;
            }
        }
        //("1 - Cantidad de movimientos totales.");
        //("2 - Primero en llegar al otro lado.");
        //("3 - Primero en llegar con todas las piezas al otro lado.");
        return termina;
    }

}
