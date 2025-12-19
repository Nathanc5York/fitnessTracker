package io.github.nathanc5york.model;
import io.github.nathanc5york.model.Intensity;
/**
 * Represents a Cardio Exercise with input validation and a calorie calculation method.
 * @author Nathan Chung
 * @version 1.0
 * @since 2025-12-18
 */
public class CardioExercise extends Exercise{
    private int durationMinutes;
    
    public CardioExercise(String name, Intensity intensity, int durationMinutes) {
        super(name, intensity);
        this.durationMinutes = validateInt(durationMinutes);
    }
    /**
     * Calculates the calories burned during the cardio exercise based on intensity and duration.
     * @return the calculated calories burned
     */
    public double caloriesBurned(){
        if (intensity == Intensity.LOW){
            return durationMinutes * 2;
        }
        else if (intensity == Intensity.MEDIUM){
            return durationMinutes * 3;
        }
        else {
            return durationMinutes * 4;
        }
    }

    public String toString(){
        return "Category: Cardio\nName: %s\nDuration: %d Minutes\nIntensity: %s\nCalories Burned: %.2f".formatted(name, durationMinutes, intensity, caloriesBurned());
    }
}
