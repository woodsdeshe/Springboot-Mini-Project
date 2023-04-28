package com.miniproject.Spring.Mini.Project.repository;

import com.miniproject.Spring.Mini.Project.model.HairCareCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HairCareRepository extends JpaRepository<HairCareCategory, Long> {
    HairCareCategory findByName(String name);
}

