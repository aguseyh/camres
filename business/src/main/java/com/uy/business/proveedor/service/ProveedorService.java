package com.uy.business.proveedor.service;

import com.uy.business.proveedor.dto.ProveedorDTO;
import com.uy.business.proveedor.exception.ProveedorException;

import java.util.List;

public interface ProveedorService {

    Integer crearProveedor(ProveedorDTO proveedorDTO) throws ProveedorException;

    Integer modificarProveedor(ProveedorDTO proveedorDTO) throws ProveedorException;

    ProveedorDTO obtenerProveedor(Integer id) throws  ProveedorException;

    List<ProveedorDTO> obtenerProveedores() throws ProveedorException;

    void borrarProveedor(List<Integer> ids) throws ProveedorException;
}
