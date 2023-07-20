package org.customer.Services;

import org.customer.Domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerServices {

   Optional<Customer> getById(int id);
   List<Customer> getAll();

   Customer save(Customer customer);


   void delete(int id);

//   Optional<Customer> getByEmail(String email);

   Optional<Customer> getEmailAndPassword(String email, String password);

   Optional<Customer> getCustomerByEmail(String email);
}
