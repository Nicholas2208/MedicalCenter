package GUI.Medico;

import GUI.Gestor.TableAdaptor;
import clases.Medico;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pablo
 */
public class ModificarFichaSeleccionada extends javax.swing.JPanel {

    /**
     * Creates new form mostrarPacientesMedico
     */
    private  Medico medico;
    private  String codFicha;
    private  String hora;
    private  String dia;
    private  String comentario;

    public ModificarFichaSeleccionada(Medico medico, String codFicha, String hora, String dia, String comentario) {
        this.medico = medico;
        this.codFicha = codFicha;
        this.hora = hora;
        this.dia = dia;
        this.comentario = comentario;

        initComponents();
        initVentana();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DiaHora = new javax.swing.JLabel();
        campoDiaHora = new javax.swing.JLabel();
        labelFicha = new javax.swing.JLabel();
        campoCodFicha = new javax.swing.JLabel();
        labelComentario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaComentario = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaComentario1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();

        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        DiaHora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DiaHora.setText("Dia");

        campoDiaHora.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        campoDiaHora.setForeground(new java.awt.Color(0, 51, 102));
        campoDiaHora.setText("");

        labelFicha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelFicha.setText("Ficha");

        campoCodFicha.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        campoCodFicha.setForeground(new java.awt.Color(0, 51, 102));
        campoCodFicha.setText("");

        labelComentario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelComentario.setText("Comentario:");

        jTextAreaComentario.setColumns(20);
        jTextAreaComentario.setRows(5);
        jScrollPane1.setViewportView(jTextAreaComentario);

        jTextAreaComentario1.setBackground(new java.awt.Color(204, 204, 204));
        jTextAreaComentario1.setColumns(20);
        jTextAreaComentario1.setRows(5);
        jScrollPane2.setViewportView(jTextAreaComentario1);

        jLabel1.setForeground(java.awt.Color.blue);
        jLabel1.setText("(?)");

        Guardar.setText("jButton1");
        Guardar.setActionCommand("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campoCodFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DiaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campoDiaHora, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addGap(241, 241, 241))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Guardar))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDiaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCodFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelComentario, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Guardar)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        try {
            String comentarioNuevo = jTextAreaComentario.getText();
            jTextAreaComentario.setText("");
            medico.updateFicha(this.comentario, comentarioNuevo, codFicha);
            recargarVentana();
        } catch (SQLException ex) {
            Logger.getLogger(ModificarFichaSeleccionada.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_GuardarActionPerformed
    private void initVentana() {
        campoDiaHora.setText(dia + "  " + hora);
        campoCodFicha.setText(codFicha);
        jTextAreaComentario1.setText(comentario);
    }

    private void recargarVentana() throws SQLException {
        ArrayList<String> ficha = medico.cargarFicha(codFicha);
        this.codFicha = ficha.get(0);
        this.comentario = ficha.get(1);
        this.dia = ficha.get(2);
        this.hora = ficha.get(3);
        initVentana();
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DiaHora;
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel campoCodFicha;
    private javax.swing.JLabel campoDiaHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaComentario;
    private javax.swing.JTextArea jTextAreaComentario1;
    private javax.swing.JLabel labelComentario;
    private javax.swing.JLabel labelFicha;
    // End of variables declaration//GEN-END:variables

}
