//Martin Rilo - 236209
//Joaquin Calvo - 203832
package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import sumas.Ficha;
import sumas.Jugador;
import sumas.Partida;
import sumas.Sistema;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tablero extends javax.swing.JFrame implements KeyListener {

    private Sistema sistema;
    private Partida partida;
    private JButton[][] botones;
    private String movimiento = "";
    private String numeroFicha = "";
    private int columnaAntes = 0;
    private String direccionFicha = "";
    private boolean mueve = false;
    private int movimientosActuales = 0;
    private int movimientosTotales;
    private boolean finaliza;
    private Jugador jugador;

    public Tablero(Sistema sistema, Partida partida, int movimientosTotales) {
        this.sistema = sistema;
        this.partida = partida;
        this.movimientosTotales = movimientosTotales;
        finaliza = false;
        initComponents();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

// crear botones y agregarlos al panel
        panelJuego.setLayout(new GridLayout(8, 9));
        botones = new JButton[8][9];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                JButton jButton = new JButton();
                jButton.addActionListener(new ListenerBoton(i, j));
                panelJuego.add(jButton);
                botones[i][j] = jButton;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Invoked when a key has been typed.
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_P) {
            if (!mueve) {
                if (sistema.tablero.getColorTurno().equals("ROJO")) {
                    sistema.tablero.setColorTurno("AZUL");
                    cargarPosibles(sistema);
                    mueve = false;

                } else {
                    sistema.tablero.setColorTurno("ROJO");
                    cargarPosibles(sistema);
                    mueve = false;

                }
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            for (int i = 0; i < sistema.jugadores.size(); i++) {
                if (sistema.jugadores.get(i).equalsJugador(partida.getJugadorRojo()) && sistema.tablero.getColorTurno().equals("AZUL")) {
                    sistema.jugadores.get(i).setPartidasGanadas(sistema.jugadores.get(i).getPartidasGanadas() + 1);
                } else if (sistema.jugadores.get(i).equalsJugador(partida.getJugadorAzul()) && sistema.tablero.getColorTurno().equals("ROJO")) {
                    sistema.jugadores.get(i).setPartidasGanadas(sistema.jugadores.get(i).getPartidasGanadas() + 1);
                }
            }
            this.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Invoked when a key has been released.
    }

    public void cargarPosibles(Sistema sistema) {
        ArrayList<Ficha> movimientosPosibles = sistema.verMovimientos();
        if (movimientosPosibles.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usted no posee movimientos a realizar.", "Movimientos posibles.", INFORMATION_MESSAGE);
            if (sistema.tablero.getColorTurno().equals("ROJO")) {
                sistema.tablero.setColorTurno("AZUL");
            } else {
                sistema.tablero.setColorTurno("ROJO");
            }
        } else {
            finaliza = sistema.sinMovimientos();
            cargarTablero(sistema);
            for (int i = 0; i < movimientosPosibles.size(); i++) {
                botones[movimientosPosibles.get(i).getPosicionFila()][movimientosPosibles.get(i).getPosicionColumna()].setEnabled(true);
            }
        }
    }

    public void cargarTablero(Sistema sistema) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                botones[i][j].setFocusPainted(false);
                botones[i][j].setEnabled(false);
                if (sistema.tablero.getMatriz()[i][j] != null) {
                    botones[i][j].setText(sistema.tablero.getMatriz()[i][j].toString());
                    if (sistema.tablero.getMatriz()[i][j].getColor().equals("ROJO")) {
                        botones[i][j].setBackground(Color.red);
                    } else {
                        botones[i][j].setBackground(Color.blue);
                    }
                    if (sistema.tablero.getColorTurno().equals("ROJO")) {
                        if (sistema.tablero.getMatriz()[i][j].getColor().equals("ROJO")) {
                        }
                    } else if (sistema.tablero.getMatriz()[i][j].getColor().equals("AZUL")) {
                    }
                } else {
                    botones[i][j].setBackground(Color.white);
                    botones[i][j].setText("");
                }
            }

        }
    }

    public void cargarTableroExtra(Sistema sistema, String entrada) {
        cargarTablero(sistema);
        ArrayList<String> movimientosPosiblesExtra = sistema.verMovimientosExtra(entrada, partida);
        if (!movimientosPosiblesExtra.isEmpty()) {
            for (int i = 0; i < movimientosPosiblesExtra.size(); i++) {
                int fichaAux = Integer.parseInt(movimientosPosiblesExtra.get(i).substring(0, 1));
                for (int j = 0; j < sistema.fichas.size(); j++) {
                    if (fichaAux == sistema.fichas.get(j).getNumero() && sistema.fichas.get(j).getColor().equals(sistema.tablero.getColorTurno())) {
                        botones[sistema.fichas.get(j).getPosicionFila()][sistema.fichas.get(j).getPosicionColumna()].setBackground(Color.orange);
                        if (sistema.fichas.get(j).getColor().equals("ROJO")) {
                            if (movimientosPosiblesExtra.get(i).substring(1, 2).equals("D") && sistema.fichas.get(j).getPosicionFila() - 1 > 0 && sistema.fichas.get(j).getPosicionColumna() + 1 < 9) {
                                botones[sistema.fichas.get(j).getPosicionFila() - 1][sistema.fichas.get(j).getPosicionColumna() + 1].setBackground(Color.green);
                                botones[sistema.fichas.get(j).getPosicionFila() - 1][sistema.fichas.get(j).getPosicionColumna() + 1].setEnabled(true);
                                botones[sistema.fichas.get(j).getPosicionFila() - 1][sistema.fichas.get(j).getPosicionColumna() + 1].setText(sistema.fichas.get(j).toString() + "D");
                            } else if (movimientosPosiblesExtra.get(i).substring(1, 2).equals("A") && sistema.fichas.get(j).getPosicionFila() - 1 > 0) {
                                botones[sistema.fichas.get(j).getPosicionFila() - 1][sistema.fichas.get(j).getPosicionColumna()].setBackground(Color.green);
                                botones[sistema.fichas.get(j).getPosicionFila() - 1][sistema.fichas.get(j).getPosicionColumna()].setEnabled(true);
                                botones[sistema.fichas.get(j).getPosicionFila() - 1][sistema.fichas.get(j).getPosicionColumna()].setText(sistema.fichas.get(j).toString() + "A");
                            } else if (movimientosPosiblesExtra.get(i).substring(1, 2).equals("I") && sistema.fichas.get(j).getPosicionFila() - 1 > 0 && sistema.fichas.get(j).getPosicionColumna() - 1 > 0) {
                                botones[sistema.fichas.get(j).getPosicionFila() - 1][sistema.fichas.get(j).getPosicionColumna() - 1].setBackground(Color.green);
                                botones[sistema.fichas.get(j).getPosicionFila() - 1][sistema.fichas.get(j).getPosicionColumna() - 1].setEnabled(true);
                                botones[sistema.fichas.get(j).getPosicionFila() - 1][sistema.fichas.get(j).getPosicionColumna() - 1].setText(sistema.fichas.get(j).toString() + "I");
                            }

                        } else if (sistema.fichas.get(j).getColor().equals("AZUL")) {
                            if (movimientosPosiblesExtra.get(i).substring(1, 2).equals("D") && sistema.fichas.get(j).getPosicionFila() + 1 < 8 && sistema.fichas.get(j).getPosicionColumna() + 1 < 9) {
                                botones[sistema.fichas.get(j).getPosicionFila() + 1][sistema.fichas.get(j).getPosicionColumna() + 1].setBackground(Color.green);
                                botones[sistema.fichas.get(j).getPosicionFila() + 1][sistema.fichas.get(j).getPosicionColumna() + 1].setEnabled(true);
                                botones[sistema.fichas.get(j).getPosicionFila() + 1][sistema.fichas.get(j).getPosicionColumna() + 1].setText(sistema.fichas.get(j).toString() + "D");
                            } else if (movimientosPosiblesExtra.get(i).substring(1, 2).equals("A") && sistema.fichas.get(j).getPosicionFila() + 1 < 8) {
                                botones[sistema.fichas.get(j).getPosicionFila() + 1][sistema.fichas.get(j).getPosicionColumna()].setBackground(Color.green);
                                botones[sistema.fichas.get(j).getPosicionFila() + 1][sistema.fichas.get(j).getPosicionColumna()].setEnabled(true);
                                botones[sistema.fichas.get(j).getPosicionFila() + 1][sistema.fichas.get(j).getPosicionColumna()].setText(sistema.fichas.get(j).toString() + "A");
                            } else if (movimientosPosiblesExtra.get(i).substring(1, 2).equals("I") && sistema.fichas.get(j).getPosicionFila() + 1 < 8 && sistema.fichas.get(j).getPosicionColumna() - 1 > 0) {
                                botones[sistema.fichas.get(j).getPosicionFila() + 1][sistema.fichas.get(j).getPosicionColumna() - 1].setBackground(Color.green);
                                botones[sistema.fichas.get(j).getPosicionFila() + 1][sistema.fichas.get(j).getPosicionColumna() - 1].setEnabled(true);
                                botones[sistema.fichas.get(j).getPosicionFila() + 1][sistema.fichas.get(j).getPosicionColumna() - 1].setText(sistema.fichas.get(j).toString() + "I");
                            }
                        }
                    }
                }
            }
        } else if (sistema.tablero.getColorTurno().equals("ROJO")) {
            sistema.tablero.setColorTurno("AZUL");
            cargarPosibles(sistema);
            mueve = false;

        } else {
            sistema.tablero.setColorTurno("ROJO");
            cargarPosibles(sistema);
            mueve = false;

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJuego = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        panelJuego.setLayout(null);

        jMenu1.setText("Click aqui para más ayuda");

        jMenuItem1.setText("Terminar/Pasar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    }//GEN-LAST:event_formKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
 JOptionPane.showMessageDialog(null, "Para pasar turno P, para rendirse X.");        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables
private class ListenerBoton implements ActionListener {

        private int x;
        private int y;

        public ListenerBoton(int i, int j) {
// en el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
// cuando se presiona un botón, se ejecutará este método
            clickBoton(x, y, partida);
            sistema.playSound("Media/blop.wav");
        }
    }

    private void clickBoton(int fila, int columna, Partida partida) {

        if (!mueve) {

            if (sistema.tablero.getMatriz()[fila][columna] != null) {
                if (!numeroFicha.equals(sistema.tablero.getMatriz()[fila][columna].toString())) {
                    cargarPosibles(sistema);
                }
            }
            //para botones rojos
            if (botones[fila][columna].getBackground().equals(Color.red)) {
                botones[fila][columna].setBackground(Color.magenta);
                botones[fila][columna].setEnabled(true);
                if (fila - 1 >= 0 && sistema.tablero.getMatriz()[fila - 1][columna] == null) {
                    botones[fila - 1][columna].setBackground(Color.yellow);
                    botones[fila - 1][columna].setEnabled(true);
                }
                if (fila - 1 >= 0 && columna - 1 >= 0 && sistema.tablero.getMatriz()[fila - 1][columna - 1] == null) {
                    botones[fila - 1][columna - 1].setBackground(Color.yellow);
                    botones[fila - 1][columna - 1].setEnabled(true);
                }
                if (fila - 1 >= 0 && columna + 1 < 9 && sistema.tablero.getMatriz()[fila - 1][columna + 1] == null) {
                    botones[fila - 1][columna + 1].setBackground(Color.yellow);
                    botones[fila - 1][columna + 1].setEnabled(true);
                }
                numeroFicha = sistema.tablero.getMatriz()[fila][columna].toString();
                columnaAntes = columna;
            } else if (botones[fila][columna].getBackground().equals(Color.magenta)) {
                botones[fila][columna].setBackground(Color.red);

                if (fila - 1 >= 0 && sistema.tablero.getMatriz()[fila - 1][columna] == null) {
                    botones[fila - 1][columna].setBackground(Color.white);
                    botones[fila - 1][columna].setEnabled(false);
                }
                if (fila - 1 >= 0 && columna - 1 >= 0 && sistema.tablero.getMatriz()[fila - 1][columna - 1] == null) {
                    botones[fila - 1][columna - 1].setBackground(Color.white);
                    botones[fila - 1][columna - 1].setEnabled(false);
                }
                if (fila - 1 >= 0 && columna + 1 < 9 && sistema.tablero.getMatriz()[fila - 1][columna + 1] == null) {
                    botones[fila - 1][columna + 1].setBackground(Color.white);
                    botones[fila - 1][columna + 1].setEnabled(false);
                }
            }
            //
            //para botones azules
            if (botones[fila][columna].getBackground().equals(Color.blue)) {
                botones[fila][columna].setBackground(Color.cyan);
                botones[fila][columna].setEnabled(true);

                if (fila + 1 < 8 && sistema.tablero.getMatriz()[fila + 1][columna] == null) {
                    botones[fila + 1][columna].setBackground(Color.yellow);
                    botones[fila + 1][columna].setEnabled(true);
                }
                if (fila + 1 < 8 && columna - 1 >= 0 && sistema.tablero.getMatriz()[fila + 1][columna - 1] == null) {
                    botones[fila + 1][columna - 1].setBackground(Color.yellow);
                    botones[fila + 1][columna - 1].setEnabled(true);
                }
                if (fila + 1 < 8 && columna + 1 < 9 && sistema.tablero.getMatriz()[fila + 1][columna + 1] == null) {
                    botones[fila + 1][columna + 1].setBackground(Color.yellow);
                    botones[fila + 1][columna + 1].setEnabled(true);
                }
                numeroFicha = sistema.tablero.getMatriz()[fila][columna].toString();
                columnaAntes = columna;
            } else if (botones[fila][columna].getBackground().equals(Color.cyan)) {
                botones[fila][columna].setBackground(Color.blue);
                if (fila + 1 < 8 && sistema.tablero.getMatriz()[fila + 1][columna] == null) {
                    botones[fila + 1][columna].setBackground(Color.white);
                    botones[fila + 1][columna].setEnabled(false);
                }
                if (fila + 1 < 8 && columna - 1 >= 0 && sistema.tablero.getMatriz()[fila + 1][columna - 1] == null) {
                    botones[fila + 1][columna - 1].setBackground(Color.white);
                    botones[fila + 1][columna - 1].setEnabled(false);
                }
                if (fila + 1 < 8 && columna + 1 < 9 && sistema.tablero.getMatriz()[fila + 1][columna + 1] == null) {
                    botones[fila + 1][columna + 1].setBackground(Color.white);
                    botones[fila + 1][columna + 1].setEnabled(false);
                }
            }
            if (botones[fila][columna].getBackground().equals(Color.yellow)) {

                if (columna == columnaAntes) {
                    direccionFicha = "A";
                } else if (columna < columnaAntes) {
                    direccionFicha = "I";
                } else if (columna > columnaAntes) {
                    direccionFicha = "D";
                }
                movimiento = numeroFicha + "" + direccionFicha;
                mueve = sistema.moverFicha(movimiento, partida, 1);
                if (mueve) {
                    movimientosActuales = movimientosActuales + 1;
                    cargarTableroExtra(sistema, movimiento);

                    if (sistema.finalizacion(partida.getFormaTerminacion(), movimientosTotales, movimientosActuales)) {
                        jugador = null;
                        jugador = sistema.definirGanador(partida.getFormaTerminacion(), movimientosTotales, movimientosActuales, partida);
                        if (jugador != null) {
                            JOptionPane.showMessageDialog(null, "El ganador es: " + jugador);
                            this.dispose();

                        } else {
                            JOptionPane.showMessageDialog(null, "Empate.");
                            this.dispose();
                        }
                    }
                }
                mueve = false;
            }
            if (botones[fila][columna].getBackground().equals(Color.green)) {
                sistema.moverFicha(botones[fila][columna].getText(), partida, 1);
                cargarTableroExtra(sistema, botones[fila][columna].getText());

            }
        } else {
            cargarTableroExtra(sistema, botones[fila][columna].getText());
        }

    }

}
