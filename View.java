import model.Toy;

import java.util.List;
import java.util.Scanner;

public class View {
    Scanner sc = new Scanner(System.in);

    public Integer menuInput() {
        while (true) {
            System.out.print("[ 1 | Тянуть ] [ 2 | Счёт ] [ 3 | Выход ]\n> ");
            String userInput = sc.nextLine().trim();

            if (isValidInteger(userInput)) {
                int choice = Integer.parseInt(userInput);
                if (choice >= 1 && choice <= 3) return choice;
                else System.out.println("Некорректное число, давай заново. ");
            } else System.out.println("Некорректный ввод, давай заново. ");
        }
    }

    public Integer toysInput(List<Toy> toys) {
        while (true) {
        System.out.println("Какую игрушку хочешь вытащить?");
        for (int i = 1; i <= toys.size(); i++) {
            System.out.println("[ " + i + " | " + toys.get(i - 1) + " ]");
        }
        System.out.print("> ");
        String userInput = sc.nextLine().trim();

            if (isValidInteger(userInput)) {
                int choice = Integer.parseInt(userInput);
                if (choice >= 1 && choice <= toys.size()) return choice;
                else System.out.println("Некорректное число, давай заново. ");
            } else System.out.println("Некорректный ввод, давай заново. ");
        }
    }

    private boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
