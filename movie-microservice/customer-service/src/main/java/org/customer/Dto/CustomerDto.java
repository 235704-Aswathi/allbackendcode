package org.customer.Dto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record CustomerDto(int id,
                          @NotNull(message="name cannot be null")
                          @NotEmpty(message="name cannot be empty")
                          String name,
                          @NotNull(message="email cannot be null")
                          @NotEmpty(message="email cannot be empty" )
                          @Email(message = "please provide a valid email")
                          String email,

                          @NotNull(message="password cannot be null")
                          @NotEmpty(message="password cannot be empty" )
                          String password) {
}
