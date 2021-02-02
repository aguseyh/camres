package com.uy.business.proveedor.dto;

import com.uy.business.commons.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorDTO extends BaseDTO implements Serializable {

    private Integer id;
    private BigInteger rut;
    private String nombre;

}
