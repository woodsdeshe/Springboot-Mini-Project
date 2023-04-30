package com.miniproject.Spring.Mini.Project.repository;

import com.miniproject.Spring.Mini.Project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HairCareRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    Category findHairCareCategoryById(Long hairCategoryId);

    Category findByIdAndUserId(Long hairCategoryId, Long userId);

    List<Category> findByUserId(Long userId);

    Category findByUserIdAndAndName(Long userId, String categoryName);
}

