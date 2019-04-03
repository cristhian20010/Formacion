package com.cristhiancabrera.Accessing._with_MySQL;

import org.springframework.data.repository.CrudRepository;


//Esto será IMPLEMENTADO AUTOMÁTICAMENTE por Spring en un Bean llamado RepositorioUsuario
// CRUD se refiere a Crear, Leer, Actualizar, Eliminar
public interface RepositorioUsuario extends CrudRepository<Usuario, Integer> {
}
