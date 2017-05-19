package GUI.Gestor.Medicos;

import GUI.Gestor.Medicos.añadirMedico;
import GUI.Gestor.Medicos.borrarMedico;
import GUI.Gestor.Medicos.mostrarMedicos;
import clases.Gestor;
import java.awt.BorderLayout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bm0275
 */
public class MenuDeMedico extends javax.swing.JPanel {

	private Gestor gestor;
	private añadirMedico añadirMedico;
	private borrarMedico borrarMedico;
	private mostrarMedicos mostrarMedicos;

	public MenuDeMedico(Gestor gestor) {
		initComponents();
		this.gestor = gestor;
		this.mostrarMedicos = new mostrarMedicos(gestor);
		this.añadirMedico = new añadirMedico(gestor);
		this.borrarMedico = new borrarMedico(gestor);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuOpciones = new javax.swing.JPanel();
        labelMenuDelMedico = new javax.swing.JLabel();
        buttonMostrarMedicos = new javax.swing.JButton();
        buttonAñadirMedico = new javax.swing.JButton();
        buttonBorrarMedico = new javax.swing.JButton();
        mostrarDatos = new javax.swing.JPanel();

        menuOpciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        labelMenuDelMedico.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelMenuDelMedico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMenuDelMedico.setText("Menu del medico");

        buttonMostrarMedicos.setText("Mostrar medicos");
        buttonMostrarMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMostrarMedicosActionPerformed(evt);
            }
        });

        buttonAñadirMedico.setText("Añadir medico");
        buttonAñadirMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAñadirMedicoActionPerformed(evt);
            }
        });

        buttonBorrarMedico.setText("Borrar medico");
        buttonBorrarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBorrarMedicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuOpcionesLayout = new javax.swing.GroupLayout(menuOpciones);
        menuOpciones.setLayout(menuOpcionesLayout);
        menuOpcionesLayout.setHorizontalGroup(
            menuOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMenuDelMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menuOpcionesLayout.createSequentialGroup()
                        .addGroup(menuOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonMostrarMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAñadirMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonBorrarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );
        menuOpcionesLayout.setVerticalGroup(
            menuOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMenuDelMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonMostrarMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonAñadirMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonBorrarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mostrarDatosLayout = new javax.swing.GroupLayout(mostrarDatos);
        mostrarDatos.setLayout(mostrarDatosLayout);
        mostrarDatosLayout.setHorizontalGroup(
            mostrarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        mostrarDatosLayout.setVerticalGroup(
            mostrarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(mostrarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                    .addComponent(mostrarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMostrarMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMostrarMedicosActionPerformed
		mostrarMedicos.setSize(mostrarDatos.getWidth(), mostrarDatos.getHeight());
		mostrarMedicos.setLocation(0, 0);

		mostrarDatos.removeAll();
		mostrarDatos.add(mostrarMedicos, BorderLayout.CENTER);
		mostrarDatos.revalidate();
		mostrarDatos.repaint();
    }//GEN-LAST:event_buttonMostrarMedicosActionPerformed

    private void buttonAñadirMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAñadirMedicoActionPerformed
		añadirMedico.setSize(mostrarDatos.getWidth(), mostrarDatos.getHeight());
		añadirMedico.setLocation(0, 0);

		mostrarDatos.removeAll();
		mostrarDatos.add(añadirMedico, BorderLayout.CENTER);
		mostrarDatos.revalidate();
		mostrarDatos.repaint();
    }//GEN-LAST:event_buttonAñadirMedicoActionPerformed

    private void buttonBorrarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBorrarMedicoActionPerformed
		borrarMedico.setSize(mostrarDatos.getWidth(), mostrarDatos.getHeight());
		borrarMedico.setLocation(0, 0);

		mostrarDatos.removeAll();
		mostrarDatos.add(borrarMedico, BorderLayout.CENTER);
		mostrarDatos.revalidate();
		mostrarDatos.repaint();
    }//GEN-LAST:event_buttonBorrarMedicoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAñadirMedico;
    private javax.swing.JButton buttonBorrarMedico;
    private javax.swing.JButton buttonMostrarMedicos;
    private javax.swing.JLabel labelMenuDelMedico;
    private javax.swing.JPanel menuOpciones;
    private javax.swing.JPanel mostrarDatos;
    // End of variables declaration//GEN-END:variables
}
