package GUI.Medico;

import GUI.Gestor.TableAdaptor;
import clases.Medico;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Pablo
 */
public class EscribirFichaPaciente extends javax.swing.JPanel {

    /**
     * Creates new form escribirFicha
     */
    private Medico medico;
    private String nDNI = null;
    private String cCita = null;
    private TableRowSorter trsFiltro;
    private DefaultTableModel tabla;
    private String[] columnas;

    public EscribirFichaPaciente(Medico medico) {
        initComponents();
        this.medico = medico;
        mostrarDatos();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInfo = new javax.swing.JTable();
        mostrarCitas = new javax.swing.JButton();
        desplegableColumnas = new javax.swing.JComboBox();
        buscarCampo = new javax.swing.JTextField();
        formulario = new javax.swing.JPanel();
        codCita = new javax.swing.JLabel();
        comentario = new javax.swing.JLabel();
        DNI = new javax.swing.JLabel();
        buttonEscribirDiagnostico = new javax.swing.JButton();
        campoDNI = new javax.swing.JLabel();
        campoCita = new javax.swing.JLabel();
        DNI1 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        comentarioTextArea = new javax.swing.JTextArea();
        labelTitulo = new javax.swing.JLabel();

        tablaInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaInfoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaInfo);

        mostrarCitas.setText("Mostrar Citas");
        mostrarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarCitasActionPerformed(evt);
            }
        });

        desplegableColumnas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desplegableColumnasActionPerformed(evt);
            }
        });

        buscarCampo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarCampoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout mostrarDatosLayout = new javax.swing.GroupLayout(mostrarDatos);
        mostrarDatos.setLayout(mostrarDatosLayout);
        mostrarDatosLayout.setHorizontalGroup(
            mostrarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mostrarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mostrarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mostrarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mostrarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(mostrarDatosLayout.createSequentialGroup()
                            .addComponent(desplegableColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buscarCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mostrarDatosLayout.setVerticalGroup(
            mostrarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mostrarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mostrarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mostrarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desplegableColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        codCita.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        codCita.setText("Codigo de cita");

        comentario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comentario.setText("Comentario");

        DNI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DNI.setText("DNI");

        buttonEscribirDiagnostico.setText("Guardar");
        buttonEscribirDiagnostico.setEnabled(false);
        buttonEscribirDiagnostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEscribirDiagnosticoActionPerformed(evt);
            }
        });

        campoDNI.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        campoDNI.setForeground(new java.awt.Color(0, 51, 102));
        campoDNI.setText("");

        campoCita.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        campoCita.setForeground(new java.awt.Color(0, 51, 102));
        campoCita.setText("");

        DNI1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DNI1.setText("Paciente");

        campoNombre.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(0, 51, 102));
        campoNombre.setText("");

        comentarioTextArea.setColumns(20);
        comentarioTextArea.setRows(5);
        jScrollPane2.setViewportView(comentarioTextArea);

        javax.swing.GroupLayout formularioLayout = new javax.swing.GroupLayout(formulario);
        formulario.setLayout(formularioLayout);
        formularioLayout.setHorizontalGroup(
            formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formularioLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formularioLayout.createSequentialGroup()
                        .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DNI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, formularioLayout.createSequentialGroup()
                                    .addComponent(codCita, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoCita, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(212, 212, 212))
                    .addGroup(formularioLayout.createSequentialGroup()
                        .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonEscribirDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comentario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formularioLayout.createSequentialGroup()
                                .addComponent(DNI1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        formularioLayout.setVerticalGroup(
            formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formularioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DNI1)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codCita, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCita, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(comentario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(49, 49, 49)
                .addComponent(buttonEscribirDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitulo.setText("Escribir ficha de paciente");
        labelTitulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mostrarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mostrarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarCitasActionPerformed
        mostrarDatos();
    }//GEN-LAST:event_mostrarCitasActionPerformed

    private void mostrarDatos() {
        try {
            ResultSet rs = medico.mostrarCitasMedico();
            TableAdaptor aux = new TableAdaptor(rs);
            setTabla(aux.getValue());
            DefaultTableModel tabla = getTabla();
            tablaInfo.setModel(tabla);
            int numColums = tabla.getColumnCount();
            this.columnas = new String[numColums];
            for (int i = 0; i < numColums; i++) {
                this.columnas[i] = tabla.getColumnName(i);
            }
            desplegableColumnas.setModel(new javax.swing.DefaultComboBoxModel(this.columnas));
        } catch (SQLException ex) {
            Logger.getLogger(mostrarCitasMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void desplegableColumnasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desplegableColumnasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desplegableColumnasActionPerformed

    private void buscarCampoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarCampoKeyTyped
        buscarCampo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = (buscarCampo.getText());
                System.out.println(cadena);
                buscarCampo.setText(cadena);
                repaint();
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(tablaInfo.getModel());
        tablaInfo.setRowSorter(trsFiltro);
    }//GEN-LAST:event_buscarCampoKeyTyped

    private void tablaInfoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInfoMousePressed
        int row = tablaInfo.rowAtPoint(evt.getPoint());
        int col = tablaInfo.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            campoNombre.setText((String) tablaInfo.getValueAt(row, 1) + ", "
                    + (String) tablaInfo.getValueAt(row, 2));
            nDNI = (String) tablaInfo.getValueAt(row, 6);
            cCita = (String) tablaInfo.getValueAt(row, 0);
            campoDNI.setText(nDNI);
            campoCita.setText(cCita);
            buttonEscribirDiagnostico.setEnabled(true);
        }
    }//GEN-LAST:event_tablaInfoMousePressed

    private void buttonEscribirDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEscribirDiagnosticoActionPerformed
            try {
                System.out.println(comentarioTextArea.getText());
                medico.escribirFichaPaciente(nDNI, cCita, comentarioTextArea.getText());
            } catch (SQLException ex) {
                Logger.getLogger(EscribirFichaPaciente.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_buttonEscribirDiagnosticoActionPerformed

    public void filtro() {
        int colum = 0;
        while (!(desplegableColumnas.getSelectedItem() == this.columnas[colum])) {
            colum++;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(buscarCampo.getText(), colum));
    }

    private void setTabla(DefaultTableModel tabla) {
        this.tabla = tabla;
    }

    private DefaultTableModel getTabla() {
        return this.tabla;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DNI;
    private javax.swing.JLabel DNI1;
    private javax.swing.JTextField buscarCampo;
    private javax.swing.JButton buttonEscribirDiagnostico;
    private javax.swing.JLabel campoCita;
    private javax.swing.JLabel campoDNI;
    private javax.swing.JLabel campoNombre;
    private javax.swing.JLabel codCita;
    private javax.swing.JLabel comentario;
    private javax.swing.JTextArea comentarioTextArea;
    private javax.swing.JComboBox desplegableColumnas;
    private javax.swing.JPanel formulario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JButton mostrarCitas;
    private javax.swing.JPanel mostrarDatos;
    private javax.swing.JTable tablaInfo;
    // End of variables declaration//GEN-END:variables

}
