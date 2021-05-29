/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Vehiculo;

/**
 *
 * @author Alex Zumba
 */
public class VistaGeneral {
    
    private VistaCliente vistaCliente;
    private VistaEmpresa vistaEmpresa;
    private VistaVehiculo vistaVehivulo;
    private VistaServicio vistaServicio;
    private Scanner entrada;

    
    public VistaGeneral() {
        vistaEmpresa = new VistaEmpresa();
        vistaCliente = new VistaCliente(vistaEmpresa.getControladorEmpresa()); // estoy unificando el controlador de empresa en uno solo
        vistaVehivulo = new VistaVehiculo(vistaCliente.getControladorCliente());
        vistaServicio = new VistaServicio(vistaVehivulo.getControladorVehiculo());
        entrada = new Scanner(System.in);
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("Seleccione una opción");
            System.out.println("1. Empresa");
            System.out.println("2. Cliente");
            System.out.println("3. Vehiculo");
            System.out.println("4. Servicio");
            System.out.println("5. Salir");
            opcion = entrada.nextInt();
            switch(opcion){
                case 1: vistaEmpresa.menu(); break;
                case 2: this.cliente(); break;
                case 3: this.vehiculo(); break;
                case 4: this.servicio();break;
            }
        } while (opcion < 5);
    }
    public void cliente() {
        System.out.println("Seleccione una empresa para gestionar los clientes");
        Empresa empresa = vistaEmpresa.buscar();
        if(empresa != null){ 
            vistaEmpresa.asignarSelecionado(empresa);
            vistaCliente.menu();
        }else {
            System.out.println("No exite la empresa");
            this.cliente();
        }
    }
    public void vehiculo(){
        System.out.println("Seleccione una propietario para gestionar los vechiculos");
        Cliente cliente = vistaCliente.buscar();
        if(cliente != null){ 
            vistaCliente.asignarSeleccionado(cliente);
            vistaVehivulo.menu();
        }else {
            System.out.println("No exite la empresa");
            this.vehiculo();
        }
    }
    public void servicio(){
        System.out.println("Selecione un vehiculo");
        Vehiculo vehiculo =  vistaVehivulo.buscar();
        if(vehiculo != null){
            vistaVehivulo.asignarSeleccionado(vehiculo);
            vistaServicio.menu();
        }else {
            System.out.println("No existe vehiculo");
            this.menu();
        }
    }
}
