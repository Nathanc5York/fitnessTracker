package io.github.nathanc5york.observer;
import io.github.nathanc5york.model.Workout;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class SaveObserver implements Observer {
    @Override
    public void update(Workout workout) {
        try {
            File file = new File("previousLogs.txt");
            file.createNewFile();
            FileWriter writeToFile = new FileWriter("previousLogs.txt");
            writeToFile.write(workout.toString() + "\n");
            writeToFile.close();
            System.out.println("Workout saved to previousLogs.txt");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
