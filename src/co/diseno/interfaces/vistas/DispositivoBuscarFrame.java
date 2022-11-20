/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package co.diseno.interfaces.vistas;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Image;

import co.diseno.interfaces.controladores.PrincipalControlador;
import co.diseno.interfaces.modelos.Dispositivo;

/**
 *
 * @author johno
 */
public class DispositivoBuscarFrame extends javax.swing.JInternalFrame {

    private PrincipalControlador principalControlador;

    /**
     * Creates new form DispositivoBuscarFrame
     * @param principalControlador Controlador principal.
     */
    public DispositivoBuscarFrame(PrincipalControlador principalControlador) {
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

        lblLocalizacion = new javax.swing.JLabel();
        txtLocalizacion = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        lblDireccionIp = new javax.swing.JLabel();
        txtDireccionIp = new javax.swing.JTextField();
        lblDireccionMac = new javax.swing.JLabel();
        txtDireccionMac = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblFotoDispositivo = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Dispositivo - Buscar");

        lblLocalizacion.setText("Localización:");

        lblFoto.setText("Foto:");

        lblDireccionIp.setText("Dirección IP:");

        lblDireccionMac.setText("Dirección MAC:");

        lblNombre.setText("Nombre:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblDireccionMac))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(txtDireccionMac)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccionIp)
                            .addComponent(lblLocalizacion)
                            .addComponent(lblFoto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDireccionIp, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLocalizacion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFotoDispositivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionIp)
                    .addComponent(txtDireccionIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLocalizacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFoto)
                        .addGap(0, 85, Short.MAX_VALUE))
                    .addComponent(lblFotoDispositivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccionMac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccionMac))
                .addGap(75, 75, 75))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nombre = txtNombre.getText().trim();
        String direccionIp = txtDireccionIp.getText().trim();

        if (nombre.isEmpty() && direccionIp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre o una dirección IP", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!nombre.isEmpty()) {
            Dispositivo dispositivo = principalControlador.buscarDispositivoPorNombre(nombre);

            if (dispositivo == null) {
                JOptionPane.showMessageDialog(this, "No se encontró ningún dispositivo con el nombre ingresado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            txtDireccionIp.setText(dispositivo.getIp());
            txtLocalizacion.setText(dispositivo.getLocalizacion());
            txtDireccionMac.setText(dispositivo.getDireccionMac());
            
            ImageIcon icon = new ImageIcon(dispositivo.getFoto());
            Image image = icon.getImage().getScaledInstance(lblFotoDispositivo.getWidth(), lblFotoDispositivo.getHeight(), Image.SCALE_SMOOTH);
            lblFotoDispositivo.setIcon(new ImageIcon(image));
            return;
        }

        if (!direccionIp.isEmpty()) {
            Dispositivo dispositivo = principalControlador.buscarDispositivoPorIp(direccionIp);

            if (dispositivo == null) {
                JOptionPane.showMessageDialog(this, "No se encontró ningún dispositivo con la dirección IP ingresada", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            txtNombre.setText(dispositivo.getNombre());
            txtLocalizacion.setText(dispositivo.getLocalizacion());
            txtDireccionMac.setText(dispositivo.getDireccionMac());
            
            ImageIcon icon = new ImageIcon(dispositivo.getFoto());
            Image image = icon.getImage().getScaledInstance(lblFotoDispositivo.getWidth(), lblFotoDispositivo.getHeight(), Image.SCALE_SMOOTH);
            lblFotoDispositivo.setIcon(new ImageIcon(image));
            return;
        }

        JOptionPane.showMessageDialog(this, "No se encontró ningún dispositivo con los datos ingresados", "Error", JOptionPane.WARNING_MESSAGE);

        // Limpiar campos:
        txtLocalizacion.setText("");
        txtDireccionMac.setText("");
        lblFotoDispositivo.setIcon(null);

    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel lblDireccionIp;
    private javax.swing.JLabel lblDireccionMac;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblFotoDispositivo;
    private javax.swing.JLabel lblLocalizacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtDireccionIp;
    private javax.swing.JTextField txtDireccionMac;
    private javax.swing.JTextField txtLocalizacion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
