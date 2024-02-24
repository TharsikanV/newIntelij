package com.finalProject.finalProject.repo;

import com.finalProject.finalProject.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
