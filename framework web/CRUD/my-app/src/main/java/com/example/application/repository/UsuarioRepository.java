package com.example.application.repository;

import com.example.application.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Override
    List<Usuario> findAll();

    Usuario findById(long id);

    @Query(value = "from Usuario u where u.nome like concat(lower(:_param), '%') or u.sobrenome like concat(lower(:_param), '%')")
    List<Usuario> findByNome(String _param);
}
