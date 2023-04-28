package com.miniproject.Spring.Mini.Project.repository;

import com.miniproject.Spring.Mini.Project.model.HairCareCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HairCareRepository extends JpaRepository<HairCareCategory, Long> {
    HairCareCategory findByName(String name);

    HairCareCategory findHairCareCategoryById(Long hairCategoryId);
}

