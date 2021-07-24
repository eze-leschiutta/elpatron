package edu.it.repository;

import edu.it.components.ConectorJPA;
import edu.it.entities.Cliente;

public class GrabadorClienteSQL implements GrabadorCliente {
    public void grabar(Cliente c) {
        var em = new ConectorJPA().getEntityManager();

        try {
            if (c.modelo.equals("fallo")) {
                throw new Exception("No se pudo grabar");
            }
            var tx = em.getTransaction();
            tx.begin();
            em.merge(c);
            em.flush();
            tx.commit();
        }
        catch (Throwable ex) {
            System.out.println("***************************************");
            throw new RuntimeException("No se pudo grabar el cliente");
        }
    }
}
