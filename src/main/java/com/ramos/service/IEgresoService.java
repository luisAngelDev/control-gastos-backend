package com.ramos.service;

import java.util.List;

import com.ramos.dto.EgresoResumenDTO;
import com.ramos.model.Egreso;

public interface IEgresoService extends ICRUD<Egreso, Integer>{

	List<EgresoResumenDTO> listarResumenDia();
	List<EgresoResumenDTO> listarResumenXMes(Integer mes, Integer anio);
	List<EgresoResumenDTO> listarTotalesMes(Integer anio);
	
}
