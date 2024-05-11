package dev.seyma.springbootlibrarymanagement.v1.business.abstracts;

import dev.seyma.springbootlibrarymanagement.v1.entities.Author;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorServices {
    Author save(Author author);
    Author update(Author author);
    Author getId(long id);
    Page<Author> cursor(int page, int pageSize);
    boolean delete(long id);
}
