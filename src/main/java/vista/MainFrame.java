/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author DELL
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

    // ─────────────────────────────────────────────────────────────────────────
    // CardLayout: el "gestor" que permite cambiar paneles en el área central.
    // Piénsalo como una baraja de cartas — solo ves una carta a la vez,
    // pero todas están apiladas. CardLayout te deja elegir cuál mostrar.
    // ─────────────────────────────────────────────────────────────────────────
    private CardLayout cardLayout;
    private JPanel contenedor;

    public MainFrame() {
        setTitle("Hotelink");
        setMinimumSize(new Dimension(1300, 800));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(crearHeader(),    BorderLayout.NORTH);
        add(crearSidebar(),   BorderLayout.WEST);
        add(crearContenido(), BorderLayout.CENTER);
    }

    private JPanel crearHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(0x1C2B3A));
        header.setPreferredSize(new Dimension(0, 60));
        
        java.net.URL imgURL = getClass().getResource("/img/logopeque.png");
        ImageIcon icono = new ImageIcon(imgURL);
        

        JLabel titulo = new JLabel("Hotelink - Sistema Hotelero");
        titulo.setIcon(new ImageIcon(icono.getImage()));
        
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Poppins", Font.BOLD, 20));
        titulo.setBorder(new EmptyBorder(0, 20, 0, 0));
        titulo.setIconTextGap(10);
        titulo.setVerticalAlignment(JLabel.CENTER);
        header.add(titulo, BorderLayout.WEST);
        
        JLabel usuario = new JLabel("Usuario: Cesar Diaz      ");
        usuario.setForeground(new Color(0xAAAAAA));
        usuario.setFont(new Font("Poppins", Font.PLAIN, 13));
        header.add(usuario, BorderLayout.EAST);

        return header;
    }

    private JPanel crearSidebar() {
        // BoxLayout con eje Y → apila los componentes verticalmente (uno encima del otro)
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(0x162030));
        sidebar.setPreferredSize(new Dimension(200, 0)); // ancho fijo de 200px

        // ── Botones de navegación ─────────────────────────────────────────
        // Cada botón lleva el nombre de la "carta" (panel) que debe mostrar.
        // Ese nombre debe coincidir EXACTAMENTE con el que usaste en:
        //   contenedor.add(panel, "NOMBRE")

        sidebar.add(crearBotonNav("Habitaciones",   "habitaciones", "/img/habitaciones.png"));
        sidebar.add(crearBotonNav("Reservas",       "reservas",     "/img/reservas.png"));
        sidebar.add(crearBotonNav("Check In / Out", "check",       "/img/checkin.png"));
        sidebar.add(crearBotonNav("Consumo", "consumo",       "/img/consumibles.png"));
        sidebar.add(crearBotonNav("Facturacion",    "facturacion", "/img/facturacion.png"));
        sidebar.add(crearBotonNav("Reportes",       "reportes",   "/img/reportes.png"));
        sidebar.add(crearBotonNav("Gestionar Usuarios",       "usuarios",   "/img/usuarios.png"));
        sidebar.add(crearBotonNav("Cerrar Sesion",  "sesion",       "/img/sesion.png"));

        // Empuja todo hacia arriba, dejando espacio vacío abajo
        sidebar.add(Box.createVerticalGlue());

        return sidebar;
    }

    private JButton crearBotonNav(String texto, String nombrePanel, String rutaIcono) {
        JButton btn = new JButton(texto);
        
        java.net.URL imgURL = getClass().getResource(rutaIcono);
        ImageIcon icono = new ImageIcon(imgURL);
        
        btn.setIcon(new ImageIcon(icono.getImage()));
        btn.setFont(new Font("Poppins", Font.PLAIN, 14));
        btn.setForeground(new Color(0xCCCCCC));
        btn.setBackground(new Color(0x162030));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        btn.setPreferredSize(new Dimension(0, 50));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(0x243447));
                btn.setForeground(Color.red);
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(0x162030));
                btn.setForeground(new Color(0xCCCCCC));

            }
        });

        btn.addActionListener(e -> {
            cardLayout.show(contenedor, nombrePanel);
        });

        return btn;
    }

    private JPanel crearContenido() {
        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        contenedor.add(new PanelInicio(),   "inicio");
        contenedor.add(new PanelHabitaciones(),  "habitaciones");
        contenedor.add(new PanelReservas(),  "reservas");
        contenedor.add(new PanelCheckInOut(),   "check");
        contenedor.add(new PanelConsumo(),   "consumo");
        contenedor.add(new PanelFacturacion(),   "facturacion");
        contenedor.add(new PanelReportes(),   "reportes");
        contenedor.add(new PanelGestionUsuarios(),   "usuarios");

        cardLayout.show(contenedor, "inicio");

        return contenedor;
    }

    static class PanelInicio extends JPanel {
        public PanelInicio() {
            setBackground(new Color(0x0F1923));
            setLayout(new BorderLayout());
            JLabel lbl = new JLabel("Bienvenido — Panel de Inicio", SwingConstants.CENTER);
            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("SansSerif", Font.BOLD, 22));
            add(lbl, BorderLayout.CENTER);
        }
    }

}
