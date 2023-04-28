package com.miniproject.Spring.Mini.Project.controller;

import com.miniproject.Spring.Mini.Project.model.HairCareCategory;
import com.miniproject.Spring.Mini.Project.service.HairCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class HairCareController {

    private HairCareService hairCareService;

    @Autowired
    public void setHairCareService(HairCareService hairCareService) {
        this.hairCareService = hairCareService;
    }

    // http://localhost:9093/api/categories/
    @GetMapping(path = "/categories/")
    public List<HairCareCategory> getCategories() {
        return hairCareService.getHairCategories();
    }

    // http://localhost:9093/api/categories/
    @PostMapping(path = "/categories/")
    public HairCareCategory createHairCategory(@RequestBody HairCareCategory hairCareObject) {
        return hairCareService.createHairCategory(hairCareObject);
    }

    // http://localhost:9093/api/categories/{categoryId}/
    @GetMapping(path = "/categories/{hairCategoryId}")
    public Optional<HairCareCategory> getHairCategory(@PathVariable  Long hairCategoryId) {
        return hairCareService.getHairCategory(hairCategoryId);
    }

    // http://localhost:9093/api/categories/{categoryId}/
    @PutMapping(path = "/categories/{hairCategoryId}")
    public HairCareCategory updateHairCategory(@PathVariable Long hairCategoryId, @RequestBody HairCareCategory hairCareObject) {
        return hairCareService.updateHairCategory(hairCategoryId, hairCareObject);
    }
}