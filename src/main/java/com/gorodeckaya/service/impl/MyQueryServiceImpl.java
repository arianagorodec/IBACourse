package com.gorodeckaya.service.impl;

import com.gorodeckaya.entity.MyQuery;
import com.gorodeckaya.repository.MyQueryRepository;
import com.gorodeckaya.service.MyQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
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
    public List<Object[]> createQuery(String query) throws SQLException {
        return em.createNativeQuery(query).getResultList();
    }
    public List<Object> tableSearch() throws SQLException {
        return em.createNativeQuery("SHOW TABLES;").getResultList();
    }
    public List<Object[]> tableDataSearch(String table) throws SQLException {
        return em.createNativeQuery("DESCRIBE "+table+";").getResultList();
    }
    @Override
    public MyQuery addMyQuery(MyQuery myQuery) {
        return myQueryRepository.saveAndFlush(myQuery);
    }
}
