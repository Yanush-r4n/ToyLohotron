package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyMachine {
    List<Toy> toys;
    Double userScore;
    List<Toy> prises;
    Double drawChance;
    Double userChance;

    public ToyMachine() {
        this.toys = new ArrayList<>();
        this.userScore = 0.0;
        this.prises = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public Toy drawToy(Toy target) {
        Random random = new Random();

        Double totalWeight = 0.0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight() * toy.getCount();
        }

        setUserChance(random.nextDouble() * 100);
        setDrawChance((target.getWeight() * target.getCount() / totalWeight) * 100);

        target.setCount(target.getCount() - 1);
        if (target.getCount() == 0) {
            this.toys.remove(target);
        }

        if (this.userChance <= this.drawChance) {
            this.userScore += getDrawChance();
            System.out.println("Ты смог вытянуть игрушку " + target.getName() + "!");
            prises.add(target);
            return target;
        } else {
            System.out.println("Неудача! Попытайся ещё раз :]");
            return null;
        }
    }

    public List<Toy> getToys() {
        return toys;
    }

    public Double getUserScore() {
        return userScore;
    }

    public List<Toy> getPrises() {
        return prises;
    }

    public Double getDrawChance() {
        return drawChance;
    }

    public void setDrawChance(Double drawChance) {
        this.drawChance = drawChance;
    }

    public Double getUserChance() {
        return userChance;
    }

    public void setUserChance(Double userChance) {
        this.userChance = userChance;
    }
}
