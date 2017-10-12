package com.springapp.mvc.model;

import javax.persistence.*;

@Entity
@Table (name="users")
public class User {
    @Id
    private Long Id;
    @Column (name="name")
    private String userName;
    @Column (name ="password")
    private String password;
    @Column (name ="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column (name="age")
    private int age;

    public User(){
        //for hibernate
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, Gender gender, int age) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.age=age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (!userName.equals(user.userName)) return false;
        if (!password.equals(user.password)) return false;
        return gender == user.gender;
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
