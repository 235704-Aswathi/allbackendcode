package org.customer.Services;

import org.customer.Domain.Customer;
import org.customer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerServices{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<Customer> getById(int id){

         return  customerRepository.findById(id);
    }
    @Override
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
    @Override
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }
   @Override
    public void delete(int id){
       customerRepository.deleteById(id);
   }


//   @Override
//    public Optional<Customer> getByEmail(String email){
//        return customerRepository.findByEmail(email);
//   }
   @Override
    public Optional<Customer> getEmailAndPassword(String email, String password){
        return customerRepository.findByEmailAndPassword(email, password);
   }

    @Override
    public Optional<Customer> getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

}
