package co.com.valtica.kitbasico.datos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.valtica.kitbasico.entidades.Afiliado;

@Repository
public interface AfiliadosRepository extends JpaRepository<Afiliado, Long> {

}