package com.miniproject.Spring.Mini.Project.repository;

import com.miniproject.Spring.Mini.Project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HairCareRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    Category findHairCareCategoryById(Long hairCategoryId);
}

