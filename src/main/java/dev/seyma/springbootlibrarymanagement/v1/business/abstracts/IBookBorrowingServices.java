package dev.seyma.springbootlibrarymanagement.v1.business.abstracts;

import dev.seyma.springbootlibrarymanagement.v1.entities.BookBorrowing;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookBorrowingServices {
    BookBorrowing save(BookBorrowing bookBorrowing);
    BookBorrowing update(BookBorrowing bookBorrowing);
    BookBorrowing getId(long id);
    Page<BookBorrowing> cursor(int page, int pageSize);
    boolean delete(long id);
}
