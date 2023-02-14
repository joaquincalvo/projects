//Martin Rilo - 236209
//Joaquin Calvo - 203832
package interfaz;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import javax.swing.JPanel;
import sumas.Partida;
import sumas.Sistema;


public class Repeticion extends javax.swing.JFrame implements Observer {

    private Sistema sistema;
    private Tablero tablero;
    private boolean continua;

   
    public Repeticion(Sistema sistema) {
        this.sistema = sistema;
        Collections.sort(sistema.partidas);

        initComponents();
        playButton.setFocusPainted(false);
        //Crear un objeto DefaultListModel
        DefaultListModel listModel = new DefaultListModel();
//Recorrer el contenido del ArrayList
        for (int i = 0; i < sistema.partidas.size(); i++) {
            //Añadir cada elemento del ArrayList en el modelo de la lista

            listModel.add(i, sistema.partidas.get(i).toString());
        }

        listPartidas.setModel(listModel);
    }

   
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jDialog4 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPartidas = new javax.swing.JList<>();
        playButton = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Repeticiones");

        listPartidas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listPartidas);

        playButton.setText("Reproducir");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(playButton)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(playButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        if (listPartidas.getSelectedIndex() != -1) {
            Partida partidaSeleccionada = sistema.partidas.get(listPartidas.getSelectedIndex());
            JOptionPane.showMessageDialog(null, "Se procede a replicar la partida.");
            sistema.tablero.reiniciarMatriz();
            sistema.inicializarFicha();
            sistema.cargaFichas();
            tablero = new Tablero(sistema, partidaSeleccionada, 100);
            tablero.cargarTablero(sistema);
            tablero.setVisible(true);
            continua = false;
            for (int i = 0; i < partidaSeleccionada.getJugadas().size(); i++) {
                if (!continua) {
                    int numeroFicha = partidaSeleccionada.getJugadas().get(i).getFicha().getNumero();
                    char direccionFicha = partidaSeleccionada.getJugadas().get(i).getDireccionFicha();
                    String movida = numeroFicha + "" + direccionFicha;
                    sistema.tablero.setColorTurno(partidaSeleccionada.getJugadas().get(i).getFicha().getColor());
                    int input = JOptionPane.showConfirmDialog(null, "Presiona ACEPTAR para continuarla, CANCELAR para jugar desde este punto.", "¿Desea continuar la repeticion?", OK_CANCEL_OPTION);
                    if (input == 0) {
                        sistema.moverFicha(movida, partidaSeleccionada, 2);
                        sistema.cargaFichas();
                        tablero.cargarTablero(sistema);
                    } else if (input == 2) {
                        Partida partida = new Partida(partidaSeleccionada.getJugadorRojo(), partidaSeleccionada.getJugadorAzul(), partidaSeleccionada.getFormaTerminacion());
                        sistema.partidas.add(partida);
                        continua = true;
                    }
                }
            }
            if (continua) {
                tablero.cargarPosibles(sistema);
            } else {
                JOptionPane.showMessageDialog(null, "Ese fue el ultimo movimiento.");
                tablero.setVisible(false);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una partida.");
        }


    }//GEN-LAST:event_playButtonActionPerformed

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listPartidas;
    private javax.swing.JButton playButton;
    // End of variables declaration//GEN-END:variables
}
