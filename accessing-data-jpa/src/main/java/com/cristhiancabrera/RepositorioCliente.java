package com.cristhiancabrera;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioCliente extends CrudRepository<Cliente, Long> {
    List<Cliente> findyByApellido (String apellido);
}
