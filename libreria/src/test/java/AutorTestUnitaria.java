import com.distribuida.entities.Autor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutorTestUnitaria {
    private Autor autor;

    @BeforeEach
    public void Setup(){

        autor = new Autor(1,"Juan","Guerra","Mexico","Av. Guadalajara","0984443704","juan@gmail.com");
    }
    @Test
    public void testAutorToString(){
        String str = autor.toString();
        assertAll("Validad Datos de Autor",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Juan")),
                () -> assertTrue(str.contains("Guerra")),
                () -> assertTrue(str.contains("Mexico")),
                () -> assertTrue(str.contains("Av. Guadalajara")),
                () -> assertTrue(str.contains("0984443704")),
                () -> assertTrue(str.contains("juan@gmail.com"))
        );
    }
}
