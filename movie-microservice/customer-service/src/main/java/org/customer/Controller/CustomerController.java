package org.customer.Controller;

import org.customer.Domain.Customer;
import org.customer.Dto.CustomerDto;
import org.customer.Dto.LoginDto;
import org.customer.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    private CustomerDto convertToDto(Customer customer){
        return  new CustomerDto(customer.getId(), customer.getName(), customer.getEmail(), customer.getPassword());
    }
    private Customer convertToEntity(CustomerDto customerDto){
        return  new Customer(customerDto.id(),customerDto.name(),customerDto.email(), customerDto.password());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable int id){
        final  var customer= customerServices.getById(id);
        if(customer==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        final var dto=convertToDto(customer.get());
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
//    @GetMapping()
//    public ResponseEntity<List<CustomerDto>> getAll(){
//        final var  list=customerServices.getAll();
//       List<CustomerDto> customerDtoList=new ArrayList<>();
//       if (list.isEmpty()){
//           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//       }
//       for(Customer customer:list){
//           customerDtoList.add(convertToDto(customer));
//       }
//        return ResponseEntity.status(HttpStatus.OK).body(customerDtoList);
//    }
//    @GetMapping("/email/{email}")
//    public ResponseEntity<CustomerDto> getEmail(@PathVariable String email){
//        final  var entity=customerServices.getByEmail(email).get();
//        final var dto=convertToDto(entity);
//        return ResponseEntity.status(HttpStatus.OK).body(dto);
//    }

    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerDto> getByEmail(@PathVariable String email){
           final var customer=  customerServices.getCustomerByEmail(email);
           if(customer.isEmpty()){
               return ResponseEntity.badRequest().build();
           }
           final var customer1=convertToDto(customer.get());
           return ResponseEntity.ok().body(customer1);
    }
   @PostMapping("/customer")
   public  ResponseEntity<CustomerDto> create(@RequestBody LoginDto loginDto){
         final var entity= customerServices.getEmailAndPassword(loginDto.email(), loginDto.password());
         if(entity.isEmpty()){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
       return ResponseEntity.status(HttpStatus.OK).body(convertToDto(entity.get()));
   }


    @PostMapping()
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerDto customerDto){
          final var customerEntity=   convertToEntity(customerDto);
          final var customerEntity1=  customerServices.save(customerEntity);
          final  var dto=   convertToDto(customerEntity1);
          return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable int id,@RequestBody CustomerDto customerDto){

        final var entity1= customerServices.getById(id);
        if(entity1==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
         final var entity2=  entity1.get();
         final  var entity= customerServices.save(convertToEntity(customerDto));
           return ResponseEntity.status(HttpStatus.OK).body( convertToDto(entity));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> delete(@PathVariable int id){
         final var get= customerServices.getById(id);
         if(get.isEmpty()){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         customerServices.delete(id);
         return ResponseEntity.status(HttpStatus.OK).body(null);
    }




}
