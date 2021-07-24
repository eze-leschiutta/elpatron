package edu.it.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    public String id;
    public String nombre;
    public String modelo;

    public Cliente(String id, String nombre, String modelo) {
        this.id = id;
        this.nombre = nombre;
        this.modelo = modelo;
    }

    public Cliente() {
    }
}
