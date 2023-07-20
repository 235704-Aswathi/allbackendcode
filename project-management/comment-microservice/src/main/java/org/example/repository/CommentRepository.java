package org.example.repository;

import org.example.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,String> {

    Optional<List<Comment>> findByTaskId(String taskId);
}
