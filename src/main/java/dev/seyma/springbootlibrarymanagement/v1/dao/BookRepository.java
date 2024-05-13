package dev.seyma.springbootlibrarymanagement.v1.dao;

import dev.seyma.springbootlibrarymanagement.v1.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
