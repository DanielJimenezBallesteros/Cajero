package com.daniel.cajero.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daniel.cajero.entitybeans.Cuenta;
import com.daniel.cajero.entitybeans.Movimiento;
import com.daniel.cajero.repository.CuentaRepository;

@Repository
public class CuentaDaoImpl implements CuentaDao {

	@Autowired
	private CuentaRepository crepo;
	
	@Autowired
	private MovimientoDao mdao;
	
	//Este método nos permite consultar todas las cuentas disponibles
	//y nos devuelve una lista con ellas
	@Override
	public List<Cuenta> buscarTodos() {
		return crepo.findAll();
	}

	//Este método nos permite consultar una cuenta a través de un id
	//y nos devuelve la cuenta que buscábamos
	@Override
	public Cuenta buscarUna(int idCuenta) {
		// TODO Auto-generated method stub
		return crepo.findById(idCuenta).orElse(null);
	}
	
	//Este método nos permite ingresar una cantidad (introducida por el usuario)
	//en su propia cuenta (con la que ha accedido), además inserta el movimiento como ingreso
	@Override
	public boolean ingresarCantidad(Cuenta cuenta, double importe) {
		cuenta.setSaldo(cuenta.getSaldo()+importe);
		crepo.save(cuenta);
		Movimiento movimiento = new Movimiento(0,importe,"ingreso",cuenta);
		mdao.añadirMovimiento(movimiento);
		return true;
	}

	//Este método nos permite extraer una cantidad (introducida por el usuario)
	//de su propia cuenta (con la que ha accedido), además inserta el movimiento como extracción
	@Override
	public boolean extraerCantidad(Cuenta cuenta, double importe) {
		cuenta.setSaldo(cuenta.getSaldo()-importe);
		crepo.save(cuenta);
		Movimiento movimiento = new Movimiento(0,importe,"extracción",cuenta);
		mdao.añadirMovimiento(movimiento);
		return true;
	}
	
}
