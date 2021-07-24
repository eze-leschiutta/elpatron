package edu.it.components;

import edu.it.entities.Cliente;
import java.util.Scanner;
import java.util.UUID;

public class CargaDeCliente {
    public Cliente cargarCliente() {
        try {
            Scanner scn = new Scanner(System.in);

            Cliente cli = new Cliente();

            cli.id = UUID.randomUUID().toString();
            System.out.println("Ingrese el nombre del cliente");
            cli.nombre = scn.nextLine();
            System.out.println("Ingrese el modelo a adquirir");
            cli.modelo = scn.nextLine();

            return cli;
        }
        catch (Exception ex) {
            throw new RuntimeException("No se pudo cargar el cliente");
        }
    }
}
