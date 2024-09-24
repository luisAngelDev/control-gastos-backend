package com.ramos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramos.dto.EgresoResumenDTO;
import com.ramos.model.Egreso;
import com.ramos.repo.IEgresoRepo;
import com.ramos.repo.IGenericRepo;
import com.ramos.service.IEgresoService;

@Service
public class EgresoServiceImpl extends CRUDImpl<Egreso, Integer> implements IEgresoService{

	@Autowired
	private IEgresoRepo repo;
	
	@Override
	protected IGenericRepo<Egreso, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public List<EgresoResumenDTO> listarResumenDia() {

		// lista de arreglo de objetos List<Objet[]>
		List<EgresoResumenDTO> ventas = new ArrayList<>();

		repo.listarResumenDia().forEach(x -> {
			EgresoResumenDTO vr = new EgresoResumenDTO();
			vr.setCantidad(Double.parseDouble(String.valueOf(x[0])));
			vr.setFecha(String.valueOf(x[1]));
			ventas.add(vr);
		});

		return ventas;
	}
	
	@Override
	public List<EgresoResumenDTO> listarResumenXMes(Integer mes, Integer anio) {

		// lista de arreglo de objetos List<Objet[]>
		List<EgresoResumenDTO> ventas = new ArrayList<>();

		repo.listarResumenXMes(mes, anio).forEach(x -> {
			EgresoResumenDTO vr = new EgresoResumenDTO();
			vr.setCantidad(Double.parseDouble(String.valueOf(x[0])));
			vr.setFecha(String.valueOf(x[1]));
			ventas.add(vr);
		});

		return ventas;
	}
	
	@Override
	public List<EgresoResumenDTO> listarTotalesMes(Integer anio) {

		// lista de arreglo de objetos List<Objet[]>
		List<EgresoResumenDTO> ventas = new ArrayList<>();

		repo.listarTotalesMes(anio).forEach(x -> {
			EgresoResumenDTO vr = new EgresoResumenDTO();
			vr.setCantidad(Double.parseDouble(String.valueOf(x[0])));
			vr.setFecha(String.valueOf(x[1]));
			ventas.add(vr);
		});

		return ventas;
	}

}
