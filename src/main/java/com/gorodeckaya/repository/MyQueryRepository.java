package com.gorodeckaya.repository;


import com.gorodeckaya.entity.MyQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public interface MyQueryRepository extends JpaRepository<MyQuery, Long> {
    public MyQuery findById(long id);
}
