package io.github.nathanc5york.model;
import java.util.List;
import java.time.LocalDate;
public class Workout {
    private List<Exercise> exercises;
    private LocalDate date;
    private String name;
    private double totalCaloriesBurned;
    public Workout(String name, LocalDate date, List<Exercise> exercises) {
        this.name = name;
        this.date = date;
        this.exercises = exercises;
        this.totalCaloriesBurned = calculateTotalCalories();
    }
    
    public Workout(String name, List<Exercise> exercises) {
        this.name = name;
        this.date = LocalDate.now();
        this.exercises = exercises;
        this.totalCaloriesBurned = calculateTotalCalories();
    }

    public void addExercise(Exercise exercise){
        exercises.add(exercise);
        totalCaloriesBurned = calculateTotalCalories();
    }

    public void removeExercise(Exercise exercise){
        exercises.remove(exercise);
        totalCaloriesBurned = calculateTotalCalories();
    }

    public double calculateTotalCalories(){
        double total = 0;
        for (Exercise e : exercises){
            total += e.caloriesBurned();
        }
        return total;
    }

    public String toString(){
        String fString = "Workout Name: %s\nDate: %s\nTotal Calories Burned: %.2f\nExercises:\n".formatted(name, date.toString(), totalCaloriesBurned);
        for (Exercise e : exercises){
            fString += e.toString() + "\n\n";
        }
        return fString;
    }
}
