package com.finalProject.finalProject.repo;

import com.finalProject.finalProject.dto.CartDto;
import com.finalProject.finalProject.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    public List<Cart> findByUserId(Long id);

    Optional<Cart> findByUserIdAndProductId(Long userId, Long productId);

//    Cart save(Long userId, Long productId);
}
