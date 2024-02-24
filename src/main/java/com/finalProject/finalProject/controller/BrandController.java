package com.finalProject.finalProject.controller;

import com.finalProject.finalProject.dto.BrandDto;
import com.finalProject.finalProject.entity.Brand;
import com.finalProject.finalProject.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BrandController {
    @Autowired
    BrandService brandService;
    @PostMapping("/brands")
    public String Brand(@RequestBody BrandDto brandDto){
        return brandDto.toString();
    }

    @PostMapping("/brand")
    public Brand insertBrand(@RequestBody BrandDto brandDto){
        return brandService.insertBrand(brandDto);
    }

    @GetMapping("/brand")
    public List<Brand> showBrand(){
        return brandService.showBrand();
    }
}
