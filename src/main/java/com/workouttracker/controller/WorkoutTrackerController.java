package com.workouttracker.controller;

import com.workouttracker.service.WorkoutTrackerService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@Api(value = "WorkoutTrackerControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkoutTrackerController {

    private WorkoutTrackerService workoutTrackerService;

    @RequestMapping(path = "/muscle-groups", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ArrayList<String>> getMuscleGroup(){
        ArrayList<String> res =  workoutTrackerService.getMuscleGround();
        if(res!=null && !res.isEmpty()){
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    public void setWorkoutTrackerService(WorkoutTrackerService workoutTrackerService){
        this.workoutTrackerService = workoutTrackerService;
    }
}
