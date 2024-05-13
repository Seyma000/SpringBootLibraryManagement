package dev.seyma.springbootlibrarymanagement.v1.dao;

import dev.seyma.springbootlibrarymanagement.v1.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowingRepository extends JpaRepository<BookBorrowing, Long> {
}
