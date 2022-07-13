package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostMem;

import java.util.Collection;

@Service
public class PostService {

    private final PostMem postStore;

    public PostService(PostMem postStore) {
        this.postStore = postStore;
    }

    public Collection<Post> getAll() {
        return postStore.findAll();
    }

    public void add(Post post) {
        if (post.getId() == 0) {
            postStore.create(post);
        } else {
            postStore.update(post);
        }
    }

    public Post update(Post post) {
        return postStore.update(post);
    }

    public Post findById(int id) {
        return postStore.findById(id);
    }
}