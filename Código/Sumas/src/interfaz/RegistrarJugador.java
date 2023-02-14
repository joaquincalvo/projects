//Martin Rilo - 236209
//Joaquin Calvo - 203832
package interfaz;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import sumas.Interfaz;
import sumas.Jugador;
import sumas.Sistema;


public class RegistrarJugador extends javax.swing.JFrame {

    private Sistema sistema;
    private boolean correctoNombre = false;
    private boolean correctoApodo = false;
    private boolean correctoEdad = false;

    
    public RegistrarJugador(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtApodo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jButtonRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        txtNombre.setNextFocusableComponent(txtApodo);
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        txtApodo.setNextFocusableComponent(txtEdad);
        txtApodo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApodoFocusLost(evt);
            }
        });

        jLabel2.setText("Apodo: ");

        jLabel3.setText("Edad: ");

        txtEdad.setNextFocusableComponent(jButtonRegistrar);
        txtEdad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEdadFocusLost(evt);
            }
        });
        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });

        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtApodo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEdad))
                .addGap(31, 31, 31)
                .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        if (txtNombre.getText().equals("") || txtApodo.getText().equals("") || txtEdad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
        } else {
            if (!correctoNombre || !correctoApodo || !correctoEdad) {
                JOptionPane.showMessageDialog(null, "Existen campos incorrectos, verificar.");
            } else if (correctoNombre && correctoApodo && correctoEdad) {
                String nombre = txtNombre.getText();
                String apodo = txtApodo.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                Jugador nuevoJugador = new Jugador(nombre, apodo, edad);
                boolean creado = sistema.agregarJugador(nuevoJugador);
                if (!creado) {
                    txtNombre.setText("");
                    txtApodo.setText("");
                    txtEdad.setText("");
                    this.dispose();
                    JOptionPane.showMessageDialog(null, "Jugador creado satisfactoriamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un jugador con ese apodo, pruebe otro.");
                }

            }
        }

    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        txtNombre.setText("");
        txtNombre.setBorder(BorderFactory.createLineBorder(Color.gray));
        txtApodo.setText("");
        txtApodo.setBorder(BorderFactory.createLineBorder(Color.gray));
        txtEdad.setText("");
        txtEdad.setBorder(BorderFactory.createLineBorder(Color.gray));
        this.setVisible(false);
     }//GEN-LAST:event_formWindowClosed

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        txtNombre.setText(txtNombre.getText().trim());
        if (!txtNombre.getText().trim().equals("")) {
            correctoNombre = sistema.stringRango(txtNombre.getText().trim(), 3, 10);
        } else {
            txtNombre.setBorder(BorderFactory.createLineBorder(Color.red));
        }

        if (!correctoNombre) {
            txtNombre.setBorder(BorderFactory.createLineBorder(Color.red));
        } else {
            txtNombre.setBorder(BorderFactory.createLineBorder(Color.gray));
        }

    }//GEN-LAST:event_txtNombreFocusLost

    private void txtApodoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApodoFocusLost
        txtApodo.setText(txtApodo.getText().trim());
        if (!txtApodo.getText().trim().equals("")) {
            correctoApodo = sistema.stringRango(txtApodo.getText().trim(), 3, 10);
        } else {
            txtApodo.setBorder(BorderFactory.createLineBorder(Color.red));
        }

        if (!correctoApodo) {
            txtApodo.setBorder(BorderFactory.createLineBorder(Color.red));
        } else {
            txtApodo.setBorder(BorderFactory.createLineBorder(Color.gray));
        }
    }//GEN-LAST:event_txtApodoFocusLost

    private void txtEdadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdadFocusLost
        txtEdad.setText(txtEdad.getText().trim());
        if (!txtEdad.getText().trim().equals("")) {
            try {
            correctoEdad = sistema.intRango(Integer.parseInt(txtEdad.getText().trim()), 18, 100);
            }
            catch (NumberFormatException e){
                correctoEdad = false;
            }
        } else {
            txtEdad.setBorder(BorderFactory.createLineBorder(Color.red));
        }

        if (!correctoEdad) {
            txtEdad.setBorder(BorderFactory.createLineBorder(Color.red));
        } else {
            txtEdad.setBorder(BorderFactory.createLineBorder(Color.gray));
        }

    }//GEN-LAST:event_txtEdadFocusLost

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtApodo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
