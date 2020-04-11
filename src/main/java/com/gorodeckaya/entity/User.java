package com.gorodeckaya.entity;

import com.gorodeckaya.entity.enums.RoleEnum;
import com.gorodeckaya.entity.enums.RoleEnum;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="user")

public class User implements UserDetails {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name= "native", strategy= "native")
    @Column(name = "id_user", length = 11, nullable = false)
    private long id;

    @Transient
    private String passwordConfirm;


    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    @Column(name = "role")
    private RoleEnum role;

    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    public User() {
    }

    public User(String passwordConfirm, RoleEnum role, String username, String password) {
        this.passwordConfirm = passwordConfirm;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority(role.getAuthority()));

        return list;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
