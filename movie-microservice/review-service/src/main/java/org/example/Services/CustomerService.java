package org.example.Services;

import org.example.Dto.CustomerDto;

import java.util.Optional;

public interface CustomerService {

    Optional<CustomerDto> findByEmail(String email);
}

