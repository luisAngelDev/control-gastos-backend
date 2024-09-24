package com.ramos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramos.model.Ingreso;
import com.ramos.repo.IGenericRepo;
import com.ramos.repo.IIngresoRepo;
import com.ramos.service.IIngresoService;

@Service
public class IngresoServiceImpl extends CRUDImpl<Ingreso, Integer> implements IIngresoService{

	@Autowired
	private IIngresoRepo repo;
	
	@Override
	protected IGenericRepo<Ingreso, Integer> getRepo() {
		return repo;
	}

}
