package com.miniproject.Spring.Mini.Project.controller;

import com.miniproject.Spring.Mini.Project.model.HairCareCategory;
import com.miniproject.Spring.Mini.Project.service.HairCareService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HairCareController {

    private HairCareService hairCareService;

    public void setHairCareService(HairCareService hairCareService) {
        this.hairCareService = hairCareService;
    }

    // http://localhost:9093/api/categories/
    @GetMapping(path = "/categories/")
    public List<HairCareCategory> getCategories() {
        return hairCareService.getHairCategories();
    }

    @PostMapping(path = "/categories/")
    public HairCareCategory createHairCategory(HairCareCategory hairCareObject) {
        return hairCareService.createCategory(hairCareObject);
    }
}