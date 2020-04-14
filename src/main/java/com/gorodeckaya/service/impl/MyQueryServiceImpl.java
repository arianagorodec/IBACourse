package com.gorodeckaya.service.impl;

import com.gorodeckaya.repository.MyQueryRepository;
import com.gorodeckaya.service.MyQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

@Service
public class MyQueryServiceImpl implements MyQueryService {
    @Autowired
    private MyQueryRepository myQueryRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public String executeQuery(String query) throws SQLException{
        em.createNativeQuery(query).executeUpdate();
        return "success";
    }
    public List createQuery(String query) throws SQLException {
        //em.createQuery(query);
        return em.createNativeQuery(query).getResultList();
    }
}
