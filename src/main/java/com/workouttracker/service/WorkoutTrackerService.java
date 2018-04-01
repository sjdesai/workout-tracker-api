package com.workouttracker.service;

import com.workouttracker.repository.impl.WorkoutTrackerCallsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WorkoutTrackerService {

    private WorkoutTrackerCallsImpl workoutTrackerCalls;

    public ArrayList<String> getMuscleGround(){
        return workoutTrackerCalls.getMuscleGroups();
    }

    @Autowired
    public void setWorkoutTrackerCalls(WorkoutTrackerCallsImpl workoutTrackerCalls){
        this.workoutTrackerCalls = workoutTrackerCalls;
    }
}
