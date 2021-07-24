package edu.it.factory;

import edu.it.components.CargaDeCliente;
import edu.it.repository.GrabadorCliente;
import edu.it.repository.GrabadorClienteInterceptor;
import edu.it.repository.GrabadorClienteJSON;
import edu.it.repository.GrabadorClienteSQL;
import edu.it.service.ServicioNoMolestarSQL;

public class Factory {
    public static CargaDeCliente crearCargaDeCliente() {
        try {
            return (CargaDeCliente)Class.forName("edu.it.components.CargaDeCliente")
                .getConstructor()
                .newInstance();
        }
        catch (Exception ex) {
            throw new RuntimeException("No se pudo construir CargaDecliente");
        }
    }
    public static GrabadorCliente crearGrabadorCliente() {
        return new GrabadorClienteInterceptor(
                new GrabadorClienteSQL(),
                new GrabadorClienteJSON(),
                new ServicioNoMolestarSQL()
        );
    }
}
