package com.uy.business.proveedor.repository;


import com.uy.business.proveedor.domain.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>, QueryByExampleExecutor<Proveedor> {
    //Para busquedas con filtros
}
