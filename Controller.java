import model.Toy;
import model.ToyMachine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    View view;
    ToyMachine model;
    Logger logger;

    public Controller(View view, ToyMachine model) {
        this.view = view;
        this.model = model;
        this.logger = new Logger();
    }

    public void on() throws IOException {
        boolean flag = true;
        addingToys(model);

        logger.welcomeLog();
        while (flag) {
            Integer userInput = view.menuInput();

            switch (userInput) {
                case 1 -> {
                    if (model.getToys().isEmpty()) {
                        System.out.println("Автомат с игрушками пуст! Приходите в другой раз.");
                    } else {
                        userInput = view.toysInput(model.getToys());
                        Toy result = model.drawToy(model.getToys().get(userInput - 1));
                        logger.drawLog(result, model);
                    }
                }
                case 2 -> {
                    System.out.println("Ваш текущий выигрыш:");
                    System.out.println(String.join(", ", getStringToys(model.getPrises())));
                    System.out.printf("Ваш текущий счёт: %.2f\n", model.getUserScore());
                }
                case 3 -> {
                    System.out.println("До встречи!");
                    logger.goodbyeLog();
                    flag = false;
                }
            }
        }
    }

    private List<String> getStringToys(List<Toy> toys) {
        List<String> stringToyNames = new ArrayList<>();
        for (Toy toy : toys) {
            stringToyNames.add(toy.toString());
        }
        return stringToyNames;
    }

    private void addingToys(ToyMachine model) {
        model.addToy(new Toy("Python", 250.0, 7));
        model.addToy(new Toy("Cat", 200.0, 8));
        model.addToy(new Toy("Sonic", 300.0, 3));
        model.addToy(new Toy("Eagle", 190.0, 6));
        model.addToy(new Toy("Panther", 270.0, 5));
        model.addToy(new Toy("Tails", 250.0, 3));
        model.addToy(new Toy("Shark", 300.0, 7));
        model.addToy(new Toy("Octopus", 280.0, 4));
        model.addToy(new Toy("Cobra", 150.0, 9));
        model.addToy(new Toy("Stork", 210.0, 4));
    }
}
