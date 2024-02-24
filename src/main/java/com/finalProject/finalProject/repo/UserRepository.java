package com.finalProject.finalProject.repo;

import com.finalProject.finalProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findOneByEmailIgnoreCaseAndPassword(String emailId, String password);

    User findByEmail(String email);


}
