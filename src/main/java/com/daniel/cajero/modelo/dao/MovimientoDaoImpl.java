package com.daniel.cajero.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daniel.cajero.entitybeans.Cuenta;
import com.daniel.cajero.entitybeans.Movimiento;
import com.daniel.cajero.repository.MovimientoRepository;

@Repository
public class MovimientoDaoImpl implements MovimientoDao {
	
	@Autowired
	private MovimientoRepository mrepo;

	//Es método nos permite añadir un movimiento en la base de datos
	@Override
	public boolean añadirMovimiento(Movimiento movimiento) {
		mrepo.save(movimiento);
		return true;
	}
	
	//Es método nos permite consultar todos los movimientos que ha realizado una cuenta
	@Override
	public List<Movimiento> buscarTodos(Cuenta cuenta) {
		List<Movimiento> movimientosCuenta = new ArrayList<>();
		for (Movimiento elemento: mrepo.findAll()) {
			if (elemento.getCuenta().getIdCuenta()==(cuenta.getIdCuenta())) {
				movimientosCuenta.add(elemento);
			}
		}
		return movimientosCuenta;
	}
}
