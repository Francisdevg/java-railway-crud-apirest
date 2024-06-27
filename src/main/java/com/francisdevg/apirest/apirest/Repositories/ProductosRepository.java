package com.francisdevg.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francisdevg.apirest.apirest.Entities.Producto;

public interface ProductosRepository extends JpaRepository<Producto, Long>{

}
