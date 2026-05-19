package vista;

import modelo.Cliente;
import modelo.Destino;
import modelo.PaqueteTuristico;
import modelo.PaqueteTuristicoMultiple;
import modelo.PaqueteTuristicoUnico;
import modelo.Venta;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UsaGUIVenta extends JFrame {
    private static final String ARCHIVO_VENTAS = "ventas.obj";
    private static final String ARCHIVO_CLIENTES = "clientes.obj";

    private ArrayList<Venta> datosVentas;
    private ArrayList<Cliente> datosClientes;

    private JComboBox<String> tipoIdCombo;
    private JTextField numeroIdField;
    private JCheckBox empresaCheck;
    private JTextField nombreField;
    private JTextField emailField;
    private JTextField telefonoField;
    private JTextField nombreContactoField;
    private JTextField porcentajeField;

    private JComboBox<String> categoriaCombo;
    private JTextField codigoPaqueteField;
    private JTextField nombrePaqueteField;
    private JTextField tipologiaField;
    private JTextField descripcionField;
    private JTextField origenField;
    private JCheckBox hotelCheck;
    private JCheckBox alimentacionCheck;
    private JCheckBox alimentacionTodoCheck;
    private JCheckBox vueloCheck;
    private JCheckBox asistenciaCheck;
    private JTextField tarifaDiaField;
    private JTextField cantidadUnidadesField;
    private JTextField obsequioField;
    private JTextField nombreHotelField;
    private JTextField tipoDesayunoField;

    private JTextField nombreLugarField;
    private JTextField diasPermanenciaField;
    private JTextField atractivosField;
    private JCheckBox atractivosIncluidosCheck;

    private JTextArea destinosArea;
    private JTextArea paquetesArea;

    private JTextArea resultadosArea;
    private JTextField consultaNumeroField;
    private JComboBox<String> consultaPosicionCombo;
    private JComboBox<String> consultaEstadoCombo;
    private JComboBox<String> consultaCategoriaCombo;

    private JTextField actualizarNumeroField;
    private JComboBox<String> actualizarEstadoCombo;

    private final List<Destino> destinosEnEdicion = new ArrayList<>();
    private final List<PaqueteTuristico> paquetesEnEdicion = new ArrayList<>();

    public UsaGUIVenta() {
        this.datosVentas = new ArrayList<>();
        this.datosClientes = new ArrayList<>();
        setTitle("Gestión de Ventas - Nexum");
        setSize(1100, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UsaGUIVenta app = new UsaGUIVenta();
            app.setVisible(true);
        });
    }

    private void initUI() {
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Crear venta", buildCrearVentaPanel());
        tabs.add("Consultas", buildConsultasPanel());
        tabs.add("Actualizar venta", buildActualizarPanel());
        tabs.add("Archivos", buildArchivosPanel());
        add(tabs, BorderLayout.CENTER);
    }

    private JScrollPane buildCrearVentaPanel() {
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        content.add(buildClientePanel());
        content.add(buildPaquetePanel());
        content.add(buildDestinoPanel());
        content.add(buildListasPanel());
        content.add(buildCrearVentaButtons());

        JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        return scrollPane;
    }

    private JPanel buildClientePanel() {
        JPanel panel = createFormPanel("Cliente");
        tipoIdCombo = new JComboBox<>(new String[]{"C", "N"});
        numeroIdField = new JTextField(15);
        empresaCheck = new JCheckBox("Es empresa");
        nombreField = new JTextField(20);
        emailField = new JTextField(20);
        telefonoField = new JTextField(15);
        nombreContactoField = new JTextField(20);
        porcentajeField = new JTextField(10);

        int row = 0;
        addField(panel, row++, "Tipo identificación (C=Cédula, N=NIT):", tipoIdCombo);
        addField(panel, row++, "Número identificación:", numeroIdField);
        addField(panel, row++, "Empresa:", empresaCheck);
        addField(panel, row++, "Nombre:", nombreField);
        addField(panel, row++, "Email:", emailField);
        addField(panel, row++, "Teléfono:", telefonoField);
        addField(panel, row++, "Nombre contacto:", nombreContactoField);
        addField(panel, row, "Porcentaje descuento:", porcentajeField);
        return panel;
    }

    private JPanel buildPaquetePanel() {
        JPanel panel = createFormPanel("Paquete turístico");
        categoriaCombo = new JComboBox<>(new String[]{"U", "M"});
        codigoPaqueteField = new JTextField(10);
        nombrePaqueteField = new JTextField(20);
        tipologiaField = new JTextField(15);
        descripcionField = new JTextField(25);
        origenField = new JTextField(15);
        hotelCheck = new JCheckBox("Hotel");
        alimentacionCheck = new JCheckBox("Alimentación");
        alimentacionTodoCheck = new JCheckBox("Alimentación todo");
        vueloCheck = new JCheckBox("Vuelo");
        asistenciaCheck = new JCheckBox("Asistencia");
        tarifaDiaField = new JTextField(10);
        cantidadUnidadesField = new JTextField(10);
        obsequioField = new JTextField(15);
        nombreHotelField = new JTextField(15);
        tipoDesayunoField = new JTextField(15);

        int row = 0;
        addField(panel, row++, "Categoría (U=Único, M=Múltiple):", categoriaCombo);
        addField(panel, row++, "Código:", codigoPaqueteField);
        addField(panel, row++, "Nombre:", nombrePaqueteField);
        addField(panel, row++, "Tipología:", tipologiaField);
        addField(panel, row++, "Descripción:", descripcionField);
        addField(panel, row++, "Origen:", origenField);

        JPanel extrasPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        extrasPanel.add(hotelCheck);
        extrasPanel.add(alimentacionCheck);
        extrasPanel.add(alimentacionTodoCheck);
        extrasPanel.add(vueloCheck);
        extrasPanel.add(asistenciaCheck);
        addField(panel, row++, "Servicios:", extrasPanel);

        addField(panel, row++, "Tarifa día:", tarifaDiaField);
        addField(panel, row++, "Cantidad unidades:", cantidadUnidadesField);
        addField(panel, row++, "Obsequio (si es M):", obsequioField);
        addField(panel, row++, "Nombre hotel (si es U):", nombreHotelField);
        addField(panel, row, "Tipo desayuno (opcional):", tipoDesayunoField);
        return panel;
    }

    private JPanel buildDestinoPanel() {
        JPanel panel = createFormPanel("Destino");
        nombreLugarField = new JTextField(15);
        diasPermanenciaField = new JTextField(10);
        atractivosField = new JTextField(25);
        atractivosIncluidosCheck = new JCheckBox("Atractivos incluidos");

        int row = 0;
        addField(panel, row++, "Nombre lugar:", nombreLugarField);
        addField(panel, row++, "Días permanencia:", diasPermanenciaField);
        addField(panel, row++, "Atractivos (coma):", atractivosField);
        addField(panel, row, "Incluidos:", atractivosIncluidosCheck);
        return panel;
    }

    private JPanel buildListasPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Resumen"));
        destinosArea = new JTextArea(5, 40);
        destinosArea.setEditable(false);
        paquetesArea = new JTextArea(5, 40);
        paquetesArea.setEditable(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(new JScrollPane(destinosArea), gbc);

        gbc.gridx = 1;
        panel.add(new JScrollPane(paquetesArea), gbc);
        return panel;
    }

    private JPanel buildCrearVentaButtons() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton agregarDestinoButton = new JButton("Agregar destino");
        JButton agregarPaqueteButton = new JButton("Agregar paquete");
        JButton crearVentaButton = new JButton("Crear venta");
        JButton limpiarButton = new JButton("Limpiar formulario");

        agregarDestinoButton.addActionListener(e -> agregarDestino());
        agregarPaqueteButton.addActionListener(e -> agregarPaquete());
        crearVentaButton.addActionListener(e -> crearVenta());
        limpiarButton.addActionListener(e -> limpiarFormulario());

        panel.add(agregarDestinoButton);
        panel.add(agregarPaqueteButton);
        panel.add(crearVentaButton);
        panel.add(limpiarButton);
        return panel;
    }

    private JPanel buildConsultasPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel controls = new JPanel(new GridBagLayout());
        controls.setBorder(BorderFactory.createTitledBorder("Opciones de consulta"));

        consultaNumeroField = new JTextField(10);
        consultaPosicionCombo = new JComboBox<>(new String[]{"P", "U"});
        consultaEstadoCombo = new JComboBox<>(new String[]{"A", "P", "C"});
        consultaCategoriaCombo = new JComboBox<>(new String[]{"UNICO", "MULTIPLE"});

        int row = 0;
        addField(controls, row++, "Número de venta:", consultaNumeroField);
        addField(controls, row++, "Posición (P/U):", consultaPosicionCombo);
        addField(controls, row++, "Estado (A/P/C):", consultaEstadoCombo);
        addField(controls, row, "Categoría paquete:", consultaCategoriaCombo);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton todasBtn = new JButton("Consultar todas");
        JButton numeroBtn = new JButton("Consultar número");
        JButton posicionBtn = new JButton("Consultar posición");
        JButton estadoBtn = new JButton("Consultar estado");
        JButton categoriaBtn = new JButton("Consultar categoría");

        todasBtn.addActionListener(e -> resultadosArea.setText(consultarTodasVentas(datosVentas)));
        numeroBtn.addActionListener(e -> consultarPorNumero());
        posicionBtn.addActionListener(e -> consultarPorPosicion());
        estadoBtn.addActionListener(e -> consultarPorEstado());
        categoriaBtn.addActionListener(e -> consultarPorCategoria());

        buttons.add(todasBtn);
        buttons.add(numeroBtn);
        buttons.add(posicionBtn);
        buttons.add(estadoBtn);
        buttons.add(categoriaBtn);

        resultadosArea = new JTextArea();
        resultadosArea.setEditable(false);

        panel.add(controls, BorderLayout.NORTH);
        panel.add(buttons, BorderLayout.CENTER);
        panel.add(new JScrollPane(resultadosArea), BorderLayout.SOUTH);
        return panel;
    }

    private JPanel buildActualizarPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel form = createFormPanel("Actualizar venta");
        actualizarNumeroField = new JTextField(10);
        actualizarEstadoCombo = new JComboBox<>(new String[]{"C", "P"});

        addField(form, 0, "Número de venta:", actualizarNumeroField);
        addField(form, 1, "Nuevo estado (C/P):", actualizarEstadoCombo);

        JButton actualizarBtn = new JButton("Actualizar");
        actualizarBtn.addActionListener(e -> actualizarVentaDesdeGUI());

        panel.add(form, BorderLayout.NORTH);
        panel.add(actualizarBtn, BorderLayout.CENTER);
        return panel;
    }

    private JPanel buildArchivosPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton generarVentasBtn = new JButton("Generar archivo ventas");
        JButton recuperarVentasBtn = new JButton("Recuperar archivo ventas");
        JButton generarClientesBtn = new JButton("Generar archivo clientes");
        JButton recuperarClientesBtn = new JButton("Recuperar archivo clientes");

        generarVentasBtn.addActionListener(e -> mostrarMensaje(generarArchivoObjetosVentas(datosVentas)));
        recuperarVentasBtn.addActionListener(e -> mostrarMensaje(recuperarVentasDesdeArchivoObjetos()));
        generarClientesBtn.addActionListener(e -> mostrarMensaje(generarArchivoObjetosClientes(datosClientes)));
        recuperarClientesBtn.addActionListener(e -> mostrarMensaje(recuperarClientesDesdeArchivoObjetos()));

        panel.add(generarVentasBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(recuperarVentasBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(generarClientesBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(recuperarClientesBtn);
        return panel;
    }

    private JPanel createFormPanel(String title) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }

    private void addField(JPanel panel, int row, String label, java.awt.Component component) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 6, 4, 6);
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        panel.add(component, gbc);
    }

    private void agregarDestino() {
        try {
            String nombreLugar = nombreLugarField.getText().trim();
            int dias = Integer.parseInt(diasPermanenciaField.getText().trim());
            String[] atractivos = atractivosField.getText().split(",");
            LinkedList<String> listaAtractivos = new LinkedList<>();
            for (String atr : atractivos) {
                String valor = atr.trim();
                if (!valor.isEmpty()) {
                    listaAtractivos.add(valor);
                }
            }
            boolean incluidos = atractivosIncluidosCheck.isSelected();
            Destino destino = new Destino(nombreLugar, dias, listaAtractivos, incluidos);
            destinosEnEdicion.add(destino);
            destinosArea.append(destino.toString() + "\n");

            nombreLugarField.setText("");
            diasPermanenciaField.setText("");
            atractivosField.setText("");
            atractivosIncluidosCheck.setSelected(false);
        } catch (Exception ex) {
            mostrarError("Error agregando destino: " + ex.getMessage());
        }
    }

    private void agregarPaquete() {
        try {
            if (destinosEnEdicion.isEmpty()) {
                mostrarError("Agrega al menos un destino antes de crear el paquete.");
                return;
            }
            char categoria = categoriaCombo.getSelectedItem().toString().charAt(0);
            String codigo = codigoPaqueteField.getText().trim();
            String nombre = nombrePaqueteField.getText().trim();
            String tipologia = tipologiaField.getText().trim();
            String descripcion = descripcionField.getText().trim();
            String origen = origenField.getText().trim();
            boolean hotel = hotelCheck.isSelected();
            boolean alimentacion = alimentacionCheck.isSelected();
            boolean alimentacionTodo = alimentacionTodoCheck.isSelected();
            boolean vuelo = vueloCheck.isSelected();
            boolean asistencia = asistenciaCheck.isSelected();
            int tarifaDia = Integer.parseInt(tarifaDiaField.getText().trim());
            int cantidadUnidades = Integer.parseInt(cantidadUnidadesField.getText().trim());

            PaqueteTuristico paquete;
            if (categoria == 'M') {
                String obsequio = obsequioField.getText().trim();
                paquete = new PaqueteTuristicoMultiple(obsequio, codigo, nombre, tipologia, descripcion, origen,
                        new ArrayList<>(destinosEnEdicion), hotel, alimentacion, alimentacionTodo, vuelo, asistencia,
                        tarifaDia, cantidadUnidades);
            } else {
                String nombreHotel = nombreHotelField.getText().trim();
                String tipoDesayuno = tipoDesayunoField.getText().trim();
                if (tipoDesayuno.isEmpty()) {
                    paquete = new PaqueteTuristicoUnico(nombreHotel, codigo, nombre, tipologia, descripcion, origen,
                            new ArrayList<>(destinosEnEdicion), hotel, alimentacion, alimentacionTodo, vuelo, asistencia,
                            tarifaDia, cantidadUnidades);
                } else {
                    paquete = new PaqueteTuristicoUnico(nombreHotel, tipoDesayuno, codigo, nombre, tipologia,
                            descripcion, origen, new ArrayList<>(destinosEnEdicion), hotel, alimentacion,
                            alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadUnidades);
                }
            }

            paquetesEnEdicion.add(paquete);
            paquetesArea.append(paquete.toString() + "\n");
            destinosEnEdicion.clear();
            destinosArea.setText("");
            limpiarCamposPaquete();
        } catch (Exception ex) {
            mostrarError("Error agregando paquete: " + ex.getMessage());
        }
    }

    private void crearVenta() {
        try {
            if (paquetesEnEdicion.isEmpty()) {
                mostrarError("Agrega al menos un paquete antes de crear la venta.");
                return;
            }
            char tipoId = tipoIdCombo.getSelectedItem().toString().charAt(0);
            String numeroId = numeroIdField.getText().trim();
            boolean empresa = empresaCheck.isSelected();
            String nombre = nombreField.getText().trim();
            String email = emailField.getText().trim();
            String telefono = telefonoField.getText().trim();
            String nombreContacto = nombreContactoField.getText().trim();
            double porcentaje = Double.parseDouble(porcentajeField.getText().trim());

            Cliente cliente = new Cliente(tipoId, numeroId, empresa, nombre, email, telefono, nombreContacto, porcentaje);
            datosClientes.add(cliente);

            int numeroVenta = generarNumeroVenta(datosVentas);
            LocalDateTime ahora = LocalDateTime.now();
            Venta venta = new Venta(numeroVenta, ahora, ahora, cliente, new ArrayList<>(paquetesEnEdicion), 'A');
            datosVentas.add(venta);

            mostrarMensaje("Venta creada con número: " + numeroVenta);
            limpiarFormulario();
        } catch (Exception ex) {
            mostrarError("Error creando venta: " + ex.getMessage());
        }
    }

    private void limpiarFormulario() {
        tipoIdCombo.setSelectedIndex(0);
        numeroIdField.setText("");
        empresaCheck.setSelected(false);
        nombreField.setText("");
        emailField.setText("");
        telefonoField.setText("");
        nombreContactoField.setText("");
        porcentajeField.setText("");

        limpiarCamposPaquete();
        destinosEnEdicion.clear();
        paquetesEnEdicion.clear();
        destinosArea.setText("");
        paquetesArea.setText("");

        nombreLugarField.setText("");
        diasPermanenciaField.setText("");
        atractivosField.setText("");
        atractivosIncluidosCheck.setSelected(false);
    }

    private void limpiarCamposPaquete() {
        categoriaCombo.setSelectedIndex(0);
        codigoPaqueteField.setText("");
        nombrePaqueteField.setText("");
        tipologiaField.setText("");
        descripcionField.setText("");
        origenField.setText("");
        hotelCheck.setSelected(false);
        alimentacionCheck.setSelected(false);
        alimentacionTodoCheck.setSelected(false);
        vueloCheck.setSelected(false);
        asistenciaCheck.setSelected(false);
        tarifaDiaField.setText("");
        cantidadUnidadesField.setText("");
        obsequioField.setText("");
        nombreHotelField.setText("");
        tipoDesayunoField.setText("");
    }

    private void consultarPorNumero() {
        try {
            int numero = Integer.parseInt(consultaNumeroField.getText().trim());
            resultadosArea.setText(consultarVentaDadoNumero(datosVentas, numero));
        } catch (Exception ex) {
            mostrarError("Número inválido: " + ex.getMessage());
        }
    }

    private void consultarPorPosicion() {
        char posicion = consultaPosicionCombo.getSelectedItem().toString().charAt(0);
        resultadosArea.setText(consultarVentaDadaPosicion(datosVentas, posicion));
    }

    private void consultarPorEstado() {
        char estado = consultaEstadoCombo.getSelectedItem().toString().charAt(0);
        resultadosArea.setText(consultarVentasDadoEstado(datosVentas, estado));
    }

    private void consultarPorCategoria() {
        String categoria = consultaCategoriaCombo.getSelectedItem().toString();
        resultadosArea.setText(consultarVentasDadaCategoriaPaquete(datosVentas, categoria));
    }

    private void actualizarVentaDesdeGUI() {
        try {
            int numero = Integer.parseInt(actualizarNumeroField.getText().trim());
            char operacion = actualizarEstadoCombo.getSelectedItem().toString().charAt(0);
            String mensaje = actualizarVenta(datosVentas, numero, operacion);
            mostrarMensaje(mensaje);
        } catch (Exception ex) {
            mostrarError("Error actualizando venta: " + ex.getMessage());
        }
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public int generarNumeroVenta(ArrayList<Venta> datosVentas) {
        if (datosVentas == null || datosVentas.isEmpty()) {
            return 1;
        }
        int max = 0;
        for (Venta venta : datosVentas) {
            if (venta.getNumero() > max) {
                max = venta.getNumero();
            }
        }
        return max + 1;
    }

    public String consultarTodasVentas(ArrayList<Venta> datosVentas) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nVentas registradas:\n");
        if (datosVentas == null || datosVentas.isEmpty()) {
            sb.append("No hay ventas registradas.\n");
            return sb.toString();
        }
        for (Venta venta : datosVentas) {
            sb.append(detalleVenta(venta));
            sb.append("\n");
        }
        return sb.toString();
    }

    public String consultarVentaDadoNumero(ArrayList<Venta> datosVentas, int numeroVenta) {
        if (datosVentas == null) {
            return "No hay ventas registradas.";
        }
        for (Venta venta : datosVentas) {
            if (venta.getNumero() == numeroVenta) {
                return detalleVenta(venta);
            }
        }
        return "Venta no encontrada.";
    }

    public String consultarVentaDadaPosicion(ArrayList<Venta> datosVentas, char posicionVenta) {
        if (datosVentas == null || datosVentas.isEmpty()) {
            return "No hay ventas registradas.";
        }
        if (posicionVenta == 'P') {
            return detalleVenta(datosVentas.get(0));
        }
        if (posicionVenta == 'U') {
            return detalleVenta(datosVentas.get(datosVentas.size() - 1));
        }
        return "Posición inválida.";
    }

    public String consultarVentasDadoEstado(ArrayList<Venta> datosVentas, char estadoVenta) {
        StringBuilder sb = new StringBuilder();
        if (datosVentas == null || datosVentas.isEmpty()) {
            return "No hay ventas registradas.";
        }
        for (Venta venta : datosVentas) {
            if (venta.getEstado() == estadoVenta) {
                sb.append(detalleVenta(venta));
                sb.append("\n");
            }
        }
        if (sb.length() == 0) {
            return "No hay ventas con el estado solicitado.";
        }
        return sb.toString();
    }

    public String consultarVentasDadaCategoriaPaquete(ArrayList<Venta> datosVentas, String categoriaPaquete) {
        if (datosVentas == null || datosVentas.isEmpty()) {
            return "No hay ventas registradas.";
        }
        StringBuilder sb = new StringBuilder();
        String categoria = categoriaPaquete.trim().toUpperCase();
        for (Venta venta : datosVentas) {
            boolean incluyeCategoria = false;
            for (PaqueteTuristico paquete : venta.getSusPaquetesTuristicos()) {
                if (categoria.equals("UNICO") && paquete instanceof PaqueteTuristicoUnico) {
                    incluyeCategoria = true;
                } else if (categoria.equals("MULTIPLE") && paquete instanceof PaqueteTuristicoMultiple) {
                    incluyeCategoria = true;
                }
            }
            if (incluyeCategoria) {
                sb.append(detalleVenta(venta));
                sb.append("\n");
            }
        }
        if (sb.length() == 0) {
            return "No hay ventas con la categoría solicitada.";
        }
        return sb.toString();
    }

    public String generarArchivoObjetosVentas(ArrayList<Venta> datosVentas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_VENTAS))) {
            oos.writeObject(datosVentas);
            return "Archivo de ventas generado.";
        } catch (IOException e) {
            return "Error generando archivo de ventas: " + e.getMessage();
        }
    }

    public String recuperarVentasDesdeArchivoObjetos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_VENTAS))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                datosVentas = (ArrayList<Venta>) obj;
                return "Ventas recuperadas: " + datosVentas.size();
            }
            return "Archivo de ventas inválido.";
        } catch (IOException | ClassNotFoundException e) {
            return "Error recuperando ventas: " + e.getMessage();
        }
    }

    public String actualizarVenta(ArrayList<Venta> datosVentas, int numeroVenta, char operacion) {
        if (datosVentas == null) {
            return "No hay ventas registradas.";
        }
        for (Venta venta : datosVentas) {
            if (venta.getNumero() == numeroVenta) {
                if (operacion == 'C') {
                    venta.setEstado('C');
                } else if (operacion == 'P') {
                    venta.setEstado('P');
                }
                venta.setFechaHoraActualizacion(LocalDateTime.now());
                return "Venta actualizada.";
            }
        }
        return "Venta no encontrada.";
    }

    public String generarArchivoObjetosClientes(ArrayList<Cliente> datosClientes) {
        if (datosClientes == null) {
            datosClientes = new ArrayList<>();
        }
        Set<Cliente> clientesSinDuplicar = new LinkedHashSet<>(datosClientes);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CLIENTES))) {
            oos.writeObject(new ArrayList<>(clientesSinDuplicar));
            return "Archivo de clientes generado.";
        } catch (IOException e) {
            return "Error generando archivo de clientes: " + e.getMessage();
        }
    }

    public String recuperarClientesDesdeArchivoObjetos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_CLIENTES))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                datosClientes = (ArrayList<Cliente>) obj;
                return "Clientes recuperados: " + datosClientes.size();
            }
            return "Archivo de clientes inválido.";
        } catch (IOException | ClassNotFoundException e) {
            return "Error recuperando clientes: " + e.getMessage();
        }
    }

    private String detalleVenta(Venta venta) {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta ").append(venta.getNumero()).append("\n");
        sb.append("Generación: ").append(venta.getFechaHoraGeneracion()).append("\n");
        sb.append("Actualización: ").append(venta.getFechaHoraActualizacion()).append("\n");
        sb.append("Estado: ").append(venta.getEstado()).append("\n");
        sb.append("Cliente: ").append(venta.getSuCliente()).append("\n");
        sb.append("Paquetes incluidos: ").append(venta.getSusPaquetesTuristicos().size()).append("\n");
        sb.append("Total unidades: ").append(venta.calcularCantidadTotalUnidadesPaquetes()).append("\n");
        sb.append("Valor total paquetes: ").append(venta.calcularValorTotalPaquetes()).append("\n");
        sb.append("Descuento: ").append(venta.calcularValorDescuento()).append("\n");
        sb.append("Total a pagar: ").append(venta.calcularValorTotalPagar()).append("\n");
        for (PaqueteTuristico paquete : venta.getSusPaquetesTuristicos()) {
            sb.append("  - ").append(paquete.toString()).append("\n");
            if (paquete instanceof PaqueteTuristicoMultiple) {
                PaqueteTuristicoMultiple multiple = (PaqueteTuristicoMultiple) paquete;
                Destino inicio = multiple.obtenerDestinoInicial();
                Destino fin = multiple.obtenerDestinoFinal();
                sb.append("    Destino inicial: ").append(inicio == null ? "N/A" : inicio.getNombreLugar()).append("\n");
                sb.append("    Destino final: ").append(fin == null ? "N/A" : fin.getNombreLugar()).append("\n");
            }
            sb.append("    Valor unidad: ").append(paquete.calcularValorUnidad()).append("\n");
            sb.append("    Valor total: ").append(paquete.calcularValorTotal()).append("\n");
        }
        return sb.toString();
    }
}
