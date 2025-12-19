package io.github.nathanc5york.model;
import io.github.nathanc5york.model.Intensity;
/**
 * Represents a Strength Exercise with input validation and a calorie calculation method.
 * @author Nathan Chung
 * @version 1.0
 * @since 2025-12-18
 */
public class StrengthExercise extends Exercise {
    private int reps, weight;
    private String targetedMuscles, weightUnit;

    /**
     * A basic constructor for StrengthExercise.
     * @param name
     * @param intensity
     * @param reps
     * @param weight
     * @param targetedMuscles
     * @param weightUnit
     */
    public StrengthExercise(String name, Intensity intensity, int reps, int weight, String targetedMuscles, String weightUnit) {
        super(name, intensity);
        this.reps = validateInt(reps);
        this.weight = validateInt(weight);
        this.targetedMuscles = validateString(targetedMuscles);
        this.weightUnit = validateWeight(weightUnit);
    }

    /**
     * Validates the weight unit input by checking if it is either "kg" or "lbs".
     * @param input
     * @return
     */
    public String validateWeight(String input){
        if (input.toLowerCase() == "kg" || input.toLowerCase() == "lbs"){
            return input.toLowerCase();
        }
        else {
            throw new IllegalArgumentException("Weight unit must be either 'kg' or 'lbs'.");
        }
    }

    /**
     * Calculates the calories burned during the strength exercise based on intensity, reps, and weight.
     * @return the calculated calories burned
     */
    public double caloriesBurned(){
        if (intensity == Intensity.LOW){
            return reps * 0.05 + (weight * 0.1);
        }
        else if (intensity == Intensity.MEDIUM){
            return reps * 0.1 + (weight * 0.12);
        }
        else {
            return reps * 0.15 + (weight * 0.15);
        }
    }

    public String toString(){
        return "Category: Strength\nName: %s\nTargeted Muscles: %s\nWeight: %d %s\nReps: %d\nIntensity: %s\nCalories Burned: %.2f".formatted(name, targetedMuscles, weight, weightUnit, reps, intensity, caloriesBurned());
    }
}
