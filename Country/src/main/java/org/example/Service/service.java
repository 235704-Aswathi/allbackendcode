package org.example.Service;


import org.example.Domain.entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class service {

    @Autowired
    private Repository repository;

    @Transactional
    public List<entity> getAll(){
        return repository.
    }


}
