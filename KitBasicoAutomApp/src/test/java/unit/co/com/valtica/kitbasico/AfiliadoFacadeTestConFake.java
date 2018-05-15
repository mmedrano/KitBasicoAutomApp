package unit.co.com.valtica.kitbasico;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.valtica.kitbasico.entidades.Afiliado;
import co.com.valtica.kitbasico.entidades.Ciudad;
import co.com.valtica.kitbasico.facade.AfiliadosFacade;
import co.com.valtica.kitbasico.facade.IAfiliadosFacade;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {AfiliadoRepositoryFake.class, AfiliadosFacade.class})
public class AfiliadoFacadeTestConFake {
	
	@Autowired
	IAfiliadosFacade afiliadosFacade;
	
	@Test
	public void crearAfiliadoMayor18Anios() {
		Afiliado afiliado=new Afiliado("1231232", "Pedro", "Perez", "123123123", 19, 100000, new Ciudad(1L, "Lima"));
		assertTrue("Afiliado creado correctamente", afiliadosFacade.afiliar(afiliado)!=null);
	}
	
	@Test
	public void noCrearAfiliadoMenor18Anios() {
		Afiliado afiliado=new Afiliado("1231232", "Pedro", "Perez", "123123123", 15, 0, new Ciudad(1L, "Lima"));
		assertFalse("Afiliado no creado", afiliadosFacade.afiliar(afiliado)!=null);
	}
	
}
