package com.gorodeckaya.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "query")
public class MyQuery {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id_query", length = 11, nullable = false)
    private long id;

    @Column(name = "query")
    private String query;
    @Column(name = "user")
    private String user;

    public MyQuery(String query, String user) {
        this.query = query;
        this.user = user;
    }
}
