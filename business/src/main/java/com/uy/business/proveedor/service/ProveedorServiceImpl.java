package com.uy.business.proveedor.service;

import com.uy.business.proveedor.domain.Proveedor;
import com.uy.business.proveedor.domain.builder.ProveedorBuilder;
import com.uy.business.proveedor.dto.ProveedorDTO;
import com.uy.business.proveedor.dto.ProveedorDTOBuilder;
import com.uy.business.proveedor.exception.ProveedorException;
import com.uy.business.proveedor.repository.ProveedorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private static Logger logger = LoggerFactory.getLogger(ProveedorServiceImpl.class);

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    //@Transactional(propagation = Propagation.REQUIRED, rollbackOn = {ProveedorException.class})
    public Integer crearProveedor(ProveedorDTO proveedorDto) throws ProveedorException {
        try{
            Proveedor proovedor = new ProveedorBuilder()
                    .with(p -> p.resultado = proveedorDto)
                    .create();
            proovedor = this.proveedorRepository.save(proovedor);
            return proovedor.getId();
        } catch (DataIntegrityViolationException e) {
            String msj = "No se pueden almacenar los datos del proveedor";
            logger.error(msj, e);
            throw new ProveedorException(msj);
        }
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRED, rollbackOn = {ProveedorException.class})
    public Integer modificarProveedor(ProveedorDTO proveedorDTO) throws ProveedorException {
        final Integer id = proveedorDTO.getId();

        try{
            final Proveedor proveedor = this.proveedorRepository.findById(id).orElseThrow(() -> new ProveedorException("No se encontro proveedor con id : " + id));

            new ProveedorBuilder().with(p -> p.resultado = proveedorDTO).with(p -> p.original = proveedor).update();

            this.proveedorRepository.save(proveedor);

            return id;
        } catch (ProveedorException e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRED, rollbackOn = {ProveedorException.class})
    public ProveedorDTO obtenerProveedor(Integer id) throws ProveedorException {
        try {
            Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
            return (new ProveedorDTOBuilder()).with(p -> p.resultado = proveedor).create();
        } catch (Exception e) {
            String mje = "Ha ocurrido un error al obtener el proveedor";
            logger.error(mje, e);
            throw new ProveedorException(mje);
        }
    }

    @Override
    public List<ProveedorDTO> obtenerProveedores() throws ProveedorException {
        try {
            List<Proveedor> listProveedores = this.proveedorRepository.findAll();

            List<ProveedorDTO> listDTOProveedores = listProveedores
                    .stream()
                    .map(p -> new ProveedorDTOBuilder().with(pr -> pr.resultado = p).create())
                    .collect(Collectors.toList());

            return listDTOProveedores;
        } catch (Exception e) {
            String msj = "Error al obtener los proveedores";
            logger.error(msj, e);
            throw new ProveedorException();
        }
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRED, rollbackOn = {ProveedorException.class})
    public void borrarProveedor(List<Integer> ids) throws ProveedorException{
        try {
            for (Integer id : ids){
                Proveedor proveedor = this.proveedorRepository.findById(id).orElseThrow(() -> new ProveedorException("No se encontro proveedor con id : " + id));

                this.proveedorRepository.delete(proveedor);
            }
        } catch (ProveedorException e) {
            logger.error(e.getMessage(), e);
        }
    }
}

