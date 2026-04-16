package vista.reservas;

import controlador.ControladorReserva;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class DiagCrearReserva extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DiagCrearReserva.class.getName());
    
    private ControladorReserva controlador;
    
    public DiagCrearReserva(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/logopeque.png")).getImage());
        getContentPane().setBackground(new Color(0x1C2B3A));
        spNoPersonas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
    

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnDIag = new javax.swing.JButton();
        txtApellido = new javax.swing.JTextField();
        fechaEntrada = new com.toedter.calendar.JDateChooser();
        btnBuscarDoc = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        fechaSalida = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        spNoPersonas = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbTipoHab = new javax.swing.JComboBox<>();
        cmbHabDisponibles = new javax.swing.JComboBox<>();
        btnBuscarHab = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtDineroAbonado = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();

        jLabel6.setText("jLabel6");

        setTitle("Crear reserva");
        setBackground(new java.awt.Color(0, 51, 51));
        setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Crear reserva");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Documento de identidad:");

        txtDocumento.setBackground(new java.awt.Color(255, 255, 255));
        txtDocumento.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtDocumento.setForeground(new java.awt.Color(0, 0, 0));
        txtDocumento.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre: ");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido:");

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de entrada:");

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setBorder(null);

        btnDIag.setText("Crear");
        btnDIag.addActionListener(this::btnDIagActionPerformed);

        txtApellido.setEditable(false);
        txtApellido.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(0, 0, 0));
        txtApellido.setBorder(null);

        fechaEntrada.setBackground(new java.awt.Color(255, 255, 255));
        fechaEntrada.setForeground(new java.awt.Color(0, 0, 0));

        btnBuscarDoc.setText("Buscar");
        btnBuscarDoc.setBorder(null);
        btnBuscarDoc.addActionListener(this::btnBuscarDocActionPerformed);

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha de salida:");

        fechaSalida.setBackground(new java.awt.Color(255, 255, 255));
        fechaSalida.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Numero de personas:");

        spNoPersonas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        spNoPersonas.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Habitacion:");

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tipo de habitacion:");

        cmbTipoHab.setBackground(new java.awt.Color(255, 255, 255));
        cmbTipoHab.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cmbTipoHab.setForeground(new java.awt.Color(0, 0, 0));
        cmbTipoHab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Doble", "Suite", "Deluxe" }));
        cmbTipoHab.setBorder(null);

        cmbHabDisponibles.setBackground(new java.awt.Color(255, 255, 255));
        cmbHabDisponibles.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cmbHabDisponibles.setForeground(new java.awt.Color(0, 0, 0));
        cmbHabDisponibles.setBorder(null);

        btnBuscarHab.setText("Buscar");
        btnBuscarHab.setBorder(null);
        btnBuscarHab.addActionListener(this::btnBuscarHabActionPerformed);

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Dinero abonado:");

        txtDineroAbonado.setBackground(new java.awt.Color(255, 255, 255));
        txtDineroAbonado.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtDineroAbonado.setForeground(new java.awt.Color(0, 0, 0));
        txtDineroAbonado.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spNoPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbHabDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTipoHab, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarHab, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDineroAbonado, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btnDIag, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spNoPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoHab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarHab, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHabDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDineroAbonado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnDIag, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        btnDIag.setBackground(new java.awt.Color(0, 204, 204));

        btnDIag.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        btnDIag.setForeground(new java.awt.Color(255, 255, 255));

        btnDIag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/crearReservas.png"))); // NOI18N

        btnDIag.setToolTipText("");

        btnDIag.setBorder(null);

        btnDIag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnDIag.setFocusable(false);

        btnDIag.setIconTextGap(10);

        btnDIag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDIag.setBackground(new Color(81, 109, 110));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDIag.setBackground(new Color(0, 204, 204));
            }
        });

        // Code adding the component to the parent container - not shown here
        // Code adding the component to the parent container - not shown here
        btnBuscarDoc.setBackground(new java.awt.Color(0, 204, 204));

        btnBuscarDoc.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        btnBuscarDoc.setForeground(new java.awt.Color(255, 255, 255));

        btnBuscarDoc.setToolTipText("");

        btnBuscarDoc.setBorder(null);

        btnBuscarDoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnBuscarDoc.setFocusable(false);

        btnBuscarDoc.setIconTextGap(10);

        btnBuscarDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarDoc.setBackground(new Color(81, 109, 110));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarDoc.setBackground(new Color(0, 204, 204));
            }
        });
        // Code adding the component to the parent container - not shown here
        btnBuscarHab.setBackground(new java.awt.Color(0, 204, 204));

        btnBuscarHab.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        btnBuscarHab.setForeground(new java.awt.Color(255, 255, 255));

        btnBuscarHab.setToolTipText("");

        btnBuscarHab.setBorder(null);

        btnBuscarHab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnBuscarHab.setFocusable(false);

        btnBuscarHab.setIconTextGap(10);

        btnBuscarHab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarHab.setBackground(new Color(81, 109, 110));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarHab.setBackground(new Color(0, 204, 204));
            }
        });
        txtID.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDIagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDIagActionPerformed
        // TODO add your handling code here:
        btnDIag.setEnabled(false);
        if (txtID.getText().trim().isEmpty() || txtNombre.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, busque y seleccione un huésped primero.", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
            btnDIag.setEnabled(true);
            return;
        }

        if (fechaEntrada.getDate() == null || fechaSalida.getDate() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione las fechas de entrada y salida.", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
            btnDIag.setEnabled(true);
            return;
        }

        if (fechaSalida.getDate().before(fechaEntrada.getDate()) || fechaSalida.getDate().equals(fechaEntrada.getDate())) {
            javax.swing.JOptionPane.showMessageDialog(this, "La fecha de salida debe ser posterior a la de entrada.", "Error de fechas", javax.swing.JOptionPane.WARNING_MESSAGE);
            btnDIag.setEnabled(true);
            return;
        }

        if (cmbHabDisponibles.getSelectedItem() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione una habitación disponible.", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
            btnDIag.setEnabled(true);
            return;
        }

        if (txtDineroAbonado.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el dinero abonado (coloque 0 si no abona nada).", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
            btnDIag.setEnabled(true);
            return;
        }

        try {
            double abono = Double.parseDouble(txtDineroAbonado.getText().trim());
            if (abono < 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "El dinero abonado no puede ser negativo.", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
                btnDIag.setEnabled(true);
                return;
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "El dinero abonado debe ser un número válido.", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
            btnDIag.setEnabled(true);
            return;
        }
        
        boolean reservaExitosa = controlador.crearReserva();
        
        if (reservaExitosa) {
            this.dispose(); // Solo cierra la ventana si se guardó en la BD
        } else {
            btnDIag.setEnabled(true); // Si falló (ej. por capacidad), encendemos el botón para que corrija
        }
        
    }//GEN-LAST:event_btnDIagActionPerformed

    private void btnBuscarDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDocActionPerformed
        // TODO add your handling code here:
        controlador.buscarHuesped(txtNombre, txtApellido, txtDocumento, txtID);
    }//GEN-LAST:event_btnBuscarDocActionPerformed

    private void btnBuscarHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHabActionPerformed
        // TODO add your handling code here:
        controlador.buscarHabitacionesDisponibles();
    }//GEN-LAST:event_btnBuscarHabActionPerformed
    
    public void cargarHabitacionesDisponibles(ArrayList<Integer> habitaciones) {
        cmbHabDisponibles.removeAllItems();
        for (Integer numHab : habitaciones) {
            cmbHabDisponibles.addItem(String.valueOf(numHab));
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarDoc;
    private javax.swing.JButton btnBuscarHab;
    private javax.swing.JButton btnDIag;
    private javax.swing.JComboBox<String> cmbHabDisponibles;
    private javax.swing.JComboBox<String> cmbTipoHab;
    private com.toedter.calendar.JDateChooser fechaEntrada;
    private com.toedter.calendar.JDateChooser fechaSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner spNoPersonas;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDineroAbonado;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public String getHabDisponibles() {
        return cmbHabDisponibles.getSelectedItem().toString();
    }
 
    public String getTipoHab() {
        return cmbTipoHab.getSelectedItem().toString();
    }
 
    public long getFechaEntrada() {
        Date fechaentrada = this.fechaEntrada.getDate();
        return fechaentrada.getTime();
    }
 
    public long getFechaSalida() {
        Date fechaSalida = this.fechaSalida.getDate();
        return fechaSalida.getTime();
    }
 
    public int getSpNoPersonas() {
        return Integer.valueOf(spNoPersonas.getValue().toString());
    }
 
    public String getApellido() {
        return txtApellido.getText();
    }
 
    public double getDineroAbonado() {
        return Double.valueOf(txtDineroAbonado.getText());
    }
 
    public String getDocumento() {
        return txtDocumento.getText();
    }
 
    public String getNombre() {
        return txtNombre.getText();
    }
    
    public void setControlador(ControladorReserva controlador) {
        this.controlador = controlador;
    }
 
    public int getTxtID() {
        return Integer.valueOf(txtID.getText());
    }
    

}

