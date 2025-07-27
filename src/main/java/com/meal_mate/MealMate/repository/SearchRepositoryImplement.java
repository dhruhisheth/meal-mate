package com.meal_mate.MealMate.repository;

import com.meal_mate.MealMate.model.Recipe;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class SearchRepositoryImplement implements SearchRepository{


    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Recipe> findByText(String text) {

        final List<Recipe> recipes = new ArrayList<>();

        MongoDatabase database = client.getDatabase("dhruhisheth");
        MongoCollection<Document> collection = database.getCollection("MealMate");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("ingredients", "name", "description", "cuisine", "tags")))),
                new Document("$sort",
                        new Document("rating", -1L)),
                new Document("$limit", 10L)));
        result.forEach(doc -> recipes.add(converter.read(Recipe.class,doc)));

        return recipes;
    }
}
