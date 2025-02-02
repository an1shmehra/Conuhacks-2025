package org.example.servicesapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@AllArgsConstructor
@Data
public class User {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private String username;
    private String password;
    private int averageRating;
    private List<String> posts;

    public User(){
        this.id = new ObjectId();
        this.username = "";
        this.password = "";
        this.averageRating = 0;
        this.posts = new ArrayList<>();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.averageRating = 0;
        this.posts = new ArrayList<>();
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public List<String> getPosts() {
        return posts;
    }

    public void setPosts(List<String> posts) {
        this.posts = posts;
    }
}
