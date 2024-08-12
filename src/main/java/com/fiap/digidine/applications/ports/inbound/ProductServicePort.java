package com.fiap.digidine.applications.ports.inbound;


import com.fiap.digidine.applications.dto.CustomerDto;
import com.fiap.digidine.applications.dto.ProductDto;

import java.util.UUID;

public interface ProductServicePort {

    void create(ProductDto productDto);
    ProductDto get(UUID id);
}