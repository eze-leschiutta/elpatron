package edu.it.repository;

import com.google.gson.Gson;
import edu.it.entities.Cliente;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class GrabadorClienteJSON implements GrabadorCliente {
    Logger logger = Logger.getLogger(GrabadorClienteJSON.class);

    public void grabar(Cliente c) {
        var path = String.join("","/var/planes/", c.id, ".json");

        try {
            var clijson = new Gson().toJson(c);
            var f = new File(path);
            FileUtils.writeStringToFile(f, clijson, "utf8");
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
