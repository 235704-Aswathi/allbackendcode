package org.customer.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record LoginDto(
                       @NotNull(message="email cannot be null")
                       @NotEmpty(message = "email cannot be empty")
                       String email,

                       @NotNull(message="password cannot be null")
                       @NotEmpty(message = "password cannot be empty")
                       String password) {
}
