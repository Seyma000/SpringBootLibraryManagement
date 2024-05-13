package dev.seyma.springbootlibrarymanagement.v1.dao;

import dev.seyma.springbootlibrarymanagement.v1.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
