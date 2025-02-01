package org.example.servicesapp.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;

import java.util.ArrayList;
import java.util.List;

public class MongoDB {


    public static void Connect() {
        String connectionString = System.getProperty("mongodb.uri");
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            System.out.println("=> Connection");
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean checks(MongoClient mongoClient) {
        Document ping = new Document("ping", 1);
        Document response = mongoClient.getDatabase("admin").runCommand(ping);
        System.out.printf("Result: ", response.toJson(JsonWriterSettings.builder().indent(true).build()));
        return response.get("ok", Number.class).intValue() == 1;
    }
}
