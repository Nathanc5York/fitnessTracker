package io.github.nathanc5york.observer;
import io.github.nathanc5york.model.Workout;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
/**
 * Observer implementation that saves workout data to a file when updated.
 * @author Nathan Chung
 * @version 1.0
 * @since 2025-12-18
 */
public class SaveObserver implements Observer {
    @Override
    /**
     * Given an inputted workout, saves its data to a file named "previousLogs.txt".
     * @param workout
     */
    public void update(Workout workout) {
        try {
            FileWriter writeToFile = new FileWriter("previousLogs.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writeToFile);
            bufferedWriter.write(workout.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            System.out.println("Workout saved to previousLogs.txt");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
