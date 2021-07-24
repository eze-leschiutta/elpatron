package edu.it;

public class App {
    public static void main(String[] args) {
        /**
         * Tenemos un punto de venta de una consecionaria
         * que vende planes de ahorro para 0KM 84 Cuotas
         * Conectado por 4G o WiFi
         * Habia momentos donde se cortaba la conexion SQL
         * Guardar a archivo local para luego subir al sql
         */

        var cargaCliente = edu.it.factory.Factory.crearCargaDeCliente();
        var cliente = cargaCliente.cargarCliente();
        var grabadorCliente = edu.it.factory.Factory.crearGrabadorCliente();

        grabadorCliente.grabar(cliente);
    }
}
