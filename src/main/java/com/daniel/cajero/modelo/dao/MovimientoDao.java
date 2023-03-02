package com.daniel.cajero.modelo.dao;

import java.util.List;

import com.daniel.cajero.entitybeans.Cuenta;
import com.daniel.cajero.entitybeans.Movimiento;

public interface MovimientoDao {

	List<Movimiento> buscarTodos(Cuenta cuenta);
	boolean añadirMovimiento(Movimiento movimiento);
}
