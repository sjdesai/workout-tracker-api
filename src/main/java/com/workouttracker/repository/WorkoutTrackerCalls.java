package com.workouttracker.repository;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;

@ApiModel
public interface WorkoutTrackerCalls {
    ArrayList<String> getMuscleGroups();
}
