package com.fiap.digidine.infrastructure.controllers.dtos;

public record CustomerResponse(long customerNumber, String cpf, String name, String email){
}
