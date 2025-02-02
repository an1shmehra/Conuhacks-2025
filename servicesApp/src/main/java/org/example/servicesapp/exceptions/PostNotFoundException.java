package org.example.servicesapp.exceptions;

import org.bson.types.ObjectId;

public class PostNotFoundException extends Exception {
    public PostNotFoundException(ObjectId id) {
        super("Could not find post " + id.toString());
    }
}
