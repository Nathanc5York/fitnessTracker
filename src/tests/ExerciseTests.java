import org.junit.Test;
import org.junit.Assert.assertEquals;
import Exercise;
public class ExerciseTests {
    public static void main(String[] args){
        Exercise exercise1 = new Exercise("Squats", "Glutes, Hamstrings, Quads", 3, 6, 100, "lbs", MEDIUM);
        System.out.println(exercise1.toString());
    }
}
