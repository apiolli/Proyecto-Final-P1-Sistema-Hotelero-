package vista;

import app.ContextoAplicacion;
import controlador.ControladorFacturacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import modelo.interfaces.Mensajes;

public class PanelFacturacion extends javax.swing.JPanel implements Mensajes {

    private ContextoAplicacion contexto;
    private ControladorFacturacion controlador;
    public PanelFacturacion(ContextoAplicacion contexto) {
        this.contexto = contexto;
        initComponents();
        setLayout(new BorderLayout());
        add(panelDeArriba(), BorderLayout.NORTH);
        add(panelMedio, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);
        disenoTabla();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMedio = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFactura = new javax.swing.JTable();
        PanelArriba = new javax.swing.JPanel();
        panelBuscar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbReservasCompletadas = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        panelDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtIDReserva = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtHuesped = new javax.swing.JTextField();
        txtDocumentoIdentida = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtNumeroFactura = new javax.swing.JTextField();
        cmbFormaPago = new javax.swing.JComboBox<>();
        tituloFact = new javax.swing.JPanel();
        as = new javax.swing.JLabel();
        panelSur = new javax.swing.JPanel();
        panelAbajo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtITBIS = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtCambio = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        btnCalcularCambio = new javax.swing.JButton();
        btnRegistrarVenta = new javax.swing.JButton();

        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(800, 650));

        tablaFactura.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tablaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cantidad", "Descripcion", "Precio Unitario", "Descuento", "ITBIS", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaFactura.setRowHeight(23);
        tablaFactura.setShowGrid(true);
        jScrollPane1.setViewportView(tablaFactura);

        javax.swing.GroupLayout panelMedioLayout = new javax.swing.GroupLayout(panelMedio);
        panelMedio.setLayout(panelMedioLayout);
        panelMedioLayout.setHorizontalGroup(
            panelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedioLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1)
                .addGap(85, 85, 85))
        );
        panelMedioLayout.setVerticalGroup(
            panelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelArriba.setBackground(new Color(0x243447)
        );

        panelBuscar.setBackground(new java.awt.Color(0, 204, 204));
        panelBuscar.setMinimumSize(new java.awt.Dimension(270, 100));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cliente: ");

        cmbReservasCompletadas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBuscar.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        javax.swing.GroupLayout panelBuscarLayout = new javax.swing.GroupLayout(panelBuscar);
        panelBuscar.setLayout(panelBuscarLayout);
        panelBuscarLayout.setHorizontalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbReservasCompletadas, 0, 218, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        panelBuscarLayout.setVerticalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbReservasCompletadas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        btnBuscar.setBackground(new java.awt.Color(0, 204, 204));

        btnBuscar.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

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

        panelDatos.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Reserva:");

        jLabel10.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Huesped:");

        jLabel11.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Telefono:");

        jLabel12.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Documento de identidad:");

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Fecha:");

        jLabel14.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Numero Factura:");

        jLabel15.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Forma de pago:");

        jLabel16.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));

        txtIDReserva.setEditable(false);
        txtIDReserva.setBackground(new java.awt.Color(255, 255, 255));
        txtIDReserva.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtIDReserva.setForeground(new java.awt.Color(0, 0, 0));
        txtIDReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        txtTelefono.setEditable(false);
        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        txtHuesped.setEditable(false);
        txtHuesped.setBackground(new java.awt.Color(255, 255, 255));
        txtHuesped.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtHuesped.setForeground(new java.awt.Color(0, 0, 0));
        txtHuesped.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        txtHuesped.setEnabled(false);

        txtDocumentoIdentida.setEditable(false);
        txtDocumentoIdentida.setBackground(new java.awt.Color(255, 255, 255));
        txtDocumentoIdentida.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtDocumentoIdentida.setForeground(new java.awt.Color(0, 0, 0));
        txtDocumentoIdentida.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(0, 0, 0));
        txtFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        txtNumeroFactura.setEditable(false);
        txtNumeroFactura.setBackground(new java.awt.Color(255, 255, 255));
        txtNumeroFactura.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtNumeroFactura.setForeground(new java.awt.Color(0, 0, 0));
        txtNumeroFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        cmbFormaPago.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        cmbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta" }));

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDocumentoIdentida, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13)
                    .addComponent(txtIDReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel10)
                    .addComponent(txtHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtDocumentoIdentida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        as.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        as.setForeground(new java.awt.Color(255, 255, 255));
        as.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        as.setText("Facturacion");
        as.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout tituloFactLayout = new javax.swing.GroupLayout(tituloFact);
        tituloFact.setLayout(tituloFactLayout);
        tituloFactLayout.setHorizontalGroup(
            tituloFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloFactLayout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(as, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tituloFactLayout.setVerticalGroup(
            tituloFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tituloFactLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(as, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelArribaLayout = new javax.swing.GroupLayout(PanelArriba);
        PanelArriba.setLayout(PanelArribaLayout);
        PanelArribaLayout.setHorizontalGroup(
            PanelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelArribaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(tituloFact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelArribaLayout.setVerticalGroup(
            PanelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelArribaLayout.createSequentialGroup()
                .addComponent(tituloFact, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        tituloFact.setBackground(new Color(0x243447));

        panelAbajo.setBackground(new java.awt.Color(0, 204, 204));

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel4.setText("Subtotal:");

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel5.setText("Descuento: ");

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel6.setText("ITBIS: ");

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel7.setText("Total a pagar: ");

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel8.setText("Efectivo: ");

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel9.setText("Cambio:");

        txtITBIS.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtITBIS.setForeground(new java.awt.Color(0, 0, 0));
        txtITBIS.setEnabled(false);

        txtTotal.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 0, 0));
        txtTotal.setEnabled(false);

        txtEfectivo.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtEfectivo.setForeground(new java.awt.Color(0, 0, 0));

        txtDescuento.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtDescuento.setForeground(new java.awt.Color(0, 0, 0));

        txtCambio.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtCambio.setForeground(new java.awt.Color(0, 0, 0));
        txtCambio.setEnabled(false);
        txtCambio.addActionListener(this::txtCambioActionPerformed);

        txtSubtotal.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtSubtotal.setForeground(new java.awt.Color(0, 0, 0));
        txtSubtotal.setEnabled(false);
        txtSubtotal.addActionListener(this::txtSubtotalActionPerformed);

        btnCalcularCambio.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnCalcularCambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cambio.png"))); // NOI18N
        btnCalcularCambio.setText("Calcular cambio");
        btnCalcularCambio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCalcularCambio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCalcularCambio.addActionListener(this::btnCalcularCambioActionPerformed);

        btnRegistrarVenta.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnRegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registrarVenta.png"))); // NOI18N
        btnRegistrarVenta.setText("Registrar Venta");
        btnRegistrarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarVenta.setIconTextGap(5);
        btnRegistrarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarVenta.addActionListener(this::btnRegistrarVentaActionPerformed);

        javax.swing.GroupLayout panelAbajoLayout = new javax.swing.GroupLayout(panelAbajo);
        panelAbajo.setLayout(panelAbajoLayout);
        panelAbajoLayout.setHorizontalGroup(
            panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAbajoLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(btnRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAbajoLayout.createSequentialGroup()
                        .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(txtITBIS)))
                    .addGroup(panelAbajoLayout.createSequentialGroup()
                        .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCalcularCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAbajoLayout.createSequentialGroup()
                        .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAbajoLayout.setVerticalGroup(
            panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAbajoLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAbajoLayout.createSequentialGroup()
                        .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtITBIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addComponent(btnCalcularCambio)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAbajoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btnCalcularCambio.setBackground(new java.awt.Color(0, 204, 204));

        btnCalcularCambio.setForeground(new java.awt.Color(255, 255, 255));

        btnCalcularCambio.setToolTipText("");

        btnCalcularCambio.setBorder(null);

        btnCalcularCambio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCalcularCambio.setFocusable(false);

        btnCalcularCambio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCalcularCambio.setBackground(new Color(81, 109, 110));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCalcularCambio.setBackground(new Color(0, 204, 204));
            }
        });
        btnRegistrarVenta.setBackground(new java.awt.Color(0, 204, 204));

        btnRegistrarVenta.setForeground(new java.awt.Color(255, 255, 255));

        btnRegistrarVenta.setToolTipText("");

        btnRegistrarVenta.setBorder(null);

        btnRegistrarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnRegistrarVenta.setFocusable(false);

        btnRegistrarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarVenta.setBackground(new Color(81, 109, 110));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarVenta.setBackground(new Color(0, 204, 204));
            }
        });

        javax.swing.GroupLayout panelSurLayout = new javax.swing.GroupLayout(panelSur);
        panelSur.setLayout(panelSurLayout);
        panelSurLayout.setHorizontalGroup(
            panelSurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSurLayout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(panelAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelSurLayout.setVerticalGroup(
            panelSurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSurLayout.createSequentialGroup()
                .addComponent(panelAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMedio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelArriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(PanelArriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelSur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelMedio.setBackground(new Color(0x243447));
        panelSur.setBackground(new Color(0x243447));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioActionPerformed

    }//GEN-LAST:event_txtCambioActionPerformed

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed

    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        controlador.cargarFactura();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed
        // TODO add your handling code here:
        controlador.registrarVenta();
    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void btnCalcularCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularCambioActionPerformed
        // TODO add your handling code here:
        controlador.calcularCambio();
    }//GEN-LAST:event_btnCalcularCambioActionPerformed

    private JPanel panelDeArriba() {
        int padding = 20;
        PanelArriba.setBorder(new EmptyBorder(0, padding, 0, padding));
        PanelArriba.setLayout(new BorderLayout(10, 10));
        PanelArriba.add(tituloFact, BorderLayout.NORTH);
        PanelArriba.add(panelBuscar, BorderLayout.CENTER);
        PanelArriba.add(panelDatos, BorderLayout.EAST);
        
        return PanelArriba;
    }
    
    private void disenoTabla() {
        JTableHeader header = tablaFactura.getTableHeader();

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
                    BorderFactory.createMatteBorder(0, 0, 0, 1, tablaFactura.getGridColor()),
                    new EmptyBorder(0, 12, 0, 0) 
                ));

                return label;
            }
        });
        
        tablaFactura.setBackground(Color.WHITE);
        tablaFactura.setForeground(Color.BLACK);   
        tablaFactura.setFont(new Font("Poppins", Font.PLAIN, 13)); 
        tablaFactura.setRowHeight(20);                             
        tablaFactura.setGridColor(new Color(0, 204, 204));
        tablaFactura.setFillsViewportHeight(true);           
        tablaFactura.setFocusable(false);    
    }

    public JComboBox<String> getCmbFormaPago() {
        return cmbFormaPago;
    }

    public JComboBox<String> getCmbReservasCompletadas() {
        return cmbReservasCompletadas;
    }

    public JTable getTablaFactura() {
        return tablaFactura;
    }

    public JTextField getTxtCambio() {
        return txtCambio;
    }

    public JTextField getTxtDescuento() {
        return txtDescuento;
    }

    public JTextField getTxtDocumentoIdentida() {
        return txtDocumentoIdentida;
    }

    public JTextField getTxtEfectivo() {
        return txtEfectivo;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public JTextField getTxtHuesped() {
        return txtHuesped;
    }

    public JTextField getTxtIDReserva() {
        return txtIDReserva;
    }

    public JTextField getTxtITBIS() {
        return txtITBIS;
    }

    public JTextField getTxtNumeroFactura() {
        return txtNumeroFactura;
    }

    public JTextField getTxtSubtotal() {
        return txtSubtotal;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public JTextField getTxtTotal() {
        return txtTotal;
    }

    public void setControlador(ControladorFacturacion controlador) {
        this.controlador = controlador;
    }
    
    @Override
    public void mostrarExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
 
    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelArriba;
    private javax.swing.JLabel as;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcularCambio;
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JComboBox<String> cmbFormaPago;
    private javax.swing.JComboBox<String> cmbReservasCompletadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelAbajo;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelMedio;
    private javax.swing.JPanel panelSur;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JPanel tituloFact;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtDocumentoIdentida;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHuesped;
    private javax.swing.JTextField txtIDReserva;
    private javax.swing.JTextField txtITBIS;
    private javax.swing.JTextField txtNumeroFactura;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
