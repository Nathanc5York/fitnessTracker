package io.github.nathanc5york.model;
import java.util.List;
import java.time.LocalDate;
/**
 * Represents a Workout consisting of multiple exercises, with methods to manage and analyze them.
 * @author Nathan Chung
 * @version 1.0
 * @since 2025-12-18
 */
public class Workout {
    private List<Exercise> exercises;
    private LocalDate date;
    private String name;
    private double totalCaloriesBurned;
    /**
     * A basic constructor for Workout that allows for the date to be set given a inputted date.
     * @param name
     * @param date
     * @param exercises
     */
    public Workout(String name, LocalDate date, List<Exercise> exercises) {
        this.name = name;
        this.date = date;
        this.exercises = exercises;
        this.totalCaloriesBurned = calculateTotalCalories();
    }
    /**
     * A basic constructor for Workout that sets the date to the current date.
     * @param name
     * @param exercises
     */
    public Workout(String name, List<Exercise> exercises) {
        this.name = name;
        this.date = LocalDate.now();
        this.exercises = exercises;
        this.totalCaloriesBurned = calculateTotalCalories();
    }

    /**
     * Adds an exercise to the workout.
     * @param exercise
     */
    public void addExercise(Exercise exercise){
        exercises.add(exercise);
        totalCaloriesBurned = calculateTotalCalories();
    }

    /**
     * Removes an exercise from the workout.
     * @param exercise
     */
    public void removeExercise(Exercise exercise){
        exercises.remove(exercise);
        totalCaloriesBurned = calculateTotalCalories();
    }

    /**
     * Calculates the total calories burned in the workout.
     * @return total calories burned
     */
    public double calculateTotalCalories(){
        double total = 0;
        for (Exercise e : exercises){
            total += e.caloriesBurned();
        }
        return total;
    }

    /**
     * Gets the exercise at the specified index.
     * @param index
     * @return exercise at the specified index
     */
    public Exercise getExercise(int index){
        return exercises.get(index);
    }
    
    /**
     * Finds and returns the exercise that burned the most calories in the workout.
     * @return the exercise that burned the most calories
     */
    public Exercise mostCaloricExercise(){
        if (exercises.isEmpty()){
            return null;
        }
        Exercise mostCaloric = exercises.get(0);
        for (Exercise e : exercises){
            if (e.caloriesBurned() > mostCaloric.caloriesBurned()){
                mostCaloric = e;
            }
        }
        return mostCaloric;
    }

    public String toString(){
        String fString = "Workout Name: %s\nDate: %s\nTotal Calories Burned: %.2f\nExercises:\n".formatted(name, date.toString(), totalCaloriesBurned);
        for (Exercise e : exercises){
            fString += e.toString() + "\n\n";
        }
        return fString;
    }
}
