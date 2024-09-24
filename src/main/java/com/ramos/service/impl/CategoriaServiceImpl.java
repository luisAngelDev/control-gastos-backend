package com.ramos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramos.model.Categoria;
import com.ramos.repo.ICategoriaRepo;
import com.ramos.repo.IGenericRepo;
import com.ramos.service.ICategoriaService;

@Service
public class CategoriaServiceImpl extends CRUDImpl<Categoria, Integer> implements ICategoriaService{

	@Autowired
	private ICategoriaRepo repo;
	
	@Override
	protected IGenericRepo<Categoria, Integer> getRepo() {
		return repo;
	}

}
