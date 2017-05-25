package GUI.Gestor;

import GUI.Gestor.Medicos.MenuDeMedico;
import GUI.Gestor.Paciente.PedirCita;
import clases.Gestor;
import clases.Paciente;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Juan
 */
public class MenuGestor extends javax.swing.JPanel {

	private TableRowSorter trsFiltro;
	private Gestor gestor;
	private Connection reg;
	private AñadirPaciente añadirPaciente;
	private BorrarPaciente borrarPaciente;
	private GestionarPacientes gestionarPacientes;
	private MenuDeMedico menuDeMedico;
	private MostrarAgenda mostrarSalas;

	public MenuGestor(Gestor gestor) {
		initComponents();
		this.gestor = gestor;
		
		this.borrarPaciente = new BorrarPaciente(gestor);
		this.menuDeMedico = new MenuDeMedico(gestor);
		this.mostrarSalas = new MostrarAgenda(gestor);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mostrarDatos = new javax.swing.JPanel();
        menuOpciones = new javax.swing.JPanel();
        buttonAñadirPaciente = new javax.swing.JButton();
        buttonGestionarPacientes = new javax.swing.JButton();
        buttonGestionarMedico = new javax.swing.JButton();
        buttonMostrarSalas = new javax.swing.JButton();
        buttonBorrarPaciente = new javax.swing.JButton();
        buttonPedirCita = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        mostrarDatos.setForeground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout mostrarDatosLayout = new javax.swing.GroupLayout(mostrarDatos);
        mostrarDatos.setLayout(mostrarDatosLayout);
        mostrarDatosLayout.setHorizontalGroup(
            mostrarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1390, Short.MAX_VALUE)
        );
        mostrarDatosLayout.setVerticalGroup(
            mostrarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        buttonAñadirPaciente.setText("Añadir nuevo paciente");
        buttonAñadirPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAñadirPacienteActionPerformed(evt);
            }
        });

        buttonGestionarPacientes.setText("Gestionar pacientes");
        buttonGestionarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGestionarPacientesActionPerformed(evt);
            }
        });

        buttonGestionarMedico.setText("Gestionar medicos");
        buttonGestionarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGestionarMedicoActionPerformed(evt);
            }
        });

        buttonMostrarSalas.setText("Mostrar agenda");
        buttonMostrarSalas.setMaximumSize(new java.awt.Dimension(100, 25));
        buttonMostrarSalas.setMinimumSize(new java.awt.Dimension(100, 25));
        buttonMostrarSalas.setPreferredSize(new java.awt.Dimension(100, 25));
        buttonMostrarSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMostrarSalasActionPerformed(evt);
            }
        });

        buttonBorrarPaciente.setText("Exportar / Importar Paciente");
        buttonBorrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBorrarPacienteActionPerformed(evt);
            }
        });

        buttonPedirCita.setText("Pedir cita");
        buttonPedirCita.setMaximumSize(new java.awt.Dimension(100, 25));
        buttonPedirCita.setMinimumSize(new java.awt.Dimension(100, 25));
        buttonPedirCita.setPreferredSize(new java.awt.Dimension(100, 25));
        buttonPedirCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPedirCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuOpcionesLayout = new javax.swing.GroupLayout(menuOpciones);
        menuOpciones.setLayout(menuOpcionesLayout);
        menuOpcionesLayout.setHorizontalGroup(
            menuOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAñadirPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonBorrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonMostrarSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPedirCita, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonGestionarPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonGestionarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        menuOpcionesLayout.setVerticalGroup(
            menuOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGestionarPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonGestionarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMostrarSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAñadirPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBorrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPedirCita, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mostrarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mostrarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

	/**
	 * Muestra el panel borrar paciente
	 *
	 * @param evt
	 */
    private void buttonBorrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBorrarPacienteActionPerformed
		borrarPaciente.setSize(mostrarDatos.getWidth(), mostrarDatos.getHeight());
		borrarPaciente.setLocation(0, 0);
		mostrarDatos.removeAll();
		mostrarDatos.add(borrarPaciente, BorderLayout.CENTER);
		mostrarDatos.revalidate();
		mostrarDatos.repaint();
    }//GEN-LAST:event_buttonBorrarPacienteActionPerformed

	/**
	 * Muestra el panel añadir paciente
	 *
	 * @param evt
	 */
    private void buttonAñadirPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAñadirPacienteActionPerformed
		añadirPacientePanel(null);
    }//GEN-LAST:event_buttonAñadirPacienteActionPerformed

	/**
	 * Muestra el panel de añadir paciente
	 */
	private void añadirPacientePanel(String dni) {
		this.añadirPaciente = new AñadirPaciente(gestor, dni);
		añadirPaciente.setSize(mostrarDatos.getWidth(), mostrarDatos.getHeight());
		añadirPaciente.setLocation(0, 0);

		mostrarDatos.removeAll();
		mostrarDatos.add(añadirPaciente, BorderLayout.CENTER);
		mostrarDatos.revalidate();
		mostrarDatos.repaint();
	}

	/**
	 * Muestra el panel gestionar pacientes
	 *
	 * @param evt
	 */
    private void buttonGestionarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGestionarPacientesActionPerformed
		gestionarPacientes = new GestionarPacientes(gestor);
		gestionarPacientes.setSize(mostrarDatos.getWidth(), mostrarDatos.getHeight());
		gestionarPacientes.setLocation(0, 0);

		mostrarDatos.removeAll();
		mostrarDatos.add(gestionarPacientes, BorderLayout.WEST);
		mostrarDatos.revalidate();
		mostrarDatos.repaint();
    }//GEN-LAST:event_buttonGestionarPacientesActionPerformed

	/**
	 * Muestra el panel mostrar salas
	 *
	 * @param evt
	 */
    private void buttonMostrarSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMostrarSalasActionPerformed
		mostrarSalas.setSize(mostrarDatos.getWidth(), mostrarDatos.getHeight());
		mostrarSalas.setLocation(0, 0);

		mostrarDatos.removeAll();
		mostrarDatos.add(mostrarSalas, BorderLayout.CENTER);
		mostrarDatos.revalidate();
		mostrarDatos.repaint();
    }//GEN-LAST:event_buttonMostrarSalasActionPerformed

	/**
	 * Muestra el panel menu de medicos
	 *
	 * @param evt
	 */
    private void buttonGestionarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGestionarMedicoActionPerformed
		menuDeMedico.setSize(mostrarDatos.getWidth(), mostrarDatos.getHeight());
		menuDeMedico.setLocation(0, 0);

		mostrarDatos.removeAll();
		mostrarDatos.add(menuDeMedico, BorderLayout.WEST);
		mostrarDatos.revalidate();
		mostrarDatos.repaint();
    }//GEN-LAST:event_buttonGestionarMedicoActionPerformed

    private void buttonPedirCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPedirCitaActionPerformed
		pedirDNI();
    }//GEN-LAST:event_buttonPedirCitaActionPerformed

	/**
	 * Pide un DNI Si existe en la base de datos, muestra pedir citas Si no
	 * existe, muestra añadir paciente
	 *
	 * @return
	 */
	private void pedirDNI() {
		try {
			String dni = JOptionPane.showInputDialog(this, "DNI del paciente", "Introduzca un dni", JOptionPane.QUESTION_MESSAGE);
			if (dni != null) {
				if (!gestor.existePacienteBD(dni)) {
					JOptionPane.showMessageDialog(this, "No existe el paciente, añada un nuevo", "Cuidado!", JOptionPane.WARNING_MESSAGE);
					añadirPacientePanel(dni);
				} else {
					añadirPedirCitaPanel(dni);
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(MenuGestor.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	/**
	 * Ingresa un paciente a su menu y Añade un panel de pedir cita
	 */
	private void añadirPedirCitaPanel(String dni) throws SQLException {
		PedirCita pedirCita = new PedirCita(gestor, gestor.getPaciente(dni));
		pedirCita.setSize(mostrarDatos.getWidth(), mostrarDatos.getHeight());
		pedirCita.setLocation(250, 0);

		mostrarDatos.removeAll();
		mostrarDatos.add(pedirCita, BorderLayout.CENTER);
		mostrarDatos.revalidate();
		mostrarDatos.repaint();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAñadirPaciente;
    private javax.swing.JButton buttonBorrarPaciente;
    private javax.swing.JButton buttonGestionarMedico;
    private javax.swing.JButton buttonGestionarPacientes;
    private javax.swing.JButton buttonMostrarSalas;
    private javax.swing.JButton buttonPedirCita;
    private javax.swing.JPanel menuOpciones;
    private javax.swing.JPanel mostrarDatos;
    // End of variables declaration//GEN-END:variables
}
