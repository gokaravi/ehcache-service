package com.ravi.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ravi Goka on 11/18/2018.
 */
public class Teachers implements Serializable{

    public Teachers(List<Teacher> teachers){
        this.teachers = teachers;
    }
    private List<Teacher> teachers;

    public List<Teacher> getTeachers() {
        return teachers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Teachers{");
        sb.append("teachers=").append(teachers);
        sb.append('}');
        return sb.toString();
    }
}
