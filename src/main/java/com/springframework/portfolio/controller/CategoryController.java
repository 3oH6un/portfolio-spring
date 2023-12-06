package com.springframework.portfolio.controller;

import com.springframework.portfolio.dto.request.CategoryAddRequest;
import com.springframework.portfolio.dto.request.CategoryUpdateRequest;
import com.springframework.portfolio.dto.response.CategoryResponse;
import com.springframework.portfolio.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    // 카테고리 추가
    @PostMapping
    public CategoryResponse addCategory(@RequestBody final CategoryAddRequest request) {

        return categoryService.insertCategory(request);
    }

    // 카테고리 목록 조회
    @GetMapping
    public List<CategoryResponse> findAllPost() {

        return categoryService.selectAllCategories();
    }

    @PutMapping("/{num}")
    public Long updateCategory(@PathVariable final Long num,
                               @RequestBody final CategoryUpdateRequest request) {

        return categoryService.updateCategory(num, request);
    }

    @DeleteMapping("/{num}")
    public void deleteCategory(@PathVariable final Long num) {

        categoryService.deleteCategory(num);
    }
}
