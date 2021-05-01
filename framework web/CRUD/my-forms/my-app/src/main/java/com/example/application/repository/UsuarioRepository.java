package com.example.application.repository;

import com.example.application.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Override
    List<Usuario> findAll();

    Usuario findById(long id);

    @Transactional(readOnly = true)
    @Query(value = "from Usuario u where u.nome like concat(:search, '%') or u.sobrenome like concat(:search, '%')  ")
    List<Usuario> findByNomeOrSobrenome(@Param("search") String search);
}
