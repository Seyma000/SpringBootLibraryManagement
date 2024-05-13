package dev.seyma.springbootlibrarymanagement.v1.api;

import dev.seyma.springbootlibrarymanagement.v1.business.abstracts.ICategoryServices;
import dev.seyma.springbootlibrarymanagement.v1.core.config.ModelMapper.ModelMapperServices;
import dev.seyma.springbootlibrarymanagement.v1.core.result.Result;
import dev.seyma.springbootlibrarymanagement.v1.core.result.ResultData;
import dev.seyma.springbootlibrarymanagement.v1.core.utilities.ResultHelper;
import dev.seyma.springbootlibrarymanagement.v1.dto.request.category.CategorySaveRequest;
import dev.seyma.springbootlibrarymanagement.v1.dto.request.category.CategoryUpdateRequest;
import dev.seyma.springbootlibrarymanagement.v1.dto.response.CursorResponse;
import dev.seyma.springbootlibrarymanagement.v1.dto.response.category.CategoryResponse;
import dev.seyma.springbootlibrarymanagement.v1.entities.Category;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryServices categoryServices;
    private final ModelMapperServices mapperService;

    @GetMapping("{id}")
    public ResultData<CategoryResponse> getId(@PathVariable long id) {
        CategoryResponse response = mapperService.forResponse().map(categoryServices.getId(id), CategoryResponse.class);
        return ResultHelper.OK(response);
    }

    @PostMapping
    public ResultData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest saveRequest) {
        CategoryResponse response = mapperService.forResponse().map(categoryServices.save(mapperService.forRequest().map(saveRequest, Category.class)), CategoryResponse.class);
        return ResultHelper.CREATED(response);
    }

    @PostMapping
    public ResultData<CategoryResponse> update(@Valid @RequestBody CategoryUpdateRequest updateRequest) {
        CategoryResponse response = mapperService.forResponse().map(categoryServices.update(mapperService.forRequest().map(updateRequest, Category.class)), CategoryResponse.class);
        return ResultHelper.CREATED(response);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable long id) {
        return ResultHelper.OK(categoryServices.delete(id));
    }

    @GetMapping
    public ResultData<CursorResponse<CategoryResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Page<Category> pages = categoryServices.cursor(page, pageSize);
        Page<CategoryResponse> responses = pages.map(category -> mapperService.forResponse().map(category, CategoryResponse.class));
        return ResultHelper.cursor(responses);
    }
}