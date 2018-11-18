package com.ravi.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ravi Goka on 5/11/2017.
 */
public class Users implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5605748419820569559L;

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
