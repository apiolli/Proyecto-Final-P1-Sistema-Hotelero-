/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author DELL
 */
public class PanelHabitaciones extends javax.swing.JPanel {
    
    public PanelHabitaciones() {
        initComponents();
        setLayout(new BorderLayout(0, 12));
        setBorder(new EmptyBorder(16, 16, 16, 16));
        setBackground(new Color(242, 242, 242));
        add(panelHeader(), BorderLayout.NORTH);
        add(panelGestion(), BorderLayout.CENTER);


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitular = new javax.swing.JPanel();
        panelInfo = new javax.swing.JPanel();
        pDispo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        btnAgregarHab = new javax.swing.JButton();
        panelHab = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelInfo.setBackground(new java.awt.Color(242, 242, 242));

        pDispo.setBackground(new java.awt.Color(0, 204, 204));
        pDispo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 0, 0, new java.awt.Color(0, 204, 0)));
        pDispo.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Disponibles");

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("1");

        javax.swing.GroupLayout pDispoLayout = new javax.swing.GroupLayout(pDispo);
        pDispo.setLayout(pDispoLayout);
        pDispoLayout.setHorizontalGroup(
            pDispoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDispoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pDispoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDispoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDispoLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        pDispoLayout.setVerticalGroup(
            pDispoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDispoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 0, 0, new java.awt.Color(204, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ocupadas");

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 0, 0, new java.awt.Color(255, 255, 0)));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("En mantenimiento");

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 0, 0, new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sucias");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pDispo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDispo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBotones.setBackground(new java.awt.Color(242, 242, 242));

        btnAgregarHab.setBackground(new java.awt.Color(0, 204, 204));
        btnAgregarHab.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnAgregarHab.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarHab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnAgregarHab.setText("Agregar Habitacion");
        btnAgregarHab.setToolTipText("");
        btnAgregarHab.setBorder(null);
        btnAgregarHab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarHab.setFocusable(false);
        btnAgregarHab.setIconTextGap(10);
        btnAgregarHab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarHabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarHabMouseExited(evt);
            }
        });
        btnAgregarHab.addActionListener(this::btnAgregarHabActionPerformed);

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addContainerGap(775, Short.MAX_VALUE)
                .addComponent(btnAgregarHab, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarHab, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelTitularLayout = new javax.swing.GroupLayout(panelTitular);
        panelTitular.setLayout(panelTitularLayout);
        panelTitularLayout.setHorizontalGroup(
            panelTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTitularLayout.setVerticalGroup(
            panelTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitularLayout.createSequentialGroup()
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelHab.setBackground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout panelHabLayout = new javax.swing.GroupLayout(panelHab);
        panelHab.setLayout(panelHabLayout);
        panelHabLayout.setHorizontalGroup(
            panelHabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelHabLayout.setVerticalGroup(
            panelHabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelHab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelHab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarHabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarHabMouseEntered

        btnAgregarHab.setBackground(new Color(0x1C2B3A));
    }//GEN-LAST:event_btnAgregarHabMouseEntered

    private void btnAgregarHabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarHabMouseExited

        btnAgregarHab.setBackground(new Color(0, 204, 204));

    }//GEN-LAST:event_btnAgregarHabMouseExited

    private void btnAgregarHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHabActionPerformed
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DiagAggHabitacion dialog = new DiagAggHabitacion(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnAgregarHabActionPerformed

    private JPanel panelHeader() {
        panelTitular.setLayout(new BorderLayout());
        panelTitular.add(panelInfo, BorderLayout.NORTH);
        panelTitular.add(panelBotones, BorderLayout.CENTER);
        
        return panelTitular;
    }
    
    private JPanel agregarHabitacion(String numero, String tipo, String estado) {
        JPanel habitacion = new javax.swing.JPanel();
        JLabel noHab = new javax.swing.JLabel("Hab. " + numero);
        JLabel tipoHab = new javax.swing.JLabel(tipo);
        JLabel iconoEstado = new javax.swing.JLabel();
        JPanel panEstado = new javax.swing.JPanel();
        JLabel estadoHab = new javax.swing.JLabel(estado);

        habitacion.setBackground(new java.awt.Color(204, 255, 255));
        habitacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        noHab.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        noHab.setForeground(Color.BLACK);

        tipoHab.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tipoHab.setForeground(Color.BLACK);

        iconoEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        panEstado.setBackground(new java.awt.Color(0, 102, 102));

        estadoHab.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        estadoHab.setForeground(new java.awt.Color(0, 204, 204));
        estadoHab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estadoHab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panEstadoLayout = new javax.swing.GroupLayout(panEstado);
        panEstado.setLayout(panEstadoLayout);
        panEstadoLayout.setHorizontalGroup(
            panEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panEstadoLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(estadoHab, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        panEstadoLayout.setVerticalGroup(
            panEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panEstadoLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(estadoHab))
        );

        GroupLayout habitacionLayout = new GroupLayout(habitacion);
        habitacion.setLayout(habitacionLayout);
        habitacionLayout.setHorizontalGroup(
            habitacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(habitacionLayout.createSequentialGroup()
                .addGap(15)
                .addGroup(habitacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(tipoHab, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(noHab, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, habitacionLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconoEstado, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addGap(77))
            .addGroup(habitacionLayout.createSequentialGroup()
                .addComponent(panEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        habitacionLayout.setVerticalGroup(
            habitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(habitacionLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(noHab, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoHab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        
        habitacion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        DiagEditarHabitacion dialog = new DiagEditarHabitacion(new javax.swing.JFrame(), true);
                        dialog.setVisible(true);
                    }
                });
            }
            
        });
        
//        habitacion.setPreferredSize(new Dimension(205, 150));
        cambiarEstado(habitacion, panEstado, estadoHab, iconoEstado, estado);
        panelHab.add(habitacion);
        return habitacion;
    }
                
    
    private void cambiarEstado(JPanel habitacion, JPanel panelEstado, JLabel lbEstado, JLabel icono, String status) {
        switch (status) {
            case "Libre":
                habitacion.setBackground(new Color(87, 171, 87));
                panelEstado.setBackground(new Color(234, 243, 222));
                lbEstado.setForeground(new Color(59, 109, 17));
                icono.setIcon(new ImageIcon(getClass().getResource("/img/disponible.png")));
                break;
            case "Ocupada":
                habitacion.setBackground(new Color(222, 42, 42));
                panelEstado.setBackground(new Color(250, 236, 231));
                lbEstado.setForeground(new Color(153, 60, 29));
                icono.setIcon(new ImageIcon(getClass().getResource("/img/ocupada.png")));
                break;
            case "Mantenimiento":
                habitacion.setBackground(new Color(245, 243, 37));
                panelEstado.setBackground(new Color(255, 255, 199));
                lbEstado.setForeground(new Color(120, 116, 0));
                icono.setIcon(new ImageIcon(getClass().getResource("/img/mantenimiento.png")));
                break;
            case "Sucia":
                habitacion.setBackground(new Color(117, 117, 117));
                panelEstado.setBackground(new Color(237, 237, 223));
                lbEstado.setForeground(new Color(36, 36, 36));
                icono.setIcon(new ImageIcon(getClass().getResource("/img/sucia.png")));
                break;
        }
    }
    
    private JScrollPane panelGestion() {
        panelHab.setLayout(new WrapLayout(FlowLayout.LEFT, 12, 12));

        agregarHabitacion("101", "Individual", "Libre");
        agregarHabitacion("102", "Doble",      "Ocupada");
        agregarHabitacion("103", "Suite",      "Sucia");
        agregarHabitacion("103", "Suite",      "Sucia");
        agregarHabitacion("104", "Familiar",   "Mantenimiento");
        agregarHabitacion("105", "Doble",      "Ocupada");
        agregarHabitacion("106", "Deluxe",     "Libre");

        JScrollPane scroll = new JScrollPane(panelHab);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scroll;
    }
    
//    private JPopupMenu menuFlotante() {
//        JPopupMenu menu = new JPopupMenu();
//
//        JMenuItem pDisponible = new JMenuItem("Disponible");
//        JMenuItem pOcupada = new JMenuItem("Ocupada");
//        JMenuItem pMantenimiento = new JMenuItem("Mantenimiento");
//        JMenuItem pSucia = new JMenuItem("Sucia");
//        
//        pDisponible.setFont(new Font("Poppins", Font.PLAIN, 14));
//        pOcupada.setFont(new Font("Poppins", Font.PLAIN, 14));
//        pMantenimiento.setFont(new Font("Poppins", Font.PLAIN, 14));
//        pSucia.setFont(new Font("Poppins", Font.PLAIN, 14));
//        
//        menu.setBorder(null);
//
//        // Darles funcionalidad (ActionListeners)
////        itemLimpiar.addActionListener(e -> );
//        
////        itemSaludar.addActionListener(e -> areaTexto.append("\n¡Hola! Seguimos programando."));
//        
////        itemSalir.addActionListener(e -> System.exit(0));
//
////            deleteBtn.addActionListener(e -> {
//    //            Container parent = card.getParent();
//    //            if (parent != null) {
//    //                parent.remove(card);
//    //                parent.revalidate();  // recalcula el WrapLayout
//    //                parent.repaint();
//    //            }
//    //        });
//
//        
//        menu.add(pDisponible);
//        menu.add(pOcupada);
//        menu.add(pMantenimiento);
//        menu.add(pSucia);
//        
//        return menu;
//    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarHab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel pDispo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelHab;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelTitular;
    // End of variables declaration//GEN-END:variables
}
