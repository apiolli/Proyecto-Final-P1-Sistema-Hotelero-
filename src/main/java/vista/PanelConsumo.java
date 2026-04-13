package vista;


public class PanelConsumo extends javax.swing.JPanel {

    public PanelConsumo() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        habitacion = new javax.swing.JPanel();
        noHab = new javax.swing.JLabel();
        tipoHab = new javax.swing.JLabel();
        iconoEstado = new javax.swing.JLabel();
        panEstado = new javax.swing.JPanel();
        estadoHab = new javax.swing.JLabel();

        habitacion.setBackground(new java.awt.Color(204, 255, 255));
        habitacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        noHab.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        noHab.setText("Hab. 101");

        tipoHab.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tipoHab.setText("Individual");

        iconoEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconoEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sucia.png"))); // NOI18N

        panEstado.setBackground(new java.awt.Color(0, 102, 102));

        estadoHab.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        estadoHab.setForeground(new java.awt.Color(0, 204, 204));
        estadoHab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estadoHab.setText("En mantenimiento");
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

        javax.swing.GroupLayout habitacionLayout = new javax.swing.GroupLayout(habitacion);
        habitacion.setLayout(habitacionLayout);
        habitacionLayout.setHorizontalGroup(
            habitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(habitacionLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(habitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tipoHab, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(noHab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(habitacionLayout.createSequentialGroup()
                .addComponent(panEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, habitacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel estadoHab;
    private javax.swing.JPanel habitacion;
    private javax.swing.JLabel iconoEstado;
    private javax.swing.JLabel noHab;
    private javax.swing.JPanel panEstado;
    private javax.swing.JLabel tipoHab;
    // End of variables declaration//GEN-END:variables
}
