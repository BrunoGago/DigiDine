package com.fiap.digidine.applications.service;

import com.fiap.digidine.applications.ports.inbound.RemoveProductInputPort;
import com.fiap.digidine.applications.ports.outbound.RemoveProductOutputPort;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;

public class RemoveProductService implements RemoveProductInputPort {

    private RemoveProductOutputPort removeProductOutputPort;

    public RemoveProductService(RemoveProductOutputPort removeProductOutputPort){
        this.removeProductOutputPort=removeProductOutputPort;
    }

    @Override
    public void removeProduct(long id){
        removeProductOutputPort.removeProduct(id);
    }

}
