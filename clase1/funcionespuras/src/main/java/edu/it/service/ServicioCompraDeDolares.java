package edu.it.service;

import java.util.List;

public class ServicioCompraDeDolares {
    private List<CriterioDeExclusion> citeriosDeExclusion;
    private List<Descuento> descuentos;
    private final Double CANT_MENSUAL = 200d;

    public ServicioCompraDeDolares(List<CriterioDeExclusion> citeriosDeExclusion, List<Descuento> descuentos) {
        this.citeriosDeExclusion = citeriosDeExclusion;
        this.descuentos = descuentos;
    }

    public Double calcularCantidadCompraPosible() {
        for (var ce : citeriosDeExclusion) {
            if (ce.estaExcluido()) {
                return 0d;
            }
        }

        Double montoDefinitivo = CANT_MENSUAL;

        for (var desc : descuentos) {
            montoDefinitivo -= desc.obtenerDescuento();
        }

        return montoDefinitivo;
    }
}
