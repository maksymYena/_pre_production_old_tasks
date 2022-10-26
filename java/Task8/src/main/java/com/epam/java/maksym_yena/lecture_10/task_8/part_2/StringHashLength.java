package com.epam.java.maksym_yena.lecture_10.task_8.part_2;

import java.util.Objects;

public class StringHashLength {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StringHashLength(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringHashLength that = (StringHashLength) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name.length();
    }

    @Override
    public String toString() {
        return  name + '\'';
    }
}
