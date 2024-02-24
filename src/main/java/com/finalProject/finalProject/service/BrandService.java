package com.finalProject.finalProject.service;

import com.finalProject.finalProject.dto.BrandDto;
import com.finalProject.finalProject.entity.Brand;
import com.finalProject.finalProject.repo.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    BrandRepository brandRepository;

    public List<Brand> showBrand(){
        return brandRepository.findAll();
    }

    public Brand insertBrand(BrandDto brandDto){
        Brand brand = new Brand();
        brand.setName(brandDto.getName());
        brand.setLocation(brandDto.getLocation());
        return brandRepository.save(brand);
    }
}
