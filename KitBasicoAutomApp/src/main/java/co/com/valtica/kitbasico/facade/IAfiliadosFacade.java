package co.com.valtica.kitbasico.facade;

import co.com.valtica.kitbasico.entidades.Afiliado;

public interface IAfiliadosFacade {
	public Afiliado afiliar(Afiliado afiliado);
	
	public Afiliado findById(long id);
}
