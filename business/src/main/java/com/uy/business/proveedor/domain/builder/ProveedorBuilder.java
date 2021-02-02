package com.uy.business.proveedor.domain.builder;

import com.uy.business.proveedor.domain.Proveedor;
import com.uy.business.proveedor.dto.ProveedorDTO;

import java.util.function.Consumer;

public class ProveedorBuilder {

    public Proveedor original;
    public ProveedorDTO resultado;

    public ProveedorBuilder with (Consumer<ProveedorBuilder> builderFunction){
        builderFunction.accept(this);
        return this;
    }

    public Proveedor create(){

        final Proveedor target = new Proveedor();
        target.setId(resultado.getId());
        target.setRut(resultado.getRut());
        target.setNombre(resultado.getNombre());

        return target;
    }

    public void update(){
        if(resultado == null || original == null){
            return;
        }

        original.setId(resultado.getId());
        original.setRut(resultado.getRut());
        original.setNombre(resultado.getNombre());
    }

}

