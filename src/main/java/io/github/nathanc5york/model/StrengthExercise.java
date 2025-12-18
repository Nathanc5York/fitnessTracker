package io.github.nathanc5york.model;
import io.github.nathanc5york.model.Intensity;
/**
 * 
 */
public class StrengthExercise extends Exercise {
    private int reps, weight;
    private String targetedMuscles, weightUnit;

    public StrengthExercise(String name, Intensity intensity, int reps, int weight, String targetedMuscles, String weightUnit) {
        super(name, intensity);
        this.reps = validateInt(reps);
        this.weight = validateInt(weight);
        this.targetedMuscles = validateString(targetedMuscles);
        this.weightUnit = validateWeight(weightUnit);
    }

    public String validateWeight(String input){
        if (input.toLowerCase() == "kg" || input.toLowerCase() == "lbs"){
            return input.toLowerCase();
        }
        else {
            throw new IllegalArgumentException("Weight unit must be either 'kg' or 'lbs'.");
        }
    }

    public double caloriesBurned(){
        if (intensity == Intensity.LOW){
            return reps * weight * 0.05;
        }
        else if (intensity == Intensity.MEDIUM){
            return reps * weight * 0.1;
        }
        else {
            return reps * weight * 0.15;
        }
    }

    public String toString(){
        return "Category: Strength\nName: %s\nTargeted Muscles: %s\nWeight: %d %s\nReps: %d\nIntensity: %s\nCalories Burned: %.2f".formatted(name, targetedMuscles, weight, weightUnit, reps, intensity, caloriesBurned());
    }
}
