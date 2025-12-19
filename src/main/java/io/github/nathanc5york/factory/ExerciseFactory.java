package io.github.nathanc5york.factory;
import io.github.nathanc5york.model.StrengthExercise;
import io.github.nathanc5york.model.CardioExercise;
import io.github.nathanc5york.model.Exercise;
import io.github.nathanc5york.model.Intensity;
import java.util.Map;
/**
 * A factory class that expedites and eases the creation of Exercise objects.
 * HEAVILY Inspired by Navid Mohaghegh's Factory Pattern implementation shown in MaterialFactory within the Labs.
 * @author Nathan Chung
 * @version 1.0
 * @since 2025-12-18
 */
public class ExerciseFactory {
    /**
     * Given a type and parameters, creates and returns the appropriate Exercise object.
     * @param type
     * @param params a map of parameter names to their values
     * @return an Exercise object
     */
    public static Exercise createExercise(String type, Map<String, Object> params){
        switch (type.trim().toUpperCase()){
            case "STRENGTH":
            case "STRENGTHEXERCISE":
            case "STRENGTH_EXERCISE":
                return createStrengthExercise(params);
            case "CARDIO":
            case "CARDIOEXERCISE":
            case "CARDIO_EXERCISE":
                return createCardioExercise(params);
        }
        return null;
    }
    /**
     * Creates a StrengthExercise from a map of parameters.
     * @param params a map of parameter names to their values
     * @return a StrengthExercise object
     */
    private static StrengthExercise createStrengthExercise(Map<String, Object> params){
        String name = getRequiredString(params, "name");
        Intensity intensity = getRequiredIntensity(params, "intensity");
        int reps = getRequiredInt(params, "reps");
        int weight = getRequiredInt(params, "weight");
        String targetedMuscles = getRequiredString(params, "targetedMuscles");
        String weightUnit = getRequiredString(params, "weightUnit");

        return new StrengthExercise(name, intensity, reps, weight, targetedMuscles, weightUnit);
    }
    /**
     * Creates a CardioExercise from a map of parameters.
     * @param params
     * @return a CardioExercise object
     */
    private static CardioExercise createCardioExercise(Map<String, Object> params){
        String name = getRequiredString(params, "name");
        Intensity intensity = getRequiredIntensity(params, "intensity");
        int durationMinutes = getRequiredInt(params, "durationMinutes");

        return new CardioExercise(name, intensity, durationMinutes);
    }

    /**
     * Retrieves and validates a String parameter from the map.
     * @param params
     * @param key
     * @return a valid String 
     */
    private static String getRequiredString(Map<String, Object> params, String key){
        Object value = params.get(key);
        if (value == null){
            throw new NullPointerException("Missing required parameter: " + key);
        }
        if (!(value instanceof String)){
            throw new IllegalArgumentException("Parameter " + key + " must be a String.");
        }
        String str = (String) value;
        if (str.trim().isEmpty()){
            throw new IllegalArgumentException("Parameter " + key + " cannot be empty.");
        }
        return str.trim();
    }

    /**
     * Retrieves and validates an integer from the map.
     * @param params
     * @param key
     * @return a valid integer
     */
    private static int getRequiredInt(Map<String, Object> params, String key){
        Object value = params.get(key);
        if (value == null){
            throw new NullPointerException("Missing required parameter: " + key);
        }
        if (value instanceof Number){
            return ((Number) value).intValue();
        }
        if (value instanceof Integer){
            return (Integer) value;
        }
        if (value instanceof String){
            try {
                return Integer.parseInt((String) value);
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException("Parameter " + key + " must be an integer.");
            }
        }
        throw new IllegalArgumentException("Parameter " + key + " must be an integer.");
    }

    /**
     * Retrieves and validates an Intensity level from the map.
     * @param params
     * @param key
     * @return a valid Intensity level
     */
    private static Intensity getRequiredIntensity(Map<String, Object> params, String key){
        Object value = params.get(key);
        if (value == null){
            throw new NullPointerException("Missing required parameter: " + key);
        }
        if (value instanceof Intensity){
            return (Intensity) value;
        }
        if (value instanceof String){
            try {
                return Intensity.valueOf(((String) value).trim().toUpperCase());
            }
            catch (IllegalArgumentException e){
                throw new IllegalArgumentException("Parameter " + key + " must be a valid Intensity.");
            }
        }
        throw new IllegalArgumentException("Parameter " + key + " must be a valid Intensity.");
    }
}
