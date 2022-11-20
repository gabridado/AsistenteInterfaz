package co.diseno.interfaces.vistas;

import javax.swing.JOptionPane;

import co.diseno.interfaces.controladores.PrincipalControlador;
import co.diseno.interfaces.modelos.Dispositivo;

/**
 *
 * @author Gabriel.
 */
public class DispositivoEliminarFrame extends javax.swing.JInternalFrame {

    private PrincipalControlador principalControlador;

    /**
     * Creates new form DispositivoEliminarFrame
     * @param principalControlador Controlador principal.
     */
    public DispositivoEliminarFrame(PrincipalControlador principalControlador) {
        initComponents();
        this.principalControlador = principalControlador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDireccionIp = new javax.swing.JLabel();
        txtDireccionIp = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Dispositivo - Eliminar");

        lblDireccionIp.setText("Dirección IP:");

        lblNombre.setText("Nombre:");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccionIp)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDireccionIp)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionIp)
                    .addComponent(txtDireccionIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String nombre = txtNombre.getText().trim();
        String direccionIp = txtDireccionIp.getText().trim();

        if (nombre.isEmpty() && direccionIp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre o una dirección IP", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!nombre.isEmpty()) {
            Dispositivo dispositivo = principalControlador.buscarDispositivoPorNombre(nombre);

            if (dispositivo == null) {
                JOptionPane.showMessageDialog(this, "No se encontró ningún dispositivo con el nombre ingresado",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el dispositivo?", "Confirmación",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (principalControlador.eliminarDispositivo(nombre)) {
                    JOptionPane.showMessageDialog(this, "Dispositivo eliminado correctamente", "Información",
                            JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el dispositivo", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            
            return;
        }

        if (!direccionIp.isEmpty()) {
            Dispositivo dispositivo = principalControlador.buscarDispositivoPorIp(direccionIp);

            if (dispositivo == null) {
                JOptionPane.showMessageDialog(this, "No se encontró ningún dispositivo con la dirección IP ingresada",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el dispositivo?", "Confirmación",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (principalControlador.eliminarDispositivoPorIp(direccionIp)) {
                    JOptionPane.showMessageDialog(this, "Dispositivo eliminado correctamente", "Información",
                            JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el dispositivo", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            return;
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel lblDireccionIp;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtDireccionIp;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}