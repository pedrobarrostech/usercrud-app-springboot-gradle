package com.pedroaugust8.usercrud;

import java.util.Objects;

/**
 * @author Pedro Barros
 */
public class User {
    private String id;
    private String username;
    private String password;

    User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getid() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    @Override
    public String toString() {
        return "User{id='" + id + "', username='" + username + "', password='" + password + "'}";
    }
}