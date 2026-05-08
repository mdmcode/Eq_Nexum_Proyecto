package vista;

import modelo.Cliente;
import modelo.Destino;
import modelo.PaqueteTuristico;
import modelo.PaqueteTuristicoMultiple;
import modelo.PaqueteTuristicoUnico;
import modelo.Venta;

import javax.swing.JFrame;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class UsaGUIVenta extends JFrame {
    private static final String ARCHIVO_VENTAS = "ventas.obj";
    private static final String ARCHIVO_CLIENTES = "clientes.obj";

    private ArrayList<Venta> datosVentas;
    private ArrayList<Cliente> datosClientes;

    public UsaGUIVenta() {
        this.datosVentas = new ArrayList<>();
        this.datosClientes = new ArrayList<>();
        setTitle("UsaGUIVenta");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        UsaGUIVenta app = new UsaGUIVenta();
        app.menuPrincipal();
    }

    private void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1. Crear una nueva venta");
            System.out.println("2. Consultar todas las ventas");
            System.out.println("3. Consultar una venta por número");
            System.out.println("4. Consultar una venta por posición");
            System.out.println("5. Consultar ventas por estado");
            System.out.println("6. Generar un archivo de objetos de ventas");
            System.out.println("7. Consultar ventas desde archivo de objetos");
            System.out.println("8. Actualizar una venta por número");
            System.out.println("9. Generar un archivo de objetos de clientes");
            System.out.println("10. Consultar clientes desde archivo de objetos");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    crearNuevaVenta(datosVentas);
                    break;
                case "2":
                    System.out.println(consultarTodasVentas(datosVentas));
                    break;
                case "3":
                    System.out.print("Número de venta: ");
                    int numero = Integer.parseInt(scanner.nextLine());
                    System.out.println(consultarVentaDadoNumero(datosVentas, numero));
                    break;
                case "4":
                    System.out.print("Posición (P/U): ");
                    char posicion = scanner.nextLine().trim().toUpperCase().charAt(0);
                    System.out.println(consultarVentaDadaPosicion(datosVentas, posicion));
                    break;
                case "5":
                    System.out.print("Estado (A/P/C): ");
                    char estado = scanner.nextLine().trim().toUpperCase().charAt(0);
                    System.out.println(consultarVentasDadoEstado(datosVentas, estado));
                    break;
                case "6":
                    generarArchivoObjetosVentas(datosVentas);
                    break;
                case "7":
                    recuperarVentasDesdeArchivoObjetos();
                    break;
                case "8":
                    System.out.print("Número de venta: ");
                    int numVenta = Integer.parseInt(scanner.nextLine());
                    System.out.print("Operación (C/P): ");
                    char operacion = scanner.nextLine().trim().toUpperCase().charAt(0);
                    actualizarVenta(datosVentas, numVenta, operacion);
                    break;
                case "9":
                    generarArchivoObjetosClientes(datosClientes);
                    break;
                case "10":
                    recuperarClientesDesdeArchivoObjetos();
                    break;
                case "11":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
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

    public ArrayList<Venta> crearNuevaVenta(ArrayList<Venta> datosVentas) {
        Scanner scanner = new Scanner(System.in);
        int numeroVenta = generarNumeroVenta(datosVentas);

        try {
            System.out.println("\nCreación de cliente");
            System.out.print("Tipo identificación (C/N): ");
            char tipoId = scanner.nextLine().trim().toUpperCase().charAt(0);
            System.out.print("Número identificación: ");
            String numeroId = scanner.nextLine();
            System.out.print("¿Es empresa? (true/false): ");
            boolean empresa = Boolean.parseBoolean(scanner.nextLine());
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Nombre contacto: ");
            String nombreContacto = scanner.nextLine();
            System.out.print("Porcentaje descuento: ");
            double porcentaje = Double.parseDouble(scanner.nextLine());

            Cliente cliente = new Cliente(tipoId, numeroId, empresa, nombre, email, telefono, nombreContacto, porcentaje);
            if (datosClientes == null) {
                datosClientes = new ArrayList<>();
            }
            datosClientes.add(cliente);

            ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();
            System.out.print("Cantidad de paquetes a agregar: ");
            int cantidadPaquetes = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < cantidadPaquetes; i++) {
                System.out.println("\nPaquete " + (i + 1));
                System.out.print("Categoría (U=Unico / M=Multiple): ");
                char categoria = scanner.nextLine().trim().toUpperCase().charAt(0);
                PaqueteTuristico paquete = crearPaquete(scanner, categoria);
                paquetes.add(paquete);
            }

            LocalDateTime ahora = LocalDateTime.now();
            Venta venta = new Venta(numeroVenta, ahora, ahora, cliente, paquetes, 'A');
            datosVentas.add(venta);
            System.out.println("Venta creada con número: " + numeroVenta);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error de validación: " + ex.getMessage());
        }
        return datosVentas;
    }

    private PaqueteTuristico crearPaquete(Scanner scanner, char categoria) {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Tipología turismo: ");
        String tipologia = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Origen: ");
        String origen = scanner.nextLine();
        ArrayList<Destino> destinos = crearDestinos(scanner);
        System.out.print("¿Hotel? (true/false): ");
        boolean hotel = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("¿Alimentación? (true/false): ");
        boolean alimentacion = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("¿Alimentación todo? (true/false): ");
        boolean alimentacionTodo = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("¿Vuelo? (true/false): ");
        boolean vuelo = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("¿Asistencia? (true/false): ");
        boolean asistencia = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Tarifa día: ");
        int tarifaDia = Integer.parseInt(scanner.nextLine());
        System.out.print("Cantidad unidades: ");
        int cantidadUnidades = Integer.parseInt(scanner.nextLine());

        if (categoria == 'M') {
            System.out.print("Obsequio: ");
            String obsequio = scanner.nextLine();
            return new PaqueteTuristicoMultiple(obsequio, codigo, nombre, tipologia, descripcion, origen, destinos,
                    hotel, alimentacion, alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadUnidades);
        }

        System.out.print("Nombre hotel: ");
        String nombreHotel = scanner.nextLine();
        System.out.print("Tipo desayuno (opcional): ");
        String tipoDesayuno = scanner.nextLine();
        if (tipoDesayuno.isBlank()) {
            return new PaqueteTuristicoUnico(nombreHotel, codigo, nombre, tipologia, descripcion, origen, destinos,
                    hotel, alimentacion, alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadUnidades);
        }
        return new PaqueteTuristicoUnico(nombreHotel, tipoDesayuno, codigo, nombre, tipologia, descripcion, origen,
                destinos, hotel, alimentacion, alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadUnidades);
    }

    private ArrayList<Destino> crearDestinos(Scanner scanner) {
        System.out.print("Cantidad de destinos: ");
        int cantidad = Integer.parseInt(scanner.nextLine());
        ArrayList<Destino> destinos = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Destino " + (i + 1));
            System.out.print("Nombre lugar: ");
            String nombreLugar = scanner.nextLine();
            System.out.print("Días permanencia: ");
            int dias = Integer.parseInt(scanner.nextLine());
            System.out.print("Atractivos (separados por coma): ");
            String[] atractivos = scanner.nextLine().split(",");
            LinkedList<String> listaAtractivos = new LinkedList<>();
            for (String atr : atractivos) {
                String valor = atr.trim();
                if (!valor.isEmpty()) {
                    listaAtractivos.add(valor);
                }
            }
            System.out.print("¿Atractivos incluidos? (true/false): ");
            boolean incluidos = Boolean.parseBoolean(scanner.nextLine());
            destinos.add(new Destino(nombreLugar, dias, listaAtractivos, incluidos));
        }
        return destinos;
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

    public void generarArchivoObjetosVentas(ArrayList<Venta> datosVentas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_VENTAS))) {
            oos.writeObject(datosVentas);
            System.out.println("Archivo de ventas generado.");
        } catch (IOException e) {
            System.out.println("Error generando archivo de ventas: " + e.getMessage());
        }
    }

    public void recuperarVentasDesdeArchivoObjetos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_VENTAS))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                datosVentas = (ArrayList<Venta>) obj;
                System.out.println("Ventas recuperadas: " + datosVentas.size());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error recuperando ventas: " + e.getMessage());
        }
    }

    public void actualizarVenta(ArrayList<Venta> datosVentas, int numeroVenta, char operacion) {
        if (datosVentas == null) {
            System.out.println("No hay ventas registradas.");
            return;
        }
        for (Venta venta : datosVentas) {
            if (venta.getNumero() == numeroVenta) {
                if (operacion == 'C') {
                    venta.setEstado('C');
                } else if (operacion == 'P') {
                    venta.setEstado('P');
                }
                venta.setFechaHoraActualizacion(LocalDateTime.now());
                System.out.println("Venta actualizada.");
                return;
            }
        }
        System.out.println("Venta no encontrada.");
    }

    public void generarArchivoObjetosClientes(ArrayList<Cliente> datosClientes) {
        if (datosClientes == null) {
            datosClientes = new ArrayList<>();
        }
        Set<Cliente> clientesSinDuplicar = new LinkedHashSet<>(datosClientes);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CLIENTES))) {
            oos.writeObject(new ArrayList<>(clientesSinDuplicar));
            System.out.println("Archivo de clientes generado.");
        } catch (IOException e) {
            System.out.println("Error generando archivo de clientes: " + e.getMessage());
        }
    }

    public void recuperarClientesDesdeArchivoObjetos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_CLIENTES))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                datosClientes = (ArrayList<Cliente>) obj;
                System.out.println("Clientes recuperados: " + datosClientes.size());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error recuperando clientes: " + e.getMessage());
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
