package dev.seyma.springbootlibrarymanagement.v1.dao;

import dev.seyma.springbootlibrarymanagement.v1.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
