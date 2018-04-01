package com.workouttracker.controller;

import com.workouttracker.service.WorkoutTrackerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@Api(value = "WorkoutTrackerControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkoutTrackerController {

    private WorkoutTrackerService workoutTrackerService;

    @RequestMapping(path = "/muscle-groups", method= RequestMethod.GET)
    @ApiOperation("Get the list of Muscle Groups")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = String.class)})
    public ArrayList<String> getMuscleGroup(){
        return workoutTrackerService.getMuscleGround();
    }

    @Autowired
    public void setWorkoutTrackerService(WorkoutTrackerService workoutTrackerService){
        this.workoutTrackerService = workoutTrackerService;
    }
}
