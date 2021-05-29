/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorEmpresa;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Empresa;

/**
 *
 * @author Alex Zumba
 */
public class VistaEmpresa {

    private ControladorEmpresa controladorEmpresa;
    private Scanner entrada;

    public VistaEmpresa() {
        controladorEmpresa = new ControladorEmpresa();
        entrada = new Scanner(System.in);
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n Gestion Empresa");
            System.out.println("1. Crear");
            System.out.println("2. Actaulizar");
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
                    this.imprimir();
                    break;
            }
        } while (opcion < 6);
    }

    public void crear() {
        System.out.println("Ingresar los siguientes datos:");
        System.out.print("Id");
        long id = entrada.nextLong();
        System.out.print("Nombre");
        String nombre = entrada.next();
        boolean resultado = controladorEmpresa.crear(id, nombre);
        System.out.println("Creado = " + resultado);
    }

    public void actualizar() {
        System.out.print("Nombre");
        String nombreAnterior = entrada.next();
        System.out.print("Nombre Nuevo");
        String nombre = entrada.next();
        boolean resultado = controladorEmpresa.actualizar(nombreAnterior, nombre);
        System.out.println("Actualizado = " + resultado);
    }

    public Empresa buscar() {
        System.out.print("Nombre");
        String nombre = entrada.next();
        Empresa empresa = controladorEmpresa.buscar(nombre);
        //empresaControlador.setSeleccionado(empresa);
        return empresa;
    }

    public void asignarSelecionado(Empresa empresa) {
        controladorEmpresa.setSeleccionado(empresa);
    }

    public void eliminar() {
        System.out.print("Nombre");
        String nombre = entrada.next();
        boolean resultado = controladorEmpresa.eliminar(nombre);
        System.out.println("Eliminado: " + resultado);
    }

    public void imprimir() {
        for (Empresa empresa : controladorEmpresa.getListaEmpresa()) {
            System.out.println(empresa);
            this.imprimirClientes(empresa);
        }
    }

    public void imprimirClientes(Empresa empresa) {
        for (Cliente cliente : empresa.getListaCliente()) {
            System.out.println(cliente);
        }
    }

    public ControladorEmpresa getControladorEmpresa() {
        return controladorEmpresa;
    }

    public void setControladorEmpresa(ControladorEmpresa controladorEmpresa) {
        this.controladorEmpresa = controladorEmpresa;
    }

}
