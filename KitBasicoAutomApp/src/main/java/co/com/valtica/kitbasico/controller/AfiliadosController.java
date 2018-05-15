package co.com.valtica.kitbasico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.valtica.kitbasico.entidades.Afiliado;
import co.com.valtica.kitbasico.facade.IAfiliadosFacade;

@RestController
@RequestMapping("/api")
public class AfiliadosController {

	 @Autowired
	 IAfiliadosFacade afiliadosFacade;
	 
	 @PostMapping("/afiliados")
	 public Afiliado crearAfiliado(@Valid @RequestBody Afiliado afiliado) {
	     return afiliadosFacade.afiliar(afiliado);
	 }
	 
	 @GetMapping("/afiliado/{id}")
	 public Afiliado getAfiliadoById(@PathVariable(value = "id") Long id) {
	     return afiliadosFacade.findById(id);
	 }
	
}
