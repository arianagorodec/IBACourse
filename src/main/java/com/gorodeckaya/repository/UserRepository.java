package com.gorodeckaya.repository;

import com.gorodeckaya.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("select u from User u where u.username = :username")
//    User findByLogin(@Param("username") String name);

    User findByUsername(String username);
}