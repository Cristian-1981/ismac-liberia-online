import com.distribuida.entities.Categoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoriaTestUnitaria {
    private Categoria categoria;

    @Test
    public void testCategoriaSetter(){
        categoria = new Categoria();

        categoria.setIdCategoria(1);
        categoria.setCategorias("Aventura");
        categoria.setDescripcion("En busca del tesoro");

        assertAll("Validar datos Categoria",
                () -> assertEquals(1,categoria.getIdCategoria()),
                () -> assertEquals("Aventura",categoria.getCategorias()),
                () -> assertEquals("En busca del tesoro",categoria.getDescripcion())
        );
    }

}
