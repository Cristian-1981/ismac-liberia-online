import com.distribuida.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTestUnitaria {

    private Cliente cliente;
    @BeforeEach
    public void setUp(){
        cliente = new Cliente(1,"1716699515","Cristian","Barreno","av. general","0984443705","correo@gmail.com");
    }
    @Test
    public void testClienteConstructorAndGetteres(){

        assertAll("Validar datos cliente",
                () -> assertEquals(1,cliente.getIdCliente()),
                () -> assertEquals("1716699515",cliente.getCedula()),
                () -> assertEquals("Cristian",cliente.getNombre()),
                () -> assertEquals("Barreno",cliente.getApellido()),
                () -> assertEquals("av. general",cliente.getDireccion()),
                () -> assertEquals("0984443705",cliente.getTelefono()),
                () -> assertEquals("correo@gmail.com",cliente.getCorreo())
        );
    }
}
