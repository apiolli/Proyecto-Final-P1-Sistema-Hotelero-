package vista;

import app.ContextoAplicacion;
import controlador.ControladorChecks;
import controlador.ControladorEmpleadoAdmin;
import controlador.ControladorHabitacion;
import controlador.ControladorReserva;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel contenedor;
    private ContextoAplicacion contexto;
    
    public MainFrame(ContextoAplicacion contexto) {
        this.contexto = contexto;
        setTitle("Hotelink");
        setMinimumSize(new Dimension(1300, 800));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(crearHeader(),    BorderLayout.NORTH);
        add(crearSidebar(),   BorderLayout.WEST);
        add(crearContenido(), BorderLayout.CENTER);
        setIconImage(new ImageIcon(getClass().getResource("/img/logopeque.png")).getImage());
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
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(0,204,204));
        sidebar.setPreferredSize(new Dimension(200, 0));

        sidebar.add(crearBotonNav("Habitaciones",   "habitaciones", "/img/habitaciones.png"));
        sidebar.add(crearBotonNav("Reservas",       "reservas",     "/img/reservas.png"));
        sidebar.add(crearBotonNav("Check In / Out", "check",       "/img/checkin.png"));
        sidebar.add(crearBotonNav("Consumo", "consumo",       "/img/consumibles.png"));
        sidebar.add(crearBotonNav("Facturacion",    "facturacion", "/img/facturacion.png"));
        sidebar.add(crearBotonNav("Reportes",       "reportes",   "/img/reportes.png"));
        sidebar.add(crearBotonNav("Gestionar Usuarios",       "usuarios",   "/img/usuarios.png"));
        sidebar.add(crearBotonNav("Cerrar Sesion",  "sesion",       "/img/sesion.png"));

        sidebar.add(Box.createVerticalGlue());

        return sidebar;
    }

    private JButton crearBotonNav(String texto, String nombrePanel, String rutaIcono) {
        JButton btn = new JButton(texto);
        
        java.net.URL imgURL = getClass().getResource(rutaIcono);
        ImageIcon icono = new ImageIcon(imgURL);
        
        btn.setIcon(new ImageIcon(icono.getImage()));
        btn.setFont(new Font("Poppins", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(0,204,204));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        btn.setPreferredSize(new Dimension(0, 50));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(0x243447));
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(0,204,204));
                btn.setForeground(Color.WHITE);

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
        contenedor.add(panelHabitaciones(),  "habitaciones");
        contenedor.add(panelReservas(),  "reservas");
        contenedor.add(panelCheckinOut(),   "check");
        contenedor.add(new PanelConsumo(),   "consumo");
        contenedor.add(new PanelFacturacion(),   "facturacion");
        contenedor.add(new PanelReportes(),   "reportes");
        contenedor.add(panelUsuarios(),   "usuarios");

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
    
    private JPanel panelHabitaciones() {
        PanelHabitaciones panelHabs = new PanelHabitaciones(contexto);
        ControladorHabitacion controlador = new ControladorHabitacion(panelHabs, contexto.getHabitacionDAO());
        panelHabs.setControlador(controlador);
        controlador.cargarHabitaciones();
        
        return panelHabs;
    }
    
    private JPanel panelReservas() {
        PanelReservas panelRes = new PanelReservas(contexto);
        ControladorReserva controlador = new ControladorReserva(panelRes, contexto.getReservaDAO());
        panelRes.setControlador(controlador);
        controlador.iniciar(panelRes.getTablaReservas());        
        return panelRes;
    }
    
    private JPanel panelUsuarios() {
        PanelGestionUsuarios panelUs = new PanelGestionUsuarios(contexto);
        ControladorEmpleadoAdmin controlador = new ControladorEmpleadoAdmin(panelUs, contexto.getAdminDAO());
        panelUs.setControlador(controlador);
        
        return panelUs;
    }
    
    private JPanel panelCheckinOut() {
        PanelCheckInOut panelCheks = new PanelCheckInOut(contexto);
        ControladorChecks controlador = new ControladorChecks(panelCheks, contexto.getCheckDAO());
        panelCheks.setControlador(controlador);
        controlador.iniciar(panelCheks.getTablaCheckin());
        
        return panelCheks;
    }
    

}
