package com.fiap.digidine.applications.ports.outbound;

import java.util.UUID;

public interface RemoveProductOutputPort {

    void removeProduct(UUID id);
}
