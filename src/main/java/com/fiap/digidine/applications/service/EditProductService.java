package com.fiap.digidine.applications.service;

import com.fiap.digidine.applications.ports.inbound.EditProductInputPort;
import com.fiap.digidine.applications.ports.outbound.EditProductOutputPort;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;

public class EditProductService implements EditProductInputPort {

    private EditProductOutputPort editProductOutputPort;

    public EditProductService(EditProductOutputPort editProductOutputPort){
        this.editProductOutputPort = editProductOutputPort;
    }

    @Override
    public ProductEntity editProduct(ProductEntity product) {
        return editProductOutputPort.editProduct(product);
    }

}
