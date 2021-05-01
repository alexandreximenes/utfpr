/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.rivolli.posjava.model;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rivolli
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Override
    List<Cliente> findAll();
    
    Cliente findById(long id);
    
    @Query(value = "from Cliente c where lower(c.primeiroNome) like '%'||lower(?1)||'%' or lower(sobrenome) like '%'||lower(?1)||'%'")
    List<Cliente> findByNome(String nome);
}
