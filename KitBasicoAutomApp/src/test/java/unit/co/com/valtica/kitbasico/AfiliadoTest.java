package unit.co.com.valtica.kitbasico;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import co.com.valtica.kitbasico.entidades.Afiliado;


public class AfiliadoTest {
	
	
	
	@Test
	public void crearAfialiadoMayorDe18Anios() {
		Afiliado afiliado = new Afiliado("1234", "Geronimo", "Giraldo", "3001112233", 19);
		
		assertTrue(afiliado.validar());
	
	}
	
	@Test
	public void crearAfialiadoMenorDe18Anios() {
		Afiliado afiliado = new Afiliado("1234", "Ana Paula", "Perez", "3001112244", 16);
		
		assertFalse(afiliado.validar());
		
		
	}

}
