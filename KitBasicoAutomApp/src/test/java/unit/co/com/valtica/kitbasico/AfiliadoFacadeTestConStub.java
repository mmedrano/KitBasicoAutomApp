package unit.co.com.valtica.kitbasico;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.valtica.kitbasico.datos.AfiliadosRepository;
import co.com.valtica.kitbasico.entidades.Afiliado;
import co.com.valtica.kitbasico.entidades.Ciudad;
import co.com.valtica.kitbasico.facade.AfiliadosFacade;
import co.com.valtica.kitbasico.facade.IAfiliadosFacade;
import unit.co.com.valtica.kitbasico.configuration.ApplicationTestConfiguration;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {ApplicationTestConfiguration.class, AfiliadosFacade.class})
public class AfiliadoFacadeTestConStub {
	
	@Autowired
	IAfiliadosFacade afiliadosFacade;
	
	@Autowired
	AfiliadosRepository afiliadosRepositorio;
		
	@Test
	public void crearAfiliadoMayor18AniosYSueldoMayorYCiudadLima() {
		Afiliado afiliado=new Afiliado("1231232", "Pedro", "Perez", "123123123", 19, 100000, new Ciudad(1L, "Lima"));
		Mockito.when(afiliadosRepositorio.save(afiliado)).thenReturn(afiliado);
		
		assertTrue("Afiliado creado correctamente", afiliadosFacade.afiliar(afiliado)!=null);
	}
	
	@Test
	public void noCrearAfiliadoMayor18AniosYSueldoMayorYCiudadNoLima() {
		Afiliado afiliado=new Afiliado("1231232", "Pedro", "Perez", "123123123", 19, 100000, new Ciudad(2L, "Trujillo"));
		Mockito.when(afiliadosRepositorio.save(afiliado)).thenReturn(afiliado);
		
		assertFalse("Afiliado no creado", afiliadosFacade.afiliar(afiliado)!=null);
	}
	
	@Test
	public void noCrearAfiliadoMayor18AniosYSueldoMenor() {
		Afiliado afiliado=new Afiliado("1231232", "Pedro", "Perez", "123123123", 19, 99999, new Ciudad(1L, "Lima"));
		Mockito.when(afiliadosRepositorio.save(afiliado)).thenReturn(afiliado);
		
		assertFalse("Afiliado no creado", afiliadosFacade.afiliar(afiliado)!=null);
	}
	
	@Test
	public void noCrearAfiliadoMenor18AniosYSueldoMayor() {
		Afiliado afiliado=new Afiliado("1231232", "Pedro", "Perez", "123123123", 17, 100000, new Ciudad(1L, "Lima"));
		Mockito.when(afiliadosRepositorio.save(afiliado)).thenReturn(afiliado);
		
		assertFalse("Afiliado no creado", afiliadosFacade.afiliar(afiliado)!=null);
	}
	
	@Test
	public void noCrearAfiliadoMenor18AniosYSueldoMenor() {
		Afiliado afiliado=new Afiliado("1231232", "Pedro", "Perez", "123123123", 17, 99999, new Ciudad(1L, "Lima"));
		Mockito.when(afiliadosRepositorio.save(afiliado)).thenReturn(afiliado);
		
		assertFalse("Afiliado no creado", afiliadosFacade.afiliar(afiliado)!=null);
	}
}