package com.fiap.digidine.applications.service;

import com.fiap.digidine.applications.ports.inbound.RemoveProductInputPort;
import com.fiap.digidine.applications.ports.outbound.RemoveProductOutputPort;

import java.util.UUID;

public class RemoveProductService implements RemoveProductInputPort {

    private RemoveProductOutputPort removeProductOutputPort;

    public RemoveProductService(RemoveProductOutputPort removeProductOutputPort){
        this.removeProductOutputPort=removeProductOutputPort;
    }

    @Override
    public void removeProduct(UUID id){
        removeProductOutputPort.removeProduct(id);
    }


}
