package edu.it;

import edu.it.service.CriterioDeExclusion;
import edu.it.service.Descuento;
import edu.it.service.ServicioCompraDeDolares;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class Criterio1 implements CriterioDeExclusion {
    public Boolean estaExcluido() {
        return false;
    }
}

class Criterio2 implements CriterioDeExclusion {
    public Boolean estaExcluido() {
        return false;
    }
}

class DecuentoXCompraPrevia implements Descuento {
    public Double obtenerDescuento() {
        return 2.3d;
    }
}

class DescuentoXCompraExterior implements Descuento {
    public Double obtenerDescuento() {
        return 12.5d;
    }
}


class AppTest {
    @Test
    void appHasAGreeting() {
        List<CriterioDeExclusion> cris =
            Arrays.asList(new Criterio1(), new Criterio2());

        List<Descuento> descuentos =
            Arrays.asList(new DecuentoXCompraPrevia(), new DescuentoXCompraExterior());

        var resp = new ServicioCompraDeDolares(cris, descuentos)
                .calcularCantidadCompraPosible();

        org.junit.jupiter.api.Assertions.assertEquals(185.20d, resp);
    }
}
