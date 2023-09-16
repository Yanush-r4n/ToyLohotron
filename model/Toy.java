package model;

public class Toy {
    String name;
    Double weight;
    Integer count;

    public Toy(String name, Double weight, Integer count) {
        this.name = name;
        this.weight = weight;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return getName();
    }
}
