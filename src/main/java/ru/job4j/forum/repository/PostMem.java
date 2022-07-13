package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostMem {

    private final Map<Integer, Post> store = new ConcurrentHashMap<>();

    private final AtomicInteger ids = new AtomicInteger();

    public PostMem() {
        store.put(1, new Post(1, "Название", "Описание", LocalDateTime.now()));
        store.put(2, new Post(2, "Название", "Описание", LocalDateTime.now()));
        store.put(3, new Post(3, "Название", "Описание", LocalDateTime.now()));
    }

    public Collection<Post> findAll() {
        return store.values();
    }

    public void create(Post post) {
        post.setId(ids.get());
        store.put(ids.getAndIncrement(), post);
        post.setCreated(LocalDateTime.now());
    }

    public Post findById(int id) {
        return store.get(id);
    }

    public Post update(Post post) {
        return store.replace(post.getId(), post);
    }
}
