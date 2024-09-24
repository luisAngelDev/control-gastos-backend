package com.ramos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramos.model.Metodopago;
import com.ramos.repo.IGenericRepo;
import com.ramos.repo.IMetodopagoRepo;
import com.ramos.service.IMetodopagoService;

@Service
public class MetodopagoServiceImpl extends CRUDImpl<Metodopago, Integer> implements IMetodopagoService{

	@Autowired
	private IMetodopagoRepo repo;
	
	@Override
	protected IGenericRepo<Metodopago, Integer> getRepo() {
		return repo;
	}

}
