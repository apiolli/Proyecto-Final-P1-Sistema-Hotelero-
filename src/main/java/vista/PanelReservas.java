/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author DELL
 */
public class PanelReservas extends javax.swing.JPanel {

    /**
     * Creates new form PanelReservas
     */
    public PanelReservas() {
        initComponents();
        setLayout(new BorderLayout());
        disenoTabla();
        add(panelTitulo, BorderLayout.NORTH);
        add(panelMedio, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        panelNumeroReservas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAgregarReserva = new javax.swing.JButton();
        btnAgregarReserva1 = new javax.swing.JButton();
        panelMedio = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();

        panelTitulo.setForeground(new java.awt.Color(242, 242, 242));

        panelNumeroReservas.setBackground(new java.awt.Color(0, 204, 204));
        panelNumeroReservas.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 0, 0, new java.awt.Color(5, 171, 196)));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Numero de reservas actuales");
        jLabel1.setToolTipText("");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/noReservas.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("1");

        javax.swing.GroupLayout panelNumeroReservasLayout = new javax.swing.GroupLayout(panelNumeroReservas);
        panelNumeroReservas.setLayout(panelNumeroReservasLayout);
        panelNumeroReservasLayout.setHorizontalGroup(
            panelNumeroReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNumeroReservasLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(panelNumeroReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelNumeroReservasLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        panelNumeroReservasLayout.setVerticalGroup(
            panelNumeroReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNumeroReservasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelNumeroReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNumeroReservasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNumeroReservasLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregarReserva.setText("Crear reserva");
        btnAgregarReserva.addActionListener(this::btnAgregarReservaActionPerformed);

        btnAgregarReserva1.setText("Registrar huesped");
        btnAgregarReserva1.addActionListener(this::btnAgregarReserva1ActionPerformed);

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(panelNumeroReservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(btnAgregarReserva1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTituloLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelNumeroReservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTituloLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnAgregarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregarReserva1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );

        btnAgregarReserva.setBackground(new java.awt.Color(0, 204, 204));

        btnAgregarReserva.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        btnAgregarReserva.setForeground(new java.awt.Color(255, 255, 255));

        btnAgregarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/aggReserva.png"))); // NOI18N

        btnAgregarReserva.setToolTipText("");

        btnAgregarReserva.setBorder(null);

        btnAgregarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAgregarReserva.setFocusable(false);

        btnAgregarReserva.setIconTextGap(10);

        btnAgregarReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarReserva.setBackground(new Color(20, 30, 40));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarReserva.setBackground(new Color(0, 204, 204));
            }
        });

        // Code adding the component to the parent container - not shown here
        btnAgregarReserva1.setBackground(new java.awt.Color(0, 204, 204));

        btnAgregarReserva1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        btnAgregarReserva1.setForeground(new java.awt.Color(255, 255, 255));

        btnAgregarReserva1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevoUsuario.png"))); // NOI18N

        btnAgregarReserva1.setToolTipText("");

        btnAgregarReserva1.setBorder(null);

        btnAgregarReserva1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAgregarReserva1.setFocusable(false);

        btnAgregarReserva1.setIconTextGap(10);

        btnAgregarReserva1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarReserva1.setBackground(new Color(20, 30, 40));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarReserva1.setBackground(new Color(0, 204, 204));
            }
        });

        // Code adding the component to the parent container - not shown here

        panelMedio.setBackground(new java.awt.Color(242, 242, 242));

        tablaReservas.setBackground(new java.awt.Color(0, 204, 204));
        tablaReservas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tablaReservas.setForeground(new java.awt.Color(255, 255, 255));
        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre cliente", "Total personas", "Habitacion", "Fecha entrada", "Fecha salida", "Dinero abonado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaReservas.setGridColor(new java.awt.Color(255, 255, 204));
        jScrollPane1.setViewportView(tablaReservas);
        if (tablaReservas.getColumnModel().getColumnCount() > 0) {
            tablaReservas.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        javax.swing.GroupLayout panelMedioLayout = new javax.swing.GroupLayout(panelMedio);
        panelMedio.setLayout(panelMedioLayout);
        panelMedioLayout.setHorizontalGroup(
            panelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(21, 21, 21))
        );
        panelMedioLayout.setVerticalGroup(
            panelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedioLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMedio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelMedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarReserva1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarReserva1ActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DiagRegistrarHuesped dialog = new DiagRegistrarHuesped(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnAgregarReserva1ActionPerformed

    private void btnAgregarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarReservaActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DiagCrearReserva dialog = new DiagCrearReserva(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnAgregarReservaActionPerformed

    private void panelDelMedio() {
        panelMedio.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(tablaReservas);
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(panelMedio.getBackground());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;               
        gbc.weighty = 1.0;                
        gbc.insets = new Insets(20, 40, 20, 40);

        wrapper.add(scrollPane, gbc);
        panelMedio.add(wrapper, BorderLayout.CENTER);
    }
    
    private void disenoTabla() {
        JTableHeader header = tablaReservas.getTableHeader();

        header.setBackground(new Color(20, 30, 40));
        header.setForeground(new Color(0, 204, 204));
        header.setFont(new Font("Poppins", Font.BOLD, 13));
        header.setPreferredSize(new Dimension(0, 35));
        header.setBorder(null);
        
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {

                JLabel label = (JLabel) super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column
                );

                label.setBackground(new Color(20, 30, 40));
                label.setForeground(new Color(0, 204, 204));
                label.setFont(new Font("Poppins", Font.BOLD, 13));
                label.setOpaque(true);

                // Borde derecho del mismo color que el grid de la tabla
                label.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0, 0, 0, 1, tablaReservas.getGridColor()), // línea derecha
                    new EmptyBorder(0, 12, 0, 0) // padding interno
                ));

                return label;
            }
        });
        
        tablaReservas.setBackground(Color.WHITE);        // fondo de las celdas
        tablaReservas.setForeground(Color.BLACK);                   // color del texto
        tablaReservas.setFont(new Font("Poppins", Font.PLAIN, 13)); 
        tablaReservas.setRowHeight(20);                             
        tablaReservas.setGridColor(new Color(0, 204, 204));
        tablaReservas.setFillsViewportHeight(true);           
        tablaReservas.setFocusable(false);    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarReserva;
    private javax.swing.JButton btnAgregarReserva1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMedio;
    private javax.swing.JPanel panelNumeroReservas;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tablaReservas;
    // End of variables declaration//GEN-END:variables
}
