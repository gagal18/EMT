package com.finki.lab1.controllers;

import com.finki.lab1.model.enums.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @GetMapping("/")
    public List<Category> getAllCategories() {
        return Arrays.asList(Category.values());
    }
}