package com.uy.business.proveedor.controller;

import com.uy.business.proveedor.dto.ProveedorDTO;
import com.uy.business.proveedor.exception.ProveedorException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProveedorResource {

    @RequestMapping(
            value = "/proveedor/agregar",
            method = RequestMethod.POST//,
            //consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    Integer crearProveedor(@RequestBody ProveedorDTO proveedorDTO) throws ProveedorException;


    @RequestMapping(
            value = "/proveedor/modificar",
            method = RequestMethod.POST//,
            //consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    Integer modificarProveedor(@RequestBody ProveedorDTO proveedorDTO) throws ProveedorException;


    @RequestMapping(
            value = "/proveedor/{id}",
            method = RequestMethod.GET//,
            //produce = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    ProveedorDTO obtenerProveedor(@PathVariable("id") Integer id) throws ProveedorException;

    @RequestMapping(
            value = "/proveedores",
            method = RequestMethod.GET//,
            //consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    List<ProveedorDTO> obtenerProveedores() throws ProveedorException;

    @RequestMapping(
            value = "/proveedores/busqueda",
            method = RequestMethod.GET//,
            //consumes = MediaType.APPLICATION_JSON_VALUE,
            //produce = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    ProveedorDTO buscarProveedor(/*@ResponseBody FiltroProveedorDTO diltro*/) throws ProveedorException;


    @RequestMapping(
            value = "/proveedores/delete",
            method = RequestMethod.POST//,
            //produce = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    void borrarProovedores(@RequestBody List<Integer> ids) throws ProveedorException;


}

