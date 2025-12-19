package io.github.nathanc5york.model;
import io.github.nathanc5york.model.Intensity;
/**
 * Abstract class Exercise allows for other classes to inherit common properties and methods.
 * @author Nathan Chung
 * @version 1.0
 * @since 2025-12-18
 */
public abstract class Exercise {
    protected String name;
    protected Intensity intensity;

    public Exercise(String name, Intensity intensity) {
        this.name = name;
        this.intensity = intensity;
    }
    /**
     * Validates a string input by checking for null or empty values.
     * @param input
     * @return a valid string, trimmed of leading and trailing whitespace
     */
    public String validateString(String input){
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }
        return input.trim();
    }

    /**
     * Validates an integer input by checking for negative values.
     * @param input
     * @return a valid integer >= 0
     */
    public int validateInt(int input){
        if (input < 0) {
            throw new IllegalArgumentException("Input integer cannot be negative.");
        }
        return input;
    }
    /**
     * Abstract method to calculate calories burned during the exercise.
     * @return
     */
    abstract double caloriesBurned();
}
