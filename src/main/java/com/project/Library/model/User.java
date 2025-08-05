package com.project.Library.model;

import jakarta.persistence.Entity;

@Entity
public class User {
    
    private Long Id;
    private String Firstname;
    private String Lastname;
    private int Age;
    private String Mobile;

    
    public User(Long id, String firstname, String lastname, int age, String mobile) {
        Id = id;
        Firstname = firstname;
        Lastname = lastname;
        Age = age;
        Mobile = mobile;
    }
    
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getFirstname() {
        return Firstname;
    }
    public void setFirstname(String firstname) {
        Firstname = firstname;
    }
    public String getLastname() {
        return Lastname;
    }
    public void setLastname(String lastname) {
        Lastname = lastname;
    }
    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        Age = age;
    }
    public String getMobile() {
        return Mobile;
    }
    public void setMobile(String mobile) {
        Mobile = mobile;
    }
    
    


    
    

}
