import model.Toy;
import model.ToyMachine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    String filePath = "history.txt";

    public void welcomeLog() throws IOException {
        File file = new File(this.filePath);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(getDate() + "Запуск автомата.");
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    public void drawLog(Toy target, ToyMachine model) throws IOException {
        StringBuilder sb = new StringBuilder();

        if (target == null) {
            sb.append("Не повезло вытянуть игрушку.\n");
        } else {
            sb.append("Повезло вытянуть игркушку ").append(target.getName()).append("\n");
        }
        sb.append(String.format("Шанс на выигрыш: %.2f%%\n", model.getDrawChance()));
        sb.append(String.format("Шанс игрока на провал: %.2f%%\n", model.getUserChance()));
        sb.append(String.format("Текущее количество очков игрока: %.2f", model.getUserScore()));

        writeToHistory(sb.toString());
    }

    public void goodbyeLog() throws IOException {
        writeToHistory("До встречи!");
    }

    public void writeToHistory(String data) throws IOException {
        FileWriter fileWriter = new FileWriter(this.filePath, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(getDate() + data);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    public String getDate() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("[ dd.MM.yyyy | HH:mm:ss ] ");
        return dateFormat.format(currentDate);
    }
}
