package ru.job4j.forum.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Post {
    private int id;
    private String userName;
    private String description;
    private LocalDateTime created = LocalDateTime.now();

    public Post() {
    }

    public Post(int id, String userName, String description, LocalDateTime created) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.created = created;
    }

    public static Post of(String userName, String description, LocalDateTime created) {
        Post post = new Post();
        post.userName = userName;
        post.description = description;
        post.created = created;
        return post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id
                && Objects.equals(userName, post.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName);
    }
}
