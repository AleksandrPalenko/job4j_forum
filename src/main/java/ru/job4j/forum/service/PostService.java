package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PostService {

    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public Collection<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public void add(Post post) {
        post.setCreated(LocalDate.now());
        posts.save(post);
    }

    public Post update(Post post) {
        return posts.save(post);
    }

    public Post findById(int id) {
        return posts.findById(id).get();
    }
}