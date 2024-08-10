package com.fiap.digidine.applications.service;

import com.fiap.digidine.applications.ports.inbound.EditProductInputPort;
import com.fiap.digidine.applications.ports.outbound.EditProductOutputPort;
import com.fiap.digidine.domain.model.ProductModel;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.ProductDto;

import java.util.UUID;

public class EditProductService implements EditProductInputPort {

    private EditProductOutputPort editProductOutputPort;

    public EditProductService(EditProductOutputPort editProductOutputPort){
        this.editProductOutputPort = editProductOutputPort;
    }

    @Override
    public ProductModel editProduct(ProductDto product, UUID id) {
        return editProductOutputPort.editProduct(product, id);
    }

}
