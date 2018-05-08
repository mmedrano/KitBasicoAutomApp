package co.com.valtica.kitbasico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.valtica.kitbasico.datos.AfiliadosRepository;
import co.com.valtica.kitbasico.entidades.Afiliado;

@RestController
@RequestMapping("/api")
public class AfiliadosController {

	 @Autowired
	 AfiliadosRepository afiliadosRepository;
	 
	 @PostMapping("/afiliados")
	 public Afiliado crearAfiliado(@Valid @RequestBody Afiliado afiliado) {
		 System.out.println("Hola");
	     return afiliadosRepository.save(afiliado);
	 }
	 
	 @GetMapping("/afiliado/{id}")
	 public Afiliado getAfiliadoById(@PathVariable(value = "id") Long noteId) {
	     return afiliadosRepository.findById(noteId)
	             .orElse(new Afiliado());
	 }
	
}
