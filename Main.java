import model.ToyMachine;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller(new View(), new ToyMachine());
        controller.on();
    }
}
