package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.category.CategoryService;
import com.ra.model.service.file.UploadService;
import com.ra.model.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UploadService uploadService;
    @GetMapping
    public String index(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "product/index";
    }
    @GetMapping("/add")
    public String add(Model model,Product product){
        model.addAttribute("product",product);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "product/add";
    }
    @PostMapping("/add")
    public String create(@ModelAttribute Product product, @RequestParam("img") MultipartFile file){
        // upload ảnh
        if(file != null){
           String productImage =  uploadService.upload(file);
           product.setImage(productImage);
        }
        // thêm mới sản phẩm
        if(productService.create(product)){
            return "redirect:/product";
        }
        return "redirect:/product/add";
    }
}
