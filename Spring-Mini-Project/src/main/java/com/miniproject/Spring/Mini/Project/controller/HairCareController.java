package com.miniproject.Spring.Mini.Project.controller;

import com.miniproject.Spring.Mini.Project.model.HairCareCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class HairCareController {

    @GetMapping(path = "/categories")
    public HairCareCategory
}