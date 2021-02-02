package com.uy.business.proveedor.controller;


import com.uy.business.proveedor.dto.ProveedorDTO;
import com.uy.business.proveedor.exception.ProveedorException;
import com.uy.business.proveedor.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProveedorController implements ProveedorResource {

    private ProveedorService proveedorService;

    @Autowired
    public ProveedorController(ProveedorService proveedorService){
        this.proveedorService = proveedorService;
    }

    @Override
    public Integer crearProveedor(ProveedorDTO proveedorDTO) throws ProveedorException {
        Integer id = this.proveedorService.crearProveedor(proveedorDTO);
        return id;
    }

    @Override
    public Integer modificarProveedor(ProveedorDTO proveedorDTO) throws ProveedorException {
        Integer id = this.proveedorService.modificarProveedor(proveedorDTO);
        return id;
    }

    @Override
    public ProveedorDTO obtenerProveedor(Integer id) throws ProveedorException {
        return this.proveedorService.obtenerProveedor(id);
    }

    @Override
    public List<ProveedorDTO> obtenerProveedores() throws ProveedorException {
        return this.proveedorService.obtenerProveedores();
    }

    @Override
    public ProveedorDTO buscarProveedor() throws ProveedorException {
        //Busqueda por filtro
        return null;
    }

    @Override
    public void borrarProovedores(List<Integer> ids) throws ProveedorException {
        this.proveedorService.borrarProveedor(ids);
    }
}
