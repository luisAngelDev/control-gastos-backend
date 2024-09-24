package com.ramos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ramos.model.Egreso;

@Repository
public interface IEgresoRepo extends IGenericRepo<Egreso, Integer> {

	@Query(value = "select * from fn_listarResumenDia()", nativeQuery = true)
	List<Object[]> listarResumenDia();
	
	@Query(value = "select * from fn_listarResumenXMes(:mes, :anio)", nativeQuery = true)
	List<Object[]> listarResumenXMes(@Param("mes") Integer mes, @Param("anio") Integer anio);
	
	@Query(value = "select * from fn_listarTotalesMes(:anio)", nativeQuery = true)
	List<Object[]> listarTotalesMes(@Param("anio") Integer anio);
}
