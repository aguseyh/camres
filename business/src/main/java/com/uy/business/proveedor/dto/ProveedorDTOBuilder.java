package com.uy.business.proveedor.dto;

import com.uy.business.proveedor.domain.Proveedor;

import java.util.function.Consumer;

public class ProveedorDTOBuilder {

    public Proveedor resultado;

    public ProveedorDTOBuilder with(Consumer<ProveedorDTOBuilder> builderFunction){
        builderFunction.accept(this);
        return this;
    }

    public ProveedorDTO create() {
        ProveedorDTO target = new ProveedorDTO();
        target.setId(resultado.getId());
        target.setRut(resultado.getRut());
        target.setNombre(resultado.getNombre());

        return target;
    }

}
