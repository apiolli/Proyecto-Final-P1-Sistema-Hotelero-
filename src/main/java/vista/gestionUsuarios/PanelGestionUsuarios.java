package vista.gestionUsuarios;

import vista.gestionUsuarios.DiagAggUsuarioAdmin;
import vista.gestionUsuarios.DiagEditarUsuarioAdmin;
import app.ContextoAplicacion;
import controlador.ControladorEmpleadoAdmin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import modelo.interfaces.Mensajes;


public class PanelGestionUsuarios extends javax.swing.JPanel implements Mensajes{

   
    private ControladorEmpleadoAdmin controlador;
    private ContextoAplicacion contexto;
    
    public PanelGestionUsuarios(ContextoAplicacion contexto) {
        this.contexto = contexto;
        initComponents();
        setLayout(new BorderLayout(0, 15));
        add(panelArriba(), BorderLayout.NORTH);
        add(panelMedio(), BorderLayout.CENTER);
        add(panelAbajo, BorderLayout.SOUTH);
        disenoTabla();
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAbajo = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtCorreo = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        titulo = new javax.swing.JLabel();

        btnAgregar.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnAgregar.setText("Agregar usuario");
        btnAgregar.addActionListener(this::btnAgregarActionPerformed);

        btnEditar.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnEditar.setText("Editar usuario");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        btnBuscar.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        label.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        label.setForeground(new java.awt.Color(0, 204, 204));
        label.setText("Usuario:");

        btnEliminar.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar usuario");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addComponent(label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        btnAgregar.setBackground(new java.awt.Color(0, 204, 204));

        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));

        btnAgregar.setToolTipText("");

        btnAgregar.setBorder(null);

        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAgregar.setFocusable(false);

        btnAgregar.setIconTextGap(10);

        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregar.setBackground(new Color(20, 30, 40));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregar.setBackground(new Color(0, 204, 204));
            }
        });
        btnEditar.setBackground(new java.awt.Color(0, 204, 204));

        btnEditar.setForeground(new java.awt.Color(255, 255, 255));

        btnEditar.setToolTipText("");

        btnEditar.setBorder(null);

        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEditar.setFocusable(false);

        btnEditar.setIconTextGap(10);

        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditar.setBackground(new Color(20, 30, 40));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditar.setBackground(new Color(0, 204, 204));
            }
        });
        btnBuscar.setBackground(new java.awt.Color(0, 204, 204));

        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));

        btnBuscar.setToolTipText("");

        btnBuscar.setBorder(null);

        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnBuscar.setFocusable(false);

        btnBuscar.setIconTextGap(10);

        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscar.setBackground(new Color(20, 30, 40));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscar.setBackground(new Color(0, 204, 204));
            }
        });
        btnEliminar.setBackground(new java.awt.Color(0, 204, 204));

        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));

        btnEliminar.setToolTipText("");

        btnEliminar.setBorder(null);

        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEliminar.setFocusable(false);

        btnEliminar.setIconTextGap(10);

        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminar.setBackground(new Color(20, 30, 40));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminar.setBackground(new Color(0, 204, 204));
            }
        });

        javax.swing.GroupLayout panelAbajoLayout = new javax.swing.GroupLayout(panelAbajo);
        panelAbajo.setLayout(panelAbajoLayout);
        panelAbajoLayout.setHorizontalGroup(
            panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAbajoLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        panelAbajoLayout.setVerticalGroup(
            panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAbajoLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabla.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Cargo", "Usuario", "Contrasena", "Nivel Acceso"
            }
        ));
        tabla.setRowHeight(25);
        jScrollPane1.setViewportView(tabla);

        titulo.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 204, 204));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Gestión de usuarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(296, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
          java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DiagAggUsuarioAdmin dialog = new DiagAggUsuarioAdmin(new javax.swing.JFrame(), true);
                controlador.setDiagAgg(dialog);
                dialog.setControlador(controlador);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        controlador.buscarEmpleadoAdmin(txtCorreo, tabla);
        txtCorreo.setText("");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
            int fila = tabla.getSelectedRow();
        if (fila == -1) {
            mostrarError("Por favor, seleccione un usuario de la tabla para editar.");
            return;
        }
      
        int idSeleccionado = (int) tabla.getValueAt(fila, 0);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DiagEditarUsuarioAdmin dialog = new DiagEditarUsuarioAdmin(new javax.swing.JFrame(), true);
                controlador.setDiagEdit(dialog);
                dialog.setControlador(controlador);
                dialog.setIdUsuario(idSeleccionado);
                               
                controlador.cargarDatosParaEdicion(idSeleccionado);
                
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tabla.getSelectedRow();

        if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un usuario válido", "Ventana de confirmación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int id = (int) tabla.getValueAt(fila, 0);

        int opcion = JOptionPane.showConfirmDialog(this,"¿Seguro que desea eliminar el usuario?","Ventana de confirmación",JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
        controlador.eliminarEmpleadoAdmin(id);
        }
    //    controlador.cargarTabla(tabla);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void labelArriba() {
        titulo.setBorder(BorderFactory.createEmptyBorder(15,0, 0,0));
    }
    
    private JPanel panelArriba() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(titulo, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel panelMedio() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 20, 10, 20));
        JScrollPane scroll = new JScrollPane(tabla);
        panel.add(scroll, BorderLayout.CENTER);
        
        return panel;
    }
    
    
    private void disenoTabla() {
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
    
    public void setControlador(ControladorEmpleadoAdmin controla) {
        this.controlador = controla;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JPanel panelAbajo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables

    
    // Pepa
    @Override
    public void mostrarExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
 
    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public JTable getTabla() {
        return tabla;
}
    
}
