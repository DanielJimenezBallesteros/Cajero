package com.daniel.cajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.cajero.entitybeans.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{

}
