package co.com.valtica.kitbasico.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.valtica.kitbasico.datos.AfiliadosRepository;
import co.com.valtica.kitbasico.entidades.Afiliado;

@Component
public class AfiliadosFacade implements IAfiliadosFacade{
	
	@Autowired
	AfiliadosRepository afiliadosRepository;
	
	public Afiliado afiliar(Afiliado afiliado) {
		if(afiliado.validar()) {
			return afiliadosRepository.save(afiliado);
		}else {
			return null;
		}
	}
	
	public Afiliado findById(long id) {
		return afiliadosRepository.findById(id)
        .orElse(new Afiliado());
	}

}
