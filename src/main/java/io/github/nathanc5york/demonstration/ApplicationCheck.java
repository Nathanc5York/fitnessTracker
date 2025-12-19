package io.github.nathanc5york.demonstration;
import io.github.nathanc5york.model.*;
import io.github.nathanc5york.observer.WorkoutLog;
import io.github.nathanc5york.observer.SaveObserver;
import io.github.nathanc5york.model.Intensity;
import io.github.nathanc5york.factory.ExerciseFactory;
import java.util.ArrayList;
import java.util.Map;
import java.io.*;
import java.util.HashMap;
/**
 * A simple demonstration application to showcase the functionality of the fitness tracker classes.
 * @author Nathan Chung
 * @version 1.0
 * @since 2025-12-18
 */
public class ApplicationCheck {
    public static void main(String[] args) {
        StrengthExercise se = new StrengthExercise("Deadlift", Intensity.HIGH, 5, 200, "Back, Legs", "lbs");
        CardioExercise ce = new CardioExercise("Cycling", Intensity.MEDIUM, 45);
        System.out.println("Individual Strength Exercise:\n");
        System.out.println(se.toString());
        System.out.println("\nIndividual Cardio Exercise:\n");
        System.out.println(ce.toString());

        ArrayList<Exercise> exercises = new ArrayList<>();
        StrengthExercise seTwo = new StrengthExercise("Squats", Intensity.MEDIUM, 10, 150, "Legs", "lbs");
        exercises.add(se);
        exercises.add(ce);
        exercises.add(seTwo);
        Workout workout = new Workout("Full Body Workout", exercises);
        System.out.printf("Total Calories: %.2f\n", workout.calculateTotalCalories());

        Map<String, Object> StrengthParams = new HashMap<>();
        StrengthParams.put("name", "Bench Press");
        StrengthParams.put("intensity", Intensity.HIGH);
        StrengthParams.put("reps", 8);
        StrengthParams.put("weight", 180);
        StrengthParams.put("targetedMuscles", "Chest, Triceps");
        StrengthParams.put("weightUnit", "lbs");
        Exercise factoryStrengthExercise = ExerciseFactory.createExercise("Strength", StrengthParams);
        System.out.printf("\nFactory Created Strength Exercise:\n%s\n", factoryStrengthExercise.toString());

        WorkoutLog log = new WorkoutLog();
        SaveObserver saver = new SaveObserver();
        log.addObserver(saver);
        log.newestWorkout(workout);
    }
}
