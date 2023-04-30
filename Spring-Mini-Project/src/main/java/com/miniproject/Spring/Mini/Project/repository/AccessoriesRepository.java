package com.miniproject.Spring.Mini.Project.repository;

import com.miniproject.Spring.Mini.Project.model.Accessories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessoriesRepository extends JpaRepository<Accessories, Long> {

    // find accessories by name
    Accessories findByName(String name);

    // find accessories by id
    Accessories findAccessoriesById(Long accessoryId);

    // find accessories by category id
    Accessories findByCategoryId(Long hairCategoryId);
}
