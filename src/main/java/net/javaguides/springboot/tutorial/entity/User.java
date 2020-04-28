package net.javaguides.springboot.tutorial.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

import static org.hibernate.annotations.FetchMode.JOIN;

@Data
public class User {

    private Long id;

    private String username;
   // @Size(min=2, message = "Не меньше 5 знаков")
    private String password;
    @Transient
    private String passwordConfirm;
   /* @Fetch(JOIN)
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;*/

    private String name;

    private int age;

    private String serName;

    public User() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSerName() {
        return serName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

}
