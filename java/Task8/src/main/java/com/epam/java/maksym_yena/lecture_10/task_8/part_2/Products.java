package com.epam.java.maksym_yena.lecture_10.task_8.part_2;

import java.util.Objects;

public class Products {
    String name;
    int counter;

    public Products(String name, int counter) {
        this.name = name;
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", counter=" + counter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return counter == products.counter &&
                Objects.equals(name, products.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, counter);
    }
}
