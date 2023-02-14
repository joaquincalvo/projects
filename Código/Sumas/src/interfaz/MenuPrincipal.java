//Martin Rilo - 236209
//Joaquin Calvo - 203832
package interfaz;

import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import sumas.Sistema;

public class MenuPrincipal extends javax.swing.JFrame implements Observer {

    private Sistema sistema;
    private RegistrarJugador registrarJugador;
    private NuevaPartida1 nuevaPartida1;
    private Tablero tablero;
    private Clasificacion clasificacion;
    private Repeticion repeticion;
    private VentanaGuardar ventanaGuardar;

    public MenuPrincipal(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
        sistema.playSound("Media/intro.wav");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        botonCrearPersonaje = new javax.swing.JButton();
        botonNuevaPartida = new javax.swing.JButton();
        botonRepeticiones = new javax.swing.JButton();
        botonClasificacion = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel2FocusGained(evt);
            }
        });

        botonCrearPersonaje.setBackground(new java.awt.Color(255, 255, 255));
        botonCrearPersonaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonCrearPersonaje.setForeground(new java.awt.Color(26, 46, 93));
        botonCrearPersonaje.setText("Crear personaje");
        botonCrearPersonaje.setBorder(null);
        botonCrearPersonaje.setBorderPainted(false);
        botonCrearPersonaje.setFocusable(false);
        botonCrearPersonaje.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCrearPersonaje.setPreferredSize(new java.awt.Dimension(155, 60));
        botonCrearPersonaje.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                botonCrearPersonajeFocusGained(evt);
            }
        });
        botonCrearPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearPersonajeActionPerformed(evt);
            }
        });

        botonNuevaPartida.setBackground(new java.awt.Color(255, 255, 255));
        botonNuevaPartida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonNuevaPartida.setForeground(new java.awt.Color(26, 46, 93));
        botonNuevaPartida.setText("Nueva partida");
        botonNuevaPartida.setBorder(null);
        botonNuevaPartida.setBorderPainted(false);
        botonNuevaPartida.setFocusable(false);
        botonNuevaPartida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonNuevaPartida.setPreferredSize(new java.awt.Dimension(155, 60));
        botonNuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaPartidaActionPerformed(evt);
            }
        });

        botonRepeticiones.setBackground(new java.awt.Color(255, 255, 255));
        botonRepeticiones.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonRepeticiones.setForeground(new java.awt.Color(26, 46, 93));
        botonRepeticiones.setText("Repeticiones");
        botonRepeticiones.setBorder(null);
        botonRepeticiones.setBorderPainted(false);
        botonRepeticiones.setFocusable(false);
        botonRepeticiones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonRepeticiones.setPreferredSize(new java.awt.Dimension(155, 60));
        botonRepeticiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRepeticionesActionPerformed(evt);
            }
        });

        botonClasificacion.setBackground(new java.awt.Color(255, 255, 255));
        botonClasificacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonClasificacion.setForeground(new java.awt.Color(26, 46, 93));
        botonClasificacion.setText("Clasificación");
        botonClasificacion.setBorder(null);
        botonClasificacion.setBorderPainted(false);
        botonClasificacion.setFocusable(false);
        botonClasificacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonClasificacion.setPreferredSize(new java.awt.Dimension(155, 60));
        botonClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonClasificacionActionPerformed(evt);
            }
        });

        botonSalir.setBackground(new java.awt.Color(255, 255, 255));
        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonSalir.setForeground(new java.awt.Color(26, 46, 93));
        botonSalir.setText("Salir");
        botonSalir.setBorder(null);
        botonSalir.setBorderPainted(false);
        botonSalir.setFocusable(false);
        botonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonSalir.setPreferredSize(new java.awt.Dimension(155, 60));
        botonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonSalirMouseEntered(evt);
            }
        });
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(0, 17, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonCrearPersonaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonNuevaPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonRepeticiones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonClasificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonCrearPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonNuevaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonRepeticiones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        
        sistema.Grabar();
         ventanaGuardar = new VentanaGuardar(sistema);

        ventanaGuardar.guardarComo();
        System.exit(0);
       
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSalirMouseEntered
        //  add your handling code here:
    }//GEN-LAST:event_botonSalirMouseEntered

    private void botonClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClasificacionActionPerformed
        clasificacion = new Clasificacion(sistema);
        clasificacion.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_botonClasificacionActionPerformed

    private void botonNuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaPartidaActionPerformed
        if (sistema.jugadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Deben haber por lo menos 2 personajes creados para empezar una partida.");
        } else if (sistema.jugadores.size() < 2) {
            JOptionPane.showMessageDialog(null, "Deben haber por lo menos 2 personajes creados para empezar una partida.");
        } else {
            nuevaPartida1 = new NuevaPartida1(sistema);
            nuevaPartida1.setVisible(true);
        }
    }//GEN-LAST:event_botonNuevaPartidaActionPerformed

    private void botonCrearPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearPersonajeActionPerformed
        registrarJugador = new RegistrarJugador(sistema);
        registrarJugador.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCrearPersonajeActionPerformed

    private void botonCrearPersonajeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonCrearPersonajeFocusGained

    }//GEN-LAST:event_botonCrearPersonajeFocusGained

    private void jPanel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2FocusGained

    private void botonRepeticionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRepeticionesActionPerformed
        repeticion = new Repeticion(sistema);

        repeticion.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_botonRepeticionesActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonClasificacion;
    private javax.swing.JButton botonCrearPersonaje;
    private javax.swing.JButton botonNuevaPartida;
    private javax.swing.JButton botonRepeticiones;
    private javax.swing.JButton botonSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
