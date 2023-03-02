package com.daniel.cajero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniel.cajero.entitybeans.Cuenta;
import com.daniel.cajero.entitybeans.Movimiento;
import com.daniel.cajero.modelo.dao.CuentaDao;
import com.daniel.cajero.modelo.dao.MovimientoDao;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class GestionCajero {
	
	@Autowired
	private CuentaDao cdao;
	@Autowired
	private MovimientoDao mdao;
	
	Cuenta cuentaIniciada;

	@PostMapping("/inicio")
	public String procInicioCajero(HttpSession miSesion, Model model, Cuenta cuenta) {	
		int idCuenta = cuenta.getIdCuenta();
		if (!(cdao.buscarUna(idCuenta)==null)){
			Cuenta cuentaIniciada = cdao.buscarUna(idCuenta);
			((HttpSession)miSesion).setAttribute("cuentaIniciada", cuentaIniciada);
			return "redirect:/cajero";
		} else {
			model.addAttribute("mensaje", "Esta cuenta NO existe");
			return "inicio";
		}
	}
	
	@GetMapping("/cerrarSesion")
	public String procCerrarSesion (HttpSession miSesion, Model model) {
		miSesion.removeAttribute("cuentaIniciada");
		return "inicio";
	}
	
	@GetMapping("/cajero")
	public String procCajero(HttpSession miSesion, Cuenta cuenta) {
		cuentaIniciada=(Cuenta) miSesion.getAttribute("cuentaIniciada");
		return "cajero";
	}
	
	@GetMapping("/ingresar")
	public String procIngresar(HttpSession miSesion, Model model) {
		model.addAttribute("cuentaIniciada", cuentaIniciada);
		return "ingresar";
	}
	
	@PostMapping("/ingresar")
	public String procIngresarImporte(HttpSession miSesion, Model model, Cuenta cuenta) {
		cuentaIniciada=(Cuenta) miSesion.getAttribute("cuentaIniciada");
		cdao.ingresarCantidad(cuentaIniciada, cuenta.getSaldo());
		return "cajero";
	}
	
	@GetMapping("/extraer")
	public String procExtraer() {
		return "extraer";
	}
	
	@PostMapping("/extraer")
	public String procExtraerImporte(HttpSession miSesion, Model model, Cuenta cuenta) {
		cuentaIniciada=(Cuenta) miSesion.getAttribute("cuentaIniciada");
		if (cuentaIniciada.getSaldo()>cuenta.getSaldo()) {
			cdao.extraerCantidad(cuentaIniciada, cuenta.getSaldo());
			return "cajero";
		}else {
			model.addAttribute("mensaje", "Saldo insuficiente");
			return "extraer";
		}
	}
	
	@GetMapping("/movimientos")
	public String procMovimientos(HttpSession miSesion, Model model) {
		cuentaIniciada=(Cuenta) miSesion.getAttribute("cuentaIniciada");
		List<Movimiento> movimientos = mdao.buscarTodos(cuentaIniciada);
		model.addAttribute("movimientos", movimientos);
		model.addAttribute("idCuenta", cuentaIniciada.getIdCuenta());
		model.addAttribute("saldo", cuentaIniciada.getSaldo());
		return "movimientos";
	}
	
	@GetMapping("/transferencia")
	public String procTransferencia() {
		return "transferencia";
	}
	
	@PostMapping("/transferencia")
	public String procTransferenciaImporte(HttpSession miSesion, Model model, Cuenta cuenta) {
		cuentaIniciada=(Cuenta) miSesion.getAttribute("cuentaIniciada");
		if (cuentaIniciada.getSaldo()>cuenta.getSaldo()) {
			if (cuenta.getIdCuenta()==cuentaIniciada.getIdCuenta() || (cdao.buscarUna(cuenta.getIdCuenta())==null) ) {
				model.addAttribute("mensaje", "Cuenta de destino NO existe");
				return "transferencia";
			}else {
				cdao.ingresarCantidad(cdao.buscarUna(cuenta.getIdCuenta()), cuenta.getSaldo());
				cdao.extraerCantidad(cuentaIniciada, cuenta.getSaldo());
				return "cajero";
			}
		}else {
			model.addAttribute("mensaje", "Saldo insuficiente");
			return "transferencia";
		}
		
	}	
}
