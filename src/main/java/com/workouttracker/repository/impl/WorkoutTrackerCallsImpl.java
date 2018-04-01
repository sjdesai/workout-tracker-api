package com.workouttracker.repository.impl;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.workouttracker.repository.WorkoutTrackerCalls;
import org.bson.Document;
import org.springframework.stereotype.Repository;
import org.json.JSONObject;


import java.util.ArrayList;

@Repository
public class WorkoutTrackerCallsImpl implements WorkoutTrackerCalls{

    public ArrayList<String> getMuscleGroups(){
        ArrayList<String> res = new ArrayList<>();
        return fetchData();
    }

    private ArrayList<String> fetchData(){
        ArrayList<String> muscleGroupList = new ArrayList<>();

        /* ToDo: don't show username and password in string. */
        String uri = "mongodb://admin:admin@wtmongo-shard-00-00-gorx0.mongodb.net:27017,wtmongo-shard-00-01-gorx0.mongodb.net:27017,wtmongo-shard-00-02-gorx0.mongodb.net:27017/admin?replicaSet=WTMongo-shard-0&ssl=true";
        MongoClientURI clientURI = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(clientURI);

        /* Gets Mongo database
         * ToDo: hide database name and add it in as dependency injection
         */
        MongoDatabase mongoDatabase = mongoClient.getDatabase("FSMongoDB");

        /* Gets the collection (equivalent of a table in Mongo)
         * ToDo: dependencies to get table names and also separate classes to make queries
         */
        MongoCollection mongoCollection = mongoDatabase.getCollection("MuscleGroup");

        /*

        // Document is a new row in the above collection
        // ToDo: Again should be done in a separate class with dependency injections

        Document document = new Document("name", "chest");

        // Finally, insert the document above in the collection
        mongoCollection.insertOne(document);

        */

        System.out.println("Connected to MongoDB!");

        mongoCollection.find(new Document()).forEach((Block<Document>) document -> {
            JSONObject json = new JSONObject(com.mongodb.util.JSON.serialize(document));
            //System.out.println(com.mongodb.util.JSON.serialize(document));
            muscleGroupList.add(json.getString("name"));
        });
        return muscleGroupList;
    }
}
