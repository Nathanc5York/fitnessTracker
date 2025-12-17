package model;
/**
 * Represents an individual immutable Exercise.
 * @author Nathan Chung
 * @version 1.0
 * @since 17/12/2025
 */
public class Exercise {
    private String name, description, targetedMuscles, weightUnit;
    private int sets, reps, weight;
    private Intensity intensity;
    

    /**
     * Exercise constructor with input validation.
     * @param name
     * @param targetedMuscles
     * @param sets
     * @param reps
     * @param weight
     * @param weightType
     * @param Intensity
     */
    public Exercise(String name, String targetedMuscles, int sets, int reps, int weight, String weightUnit, Intensity intensity){
        this.name = validateString(name);
        this.targetedMuscles = validateString(targetedMuscles);
        this.sets = validateInt(sets);
        this.reps = validateInt(reps);
        this.weight = validateInt(weight);
        this.weightUnit = validateString(weightUnit);
        this.intensity = validateIntensity(intensity);
    }
    /**
     * Checks whether or not a String is invalid through null or empty value
     * @param str
     * @return a valid String type that is trimmed
     */
    public String validateString(String str){
        if (str == null){
            throw new NullPointerException("String value can't be null.");
        }
        else if (str.trim().isEmpty()){
            throw new IllegalArgumentException("String can't be empty.");
        }
        return str.trim();
    }

    /**
     * Checks if an integer is valid if it is >= 0
     * @param integer
     * @return integer >= 0
     */
    public int validateInt(int integer){
        if (integer < 0){
            throw new IllegalArgumentException("Int value can't be below 0.");
        }
        return integer;
    }
    
    /**
     * Validates the intensity level by checking the input with the allowed types
     * @param intensity
     * @return intensity type
     */
    public Intensity validateIntensity(Intensity intensity){
        boolean validIntensity = false;
        for (Intensity i : Intensity.values()){
            if (i == intensity){
                validIntensity = true;
            }
        }
        if (validIntensity){
            return intensity;
        }
        else {
            throw new IllegalArgumentException("Invalid type of Intensity.");
        }
    }

    public String toString(){
        return "Exercise: %s\nTargeted Muscles: %s\n# Of Reps: %d\n# Of Sets: %d\n# Weight %d%s\nIntensity Level: %s".formatted(name, targetedMuscles, reps, sets, weight, weightUnit, intensity);
    }
}