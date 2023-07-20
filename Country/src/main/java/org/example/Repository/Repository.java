package org.example.Repository;

import org.example.Domain.entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<entity, String> {
}
