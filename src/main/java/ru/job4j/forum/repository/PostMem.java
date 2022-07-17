package ru.job4j.forum.repository;

import ru.job4j.forum.model.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class PostMem {

    private final Map<Integer, Post> store = new ConcurrentHashMap<>();

    private final AtomicInteger ids = new AtomicInteger();

    public PostMem() {
        store.put(1, new Post(1, "Название", "Описание", LocalDate.now()));
        store.put(2, new Post(2, "Название", "Описание", LocalDate.now()));
        store.put(3, new Post(3, "Название", "Описание", LocalDate.now()));
    }

    public Collection<Post> findAll() {
        return store.values();
    }

    public void create(Post post) {
        post.setId(ids.get());
        store.put(ids.getAndIncrement(), post);
        post.setCreated(LocalDate.now());
    }

    public Post findById(int id) {
        return store.get(id);
    }

    public Post update(Post post) {
        return store.replace(post.getId(), post);
    }
}
