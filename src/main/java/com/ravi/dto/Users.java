package com.ravi.dto;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yc05r2g on 5/11/2017.
 */
public class Users {

    public Users(List<User> users){
        this.users = users;
    }

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Users{");
        sb.append("users=").append(users);
        sb.append('}');
        return sb.toString();
    }
}
