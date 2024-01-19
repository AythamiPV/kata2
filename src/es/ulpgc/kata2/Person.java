package es.ulpgc.kata2;

import java.util.Objects;

public class Person {
    private final int id;
    private final double height;
    private final double weight;

    public Person(int id, double height, double weight) {
        this.id = id;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        return o != null && getClass() == o.getClass() && (this == o || equals((Person) o));
    }

    private boolean equals(Person person) {
        return id == person.id && person.height == height && person.weight == weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, height, weight);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
