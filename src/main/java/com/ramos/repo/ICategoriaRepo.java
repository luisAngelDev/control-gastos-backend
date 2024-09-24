package com.ramos.repo;

import org.springframework.stereotype.Repository;

import com.ramos.model.Categoria;

@Repository
public interface ICategoriaRepo extends IGenericRepo<Categoria, Integer> {

	
}
