package vista.consumo;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DiagAggProducto extends JDialog {

    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JComboBox<String> cmbCategoria;
    private JButton btnGuardar;

    public DiagAggProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Agregar Nuevo Producto");
        setSize(400, 350);
        setLocationRelativeTo(parent);
        setResizable(false);
    }

    private void initComponents() {
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(30, 30, 30));

        Font fuenteLabel = new Font("Poppins", Font.PLAIN, 14);
        Color colorTexto = Color.WHITE;
        Color colorInput = new Color(45, 52, 71);

        JLabel lblTitulo = new JLabel("NUEVO PRODUCTO");
        lblTitulo.setFont(new Font("Poppins", Font.BOLD, 18));
        lblTitulo.setForeground(new Color(0, 204, 204));
        lblTitulo.setBounds(20, 20, 200, 30);
        panel.add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(colorTexto);
        lblNombre.setFont(fuenteLabel);
        lblNombre.setBounds(20, 70, 100, 25);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 70, 250, 30);
        txtNombre.setBackground(colorInput);
        txtNombre.setForeground(Color.WHITE);
        panel.add(txtNombre);

        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setForeground(colorTexto);
        lblCategoria.setFont(fuenteLabel);
        lblCategoria.setBounds(20, 120, 100, 25);
        panel.add(lblCategoria);

        cmbCategoria = new JComboBox<>(new String[]{"Bebidas", "Comidas", "Snacks", "Otros"});
        cmbCategoria.setBounds(100, 120, 250, 30);
        cmbCategoria.setBackground(colorInput);
        cmbCategoria.setForeground(Color.WHITE);
        panel.add(cmbCategoria);

        JLabel lblPrecio = new JLabel("Precio RD$:");
        lblPrecio.setForeground(colorTexto);
        lblPrecio.setFont(fuenteLabel);
        lblPrecio.setBounds(20, 170, 100, 25);
        panel.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(100, 170, 250, 30);
        txtPrecio.setBackground(colorInput);
        txtPrecio.setForeground(Color.WHITE);
        panel.add(txtPrecio);

        btnGuardar = new JButton("Guardar en Catálogo");
        btnGuardar.setBounds(20, 240, 330, 40);
        btnGuardar.setBackground(new Color(0, 204, 204));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        panel.add(btnGuardar);

        add(panel);
    }

    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtPrecio() { return txtPrecio; }
    public JComboBox<String> getCmbCategoria() { return cmbCategoria; }
    public JButton getBtnGuardar() { return btnGuardar; }

    public void mostrarExito(String msg) { JOptionPane.showMessageDialog(this, msg, "Éxito", JOptionPane.INFORMATION_MESSAGE); }
    public void mostrarError(String msg) { JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE); }
}