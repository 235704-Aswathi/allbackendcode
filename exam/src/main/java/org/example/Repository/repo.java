package org.example.Repository;

import org.example.Entity.domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo extends JpaRepository<domain,Integer> {
}
