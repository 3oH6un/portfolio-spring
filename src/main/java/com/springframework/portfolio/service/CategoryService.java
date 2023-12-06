package com.springframework.portfolio.service;

import com.springframework.portfolio.dto.request.CategoryAddRequest;
import com.springframework.portfolio.dto.request.CategoryUpdateRequest;
import com.springframework.portfolio.dto.response.CategoryResponse;
import com.springframework.portfolio.entity.Category;
import com.springframework.portfolio.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public CategoryResponse insertCategory(CategoryAddRequest request) {

        Category category = Category.builder().name(request.getName()).build();
        categoryRepository.save(category);

        return new CategoryResponse(category);
    }

    @Transactional(readOnly = true)
    public List<CategoryResponse> selectAllCategories() {

        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long updateCategory(Long num, CategoryUpdateRequest request) {

        Category category = categoryRepository.findById(num).orElseThrow(
                () -> new IllegalStateException("해당 카테고리가 존재하지 않습니다.")
        );

        return category.updateCategory(request.getName()).getNum();
    }

    @Transactional
    public void deleteCategory(Long num) {

        categoryRepository.delete(categoryRepository.findById(num).orElseThrow(() -> new IllegalStateException("해당 카테고리가 존재하지 않습니다.")));
    }

    @Transactional
    public Category getCategoryReference(Long num) {

            return categoryRepository.getReferenceById(num);
    }
}
