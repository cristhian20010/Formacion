package com.cristhiancabrera;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}

	@Bean
	public CommandLineRunner prueba (RepositorioCliente repositorio){

		return (args) -> {
			// guardamos algunos ejemplos de prueba
			repositorio.save(new Cliente("Carlos","Araoz"));
			repositorio.save(new Cliente("Juan","Portell"));
			repositorio.save(new Cliente("Jose","Rodriguez"));
			repositorio.save(new Cliente("Santiago","Cabrera"));

			//buscamos todos los clientes

			log.info("Clientes encontrados con .findAll");
			log.info("---------------------------------");

			for (Cliente cliente : repositorio.findAll()) {
				log.info(cliente.toString());
			}

			System.out.println("Traza para llegar aqui");
			log.info("------------------------------------");

			//buscamos clientes por ID
			repositorio.findById(1L)
					.ifPresent(cliente -> {
						log.info("Cliente encontrado con el id 1L: ");
						log.info("----------------------------------");
						log.info(cliente.toString());
						log.info("----------------------------------");
					});
			//buscamos cliente por apellido

			repositorio.findyByApellido("Cabrera").forEach(cabrera ->
					log.info(cabrera.toString()));
			log.info("Clientes encontrador con el apellido Cabrera");

		};
	}
}

