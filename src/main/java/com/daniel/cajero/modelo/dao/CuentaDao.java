package com.daniel.cajero.modelo.dao;

import java.util.List;

import com.daniel.cajero.entitybeans.Cuenta;

public interface CuentaDao {
	
	List<Cuenta> buscarTodos();
	Cuenta buscarUna(int idCuenta);
	boolean ingresarCantidad(Cuenta cuenta,double importe);
	boolean extraerCantidad(Cuenta cuenta,double importe);
}
