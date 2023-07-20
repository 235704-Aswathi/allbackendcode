package org.example.Controller;

import org.example.Entity.domain;
import org.example.Repository.repo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("")
public class controoler {

    @Autowired
    private repo r;

    @GetMapping()
    public ResponseEntity<List<domain>> getAll(){
        List<domain> list=r.findAll();
        if(list.isEmpty()){
            return  ResponseEntity.ok().build();
        }
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/map/{id}")
    public ResponseEntity<domain>getElement(@PathVariable int id){
        Optional<domain> op=r.findById(id);
        if(op.isPresent()){
            domain d1= op.get();
            return ResponseEntity.ok().body(d1);
        }
            return  ResponseEntity.noContent().build();
        }

    @PostMapping("/map")
    public ResponseEntity<domain> create( @RequestBody domain d){
        domain d1=r.save(d);
        return  ResponseEntity.ok().body(d1);
    }
    @DeleteMapping("/map/{id}")
    public  ResponseEntity<domain> delete(@PathVariable int id){
        Optional<domain> op=r.findById(id);
        if(op.isPresent()){
             r.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();

    }
    @PutMapping("/map/{id}")
    public  ResponseEntity<domain>update(@PathVariable int id, @RequestBody domain d){
        Optional<domain> op=r.findById(id);
        if(op.isPresent()){
          domain dom= op.get();
          dom.setId(id);
          dom.setName(d.getName());
           r.save(dom);
          return  ResponseEntity.ok().body(dom);
        }
        return ResponseEntity.noContent().build();
    }




}
