package com.daniel.cajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.cajero.entitybeans.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer>{

}
