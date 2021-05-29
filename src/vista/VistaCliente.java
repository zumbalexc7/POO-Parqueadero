/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorCliente;
import controlador.ControladorEmpresa;
import java.util.Scanner;
import modelo.Cliente;

/**
 *
 * @author Alex Zumba
 */
public class VistaCliente {

    private Scanner entrada;
    private ControladorCliente controladorCliente;
    private ControladorEmpresa controladorEmpresa;

    public VistaCliente(ControladorEmpresa controladorEmpresa) {
        this.entrada = new Scanner(System.in);
        this.controladorCliente = new ControladorCliente();
        this.controladorEmpresa = controladorEmpresa;
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n----Gestión de Clientes----");
            System.out.println("1. Crear");
            System.out.println("2. Actualizar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar/Imprimir");
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
                    System.out.println("Listado de clientes: ");
                    controladorCliente.imprimir();
                    break;
            }
        } while (opcion < 6);
    }

    public void crear() {
        System.out.println("Ingrese los siguientes datos:");
        System.out.print("Id: ");
        long id = entrada.nextLong();
        System.out.print("Nombre: ");
        String nombre = entrada.next();
        System.out.print("Apellido: ");
        String apellido = entrada.next();
        System.out.print("Cedula: ");
        String cedula = entrada.next();
        boolean resultado = controladorCliente.crear(id, nombre, apellido, cedula, controladorEmpresa.getSeleccionado());
        System.out.println("Cliente creado: " + resultado);
    }

    public void actualizar() {
        System.out.println("Actualizar");
        System.out.print("Cedula: ");
        String cedula = entrada.next();
        System.out.print("Nombre: ");
        String nombre = entrada.next();
        System.out.print("Apellido: ");
        String apellido = entrada.next();
        boolean resultado = controladorCliente.actualizar(cedula, nombre, apellido);
        System.out.println("Cliente actualizado: " + resultado);
    }

    public void eliminar() {
        System.out.println("Eliminar Cliente");
        System.out.print("Cedula: ");
        String cedula = entrada.next();
        boolean resultado = controladorCliente.eliminar(cedula);
        System.out.println("Cliente eliminado: " + resultado);
    }

    public Cliente buscar() {
        System.out.println("Buscar Cliente");
        System.out.print("Cedula: ");
        String cedula = entrada.next();
        Cliente cliente = controladorCliente.buscar(cedula);
        System.out.println(cliente);
        return cliente;
    }

    public void asignarSeleccionado(Cliente cliente) {
        controladorCliente.setSeleccionado(cliente);
    }

    public ControladorCliente getControladorCliente() {
        return controladorCliente;
    }

    public void setControladorCliente(ControladorCliente controladorCliente) {
        this.controladorCliente = controladorCliente;
    }

    public ControladorEmpresa getControladorEmpresa() {
        return controladorEmpresa;
    }

    public void setControladorEmpresa(ControladorEmpresa controladorEmpresa) {
        this.controladorEmpresa = controladorEmpresa;
    }

}
