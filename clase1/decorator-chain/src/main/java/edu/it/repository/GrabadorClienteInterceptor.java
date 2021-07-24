package edu.it.repository;

import edu.it.entities.Cliente;
import edu.it.service.ServicioNoMolestarSQL;

public class GrabadorClienteInterceptor implements GrabadorCliente {
    private GrabadorClienteSQL grabadorCliente;
    private GrabadorClienteJSON grabadorClienteJSON;
    private ServicioNoMolestarSQL servicioNoMolestarSQL;

    public GrabadorClienteInterceptor(GrabadorClienteSQL grabadorCliente, GrabadorClienteJSON grabadorClienteJSON, ServicioNoMolestarSQL servicioNoMolestarSQL) {
        this.grabadorCliente = grabadorCliente;
        this.grabadorClienteJSON = grabadorClienteJSON;
        this.servicioNoMolestarSQL = servicioNoMolestarSQL;
    }

    @Override
    public void grabar(Cliente c) {

        if (servicioNoMolestarSQL.estaActivo()) {
            grabadorClienteJSON.grabar(c);
            return;
        }

        try {
            grabadorCliente.grabar(c);
            return;
        }
        catch (Exception ex) {
            System.out.println("GUARDAR EN ARCHIVO LOCAL....");
            grabadorClienteJSON.grabar(c);
        }
    }
}
