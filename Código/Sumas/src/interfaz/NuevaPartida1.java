//Martin Rilo - 236209
//Joaquin Calvo - 203832
package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import sumas.Sistema;
import javax.swing.JOptionPane;
import sumas.Jugador;
import sumas.Sistema;
import javax.swing.DefaultComboBoxModel;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import sumas.Ficha;
import sumas.Partida;


public class NuevaPartida1 extends javax.swing.JFrame {

    private Sistema sistema;
    private Tablero tablero;
    private int formaFinalizacion = 1;
    private Jugador jugadorAzul;
    private Jugador jugadorRojo;
    private int movimientosTotales;
    private Partida partida;
    private boolean correctoCantMovs;
    private boolean finaliza = false;
    private String msg = "";
    public int movimientosActuales;

    public NuevaPartida1(Sistema sistema) {
        this.sistema = sistema;

        initComponents();
        jugadorAzul = sistema.jugadores.get(this.comboAzul.getSelectedIndex());
        jugadorRojo = sistema.jugadores.get(this.comboRojo.getSelectedIndex());
        GrupoBotones.add(cantMov);
        GrupoBotones.add(primeraEnLlegar);
        GrupoBotones.add(todasEnLlegar);
        actualizarjComboBoxAzul();
    }

    private void actualizarjComboBoxAzul() {
        // Array para los días
        String[] apodos = new String[sistema.jugadores.size()];

        // Se carga el array con 31 Integers
        for (int i = 0; i < sistema.jugadores.size(); i++) {
            apodos[i] = sistema.jugadores.get(i).getApodoJugador();
        }

        // Se crea el modelo y se asigna al comboBox
        DefaultComboBoxModel comboModelR = new DefaultComboBoxModel(apodos);
        DefaultComboBoxModel comboModelA = new DefaultComboBoxModel(apodos);
        comboRojo.setModel(comboModelR);
        comboAzul.setModel(comboModelA);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoBotones = new javax.swing.ButtonGroup();
        comboRojo = new javax.swing.JComboBox<>();
        comboAzul = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cantMov = new javax.swing.JRadioButton();
        primeraEnLlegar = new javax.swing.JRadioButton();
        todasEnLlegar = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        GuardarCambios = new javax.swing.JButton();
        cantMovTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboRojo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRojoActionPerformed(evt);
            }
        });

        comboAzul.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAzulActionPerformed(evt);
            }
        });

        jLabel1.setText("Jugador Rojo");

        jLabel2.setText("Jugador Azul");

        cantMov.setSelected(true);
        cantMov.setText("Cantidad de movimientos totales");
        cantMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantMovActionPerformed(evt);
            }
        });

        primeraEnLlegar.setText("Primero en llegar al otro lado");
        primeraEnLlegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primeraEnLlegarActionPerformed(evt);
            }
        });

        todasEnLlegar.setText("Primero en llegar con todas las piezas al otro lado");
        todasEnLlegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todasEnLlegarActionPerformed(evt);
            }
        });

        jLabel3.setText("Forma de finalizacion");

        GuardarCambios.setText("Guardar Cambios");
        GuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarCambiosActionPerformed(evt);
            }
        });

        cantMovTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantMovTxt.setText("1");
        cantMovTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cantMovTxtFocusLost(evt);
            }
        });
        cantMovTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantMovTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(todasEnLlegar)
                            .addComponent(primeraEnLlegar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cantMov)
                                .addGap(18, 18, 18)
                                .addComponent(cantMovTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(GuardarCambios)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(comboRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(comboAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantMov)
                    .addComponent(cantMovTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(primeraEnLlegar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(todasEnLlegar)
                .addGap(18, 18, 18)
                .addComponent(GuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void comboRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRojoActionPerformed
        jugadorRojo = sistema.jugadores.get(this.comboRojo.getSelectedIndex());
    }//GEN-LAST:event_comboRojoActionPerformed

    private void primeraEnLlegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primeraEnLlegarActionPerformed
        formaFinalizacion = 2;
        cantMovTxt.setEnabled(false);
    }//GEN-LAST:event_primeraEnLlegarActionPerformed

    private void cantMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantMovActionPerformed
        formaFinalizacion = 1;
        cantMovTxt.setEnabled(true);
    }//GEN-LAST:event_cantMovActionPerformed

    private void todasEnLlegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todasEnLlegarActionPerformed
        formaFinalizacion = 3;
        cantMovTxt.setEnabled(false);
    }//GEN-LAST:event_todasEnLlegarActionPerformed

    private void comboAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAzulActionPerformed
        jugadorAzul = sistema.jugadores.get(this.comboAzul.getSelectedIndex());
    }//GEN-LAST:event_comboAzulActionPerformed

    private void GuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarCambiosActionPerformed
        if (this.comboAzul.getSelectedIndex() == this.comboRojo.getSelectedIndex()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar 2 jugadores distintos.");
        } else {
            partida = new Partida(jugadorRojo, jugadorAzul, formaFinalizacion);
            sistema.partidas.add(partida);
            movimientosTotales = Integer.parseInt(cantMovTxt.getText());
            JOptionPane.showMessageDialog(null, partida.toString());
            this.setVisible(false);
            sistema.tablero.setFormaVisualizacion("VERN");
            sistema.tablero.setColorTurno("ROJO");
            tablero = new Tablero(sistema, partida, movimientosTotales);
            sistema.tablero.reiniciarMatriz();
            sistema.inicializarFicha();
            sistema.cargaFichas();
            tablero.setVisible(true);
            tablero.cargarPosibles(sistema);

        }


    }//GEN-LAST:event_GuardarCambiosActionPerformed

    private void cantMovTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantMovTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantMovTxtActionPerformed

    private void cantMovTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantMovTxtFocusLost
        correctoCantMovs = sistema.intRango(Integer.parseInt(cantMovTxt.getText()), 1, 100);
        if (!correctoCantMovs) {
            this.cantMovTxt.requestFocusInWindow();
        } else {
            movimientosTotales = Integer.parseInt(cantMovTxt.getText());
        }
    }//GEN-LAST:event_cantMovTxtFocusLost

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotones;
    private javax.swing.JButton GuardarCambios;
    private javax.swing.JRadioButton cantMov;
    private javax.swing.JTextField cantMovTxt;
    private javax.swing.JComboBox<String> comboAzul;
    private javax.swing.JComboBox<String> comboRojo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton primeraEnLlegar;
    private javax.swing.JRadioButton todasEnLlegar;
    // End of variables declaration//GEN-END:variables
}
