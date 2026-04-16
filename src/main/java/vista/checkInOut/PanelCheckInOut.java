package vista.checkInOut;

import app.ContextoAplicacion;
import controlador.ControladorChecks;
import controlador.ControladorFacturacion;
import controlador.ControladorHabitacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import modelo.interfaces.Mensajes;

public class PanelCheckInOut extends javax.swing.JPanel implements Mensajes{

    private ContextoAplicacion contexto;
    private ControladorChecks controlador;
    private int idTabla;
    
    public PanelCheckInOut(ContextoAplicacion contexto) {
        this.contexto = contexto;
        initComponents();
        setLayout(new BorderLayout());
        disenoTabla(tablaCheckin);
        disenoTabla(tablaCheckout);
        add(panHead, BorderLayout.NORTH);
        add(panHab, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panHead = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        btnCrearCheckin = new javax.swing.JButton();
        panHab = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCheckout = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCheckin = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        btnCrearCheckin.setText("Registrar Check In");
        btnCrearCheckin.addActionListener(this::btnCrearCheckinActionPerformed);

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrearCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnCrearCheckin, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCrearCheckin.setBackground(new java.awt.Color(0, 204, 204));

        btnCrearCheckin.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        btnCrearCheckin.setForeground(new java.awt.Color(255, 255, 255));

        btnCrearCheckin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registrarCheckin.png"))); // NOI18N

        btnCrearCheckin.setToolTipText("");

        btnCrearCheckin.setBorder(null);

        btnCrearCheckin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCrearCheckin.setFocusable(false);

        btnCrearCheckin.setIconTextGap(10);

        btnCrearCheckin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearCheckin.setBackground(new Color(20, 30, 40));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearCheckin.setBackground(new Color(0, 204, 204));
            }
        });

        // Code adding the component to the parent container - not shown here

        javax.swing.GroupLayout panHeadLayout = new javax.swing.GroupLayout(panHead);
        panHead.setLayout(panHeadLayout);
        panHeadLayout.setHorizontalGroup(
            panHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panHeadLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panHeadLayout.setVerticalGroup(
            panHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tablaCheckout.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Huesped", "Fecha entrada", "Fecha salida", "Consumos", "Dinero abonado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCheckout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCheckoutMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaCheckout);
        if (tablaCheckout.getColumnModel().getColumnCount() > 0) {
            tablaCheckout.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check out.png"))); // NOI18N
        jLabel2.setText("Reservas activas - Check out pendiente");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel2.setIconTextGap(10);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tablaCheckin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Huesped", "Habitacion", "Fecha entrada", "Fecha salida", "Total personas", "Dinero abonado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCheckin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCheckinMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCheckin);
        if (tablaCheckin.getColumnModel().getColumnCount() > 0) {
            tablaCheckin.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check-in.png"))); // NOI18N
        jLabel1.setText("Reservas confimadas - Check In pendiente");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setIconTextGap(10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(360, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panHabLayout = new javax.swing.GroupLayout(panHab);
        panHab.setLayout(panHabLayout);
        panHabLayout.setHorizontalGroup(
            panHabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panHabLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panHabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(27, 27, 27))
        );
        panHabLayout.setVerticalGroup(
            panHabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panHabLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panHab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panHab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaCheckinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCheckinMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) { 
            controlador.seleccionarCheckIn();
        }        
    }//GEN-LAST:event_tablaCheckinMouseClicked

    private void tablaCheckoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCheckoutMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            controlador.seleccionarCheckOut();
        } 
    }//GEN-LAST:event_tablaCheckoutMouseClicked

    private void btnCrearCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCheckinActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnCrearCheckinActionPerformed
    
    private void disenoTabla(JTable tabla) {
        JTableHeader header = tabla.getTableHeader();

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
                label.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0, 0, 0, 1, tabla.getGridColor()),
                    new EmptyBorder(0, 12, 0, 0) 
                ));

                return label;
            }
        });
        
        tabla.setBackground(Color.WHITE);
        tabla.setForeground(Color.BLACK);   
        tabla.setFont(new Font("Poppins", Font.PLAIN, 13)); 
        tabla.setRowHeight(20);                             
        tabla.setGridColor(new Color(0, 204, 204));
        tabla.setFillsViewportHeight(true);           
        tabla.setFocusable(false);    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCheckin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panHab;
    private javax.swing.JPanel panHead;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JTable tablaCheckin;
    private javax.swing.JTable tablaCheckout;
    // End of variables declaration//GEN-END:variables

    public void setControlador(ControladorChecks contro) {
        this.controlador = contro;
    }
    
    @Override
    public void mostrarExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
 
    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public JTable getTablaCheckin() {
        return tablaCheckin;
    }

    public JTable getTablaCheckout() {
        return tablaCheckout;
    }

    public int getIdTabla() {
        return idTabla;
    }

    public void setIdTabla(int idTabla) {
        this.idTabla = idTabla;
    }

    
    
    
    
    
    

}
