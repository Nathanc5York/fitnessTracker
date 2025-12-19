package io.github.nathanc5york;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.nathanc5york.model.StrengthExercise;
import io.github.nathanc5york.model.Intensity;
import io.github.nathanc5york.model.CardioExercise;
import io.github.nathanc5york.model.Workout;
import io.github.nathanc5york.observer.SaveObserver;
import io.github.nathanc5york.factory.ExerciseFactory;
import io.github.nathanc5york.model.Exercise;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Unit test for simple App.
 */
public class ExerciseTests 
{

    @Test
    public void basicStrengthExercise() {
        StrengthExercise se = new StrengthExercise("Push Ups", Intensity.MEDIUM, 20, 0, "Chest, Triceps", "lbs");
        String expected = "Category: Strength\nName: Push Ups\nTargeted Muscles: Chest, Triceps\nWeight: 0 lbs\nReps: 20\nIntensity: MEDIUM\nCalories Burned: 2.00";
        assertTrue(se.toString(), se.toString().equals(expected));
    }

    @Test
    public void strengthExerciseCalorieTest(){
        StrengthExercise se = new StrengthExercise("Bench Press", Intensity.HIGH, 6, 125, "Chest", "lbs");
        double expectedCalories = 6 * 0.15 + (125 * 0.15); // 0.15 per rep + 0.15 per pound
        assertTrue(se.caloriesBurned() == expectedCalories);
    }

    @Test
    public void basicCardioExercise() {
        CardioExercise ce = new CardioExercise("Running", Intensity.HIGH, 30);
        String expected = "Category: Cardio\nName: Running\nDuration: 30 Minutes\nIntensity: HIGH\nCalories Burned: 120.00";
        assertTrue(ce.toString().equals(expected));
    }

    @Test
    public void basicWorkout() {
        ArrayList<Exercise> exercises = new ArrayList<>();
        exercises.add(new StrengthExercise("Push Ups", Intensity.MEDIUM, 20, 0, "Chest, Triceps", "lbs"));
        exercises.add(new CardioExercise("Running", Intensity.HIGH, 30));
        Workout workout = new Workout("Morning Routine", exercises);
        String expectedStart = "Workout Name: Morning Routine\nDate: ";
        assertTrue(workout.toString().startsWith(expectedStart));
    }

    @Test
    public void exerciseFactoryTest(){
        Map<String, Object> strengthParams = new HashMap<>();
        strengthParams.put("name", "Push Ups");
        strengthParams.put("intensity", Intensity.MEDIUM);
        strengthParams.put("reps", 20);
        strengthParams.put("weight", 0);
        strengthParams.put("targetedMuscles", "Chest, Triceps");
        strengthParams.put("weightUnit", "lbs");
        Exercise se = ExerciseFactory.createExercise("StrengthExercise", strengthParams);
        assertTrue(se instanceof StrengthExercise);
        
        Map<String, Object> cardioParams = new HashMap<>();
        cardioParams.put("name", "Running");
        cardioParams.put("intensity", Intensity.HIGH);
        cardioParams.put("durationMinutes", 30);
        Exercise ce = ExerciseFactory.createExercise("CardioExercise", cardioParams);
        assertTrue(ce instanceof CardioExercise);
    }
}
