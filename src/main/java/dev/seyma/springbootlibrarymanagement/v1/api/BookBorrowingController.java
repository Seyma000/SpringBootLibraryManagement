package dev.seyma.springbootlibrarymanagement.v1.api;

import dev.seyma.springbootlibrarymanagement.v1.business.abstracts.IBookBorrowingServices;
import dev.seyma.springbootlibrarymanagement.v1.core.config.ModelMapper.ModelMapperServices;
import dev.seyma.springbootlibrarymanagement.v1.core.result.Result;
import dev.seyma.springbootlibrarymanagement.v1.core.result.ResultData;
import dev.seyma.springbootlibrarymanagement.v1.core.utilities.ResultHelper;
import dev.seyma.springbootlibrarymanagement.v1.dto.request.book.BookSaveRequest;
import dev.seyma.springbootlibrarymanagement.v1.dto.request.bookBorrowing.BookBorrowingUpdateRequest;
import dev.seyma.springbootlibrarymanagement.v1.dto.response.CursorResponse;
import dev.seyma.springbootlibrarymanagement.v1.dto.response.bookBorrowing.BookBorrowingResponse;
import dev.seyma.springbootlibrarymanagement.v1.entities.BookBorrowing;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/authors")
@RequiredArgsConstructor
public class BookBorrowingController {
    private final IBookBorrowingServices bookBorrowingServices;
    private final ModelMapperServices mapperService;

    @GetMapping("{id}")
    public ResultData<BookBorrowingResponse> getId(@PathVariable long id) {
        BookBorrowingResponse response = mapperService.forResponse().map(bookBorrowingServices.getId(id), BookBorrowingResponse.class);
        return ResultHelper.OK(response);
    }

    @PostMapping
    public ResultData<BookBorrowingResponse> save(@Valid @RequestBody BookSaveRequest saveRequest) {
        BookBorrowingResponse response = mapperService.forResponse().map(bookBorrowingServices.save(mapperService.forRequest().map(saveRequest, BookBorrowing.class)), BookBorrowingResponse.class);
        return ResultHelper.CREATED(response);
    }

    @PostMapping
    public ResultData<BookBorrowingResponse> update(@Valid @RequestBody BookBorrowingUpdateRequest updateRequest) {
        BookBorrowingResponse response = mapperService.forResponse().map(bookBorrowingServices.update(mapperService.forRequest().map(updateRequest, BookBorrowing.class)), BookBorrowingResponse.class);
        response.setMail(response.getMail());
        return ResultHelper.CREATED(response);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable long id) {
        return ResultHelper.OK(bookBorrowingServices.delete(id));
    }

    @GetMapping
    public ResultData<CursorResponse<BookBorrowingResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Page<BookBorrowing> pages = bookBorrowingServices.cursor(page, pageSize);
        Page<BookBorrowingResponse> responses = pages.map(category -> mapperService.forResponse().map(category, BookBorrowingResponse.class));
        return ResultHelper.cursor(responses);
    }
}