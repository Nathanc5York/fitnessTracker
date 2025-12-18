package io.github.nathanc5york.observer;
import java.util.List;
import java.util.ArrayList;
import io.github.nathanc5york.model.Workout;

public class WorkoutLog implements Subject{
    private List<Observer> observers;
    private Workout workout;
    public WorkoutLog(){
        observers = new ArrayList<>();
    }
    @Override
    public void addObserver(Observer o){
        observers.add(o);
    }
    @Override
    public void removeObserver(Observer o){
        observers.remove(o);
    }
    @Override
    public void notifyObservers(){
        for(Observer o : observers){
            o.update(workout);
        }
    }
    public void newestWorkout(Workout workout){
        this.workout = workout;
        notifyObservers();
    }
}
