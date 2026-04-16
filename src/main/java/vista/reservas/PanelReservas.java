package vista.reservas;
 
import vista.reservas.DiagCrearReserva;
import app.ContextoAplicacion;
import controlador.ControladorHuesped;
import controlador.ControladorReserva;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import modelo.interfaces.Mensajes;

public class PanelReservas extends javax.swing.JPanel implements Mensajes{
    
    private ContextoAplicacion contexto;
    private ControladorReserva controlador;
    
    public PanelReservas(ContextoAplicacion contexto) {
        this.contexto = contexto;
        initComponents();
        setLayout(new BorderLayout());
        disenoTabla();
        add(panelTitulo, BorderLayout.NORTH);
        add(panelMedio(), BorderLayout.CENTER);

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
        btnRegistrarHuesped = new javax.swing.JButton();
        panelMedio = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        btnMostrarConfirmadas = new javax.swing.JButton();
        btnMostrarActivas = new javax.swing.JButton();
        btnMostrarCompletadas = new javax.swing.JButton();
        btnMostrarTodo = new javax.swing.JButton();

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

        btnRegistrarHuesped.setText("Registrar huesped");
        btnRegistrarHuesped.addActionListener(this::btnRegistrarHuespedActionPerformed);

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(panelNumeroReservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarHuesped, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(btnAgregarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelNumeroReservas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                        .addComponent(btnAgregarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegistrarHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        btnRegistrarHuesped.setBackground(new java.awt.Color(0, 204, 204));

        btnRegistrarHuesped.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        btnRegistrarHuesped.setForeground(new java.awt.Color(255, 255, 255));

        btnRegistrarHuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevoUsuario.png"))); // NOI18N

        btnRegistrarHuesped.setToolTipText("");

        btnRegistrarHuesped.setBorder(null);

        btnRegistrarHuesped.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnRegistrarHuesped.setFocusable(false);

        btnRegistrarHuesped.setIconTextGap(10);

        btnRegistrarHuesped.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarHuesped.setBackground(new Color(20, 30, 40));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarHuesped.setBackground(new Color(0, 204, 204));
            }
        });

        // Code adding the component to the parent container - not shown here

        panelMedio.setBackground(new java.awt.Color(242, 242, 242));

        tablaReservas.setBackground(new java.awt.Color(0, 204, 204));
        tablaReservas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tablaReservas.setForeground(new java.awt.Color(255, 255, 255));
        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Huesped", "Total personas", "Habitacion", "Fecha entrada", "Fecha salida", "Fecha reserva", "Estado", "Dinero abonado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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

        btnMostrarConfirmadas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnMostrarConfirmadas.setText("Reservas confirmadas");

        btnMostrarActivas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnMostrarActivas.setText("Reservas activas");
        btnMostrarActivas.addActionListener(this::btnMostrarActivasActionPerformed);

        btnMostrarCompletadas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnMostrarCompletadas.setText("Reservas completadas");

        btnMostrarTodo.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnMostrarTodo.setText("Mostrar todas las reservas");

        javax.swing.GroupLayout panelMedioLayout = new javax.swing.GroupLayout(panelMedio);
        panelMedio.setLayout(panelMedioLayout);
        panelMedioLayout.setHorizontalGroup(
            panelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedioLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMedioLayout.createSequentialGroup()
                        .addComponent(btnMostrarConfirmadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMostrarActivas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(btnMostrarCompletadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34))
                    .addGroup(panelMedioLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(32, 32, 32))))
            .addGroup(panelMedioLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(btnMostrarTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(214, 214, 214))
        );
        panelMedioLayout.setVerticalGroup(
            panelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedioLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarConfirmadas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrarActivas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrarCompletadas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMostrarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        // Code adding the component to the parent container - not shown here
        btnMostrarConfirmadas.setBackground(new java.awt.Color(0, 204, 204));

        btnMostrarConfirmadas.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        btnMostrarConfirmadas.setForeground(new java.awt.Color(255, 255, 255));

        btnMostrarConfirmadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/activa.png"))); // NOI18N

        btnMostrarConfirmadas.setToolTipText("");

        btnMostrarConfirmadas.setBorder(null);

        btnMostrarConfirmadas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnMostrarConfirmadas.setFocusable(false);

        btnMostrarConfirmadas.setIconTextGap(10);

        btnMostrarConfirmadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMostrarConfirmadas.setBackground(new Color(20, 30, 40));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMostrarConfirmadas.setBackground(new Color(0, 204, 204));
            }
        });

        // Code adding the component to the parent container - not shown here
        // Code adding the component to the parent container - not shown here
        btnMostrarActivas.setBackground(new java.awt.Color(0, 204, 204));

        btnMostrarActivas.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        btnMostrarActivas.setForeground(new java.awt.Color(255, 255, 255));

        btnMostrarActivas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmado.png"))); // NOI18N

        btnMostrarActivas.setToolTipText("");

        btnMostrarActivas.setBorder(null);

        btnMostrarActivas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnMostrarActivas.setFocusable(false);

        btnMostrarActivas.setIconTextGap(10);

        btnMostrarActivas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMostrarActivas.setBackground(new Color(20, 30, 40));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMostrarActivas.setBackground(new Color(0, 204, 204));
            }
        });

        // Code adding the component to the parent container - not shown here
        // Code adding the component to the parent container - not shown here
        btnMostrarCompletadas.setBackground(new java.awt.Color(0, 204, 204));

        btnMostrarCompletadas.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        btnMostrarCompletadas.setForeground(new java.awt.Color(255, 255, 255));

        btnMostrarCompletadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/completed.png"))); // NOI18N

        btnMostrarCompletadas.setToolTipText("");

        btnMostrarCompletadas.setBorder(null);

        btnMostrarCompletadas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnMostrarCompletadas.setFocusable(false);

        btnMostrarCompletadas.setIconTextGap(10);

        btnMostrarCompletadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMostrarCompletadas.setBackground(new Color(20, 30, 40));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMostrarCompletadas.setBackground(new Color(0, 204, 204));
            }
        });

        // Code adding the component to the parent container - not shown here
        // Code adding the component to the parent container - not shown here
        btnMostrarTodo.setBackground(new java.awt.Color(0, 204, 204));

        btnMostrarTodo.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        btnMostrarTodo.setForeground(new java.awt.Color(255, 255, 255));

        btnMostrarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/all.png"))); // NOI18N

        btnMostrarTodo.setToolTipText("");

        btnMostrarTodo.setBorder(null);

        btnMostrarTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnMostrarTodo.setFocusable(false);

        btnMostrarTodo.setIconTextGap(10);

        btnMostrarTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMostrarTodo.setBackground(new Color(20, 30, 40));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMostrarTodo.setBackground(new Color(0, 204, 204));
            }
        });

        // Code adding the component to the parent container - not shown here

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
                .addComponent(panelMedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarHuespedActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            DiagRegistrarHuesped dialog = new DiagRegistrarHuesped(new javax.swing.JFrame(), true);
            ControladorHuesped control = new ControladorHuesped(dialog, contexto.getHuespedDAO());
            dialog.setControlador(control);
            dialog.setVisible(true);
        });
    }//GEN-LAST:event_btnRegistrarHuespedActionPerformed

    private void btnAgregarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarReservaActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            DiagCrearReserva dialog = new DiagCrearReserva(new javax.swing.JFrame(), true);
            controlador.setDiagCrear(dialog);
            controlador.setHuespedDAO(contexto.getHuespedDAO());
            controlador.setHabitacionDAO(contexto.getHabitacionDAO());
            dialog.setControlador(controlador);
            dialog.setVisible(true);
        });
    }//GEN-LAST:event_btnAgregarReservaActionPerformed

    private void btnMostrarActivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActivasActionPerformed
        // TODO add your handling code here:
        btnMostrarConfirmadas.addActionListener(e -> {
            if (controlador != null) controlador.filtrarReservas("Pendiente");
        });

        btnMostrarActivas.addActionListener(e -> {
            if (controlador != null) controlador.filtrarReservas("Activa");
        });
        
        btnMostrarCompletadas.addActionListener(e -> {
            if (controlador != null) controlador.filtrarReservas("Completada");
        });
        
        btnMostrarTodo.addActionListener(e -> {
            if (controlador != null) controlador.iniciar(tablaReservas);
        });
    }//GEN-LAST:event_btnMostrarActivasActionPerformed
    
    private JScrollPane panelMedio() {
        
        JScrollPane scrollPane = new JScrollPane(panelMedio);

        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
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
                label.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0, 0, 0, 1, tablaReservas.getGridColor()),
                    new EmptyBorder(0, 12, 0, 0) 
                ));

                return label;
            }
        });
        
        tablaReservas.setBackground(Color.WHITE);
        tablaReservas.setForeground(Color.BLACK);   
        tablaReservas.setFont(new Font("Poppins", Font.PLAIN, 13)); 
        tablaReservas.setRowHeight(20);                             
        tablaReservas.setGridColor(new Color(0, 204, 204));
        tablaReservas.setFillsViewportHeight(true);           
        tablaReservas.setFocusable(false);    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarReserva;
    private javax.swing.JButton btnMostrarActivas;
    private javax.swing.JButton btnMostrarCompletadas;
    private javax.swing.JButton btnMostrarConfirmadas;
    private javax.swing.JButton btnMostrarTodo;
    private javax.swing.JButton btnRegistrarHuesped;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMedio;
    private javax.swing.JPanel panelNumeroReservas;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tablaReservas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
 
    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void setControlador(ControladorReserva controlador) {
        this.controlador = controlador;
    }

    public JTable getTablaReservas() {
        return tablaReservas;
    }
    
    public void actualizarContador(int cantidad) {
        if (jLabel3 != null) {
            jLabel3.setText(String.valueOf(cantidad));
        }
    }
    
}
 
