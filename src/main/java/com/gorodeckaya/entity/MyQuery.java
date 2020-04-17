package com.gorodeckaya.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Table;

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

    public MyQuery() {
    }

    public MyQuery(String query, String user) {
        this.query = query;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
