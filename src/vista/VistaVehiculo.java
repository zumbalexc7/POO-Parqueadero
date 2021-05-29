/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorCliente;
import controlador.ControladorVehiculo;
import java.util.Scanner;
import modelo.Vehiculo;

/**
 *
 * @author Alex Zumba
 */
public class VistaVehiculo {

    private ControladorVehiculo controladorVehiculo;
    private ControladorCliente controladorCliente;
    private Scanner entrada;

    public VistaVehiculo(ControladorCliente controladorCliente) {
        this.controladorCliente = controladorCliente;
        controladorVehiculo = new ControladorVehiculo();
        entrada = new Scanner(System.in);
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("Gestión de Vehiculos");
            System.out.println("1. Crear");
            System.out.println("2. Actualizar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Imprimir");
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
                    this.imprimir();
                    break;
            }
        } while (opcion < 6);
    }

    public void crear() {
        System.out.println("Crear - Ingrese los datos:");
        System.out.print("Placa");
        String placa = entrada.next();
        System.out.print("Marca");
        String marca = entrada.next();
        System.out.print("Modelo");
        String modelo = entrada.next();
        boolean resultado = controladorVehiculo.crear(placa, marca, modelo, controladorCliente.getSeleccionado());
        System.out.println("Creado = " + resultado);
    }

    public void actualizar() {
        System.out.println("Actualizar - Ingrese los datos: ");
        System.out.print("Placa");
        String placa = entrada.next();
        System.out.print("Marca");
        String marca = entrada.next();
        System.out.print("Modelo");
        String modelo = entrada.next();
        boolean resultado = controladorVehiculo.actualizar(placa, marca, modelo);
        System.out.println("Actualizado = " + resultado);
    }

    public Vehiculo buscar() {
        System.out.println("Ingresar la placa");
        String placa = entrada.next();
        Vehiculo vehiculo = controladorVehiculo.buscar(placa);
        System.out.println(vehiculo);
        return vehiculo;
    }

    public void eliminar() {
        System.out.println("Ingresar la placa");
        String placa = entrada.next();
        boolean resultado = controladorVehiculo.eliminar(placa);
    }

    public void imprimir() {
        for (Vehiculo vehiculo : controladorVehiculo.getListaVehiculo()) {
            System.out.println(vehiculo);
        }
    }

    public void asignarSeleccionado(Vehiculo vehiculo) {
        controladorVehiculo.setSeleccionado(vehiculo);
    }

    public ControladorVehiculo getControladorVehiculo() {
        return controladorVehiculo;
    }

    public void setControladorVehiculo(ControladorVehiculo controladorVehiculo) {
        this.controladorVehiculo = controladorVehiculo;
    }

    public ControladorCliente getControladorCliente() {
        return controladorCliente;
    }

    public void setControladorCliente(ControladorCliente controladorCliente) {
        this.controladorCliente = controladorCliente;
    }

}
