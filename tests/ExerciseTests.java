import org.junit.Test;
import org.junit.Assert.assertEquals;
import model.Exercise;
import model.Intensity;
public class ExerciseTests {
    public static void main(String[] args){
        Exercise exercise1 = new Exercise("Squats", "Glutes, Hamstrings, Quads", 3, 6, 100, "lbs", Intensity.MEDIUM);
        System.out.println(exercise1.toString());
    }
}
