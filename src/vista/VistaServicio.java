/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorServicio;
import controlador.ControladorVehiculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modelo.Servicio;

/**
 *
 * @author Alex Zumba
 */
public class VistaServicio {

    private ControladorServicio controladorServicio;
    private ControladorVehiculo controladorVehiculo;
    private Scanner entrada;
    private SimpleDateFormat formatoFecha;
    public static String formato = "dd-MM-yyyy HH:mm";

    public VistaServicio(ControladorVehiculo controladorVehiculor) {
        this.controladorVehiculo = controladorVehiculor;
        controladorServicio = new ControladorServicio();
        entrada = new Scanner(System.in);
        formatoFecha = new SimpleDateFormat(formato);
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("Gestión del Servicio");
            System.out.println("1. Crear");
            System.out.println("2. Actualizar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("6. Salir");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    this.crear();
                    break;
                case 2:
                    this.actualizar();
                    break;
                case 3:
                    this.buscar();
                    break;
                case 4:
                    this.eliminar();
                    break;
                case 5:
                    this.listar();
                    break;
            }
        } while (opcion < 6);
    }

    public void crear() {
        System.out.print("Ingresar hora entrada: " + formato);
        entrada.nextLine();
        try {
            Date horaEntrada = formatoFecha.parse(entrada.nextLine());
            boolean resultado = controladorServicio.crear(horaEntrada, null, 0, controladorVehiculo.getSeleccionado());
            System.out.println("Creado " + resultado);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            this.crear();
        }
    }

    public Servicio buscar() {
        System.out.print("Ingrese hora entrada: " + formato);
        entrada.nextLine();
        try {
            Date horaEntrada = formatoFecha.parse(entrada.nextLine());
            Servicio servicio = controladorServicio.buscar(horaEntrada);
            System.out.println(servicio);
            return servicio;
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            this.menu();
        }
        return null;
    }

    public void actualizar() {
        Servicio servicio = this.buscar();
        System.out.print("Ingrese hora salida: " + formato);
        try {
            Date horaSalida = formatoFecha.parse(entrada.nextLine());
            boolean resultado = controladorServicio.actualizar(servicio.getHoraEntrada(), horaSalida);
            System.out.println("Resultado: " + resultado);
            System.out.println("Valor a pagar = " + servicio.getValorPagar());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            this.actualizar();
        }
    }

    public void eliminar() {
        Servicio servicio = this.buscar();
        if (servicio != null) {
            boolean resultado = controladorServicio.eliminar(servicio.getHoraEntrada());
            System.out.println("Elminado: " + resultado);
        }
    }

    public void listar() {
        for (Servicio dato : controladorServicio.getDatos()) {
            System.out.println(dato);
        }
    }
}
